
<#-- 得到bodyID -->
<#assign bodyID = ''>
<#if pageConfig.id??>
    <#assign bodyID = ' id="' + pageConfig.id + '"'>
</#if>
<#-- 得到bodyClass -->
<#assign bodyClass = ''>
<#if pageConfig.class??>
    <#assign bodyClass = ' class="' + pageConfig.class + '"'>
</#if>

<#-- 得到headerClass -->
<#assign headerClass = ''>

<#-- 是否隐藏header -->
<#assign hideHeader = false>

</head>
<body${bodyID}${bodyClass}>

<#-- 提示框 -->
<#if ErrMsg??>
<div id="tips" class="tips tips-err" style="display: block">${ErrMsg}</div>
<#elseif OkMsg??>
<div id="tips" class="tips tips-ok" style="display: block">${OkMsg}</div>
<#elseif TipMsg??>
<div id="tips" class="tips" style="display: block">${TipMsg}</div>
<#else>
<div id="tips"></div>
</#if>

    <#if !pageConfig.hideHeader?? && !hideHeader??>
        <#if pageConfig.id?? == "index">
        <#-- 首页 Header -->
        <header class="navbar">首页</header>
        <#else >
        <header class="navbar">内容</header>
        </#if>
    </#if>