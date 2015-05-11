<#--
    脚本方法库
    调用规则：<@ScriptHelper.macroName params /> 及 ${ScriptHelper.fnName(arguments)}
    命名规则：正常是驼峰状格式，有return时加一个get
    注明：
        1. 在定义内部变量时，请使用<#local var1=value1 var2=value2 >替代<#assign ...>
        2. 每次在lib下新建一个xxx.ftl，需要在../common/head.ftl最上方加上<#import './lib/xxx.ftl' as XxxHelper>
-->
<#include "/automan/lib/static.ftl" />

<#--
   登录页需要使用HTTPS
-->
<#macro setSSLPath>
    <#assign STATIC_PATH = SSL_STATIC_PATH
    COMBO_PATH = SSL_COMBO_PATH
    >
</#macro>

<#--
    获取CSS文件地址
-->
<#function getCssUrl name>
    <#if IS_ONLINE>
        <#return STATIC_PATH + "css/" + CSS_FILE[name]>
    <#else>
        <#return STATIC_PATH + "css/" + name>
    </#if>
</#function>

<#--
    获取JS文件地址
-->
<#function getJsUrl name>
    <#if IS_ONLINE>
        <#return STATIC_PATH + "js/" + JS_FILE[name]>
    <#else>
        <#return STATIC_PATH + "js/" + name>
    </#if>
</#function>

<#--
    获取image文件的地址
-->
<#function getImageUrl name>
    <#if IS_ONLINE>
        <#return STATIC_PATH + "image/" + IMAGE_FILE[name]>
    <#else>
        <#return STATIC_PATH + "image/" + name>
    </#if>
</#function>

<#--
    是否是测试环境
-->
<#function isOnline>
    <#return IS_ONLINE!'' />
</#function>
