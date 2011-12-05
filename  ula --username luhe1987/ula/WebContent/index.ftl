<@fp.page>
<body>
<!-- The Head -->
<@fp.header /><#-- header宏 -->
<!-- The Container  -->
<div id="container">
	<!-- The Banner  -->
	<@fp.banner /><#-- banner宏 -->
    <!-- The Navigation  -->
	<@fp.navigation /><#-- navigation宏 -->
	<!-- The Search Bar  -->
	<@fp.search /><#-- search宏 -->
    <!-- The Main Body -->
    <div id="main_body">
         <!-- The Left -->
        <div id="main_left">
            <div id="left_title">关于大连</div>
            <div id="left_menu">
                    <ul class="left_first_menu">
                        <li><a href="#">Представление о городе</a></li>
                        <li><a href="#">История города</a></li>
                        <li><a href="#">Карта города</a></li>
                        <li><a href="#">Достопримечательности,парки</a></li>
                    </ul>
                    <ul class="left_second_menu">
                        <li><a href="#">На территории города</a></li>
                        <li><a href="#">В Порт-Артуре</a></li>
                        <li><a href="#">В Цзиньшитане</a></li>
                    </ul>
                    <ul class="left_first_menu">
                        <li><a href="#">Гурманство в Даляне</a></li>
                        <li><a href="#">Проживание в Даляне</a></li>
                        <li><a href="#">Шоппинг</a></li>
                        <li><a href="#">Транспорт</a></li>
                        <li><a href="#">Лечение</a></li>
                        <li><a href="#">Даляньские приздники</a></li>
                        <li><a href="#">Выставки</a></li>
                        <li><a href="#">Информация</a></li>
                    </ul>
                     <ul class="left_second_menu">
                        <li><a href="#">Страхование</a></li>
                        <li><a href="#">Юридическая информация</a></li>
                        <li><a href="#">Мобильная связь</a></li>
                        <li><a href="#">Практические советы</a></li>
                    </ul>
                </div>
                <div class="clear"></div>
                <div id="left_bottom"></div>
                <div id="left_rss">
                	<div id="rss_title"><span><@s.property value="%{getText('front.rss.title')}"/></span></div>
                    <div id="rss_form">
                    	<form>
                        <p id="email_rss">
                        	<label><@s.property value="%{getText('front.rss.label')}"/>：</label>
                        	<input id="email_input" type="text" name="email_ad"/>
                        </p>
                        <input class="rss_ch" type="radio" name="ree_ornot" value="yes" /><span><@s.property value="%{getText('front.rss.radio.subscribe')}"/></span><br />
                        <input class="rss_ch" type="radio" name="ree_ornot" value="no" /><span><@s.property value="%{getText('front.rss.radio.cancel')}"/></span>
                        <p align="right"><input id="info_submit" name="rss_add" type="button" value="    <@s.property value="%{getText('front.rss.submit')}"/>    " onclick="rssSubmit()"/></p>
                    	</form>
                    </div>
                </div>
                
              <div id="left_waether">
                	<div id="waether_title">
                    	<span><@s.property value="%{getText('front.weather.title')}"/></span>
                    </div>
                <table border="0"  cellspacing="0" cellpadding="0">
                    	<tr>
                        	<td width="60">
                        		<img src="http://m.weather.com.cn/img/b${weather.IMG1}.gif" width="26" height="26" alt="network error" title="Weather"/>
								<#if weather.IMG2?number?int!=99>
								<img src="http://m.weather.com.cn/img/b${weather.IMG2}.gif" width="26" height="26" alt="network error" title="Weather"/>
								</#if>
							</td>
                            <td width="75"><@s.property value="%{getText('front.weather.today')}"/></td>
                            <td>${weather.TEMP1}</td>
                        </tr>
                        <tr >
                        	<td width="60">
                        		<img src="http://m.weather.com.cn/img/b${weather.IMG3}.gif" width="26" height="26" alt="network error" title="Weather"/>
								<#if weather.IMG4?number?int!=99>
									<img src="http://m.weather.com.cn/img/b${weather.IMG4}.gif" width="26" height="26" alt="network error" title="Weather"/>
								</#if>
                        	</td>
                            <td width="75"><@s.property value="%{getText('front.weather.tomorrow')}"/></td>
                            <td>${weather.TEMP2}</td>
                        </tr>
                    </table>
                </div>
            </div>
            <!-- The Middle -->
            <div id="main_middle">
            	<div id="middle_title">产品展示</div>
                <div id="middle_con">
                	<!-- 1ST -->
                	<ul>
                    	<li>
                        	<a href="#"><img src="ad_img/middle_img.jpg" alt="推荐1" /></a>
                            <div class="travel_info">
                            	<span class="left_words">￥1888</span>
                                <a href="#" class="right_words">治疗行程 >></a>
                            </div>
                        </li>
                       	<li>
                        	<a href="#"><img src="ad_img/middle_img.jpg" alt="推荐1" /></a>
                            <div class="travel_info">
                            	<span class="left_words">￥1888</span>
                                <a href="#" class="right_words">治疗行程 >></a>
                            </div>
                        </li>
                        <li>
                        	<a href="#"><img src="ad_img/middle_img.jpg" alt="推荐1" /></a>
                            <div class="travel_info">
                            	<span class="left_words">￥1888</span>
                                <a href="#" class="right_words">治疗行程 >></a>
                            </div>
                        </li>
                    </ul>
                    <!-- 2ND -->
                   	<ul>
                    	<li>
                        	<a href="#"><img src="ad_img/middle_img.jpg" alt="推荐1" /></a>
                            <div class="travel_info">
                            	<span class="left_words">￥1888</span>
                                <a href="#" class="right_words">治疗行程 >></a>
                            </div>
                        </li>
                       	<li>
                        	<a href="#"><img src="ad_img/middle_img.jpg" alt="推荐1" /></a>
                            <div class="travel_info">
                            	<span class="left_words">￥1888</span>
                                <a href="#" class="right_words">治疗行程 >></a>
                            </div>
                        </li>
                        <li>
                        	<a href="#"><img src="ad_img/middle_img.jpg" alt="推荐1" /></a>
                            <div class="travel_info">
                            	<span class="left_words">￥1888</span>
                                <a href="#" class="right_words">治疗行程 >></a>
                            </div>
                        </li>
                    </ul>
                    <!-- 3RD -->
                   	<ul>
                    	<li>
                        	<a href="#"><img src="ad_img/middle_img.jpg" alt="推荐1" /></a>
                            <div class="travel_info">
                            	<span class="left_words">￥1888</span>
                                <a href="#" class="right_words">治疗行程 >></a>
                            </div>
                        </li>
                       	<li>
                        	<a href="#"><img src="ad_img/middle_img.jpg" alt="推荐1" /></a>
                            <div class="travel_info">
                            	<span class="left_words">￥1888</span>
                                <a href="#" class="right_words">治疗行程 >></a>
                            </div>
                        </li>
                        <li>
                        	<a href="#"><img src="ad_img/middle_img.jpg" alt="推荐1" /></a>
                            <div class="travel_info">
                            	<span class="left_words">￥1888</span>
                                <a href="#" class="right_words">治疗行程 >></a>
                            </div>
                        </li>
                    </ul>
                    <!-- 4TH -->
                   	<ul>
                    	<li>
                        	<a href="#"><img src="ad_img/middle_img.jpg" alt="推荐1" /></a>
                            <div class="travel_info">
                            	<span class="left_words">￥1888</span>
                                <a href="#" class="right_words">治疗行程 >></a>
                            </div>
                        </li>
                       	<li>
                        	<a href="#"><img src="ad_img/middle_img.jpg" alt="推荐1" /></a>
                            <div class="travel_info">
                            	<span class="left_words">￥1888</span>
                                <a href="#" class="right_words">治疗行程 >></a>
                            </div>
                        </li>
                        <li>
                        	<a href="#"><img src="ad_img/middle_img.jpg" alt="推荐1" /></a>
                            <div class="travel_info">
                            	<span class="left_words">￥1888</span>
                                <a href="#" class="right_words">治疗行程 >></a>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- The Right -->
            <div id="main_right">
            	<div id="right_show"><a href="#">Далянь Выставка<br />2011-2012</a></div>
                <div id="right_mice"><a href="#">MICE</a></div>
                <div class="right_tools">
                	<div class="right_tool1"><a href="#">签证</a></div>
                    <div class="right_tool2"><a href="#">订票</a></div>
                </div>
                <div class="right_tools">
                	<div class="right_tool1"><a href="#">订车</a></div>
                    <div class="right_tool2"><a href="#">翻译</a></div>
                </div>
                <div id="right_about">
                	<div id="right_about_about"><a href="#">关于我们</a></div>
                    <div id="right_about_allow"><a href="#">许可证</a></div>
                </div>
                <div class="right_links"><a href="#">运输服务</a></div>
                <div class="right_links"><a href="#">供货者搜索</a></div>
                <div class="right_links"><a href="#">宣传册</a></div>
                <div class="money_ch">
                	<div class="mtitle">货币汇率</div>
                    <div class="mcon"></div>
                </div>
            </div>
        </div>
    <!-- The Footer -->
    	<div class="clear"></div>
    	<div id="links_bar">
        	<div id="lk_title"><@s.property value="%{getText('front.links')}"/></div>
            <ul class="links">
            	<li><a href="#">Юридическая информация</a></li>
                <li><a href="#">Юридическая информация</a></li>
                <li><a href="#">Юридическая информация</a></li>
            </ul>
            <div class="clear"></div>
        </div>
        <div id="copyright">
        	<@s.property value="%{getText('front.copyright')}"/> © 2010-2012  <@s.property value="%{getText('front.company')}"/>
        </div>
    </div>
    <div id="back_top"><a href="#">TOP</a></div>
	<script language="javascript" type="text/javascript">
		<!--//--><![CDATA[//><!--
		var scrollPic_02 = new ScrollPic();
		scrollPic_02.scrollContId   = "banner_ad"; //内容容器ID
		scrollPic_02.arrLeftId      = "LeftArr";//左箭头ID
		scrollPic_02.arrRightId     = "RightArr"; //右箭头ID

		scrollPic_02.frameWidth     = 764;//显示框宽度
		scrollPic_02.pageWidth      = 191; //翻页宽度

		scrollPic_02.speed          = 10; //移动速度(单位毫秒，越小越快)
		scrollPic_02.space          = 10; //每次移动像素(单位px，越大越快)
		scrollPic_02.autoPlay       = true; //自动播放
		scrollPic_02.autoPlayTime   = 3; //自动播放间隔时间(秒)

		scrollPic_02.initialize(); //初始化
							
		//--><!]]>
	</script>
</body>
</html>
</@fp.page>