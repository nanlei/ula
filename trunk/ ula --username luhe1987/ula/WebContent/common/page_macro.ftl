<#include "config.ftl">
<#include "common_function.ftl">

<#-- 页面统一基础模板 -->
<#macro page title=macro_config.default_title setReferUrl=false referUrlKey="" js=[] css=[]>
<#if setReferUrl><#if referUrlKey?has_content>${action.setReferUrl(referUrlKey)}<#else>${action.setReferUrl()}</#if></#if>
<#if navi?has_content>
	<#if title==macro_config.default_title>
		<#local title = navi?last>
	</#if>
</#if>
<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"]>
<html>
<head>
	<title>${macro_config.common_title} - ${title?html}</title>
	<#list macro_config.css_path as css><#-- 系统CSS加载 -->
		<link href="${base}${css}" rel="stylesheet" type="text/css">
	</#list>
	<#if css?has_content>
	<#list css as cssfile><#-- 自定义CSS加载 -->
		<link href="${base}/css/${cssfile}" rel="stylesheet" type="text/css">
	</#list>
	</#if>
	<#list macro_config.js_path as js><#-- 系统JS加载 -->
		<script language="javascript" src="${base}${js}"></script>
	</#list>
	<#if js?has_content>
	<#list js as jsfile><#-- 自定义JS加载 -->
		<script language="javascript" src="${base}/js/${jsfile}"></script>
	</#list>
	</#if>
	<script language="javascript"> 
	function toggleTree() {
		$("#TreeTD").toggle();
	}
	</script>
	<meta http-equiv="Content-type" content="text/html; charset=${macro_config.charset}">
</head>
<body>
<#nested>
</body>
</html>
</#macro>

<#-- 树形控件 tree -->
<#macro tree root="" display="">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=${macro_config.charset}">
<link href="${base}/css/default.css" rel="stylesheet" type="text/css">
<style type="text/css">@import url('${base}/components/dtree/dtree.css');</style>
<script type="text/javascript">var dtreeIconBasePath = "${base}/components/dtree";</script>
<script language="javascript" src="${base}/components/dtree/dtree.js"></script>
<#nested>
</head>
<body>
<div style="display:${display};margin-bottom:5px;">菜单控制:【<a href="javascript:void(0)" onclick="tree.openAll();this.blur();return false;" style="color:#333333">展开</a>】【<a href="javascript:void(0)" onclick="tree.closeAll();this.blur();return false;" style="color:#333333">折叠</a>】</div>
<div class="dtree">
</div>
</body>
<script type="text/javascript"> 
//建立新树
tree = new dTree('tree');
tree.config.target = "MainFrame";
tree.config.useCookies = false;
var selNum = -1;
var link = "";

//根目录
tree.add(0,-1,'${root}', null, null, null, '${base}/images/tico_root.gif', '${base}/images/tico_root.gif');
var count = 0;
var pLevelIdArray = new Array();
pLevelIdArray[1] = 0;
var currLevel = 1;
for (var i=0; i<treeMenu.length; i++) {
	var item = treeMenu[i];
	var itemLevel = item.level;
	pLevelIdArray[itemLevel+1] = ++count;
	if (item.link!=null && item.link!="") {
		if (item.ico!=null) {
			tree.add(count, pLevelIdArray[itemLevel], item.name, item.link, null, null, item.ico, item.ico);
		} else {
			tree.add(count, pLevelIdArray[itemLevel], item.name, item.link);
		}
	} else {
		if (item.ico!=null) {
			tree.add(count, pLevelIdArray[itemLevel], item.name, null, null, null, item.ico, item.ico);
		} else {
			tree.add(count, pLevelIdArray[itemLevel], item.name);
		}
	}
	if (item.select) {
		selNum = count;
		link = item.link;
	}
}
document.write(tree);
tree.openAll();
if (selNum != -1) {
	tree.openTo(selNum,true);
	top.document.frames["MainFrame"].location.href=link;
}
</script>
</html>
</#macro>

<#-- 处理分页参数 -->
<#function getPageUrl pageNum>
<#local pageUrl=base+fullUrlWithoutPageInfo>
<#if pageUrl?ends_with("?")>
<#return pageUrl + "pageSize=" + pageSize + "&pageNum=" + pageNum>
<#else>
<#return pageUrl + "&pageSize=" + pageSize + "&pageNum=" + pageNum>
</#if>
</#function>

