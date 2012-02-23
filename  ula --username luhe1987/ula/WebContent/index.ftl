<@fp.page index=true>
<!-- The Head -->
<@fp.header /><#-- header宏 -->
<!-- The Container  -->
<div id="container">
	<!-- The Banner  -->
	<@fp.banner /><#-- banner宏 -->
	<!-- The Navigation  -->
	<@fp.navigation c_index=true c_city=false c_tour=false c_service=false c_search=false c_contact=false c_online=false/><#-- navigation宏 -->
	<!-- The Search Bar  -->
	<@fp.search /><#-- search宏 -->
	<!-- The Main Body -->
	<div id="main_body">
		<!-- The Left -->
		<@fp.main_left /><#-- 主体左侧宏，包含关于大连导航，RSS订阅，天气预报-->
		<!-- The Middle -->
		<@fp.main_middle /><#-- 主体中间宏，包含产品展示 -->
		<!-- The Right -->
		<@fp.main_right /><#-- 主体右侧宏，包含工具链接 -->
	</div>
    <!-- The Footer -->
	<@fp.footer /><#-- footer宏 -->
</div>
</@fp.page>