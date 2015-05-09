<#--
    组建方法库
    调用规则：${Util.fnName(arguments)}
    命名规则：正常是驼峰状格式，有return时加一个get
    注明：
        1. 在定义内部变量时，请使用<#local var1=value1 var2=value2 >替代<#assign ...>
        2. 每次在lib下新建一个xxx.ftl，需要在../common/head.ftl最上方加上<#import './lib/xxx.ftl' as XxxHelper>
-->

<#--
/**
 * 获取加星的手机号码
 * @namespace Util
 * @method getMaskMobile
 * @param {String} mobile 带入的手机号码
 * @returns {String} 返回加星号的手机号码
 */
-->
<#function getMaskMobile mobile=''>
    <#if (mobile?length > 7)>
        <#return mobile?substring(0, 4) + '****' + mobile?substring(7)>
    <#else>
        <#return mobile>
    </#if>
</#function>

<#function formatMM date>
    <#return date?string("yyyy-MM-dd HH:mm") />
</#function>

<#function formatDate originDate pattern="yyyy-MM-dd HH:mm:ss">
    <#-- 2011-05-16T21:32:13Z -->
    <#-- 01234567890123456789 -->
    <#local
        year = originDate?iso("UTC")?substring(0, 3)
        month = originDate?iso("UTC")?substring(5, 6)
        date = originDate?iso("UTC")?substring(8, 9)
        hour = originDate?iso("UTC")?substring(11, 12)
        minute = originDate?iso("UTC")?substring(14,15)
        second = originDate?iso("UTC")?substring(17, 18)
    >

    <#local ret = pattern?replace('yyyy', year)?replace('MM', month)?replace('dd', date)?replace('HH', hour)?replace('mm', minute)?replace('ss', second) >

    <#return ret>
</#function>

<#function formatDateString originDate pattern="yyyy-MM-dd HH:mm:ss">
<#-- 2015-05-29 23:59:59 -->
<#-- 0123456789012345678 -->
    <#local
    year = originDate?number_to_datetime?substring(0, 4)
    month = originDate?number_to_datetime?substring(5, 7)
    date = originDate?number_to_datetime?substring(8, 10)
    hour = originDate?number_to_datetime?substring(11, 13)
    minute = originDate?number_to_datetime?substring(14, 16)
    second = originDate?number_to_datetime?substring(17, 19)
    >

    <#local ret = pattern?replace('yyyy', year)?replace('MM', month)?replace('dd', date)?replace('HH', hour)?replace('mm', minute)?replace('ss', second) >

    <#return ret>
</#function>