<#-- 全部或分页显示 -->
<#function getPageUrlResize size>
<#local pageUrl=base+fullUrlWithoutPageInfo>
<#if pageUrl?ends_with("?")>
<#return pageUrl + "pageNum=1&pageSize=" + size>
<#else>
<#return pageUrl + "&pageNum=1&pageSize=" + size>
</#if>
</#function>

<#-- 分页信息 -->
<#macro paging pagingListHt>
<#local pageCount=pagingListHt.pageCount>
<#local rowCount=pagingListHt.rowCount>
<#local pageNum=pagingListHt.pageNum>
<#local pageSize=pagingListHt.pageSize>
<#if rowCount == 0>
	<#if useFlag?exists>
	<div style="border:1px solid #666;padding:2 5 2 5;background:#efefef;color:#333">没有相关记录</div>
	<#else>
	<#assign useFlag = 1>
	</#if>
<#else>
<table>
<tr>
	<td style="line-height:150%">
	共 ${rowCount} 条记录 ${pageCount} 页 
	<#if pageCount gt 1 && pageSize!=maxPageSize>
		<span class="selectedPage" style="padding:2px 3px 0 3px"><a class="page" href="${getPageUrlResize(maxPageSize)}">全部显示</a></span>
	<#elseif pageSize==maxPageSize>
		<span class="selectedPage" style="padding:2px 3px 0 3px"><a class="page" href="${getPageUrlResize(defaultPageSize)}">分页显示</a></span>
	</#if>
	<#if (pageCount <= 11)>
		<#local startPage = 1>
		<#local endPage = pageCount>
	<#elseif (pageNum + 5 > pageCount)>
		<#local startPage = pageCount - 10>
		<#local endPage = pageCount>
	<#elseif (pageNum - 5 < 1)>
		<#local startPage = 1>
		<#local endPage = 11>
	<#else>
		<#local startPage = pageNum - 5>
		<#local endPage = pageNum + 5>
	</#if>
	<#if (pageCount > 1)>
		<#if (pageNum != 1)>
			<#if (pageCount > 11)>
				<a class="page" href="${getPageUrl(1)}" style="font-family:Webdings" title="首页">9</a>
			</#if>
			<a class="page" href="${getPageUrl(pageNum-1)}" style="font-family:Webdings" title="上页">3</a>
		<#else>
			<#if (pageCount > 11)>
				<span style="font-family:Webdings;color:#999">9</span>
			</#if>
			<span style="font-family:Webdings;color:#999">3</span>
		</#if>
		<#list startPage..endPage as x><#if x=pageNum>
			<span class="selectedPage">${x}</span>
	<#else>
		<span class="noSelectedPage"><a class="page" href="${getPageUrl(x)}">${x}</a></span>
	</#if>
	</#list>
		<#if (pageCount != pageNum)>
			<a class="page" href="${getPageUrl(pageNum+1)}" style="font-family:Webdings" title="下页">4</a>
			<#if (pageCount > 11)>
				<a class="page" href="${getPageUrl(pageCount)}" style="font-family:Webdings" title="尾页">:</a>
			</#if>
		<#else>
			<span style="font-family:Webdings;color:#999">4</span>
			<#if (pageCount > 11)>
				<span style="font-family:Webdings;color:#999">:</span>
			</#if>
		</#if>
	</#if>
	</#if>
	</td>
</tr>
</table>
</#macro>

<#-- CKEditor编辑器 -->
<#macro ckeditor id upload=true>
${importJS("/components/ckeditor/ckeditor.js")}
<#if upload>
<script type="text/javascript">
CKEDITOR.replace('${id}',{
	filebrowserUploadUrl : '${base}/admin/pic/editorUpload.action',
	filebrowserImageUploadUrl : '${base}/admin/pic/editorUpload.action',
	filebrowserFlashUploadUrl : '${base}/admin/pic/editorUpload.action'
});
</script>
<#else>
<script type="text/javascript">
CKEDITOR.replace('${id}');
</script>
</#if>
</#macro>

