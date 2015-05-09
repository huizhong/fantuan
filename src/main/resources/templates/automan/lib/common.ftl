
<#assign GLOBAL = {
"host":"test.daidaiduoduo.com"
}>

<#--
/**
 * 生产链接
 * @namespace CommonHelper
 * @method getUniformUrl
 * @param {String} originURI Uri
 * @param {Object} map 链接中的变量
 * @returns {String} 拼接好的Url
 */
-->
<#function getUniformUrl originURI="/" map={}>
    <#local globalParam = 'userId=101'>
    <#local param = ''>
<#-- 线下环境 -->
    <#--<#if originURI?starts_with('/')>-->
        <#--<#local newOriginURI = "http://" + GLOBAL.host + originURI>-->
    <#--<#else>-->
        <#local newOriginURI = originURI>
    <#--</#if>-->

    <#list map?keys as k>
        <#local param = param + k + '=' + map[k]?url + '&'>
    </#list>

    <#if globalParam?? || param??>
        <#local newOriginURI = (newOriginURI?contains('?'))?string("${newOriginURI}&", "${newOriginURI}" + '?')>
    </#if>

    <#return (newOriginURI + param + globalParam)>
</#function>


<#--
 /*
  * @name 格式化数组
  * @param arr {Array} freemarker格式的数组
  * @return str {String} JS格式的数组
  */
-->
<#function formatArray arr>
    <#local str = "[">

    <#list arr as s>

        <#if s?is_hash>
            <#local str = str + formatObject(s)>
        <#elseif s?is_sequence>
            <#local str = str + formatArray(s)>
        <#elseif s?string>
            <#local str = str + "\"" + s + "\"">
        <#else>
            <#local str = str + s>
        </#if>

        <#if s_has_next>
            <#local str = str + ",">
        </#if>
    </#list>

    <#local str = str + "]">

    <#return str>
</#function>

<#--
 /*
  * @name 格式化hashMap
  * @param arr {hashMap} freemarker格式的hashMap
  * @return str {String} JS格式的hashMap
  */
-->
<#function formatObject obj >
    <#local str = "{">

    <#list obj?keys as k>
        <#if k != "this$0">
            <#if obj[k]?is_sequence>
                <#local str = str + "\"" + k + "\"" + ":" + formatArray(obj[k])>
            <#elseif obj[k]?is_hash>
                <#local str = str + "\"" + k + "\"" + ":" + formatObject(obj[k])>
            <#elseif obj[k]?is_string>
                <#local str = str + "\"" + k + "\"" + ":" + "\"" + obj[k] + "\"">
            <#elseif obj[k]?is_boolean || obj[k]?is_number>
                <#local str = str + "\"" + k + "\"" + ":" + obj[k]>
            </#if>

            <#if k_has_next>
                <#local str = str + ",">
            </#if>

        </#if>
    </#list>

    <#local str = str + "}">

    <#return str>
</#function>

<#function JSONFormat obj sch>
    <#if sch?is_hash>
        <#local str = "{">
        <#list sch?keys as k>
            <#if obj[k]>
                <#local str = str + "\"" + k + "\"" + ":" + JSONFormat(obj[k], sch[k])>
                <#if k_has_next>
                    <#local str = str + ",">
                </#if>
            </#if>
        </#list>
        <#local str = str + "}">
        <#return str>
    <#elseif sch?is_sequence>
        <#local str = "[">
        <#list obj as s>
            <#local str = str + JSONFormat(s, sch[0])>
            <#if s_has_next>
                <#local str = str + ",">
            </#if>
        </#list>
        <#local str = str + "]">
        <#return str>
    <#elseif obj?is_string>
        <#return  '"'+obj+'"'>
    <#elseif obj?is_boolean>
        <#return obj?string("true", "false")>
    <#elseif obj?is_number>
        <#return obj>
    <#else>
        <#return "false">
    </#if>
</#function>
