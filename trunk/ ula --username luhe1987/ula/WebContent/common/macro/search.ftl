<#-- search宏 -->
<#macro search>
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
						<div class="s_title"><@s.property value="%{getText('front.search.vacation.type')}"/></div>
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
					<div class="single_part">
						<div class="s_title"><@s.property value="%{getText('front.search.load.sport')}"/></div>
						<p>
							<span><@s.property value="%{getText('front.search.load.unit')}"/>：</span>
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
						<p><@s.property value="%{getText('front.search.date.travel')}"/>:</p>
						<p><input id="search_dater" type="checkbox" name="nothtl" onchange="hdiien_input()" /><@s.property value="%{getText('front.search.date.no')}"/></p>
						<div id="start_time" class="time_ch"><@s.property value="%{getText('front.search.date.from')}"/>:<input name="start_time" id="fromDate" class="Wdate" type="text" readonly="readonly"/></div>
						<div id="end_time" class="time_ch"><@s.property value="%{getText('front.search.date.to')}"/>:<input name="end_time" id="toDate" class="Wdate" type="text" readonly="readonly"/></div>
						<div><@s.property value="%{getText('front.search.date.people')}"/>:</div>
						<div><input class="short" type="text" />&nbsp;<@s.property value="%{getText('front.search.date.adult')}"/></div>
						<div style="margin-top:5px"><input class="short" type="text" />&nbsp;<@s.property value="%{getText('front.search.date.child')}"/></div>	
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
					<div class="clear"></div>
				</form>
			</div>
			<div id="con_stab_2" class="hidden">
				<form class="search_bar" action="" method="post">
					<div class="single_part">
						<div class="s_title"><@s.property value="%{getText('front.search.location')}"/></div>
						<p><input type="radio" name="where" value="city" /><span><@s.property value="%{getText('front.search.location.dalian')}"/></span></p>
						<p><input type="radio" name="where" value="jst" /><span><@s.property value="%{getText('front.search.location.jst')}"/></span></p>
						<p><input type="radio" name="where" value="ls" /><span><@s.property value="%{getText('front.search.location.ls')}"/></span></p>
					</div>
					<div class="single_part">
						<div class="s_title"><@s.property value="%{getText('front.search.star')}"/></div>
						<p><input type="radio" name="hotel" value="ht_le3" /><span><@s.property value="%{getText('front.search.star3')}"/></span></p>
						<p><input type="radio" name="hotel" value="ht_le4" /><span><@s.property value="%{getText('front.search.star4')}"/></span></p>
						<p><input type="radio" name="hotel" value="ht_le5" /><span><@s.property value="%{getText('front.search.star5')}"/></span></p>
						<p><input type="radio" name="hotel" value="sty_kj" /><span><@s.property value="%{getText('front.search.star.express')}"/></span></p>
						<p><input type="radio" name="hotel" value="sty_gy" /><span><@s.property value="%{getText('front.search.star.dormitory')}"/></span></p>
						<p><input type="radio" name="hotel" value="sty_ly" /><span><@s.property value="%{getText('front.search.star.nursing')}"/></span></p>
					</div>
					<div class="single_part_func">
						<div class="s_title"><@s.property value="%{getText('front.search.function')}"/></div>
						<div class="text_part_func">
							<p><input type="radio" name="hotel" value="sty_ly" /><span><@s.property value="%{getText('front.search.function.exhibition')}"/></span></p>
							<p><input type="radio" name="hotel" value="sty_ly" /><span><@s.property value="%{getText('front.search.function.beach')}"/></span></p>
							<p><input type="radio" name="hotel" value="sty_ly" /><span><@s.property value="%{getText('front.search.function.treatment')}"/></span></p>
							<p><input type="radio" name="hotel" value="sty_ly" /><span><@s.property value="%{getText('front.search.function.store')}"/></span></p>
							<p><input type="radio" name="hotel" value="sty_ly" /><span><@s.property value="%{getText('front.search.function.treatment.store')}"/></span></p>
							<p><input type="radio" name="hotel" value="sty_ly" /><span><@s.property value="%{getText('front.search.function.treatment.beach')}"/></span></p>
						</div>
						<div class="text_part_func">
							<p><input type="radio" name="hotel" value="sty_ly" /><span><@s.property value="%{getText('front.search.function.garden.hotel')}"/></span></p>
							<p><input type="radio" name="hotel" value="sty_ly" /><span><@s.property value="%{getText('front.search.function.college')}"/></span></p>
						</div>
					</div>
					<input type="submit" class="search_btn" name="hotel_sh" value=" " />
				</form>
				<div class="clear"></div>
			</div>
		</div>
	</div>
</#macro>