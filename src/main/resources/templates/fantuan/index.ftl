<#-- @ftlvariable name="data" type="com.eeeya.fantuan.model.table.TableInfo" -->
<#--
    这里存放页面级的常量配置
-->
<#assign pageConfig = {
"id": "mingdian",
"pageid": "100050",
"title": "饭团",
"noscale":true,
"hideFooter":true
}>

<#include "/automan/common/head.ftl">
<style>
    .user-logo{
        width: 100px;
    }
</style>
<#include "/automan/common/header.ftl">


<h4>${data.restaurantInfo.shortName}</h4>
<span>${data.tableType.label}</span>
<h6>${data.tableStatus.joinStatus.joinNumber}/${data.tableType.value}</h6>
<dl>
<#list data.tableStatus.joinStatus.joinUserList as joinUser>
<dd>
    <img src="${joinUser.userLogo.imageUrl}" id="user-${joinUser.userId}" class="user-logo"  />
</dd>
</#list>
</dl>
${data.tableId}

<#include "/automan/common/footer.ftl">
<#include "/automan/common/foot.ftl">