<#-- 日历控件  id : 目标input元素的id（注意，不是name属性，是id属性）-->
<#macro cal id format="%Y-%m-%d" text="选择日期">
<#if calcount?exists>
<#assign calcount=calcount+1>
<#else>
<#assign calcount=0>
${importCSS("/components/calendar/skins/aqua/theme.css")}
${importJS("/components/calendar/calendar.js")}
${importJS("/components/calendar/calendar-setup.js")}
${importJS("/components/calendar/lang/calendar-zh-utf8.js")}
</#if>
<img id="calImg${calcount}" src="${base}/components/calendar/skins/aqua/cal.gif" border="0" alt="${text}" style="cursor:pointer">
<script language="JavaScript">Calendar.setup({inputField:"${id}",ifFormat:"${format}",button:"calImg${calcount}"});</script>
</#macro>

<#-- 表单必填项标识 -->
<#macro mustMark><span class="notNull">*</span></#macro>

<#-- 表格鼠标覆盖后换色 -->
<#macro trChangeColor>
 onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#BFDFFF'"
</#macro>

<#-- 页面居中控制宏 -->
<#macro Container width="" height="" layout="" color="" size="" style="">
<div id="container" <#if width?has_content||height?has_content||layout?has_content||color?has_content||size?has_content||style?has_content>style="<#if width?has_content>width:${width}px;</#if><#if height?has_content>height:${height}px;</#if><#if layout?has_content>float:${layout};</#if><#if color?has_content||size?has_content||style?has_content>border:${color} ${size}px ${style}</#if>"</#if>>
<#nested>
</div>
</#macro>
<#-- 一级布局层 -->
<#macro FlowLayout width="" height="" layout="" color="" size="" style="" padding_top="" padding_right="" padding_bottom="" padding_left="" margin_top="" margin_right="" margin_bottom="" margin_left="" background_color="" img="" repeat="">
<div class="layout"<#if width?has_content||height?has_content||layout?has_content||color?has_content||size?has_content||style?has_content||padding_top?has_content||padding_right?has_content||padding_bottom?has_content||padding_left?has_content||margin_top?has_content||margin_right?has_content||margin_bottom?has_content||margin_left?has_content||background_color?has_content||img?has_content||repeat?has_content>style="<#if width?has_content>width:${width}px;</#if><#if height?has_content>height:${height}px;</#if><#if layout?has_content>float:${layout};</#if><#if color?has_content||size?has_content||style?has_content>border:${color} ${size}px ${style};</#if><#if padding_top?has_content>padding-top:${padding_top}px;</#if><#if padding_bottom?has_content>padding-bottom:${padding_bottom}px;</#if><#if padding_right?has_content>padding-right:${padding_right}px;</#if><#if padding_left?has_content>padding-left:${padding_left}px;</#if><#if margin_top?has_content>margin-top:${margin_top}px</#if><#if margin_bottom?has_content>margin-bottom:${margin_bottom}px</#if><#if margin_right?has_content>margin-right:${margin_right}px</#if><#if margin_left?has_content>margin-left:${margin_left}px</#if><#if background_color?has_content>background-color:${background_color};</#if><#if img?has_content>background-image:url(${base}/images/${img});</#if><#if repeat?has_content>background-repeat:${repeat};</#if>"</#if>>
<#nested>
</div>
</#macro>
<#-- 二级布局层 -->
<#macro BoxLayout width="" height="" layout="" color="" size="" style="" padding_top="" padding_right="" padding_bottom="" padding_left="" margin_top="" margin_right="" margin_bottom="" margin_left="" background_color="" img="" repeat="">
<div class="layout"<#if width?has_content||height?has_content||layout?has_content||color?has_content||size?has_content||style?has_content||padding_top?has_content||padding_right?has_content||padding_bottom?has_content||padding_left?has_content||margin_top?has_content||margin_right?has_content||margin_bottom?has_content||margin_left?has_content||background_color?has_content||img?has_content||repeat?has_content>style="<#if width?has_content>width:${width}px;</#if><#if height?has_content>height:${height}px;</#if><#if layout?has_content>float:${layout};</#if><#if color?has_content||size?has_content||style?has_content>border:${color} ${size}px ${style};</#if><#if padding_top?has_content>padding-top:${padding_top}px;</#if><#if padding_bottom?has_content>padding-bottom:${padding_bottom}px;</#if><#if padding_right?has_content>padding-right:${padding_right}px;</#if><#if padding_left?has_content>padding-left:${padding_left}px;</#if><#if margin_top?has_content>margin-top:${margin_top}px</#if><#if margin_bottom?has_content>margin-bottom:${margin_bottom}px</#if><#if margin_right?has_content>margin-right:${margin_right}px</#if><#if margin_left?has_content>margin-left:${margin_left}px</#if><#if background_color?has_content>background-color:${background_color};</#if><#if img?has_content>background-image:url(${base}/images/${img});</#if><#if repeat?has_content>background-repeat:${repeat};</#if>"</#if>>
<#nested>
</div>
</#macro>
<#-- 三级布局层 -->
<#macro GridLayout width="" height="" layout="" color="" size="" style="" padding_top="" padding_right="" padding_bottom="" padding_left="" margin_top="" margin_right="" margin_bottom="" margin_left="" background_color="" img="" repeat="">
<div class="layout"<#if width?has_content||height?has_content||layout?has_content||color?has_content||size?has_content||style?has_content||padding_top?has_content||padding_right?has_content||padding_bottom?has_content||padding_left?has_content||margin_top?has_content||margin_right?has_content||margin_bottom?has_content||margin_left?has_content||background_color?has_content||img?has_content||repeat?has_content>style="<#if width?has_content>width:${width}px;</#if><#if height?has_content>height:${height}px;</#if><#if layout?has_content>float:${layout};</#if><#if color?has_content||size?has_content||style?has_content>border:${color} ${size}px ${style};</#if><#if padding_top?has_content>padding-top:${padding_top}px;</#if><#if padding_bottom?has_content>padding-bottom:${padding_bottom}px;</#if><#if padding_right?has_content>padding-right:${padding_right}px;</#if><#if padding_left?has_content>padding-left:${padding_left}px;</#if><#if margin_top?has_content>margin-top:${margin_top}px</#if><#if margin_bottom?has_content>margin-bottom:${margin_bottom}px</#if><#if margin_right?has_content>margin-right:${margin_right}px</#if><#if margin_left?has_content>margin-left:${margin_left}px</#if><#if background_color?has_content>background-color:${background_color};</#if><#if img?has_content>background-image:url(${base}/images/${img});</#if><#if repeat?has_content>background-repeat:${repeat};</#if>"</#if>>
<#nested>
</div>
</#macro>
<#-- 四级布局层 -->
<#macro OutterLayout width="" height="" layout="" color="" size="" style="" padding_top="" padding_right="" padding_bottom="" padding_left="" margin_top="" margin_right="" margin_bottom="" margin_left="" background_color="" img="" repeat="">
<div class="layout"<#if width?has_content||height?has_content||layout?has_content||color?has_content||size?has_content||style?has_content||padding_top?has_content||padding_right?has_content||padding_bottom?has_content||padding_left?has_content||margin_top?has_content||margin_right?has_content||margin_bottom?has_content||margin_left?has_content||background_color?has_content||img?has_content||repeat?has_content>style="<#if width?has_content>width:${width}px;</#if><#if height?has_content>height:${height}px;</#if><#if layout?has_content>float:${layout};</#if><#if color?has_content||size?has_content||style?has_content>border:${color} ${size}px ${style};</#if><#if padding_top?has_content>padding-top:${padding_top}px;</#if><#if padding_bottom?has_content>padding-bottom:${padding_bottom}px;</#if><#if padding_right?has_content>padding-right:${padding_right}px;</#if><#if padding_left?has_content>padding-left:${padding_left}px;</#if><#if margin_top?has_content>margin-top:${margin_top}px</#if><#if margin_bottom?has_content>margin-bottom:${margin_bottom}px</#if><#if margin_right?has_content>margin-right:${margin_right}px</#if><#if margin_left?has_content>margin-left:${margin_left}px</#if><#if background_color?has_content>background-color:${background_color};</#if><#if img?has_content>background-image:url(${base}/images/${img});</#if><#if repeat?has_content>background-repeat:${repeat};</#if>"</#if>>
<#nested>
</div>
</#macro>
<#-- 五级布局层 -->
<#macro InnerLayout width="" height="" layout="" color="" size="" style="" padding_top="" padding_right="" padding_bottom="" padding_left="" margin_top="" margin_right="" margin_bottom="" margin_left="" background_color="" img="" repeat="">
<div class="layout"<#if width?has_content||height?has_content||layout?has_content||color?has_content||size?has_content||style?has_content||padding_top?has_content||padding_right?has_content||padding_bottom?has_content||padding_left?has_content||margin_top?has_content||margin_right?has_content||margin_bottom?has_content||margin_left?has_content||background_color?has_content||img?has_content||repeat?has_content>style="<#if width?has_content>width:${width}px;</#if><#if height?has_content>height:${height}px;</#if><#if layout?has_content>float:${layout};</#if><#if color?has_content||size?has_content||style?has_content>border:${color} ${size}px ${style};</#if><#if padding_top?has_content>padding-top:${padding_top}px;</#if><#if padding_bottom?has_content>padding-bottom:${padding_bottom}px;</#if><#if padding_right?has_content>padding-right:${padding_right}px;</#if><#if padding_left?has_content>padding-left:${padding_left}px;</#if><#if margin_top?has_content>margin-top:${margin_top}px;</#if><#if margin_bottom?has_content>margin-bottom:${margin_bottom}px;</#if><#if margin_right?has_content>margin-right:${margin_right}px;</#if><#if margin_left?has_content>margin-left:${margin_left}px;</#if><#if background_color?has_content>background-color:${background_color};</#if><#if img?has_content>background-image:url(${base}/images/${img});</#if><#if repeat?has_content>background-repeat:${repeat};</#if>"</#if>>
<#nested>
</div>
</#macro>
<#-- 标题 -->
<#macro title title="" title_href="" title_color="" title_margin_top="" title_margin_left="" 
		      more="" more_href="" more_color="" more_over_color="" more_margin_top="" more_margin_right="" 
			  img="" repeat="" height="" bottom_color="" >
