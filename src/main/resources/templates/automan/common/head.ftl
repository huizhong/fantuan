<#-- head.ftl -->

<#assign GLOBAL = {
"title":"饭团",
"isWebView": false,
"hideHeader": true
}>

<#--
    一次性调用整站的方法库
    注明：
        lib文件夹下每增加一个文件都需要在这里增加对应引用
-->
<#import "/automan/lib/util.ftl" as UtilHelper />
<#import "/automan/lib/common.ftl" as CommonHelper />
<#import "/automan/lib/script.ftl" as ScriptHelper />

<#-- 防止不同系统版本及不同语言导致的显示不一致 -->
<#setting date_format="yyyy-MM-dd')}"  />
<#setting datetime_format="yyyy-MM-dd HH:mm:ss')}"  />
<#-- 解决四位以上数字不加逗号的处理 -->
<#setting number_format='0.##' />

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
<title>${pageConfig.metatitle!pageConfig.title!GLOBAL.title}</title>
<meta name="description" content="${pageConfig.description!GLOBAL.title}">
<meta name="keywords" content="${pageConfig.keywords!GLOBAL.title}">

<#-- 以下HandlheldFriendly、MobileOptimized与viewport，优先级层层提高-->
<#-- <meta name="HandheldFriendly" content="True"> --><#-- 针对plam 黑莓等老版浏览器，告诉浏览器针对小屏幕进行优化 -->
<#-- <meta name="MobileOptimized" content="320"> --><#-- windows phone（包括PocketPC)的优化，让浏览器以320的宽度进行优化 -->
<#-- TODO: 根据UA更改viewport，比方说ipad嵌入touch为578px -->
<#-- standard viewport tag to set the viewport to the device's width
, Android 2.3 devices need this so 100% width works properly and
doesn't allow children to blow up the viewport width -->

<#if pageConfig.fixsize??>
    <meta name="viewport" content="width=320px, user-scalable=no">
    <script type="text/javascript">
            document.documentElement.style.fontSize = "50px";
    </script>
<#elseif !pageConfig.noscale??>
    <script type="text/javascript">
        //根据屏幕大小及dpi调整缩放和大小
        (function() {
            var scale = 1.0;
            var ratio = 1;
            if (window.devicePixelRatio >= 2) {
                scale *= 0.5;
                ratio *= 2;
            }
            var text = '<meta name="viewport" content="initial-scale=' + scale + ', maximum-scale=' + scale +', minimum-scale=' + scale + ', width=device-width, user-scalable=no')}"  />';
            document.write(text);
            document.documentElement.style.fontSize = 50*ratio + "px";
        })();
    </script>
<#else>
    <meta name="viewport" content="initial-scale=1, width=device-width, maximum-scale=1, user-scalable=no">
</#if>
<#-- width=device-width causes the iPhone 5 to letterbox the app, so
we want to exclude it for iPhone 5 to allow full screen apps -->
<#-- <meta http-equiv="cleartype" content="on"> --><#-- mobile IE 平滑字体技术-->
<#if !GLOBAL.isWebView>
<meta name="apple-mobile-web-app-capable" content="yes"><#-- home screen app 全屏 -->
<meta name='apple-touch-fullscreen' content='yes'>
<meta name="apple-mobile-web-app-status-bar-style" content="black"><#-- 状态栏 -->


    <link rel="shortcut icon" href="${ScriptHelper.getImageUrl('icon/favicon.ico" type="image/x-icon')}"  />
    <link rel="apple-touch-icon" href="${ScriptHelper.getImageUrl('startup/apple-touch-icon.png')}"  />
    <link rel="apple-touch-icon" sizes="57x57" href="${ScriptHelper.getImageUrl('startup/apple-touch-icon-57x57.png')}"  />
    <link rel="apple-touch-icon" sizes="72x72" href="${ScriptHelper.getImageUrl('startup/apple-touch-icon-72x72.png')}"  />
    <link rel="apple-touch-icon" sizes="76x76" href="${ScriptHelper.getImageUrl('startup/apple-touch-icon-76x76.png')}"  />
    <link rel="apple-touch-icon" sizes="114x114" href="${ScriptHelper.getImageUrl('startup/apple-touch-icon-114x114.png')}"  />
    <link rel="apple-touch-icon" sizes="120x120" href="${ScriptHelper.getImageUrl('startup/apple-touch-icon-120x120.png')}"  />
    <link rel="apple-touch-icon" sizes="144x144" href="${ScriptHelper.getImageUrl('startup/apple-touch-icon-144x144.png')}"  />
    <link rel="apple-touch-icon" sizes="152x152" href="${ScriptHelper.getImageUrl('startup/apple-touch-icon-152x152.png')}"  />


    <link rel="apple-touch-startup-image"
          href="${ScriptHelper.getImageUrl('startup/apple-touch-startup-image-640x1096.png')}"
          media="(device-height:568px)"><#-- iPhone5启动图 -->
    <link rel="apple-touch-startup-image"
          href="${ScriptHelper.getImageUrl('startup/apple-touch-startup-image-640x920.png')}"
          media="(device-height:480px)"><#-- iPhone4启动图 -->
</#if>
    <meta name="format-detection" content="telephone=no"><#-- 禁止浏览器自动将手机号码变为拨号链接 -->
    <meta name="format-detection" content="address=no"><#-- 禁止浏览器自动将地址转换 -->

