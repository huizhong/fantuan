package com.eeeya.mybatis.offset;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;
import java.util.Properties;


public class PaginationSupportedPlugin extends PluginAdapter {
    private String customOffsetName = "offset";

    private String customRowsName = "rows";

    /**
     * 包含的在内的表(会生成Limit）
     */
    private String[] includes = new String[0];

    /**
     * 排除在外的表（不会生成LImit）
     */
    private String[] excludes = new String[0];


    /**
     * 自定义setProperties的过程，取出自定义属性
     */
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        if (properties.containsKey("customOffsetName")) {
            this.customOffsetName = properties.getProperty("customOffsetName");
        }
        if (properties.containsKey("customRowsName")) {
            this.customRowsName = properties.getProperty("customRowsName");
        }

        if (properties.containsKey("includes")) {
            this.includes = properties.getProperty("includes").split(",");
        }

        if (properties.containsKey("excludes")) {
            this.excludes = properties.getProperty("excludes").split(",");
        }
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if (!this.shouldAppendLimit(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()))
            return true;

        // add field, getter, setter for limit clause
        addLimit(topLevelClass, introspectedTable, this.customOffsetName);
        addLimit(topLevelClass, introspectedTable, this.customRowsName);
        return true;
    }

    /**
     * 修改SQLMAP XML的生成属性（将offset/rows加入到属性之中）
     */
    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

        return this.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    /**
     * 修改SQLMAP XML的生成属性（将offset/rows加入到属性之中）
     */
    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        if (!this.shouldAppendLimit(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()))
            return true;

        StringBuilder limitBuilder = new StringBuilder();
        limitBuilder.append("limit ${").append(this.customOffsetName).append("}, " +
                "${").append(this.customRowsName).append('}');

        XmlElement isParameterPresenteElemen = (XmlElement) element.getElements().get(element
                .getElements().size()-1);

        XmlElement isNotNullElement = new XmlElement("if");
        isNotNullElement.addAttribute(new Attribute("test", "offset!=-1"));
        isNotNullElement.addElement(new TextElement(limitBuilder.toString()));
//    isParameterPresenteElemen.addElement(isNotNullElement);
        element.addElement(isNotNullElement);
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    /**
     * 修改SQLProvider的生成属性，用在使用注解的方式生成DAO时（SQLProvider）
     */
    @Override
    public boolean providerSelectByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return !this.shouldAppendLimit(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()) || this.appendLimitForProvider(method);

    }

    /**
     * 修改SQLProvider的生成属性，用在使用注解的方式生成DAO时（SQLProvider）
     */
    @Override
    public boolean providerSelectByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return !this.shouldAppendLimit(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()) || this.appendLimitForProvider(method);

    }

    private boolean appendLimitForProvider(Method method) {

        List<String> lines = method.getBodyLines();
        lines.remove(lines.size() - 1); // 去掉最后一行return SQL(); 替换成如下方式的：

        //if(example.getOffset() > -1 && example.getRows > -1) {

        //return SQL() + "limit" + example.getOffset() + ',' example.getRows

        lines.add(
                "if(example.get"
                + Character.toUpperCase(this.customOffsetName.charAt(0))
                + this.customOffsetName.substring(1)
                + "() > -1 && example.get"
                + Character.toUpperCase(this.customRowsName.charAt(0))
                + this.customRowsName.substring(1)
                + "() > 0) {"
        );
        lines.add(
                "return SQL() + \" limit \" + example.get"
                        + Character.toUpperCase(this.customOffsetName.charAt(0))
                        + this.customOffsetName.substring(1) + "()+ \",\" + example.get"
                        + Character.toUpperCase(this.customRowsName.charAt(0))
                        + this.customRowsName.substring(1) + "();"
        );
        lines.add("}");
        lines.add("return SQL();");

        return true;
    }

    private void addLimit(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(FullyQualifiedJavaType.getIntInstance());
        field.setName(name);
        field.setInitializationString("-1");
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }

    /**
     * 检查是否应该加入分页相关的信息。
     * <pre>
     * . 在Exclude列表里面，不会生成；
     * . includes没有配置，都会生成；
     * . 配置了includes，按照includes规则生成
     * </pre>
     */
    private boolean shouldAppendLimit(String tableName) {
        return !this.checkExists(tableName, excludes) && (this.includes.length < 1 || this.checkExists(tableName, includes));

    }


    private boolean checkExists(String tableName, String[] collection) {
        for (String i : collection) {
            if (i.equalsIgnoreCase(tableName)) {
                return true;
            }
        }

        return false;
    }

    /**
     * This plugin is always valid - no properties are required
     */
    public boolean validate(List<String> warnings) {
        return true;
    }
}