<style>
<#if more_over_color?has_content>
.title h4 a:hover {
	color:${more_over_color};
}
</style>
</#if>
<div class="title" 
<#if img?has_content||repeat?has_content||height?has_content||bottom_color?has_content>
style="
		<#if img?has_content>background-image:url(${base}/images/${img});</#if>
		<#if repeat?has_content>background-repeat:${repeat};</#if>
		<#if height?has_content>height:${height}px;</#if>
		<#if bottom_color?has_content>border-bottom-color:${bottom_color};</#if>
	  "
</#if>
>
        <#if title?has_content><h3 <#if title_color?has_content||title_margin_top?has_content||title_margin_left?has_content>style="<#if title_color?has_content>color:${title_color};</#if><#if title_margin_top?has_content>margin-top:${title_margin_top}px;</#if><#if title_margin_left?has_content>margin-left:${title_margin_left}px;</#if>"</#if>><#if title_href?has_content><a href="${title_href}"></#if>${title}<#if title_href?has_content></a></#if></h3></#if>
        <#if more?has_content><h4 <#if more_margin_top?has_content||more_margin_right?has_content>style="<#if more_margin_top?has_content>margin-top:${more_margin_top}px;</#if><#if more_margin_right?has_content>margin-right:${more_margin_right}px;</#if>"</#if>><#if more_href?has_content><a href="${more_href}" <#if more_color?has_content>style="color:${more_color};"</#if>></#if>${more}<#if more_href?has_content></a></#if></h4></#if>
</div>
</#macro>
<#-- 导航 -->
<#macro navi navi=[] height="" font_size="" margin_left="" margin_right="" layout="">
 	<ul class="navi" <#if font_size?has_content||margin_left?has_content||margin_right?has_content>style="<#if font_size?has_content>font-size:${font_size}px;</#if><#if margin_left?has_content>margin-left:${margin_left}px;</#if><#if margin_right?has_content>margin-right:${margin_right}px;</#if>"</#if>>
 		<#list navi as n>
 		<#assign keys = n?keys>
 			<#list keys as key><li <#if layout?has_content>style="<#if layout?has_content>float:${layout};</#if>"</#if>><a href="${parseLink(n[key])}">${key}</a></li></#list>
 		</#list>
 	</ul>
</#macro>
