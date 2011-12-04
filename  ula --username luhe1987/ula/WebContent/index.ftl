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
	<div id="search">
		<ul id="search_title">
			<li id="stab1" class="hover" onmouseover="setTab('stab',1,2)"><@s.property value="%{getText('front.search.tour')}"/></li>
			<li id="stab2" onmouseover="setTab('stab',2,3)"><@s.property value="%{getText('front.search.hotel')}"/></li>
		</ul>
		<!-- The Search Content -->
		<div id="tabcontent">
			<div id="con_stab_1">
				<form class="search_bar" action="" name="sch_form" method="post">
					<div class="tra_style">
						<div class="s_title">
							<@s.property value="%{getText('front.search.vacation.type')}"/>
						</div>
						<div>
							<div class="text_part">
								<p><input type="radio" name="travel_type" value="tt1" /><span><@s.property value="%{getText('front.search.vacation.type.all')}"/></span></p>
								<p><input type="radio" name="travel_type" value="tt2" /><span><@s.property value="%{getText('front.search.vacation.type.child')}"/></span></p>
								<p><input type="radio" name="travel_type" value="tt3" /><span><@s.property value="%{getText('front.search.vacation.type.luxurious')}"/></span></p>
								<p><input type="radio" name="travel_type" value="tt4" /><span><@s.property value="%{getText('front.search.vacation.type.foodie')}"/></span></p>
								<p><input type="radio" name="travel_type" value="tt5" /><span><@s.property value="%{getText('front.search.vacation.type.event')}"/></span></p>
							</div>
							<div class="text_part">
								<p><input type="radio" name="travel_type" value="tt6" /><span><@s.property value="%{getText('front.search.vacation.type.romantic')}"/></span></p>
								<p><input type="radio" name="travel_type" value="tt8" /><span><@s.property value="%{getText('front.search.vacation.type.family')}"/></span></p>
								<p><input type="radio" name="travel_type" value="tt9" /><span><@s.property value="%{getText('front.search.vacation.type.sport')}"/></span></p>
								<p><input type="radio" name="travel_type" value="tt0" /><span><@s.property value="%{getText('front.search.vacation.type.learn')}"/></span></p>
							</div>
						</div>
					</div>
					<div class="single_part">
						<div class="s_title"><@s.property value="%{getText('front.search.load.sport')}"/></div>
						<p><span><@s.property value="%{getText('front.search.load.unit')}"/>：</span>
							<select id="sport_num" name="sport_n">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</p>
						<p><input type="radio" name="sport_nl" onclick="sport_change('sport_num',5)" /><span><@s.property value="%{getText('front.search.load.max')}"/></span></p>
						<p><input type="radio" name="sport_nl" onclick="sport_change('sport_num',1)" /><span><@s.property value="%{getText('front.search.load.min')}"/></span></p>
					</div>
					<div class="single_part">
						<div class="s_title"><@s.property value="%{getText('front.search.hotel')}"/></div>
							<p><input type="radio" name="hotel" value="whole" /><span><@s.property value="%{getText('front.search.hotel.all')}"/></span></p>
							<p>
								<input type="radio" name="hotel" value="level3" /><span><@s.property value="%{getText('front.search.hotel.star3')}"/></span>
								<input type="radio" name="hotel" value="level4" /><span><@s.property value="%{getText('front.search.hotel.star4')}"/></span>
								<input type="radio" name="hotel" value="level5" /><span><@s.property value="%{getText('front.search.hotel.star5')}"/></span>
							</p>
							<p><input type="radio" name="hotel" value="level3" /><span><@s.property value="%{getText('front.search.hotel.express')}"/></span></p>
							<p><input type="radio" name="hotel" value="level3" /><span><@s.property value="%{getText('front.search.hotel.dormitory')}"/></span></p>
							<p><input type="radio" name="hotel" value="level3" /><span><@s.property value="%{getText('front.search.hotel.nursing')}"/></span></p>
						</div>
						<div class="time_part">
							<div class="s_title"><@s.property value="%{getText('front.search.date.title')}"/></div>
							<p><@s.property value="%{getText('front.search.date.travel')}"/>：</p>
							<p><input id="search_dater" type="checkbox" name="nothtl" onchange="hdiien_input()" /><@s.property value="%{getText('front.search.date.no')}"/></p>
							<div id="start_time" class="time_ch"><@s.property value="%{getText('front.search.date.from')}"/>:<input name="start_time" id="fromDate" class="Wdate" type="text" readonly="readonly"/></div>
							<div id="end_time" class="time_ch"><@s.property value="%{getText('front.search.date.to')}"/>:<input name="end_time" id="toDate" class="Wdate" type="text" readonly="readonly"/></div>
							<div>
								<div><@s.property value="%{getText('front.search.date.people')}"/>:</div>
								<div><input class="short" type="text" />&nbsp;<@s.property value="%{getText('front.search.date.adult')}"/></div>
								<div style="margin-top:5px"><input class="short" type="text" />&nbsp;<@s.property value="%{getText('front.search.date.child')}"/></div>
							</div>
						</div>
						<div class="single_part">
							<div class="s_title"><@s.property value="%{getText('front.search.guide.require')}"/></div>
							<p><input type="radio" name="guide" value="ser1" /><span><@s.property value="%{getText('front.search.guide.airport')}"/></span></p>
							<p><input type="radio" name="guide" value="ser2" /><span><@s.property value="%{getText('front.search.guide.tour')}"/></span></p>
							<p><input type="radio" name="guide" value="ser3" /><span><@s.property value="%{getText('front.search.guide.fulltime')}"/></span></p>
							<p><input type="radio" name="guide" value="ser4" /><span><@s.property value="%{getText('front.search.guide.fixed')}"/></span></p>
							<p><input type="radio" name="guide" value="ser5" /><span><@s.property value="%{getText('front.search.guide.no')}"/></span></p>
						</div>
						<input type="submit" class="search_btn" name="travel_sh" value=" " />
					</form>
					<div class="clear"></div>
				</div>
                <div id="con_stab_2" class="hidden">
                	<form class="search_bar" action="" method="post">
                     	<div class="single_part">
                        	<div class="s_title">位置</div>
                            <p><input type="radio" name="where" value="city" /><span>大连市区</span></p>
                            <p><input type="radio" name="where" value="jst" /><span>金石滩</span></p>
                            <p><input type="radio" name="where" value="ls" /><span>旅顺</span></p>
                            <p><input type="radio" name="where" value="hb" /><span>海边</span></p>
                       	</div>
                   		<div class="single_part">
                        	<div class="s_title">按星级选择</div>
                            <p><input type="radio" name="hotel" value="ht_le3" /><span>3星</span></p>
                            <p><input type="radio" name="hotel" value="ht_le4" /><span>4星</span></p>
                            <p><input type="radio" name="hotel" value="ht_le5" /><span>5星</span></p>
                        </div>
                        <div class="single_part">
                        	<div class="s_title">按功能选择</div>
                            <p><input type="radio" name="hotel" value="sty_kj" /><span>快捷酒店</span></p>
                            <p><input type="radio" name="hotel" value="sty_gy" /><span>公寓式酒店</span></p>
                            <p><input type="radio" name="hotel" value="sty_ly" /><span>疗养院式酒店</span></p>
                        </div>
                        <input type="submit" class="search_btn" name="hotel_sh" value=" " />
                        </form>
                        <div class="clear"></div>
                </div>
            </div>
        </div>
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
        	Copyright © 2010-2012 <@s.property value="%{getText('front.copyright')}"/>  <@s.property value="%{getText('front.company')}"/>
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