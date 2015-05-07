
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
    <#local globalParam = ''>
    <#local param = ''>
<#-- 线下环境 -->
    <#if originURI?starts_with('/')>
        <#local newOriginURI = "http://" + GLOBAL.host + originURI>
    <#else>
        <#local newOriginURI = originURI>
    </#if>

    <#list map?keys as k>
        <#local param = param + k + '=' + map[k]?url + '&'>
    </#list>

    <#if globalParam?? || param??>
        <#local newOriginURI = (newOriginURI?contains('?'))?string("${newOriginURI}&", "${newOriginURI}" + '?')>
    </#if>

    <#return (newOriginURI + param + globalParam)>
</#function>

