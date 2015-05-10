<#-- @ftlvariable name="time" type="java.lang.Long" -->
<#-- @ftlvariable name="data" type="com.eeeya.fantuan.server.api.v1.model.table.TableInfo" -->
<#--
    这里存放页面级的常量配置
-->
<#assign pageConfig = {
"id": "mingdian",
"pageid": "100050",
"title": "拼桌详情",
"description":"餐桌详情",
"noscale":true,
"hideFooter":true
}>

<#include "/automan/common/head.ftl">
<style>
    .user-logo {
        width: 50px;
        float: left;
    }

    .table-detail-item {
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
    ol{
        list-style-type: none;
    }
</style>
<#include "/automan/common/header.ftl">
<a href="${CommonHelper.getUniformUrl('/?action=showTable&tableId=' + data.tableId)}">返回</a>
<h1>${data.mealTime?number_to_datetime?string("M月d日")+data.restaurantInfo.shortName+data.mealType.label+"拼桌"}</h1>
<div class="table-detail-item table-detail-join">
    <div class="join-description">
        <span>${data.restaurantInfo.shortName}</span>|<span>${data.tableType.label}</span>
        <#list data.tableStatus.joinStatus.joinUserList as userInfo >
            ,<span class="user-name">${userInfo.userName}</span>
        </#list>
        <span>等${data.tableStatus.joinStatus.joinNumber}人已报名</span>
    </div>
    <div class="join-user-logo-list">
    <#list data.tableStatus.joinStatus.joinUserList as userInfo >
        <img class="user-logo" src="${userInfo.userLogo.imageUrl}"/>
    </#list>
        <#list 1..(data.tableType.value - data.tableStatus.joinStatus.joinNumber) as i>
            <div class="user-logo" >等待</div>
        </#list>
    </div>
</div>
<div class="table-detail-item restaurant-contact">
    <div>
        <div class="restaurant-full-name">${data.restaurantInfo.fullName}</div>
        <div class="restaurant-address">${data.restaurantInfo.restaurantAddress}</div>
    </div>
    <div class="restaurant-phone">${data.restaurantInfo.restaurantPhone}</div>
</div>
<div class="table-detail-item restaurant-food-list">
    <div>大家待会儿吃什么！（每人选择一道）</div>
    <#list data.restaurantInfo.foodItemList as foodItem>
        <span class="food-item"> <a href="${CommonHelper.getUniformUrl('/?action=userVote&argument='+ foodItem.foodId + '&tableId=' + data.tableId)}">${foodItem.foodName}</a></span>
    </#list>
    <hr/>
    <ol>
    <#list data.tableStatus.mealVoteStatus.mealVoteItemList as mealVoteInfo>
        <li class="meal-message meal-vote-item">
            ${mealVoteInfo.userInfo.userName}, ${(time-mealVoteInfo.voteTime)?number_to_datetime?string("m")}分钟前点选了${mealVoteInfo.foodItem.foodName}！
        </li>
    </#list>
    </ol>
</div>
<div class="table-detail-item user-start-info">
    <div>我已准备出发!</div>
    <div>
    <a href="${CommonHelper.getUniformUrl('/?action=userStart&tableId=' + data.tableId)}">确定出发</a>
    </div>
    <hr/>
    <ol>
        <#list data.tableStatus.mealStartStatus.mealStartItemList as meaStartInfo>
            <li class="meal-message meal-start-item">
                ${meaStartInfo.userInfo.userName}<span class="phone-number">${meaStartInfo.userInfo.userPhone}</span>,${(time-meaStartInfo.startTime)?number_to_datetime?string("m")}分钟前准备出发！
            </li>
        </#list>
    </ol>

</div>

<#include "/automan/common/footer.ftl">
<#include "/automan/common/foot.ftl">