<#-- @ftlvariable name="data" type="com.eeeya.fantuan.api.v1.model.table.TableInfo" -->
<#--
    这里存放页面级的常量配置
-->
<#assign pageConfig = {
"id": "mingdian",
"pageid": "100050",
"title": "约饭",
"description":"午餐拼饭",
"noscale":true,
"hideFooter":true
}>

<#include "/automan/common/head.ftl">
<style>
    .user-logo {
        width: 50px;
        float: left;
    }

    .table-info {
        clear: both;
    }

    .table-button {
        width: 100px;
        padding: 10px;
        float: left;
    }

    hr {
        clear: both;
    }
</style>
<#include "/automan/common/header.ftl">

<h1>${pageConfig.title}</h1>

<h2>${pageConfig.description}</h2>

<div class="table-banner">
    <h4>${data.restaurantInfo.shortName}</h4>
    <h5>${data.tableType.label}</h5>
    <h6>${data.tableStatus.joinStatus.joinNumber}/${data.tableType.value}</h6>
    <dl>
    <#list data.tableStatus.joinStatus.joinUserList as joinUser>
        <dd>
            <img src="${joinUser.userLogo.imageUrl}" id="user-${joinUser.userId}" class="user-logo"/>
        </dd>
    </#list>
    </dl>
</div>
<div class="table-info">
    <div class="table-join-status">
        <span class="table-join-status-icon">${data.tableStatus.joinStatus.tableIconType.label}</span>
        <span class="table-join-status-label">${data.tableStatus.joinStatus.tableStatusTitle}</span>
    </div>
    <div class="table-time-info table-info-item">${data.mealTime?number_to_datetime?string("yyyy-MM-dd E HH:mm")}</div>
    <div class="table-average-price-info table-info-item">
        <span>${data.averagePrice.priceValue}</span>
        <span>${data.averagePrice.priceUnit}</span>
        <span>${data.payType.label}</span>
    </div>
    <div class="table-address-info table-info-item">${data.restaurantInfo.restaurantAddress}    </div>
</div>
<div class="table-action">
    <div class="table-button">
        <a href="${CommonHelper.getUniformUrl('/?action=changeTable&tableId=' + data.tableId)}">换桌</a>
    </div>

    <div class="table-button">${data.tableId}</div>

<#if data.tableStatus.joinStatus.joinNumber == 0 >
    <div class="table-button">
        <a href="${CommonHelper.getUniformUrl('/?action=addTable&tableId=' + data.tableId)}">开桌</a>
    </div>
<#else>
    <div class="table-button">
        <a href="${CommonHelper.getUniformUrl('/?action=joinTable&tableId=' + data.tableId)}">加入</a>
    </div>
</#if>
    <hr/>

    <div class="table-button">
    <#assign argument='{"isFarther":true}' />
        <a href="${CommonHelper.getUniformUrl('/?action=changeRestaurant&argument=' + argument?url("utf-8") + '&tableId=' + data.tableId)}">更远餐厅</a>
    </div>
    <div class="table-button">
    <#assign argument='{"isFarther":false}' />
        <a href="${CommonHelper.getUniformUrl('/?action=changeRestaurant&argument=' + argument?url("utf-8") + '&tableId=' + data.tableId)}">更近餐厅</a>
    </div>
</div>

<#include "/automan/common/footer.ftl">
<#include "/automan/common/foot.ftl">