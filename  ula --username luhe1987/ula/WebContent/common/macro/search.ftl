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
				<form name="tourSearchForm" class="search_bar" action="${base}/search/tourSearch.html" name="sch_form" method="post">
					<div class="tra_style">
						<div class="s_title"><@s.property value="%{getText('front.search.vacation.type')}"/></div>
						<div class="text_part">
							<p><input type="checkbox" id="ttselector" onClick="selectAllType()" /><span><@s.property value="%{getText('front.search.vacation.type.all')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="2" /><span><@s.property value="%{getText('front.search.vacation.type.therapy')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="3" /><span><@s.property value="%{getText('front.search.vacation.type.child')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="4" /><span><@s.property value="%{getText('front.search.vacation.type.romantic')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="5" /><span><@s.property value="%{getText('front.search.vacation.type.luxurious')}"/></span></p>
						</div>
						<div class="text_part2">
							<p><input type="checkbox" name="travel_type" value="6" /><span><@s.property value="%{getText('front.search.vacation.type.family')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="7" /><span><@s.property value="%{getText('front.search.vacation.type.foodie')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="8" /><span><@s.property value="%{getText('front.search.vacation.type.sport')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="9" /><span><@s.property value="%{getText('front.search.vacation.type.event')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="10" /><span><@s.property value="%{getText('front.search.vacation.type.learn')}"/></span></p>
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
					<div class="hotel_part">
						<div class="s_title"><@s.property value="%{getText('front.search.hotel')}"/></div>
						<p><input type="checkbox" id="hselector" onclick="selectAllHotel()" /><span><@s.property value="%{getText('front.search.hotel.all')}"/></span></p>
						<p>
							<input type="checkbox" name="level" value="3star" /><span><@s.property value="%{getText('front.search.hotel.star3')}"/></span>
							<input type="checkbox" name="level" value="4star" /><span><@s.property value="%{getText('front.search.hotel.star4')}"/></span>
							<input type="checkbox" name="level" value="5star" /><span><@s.property value="%{getText('front.search.hotel.star5')}"/></span>
						</p>
						<p><input type="checkbox" name="level" value="express_hotel" /><span><@s.property value="%{getText('front.search.hotel.express')}"/></span></p>
						<p><input type="checkbox" name="level" value="apartment_hotel" /><span><@s.property value="%{getText('front.search.hotel.dormitory')}"/></span></p>
						<p><input type="checkbox" name="level" value="nursing_hotel" /><span><@s.property value="%{getText('front.search.hotel.nursing')}"/></span></p>
					</div>
					
					<div class="time_part">
						<div class="s_title"><@s.property value="%{getText('front.search.date.title')}"/></div>
						<p><@s.property value="%{getText('front.search.date.travel')}"/>:</p>
						<p><input id="search_dater" type="checkbox" name="notnecessary" onchange="hdiien_input()" /><@s.property value="%{getText('front.search.date.no')}"/></p>
						<div id="start_time" class="time_ch"><span class="date_span"><@s.property value="%{getText('front.search.date.from')}"/>:</span><input name="start_time" id="fromDate" type="text" readonly="readonly"/></div>
						<div id="end_time" class="time_ch"><span class="date_span"><@s.property value="%{getText('front.search.date.to')}"/>:</span><input name="end_time" id="toDate" type="text" readonly="readonly"/></div>
						
					    <div align="left">
							<p><span class="p_people"><@s.property value="%{getText('front.search.date.people')}"/></span></p>
							<p><span class="p_nums"><@s.property value="%{getText('front.search.date.adult')}"/>:</span><input class="short" type="text" name="adult_n"/></p>
							<p><span class="p_nums"><@s.property value="%{getText('front.search.date.child')}"/>:</span><input class="short" type="text" name="child_n"/></p>	
					 	</div>
					</div>
					
					<div class="single_part">
						<div class="s_title"><@s.property value="%{getText('front.search.guide.require')}"/></div>
						<p><input type="radio" name="guide" value="airport" /><span><@s.property value="%{getText('front.search.guide.airport')}"/></span></p>
						<p><input type="radio" name="guide" value="tour" /><span><@s.property value="%{getText('front.search.guide.tour')}"/></span></p>
						<p><input type="radio" name="guide" value="fulltime" /><span><@s.property value="%{getText('front.search.guide.fulltime')}"/></span></p>
						<p><input type="radio" name="guide" value="fixed" /><span><@s.property value="%{getText('front.search.guide.fixed')}"/></span></p>
						<p><input type="radio" name="guide" value="no" /><span><@s.property value="%{getText('front.search.guide.no')}"/></span></p>
					</div>
					<input type="submit" class="search_btn" name="travel_sh" value=" " />
					<div class="clear"></div>
				</form>
			</div>
			
			<div id="con_stab_2" class="hidden">
				<form name="hotelSearchForm" class="search_bar" action="${base}/search/hotelSearch.html" method="post" onsubmit="return validateForm(this)">
					<div class="single_part">
						<div class="s_title"><@s.property value="%{getText('front.search.location')}"/></div>
						<p><input type="radio" name="location" value="downtown" emptyInfo="please choose location"/><span><@s.property value="%{getText('front.search.location.dalian')}"/></span></p>
						<p><input type="radio" name="location" value="jinshitan" emptyInfo="please choose location"/><span><@s.property value="%{getText('front.search.location.jst')}"/></span></p>
						<p><input type="radio" name="location" value="lvshun" emptyInfo="please choose location"/><span><@s.property value="%{getText('front.search.location.ls')}"/></span></p>
					</div>
					<div class="single_part">
						<div class="s_title"><@s.property value="%{getText('front.search.star')}"/></div>
						<p><input type="radio" name="level" value="3star" emptyInfo="please choose level"/><span><@s.property value="%{getText('front.search.star3')}"/></span></p>
						<p><input type="radio" name="level" value="4star" emptyInfo="please choose level"/><span><@s.property value="%{getText('front.search.star4')}"/></span></p>
						<p><input type="radio" name="level" value="5star" emptyInfo="please choose level"/><span><@s.property value="%{getText('front.search.star5')}"/></span></p>
						<p><input type="radio" name="level" value="express_hotel" emptyInfo="please choose level"/><span><@s.property value="%{getText('front.search.star.express')}"/></span></p>
						<p><input type="radio" name="level" value="apartment_hotel" emptyInfo="please choose level"/><span><@s.property value="%{getText('front.search.star.dormitory')}"/></span></p>
						<p><input type="radio" name="level" value="nursing_hotel" emptyInfo="please choose level"/><span><@s.property value="%{getText('front.search.star.nursing')}"/></span></p>
					</div>
					<div class="single_part_func">
						<div class="s_title"><@s.property value="%{getText('front.search.function')}"/></div>
						<div class="text_part_func">
							<p><input type="radio" name="func" value="huizhanzhongxinfujin" emptyInfo="please choose function"/><span><@s.property value="%{getText('front.search.function.exhibition')}"/></span></p>
							<p><input type="radio" name="func" value="yuchang" emptyInfo="please choose function"/><span><@s.property value="%{getText('front.search.function.beach')}"/></span></p>
							<p><input type="radio" name="func" value="zhiliao" emptyInfo="please choose function"/><span><@s.property value="%{getText('front.search.function.treatment')}"/></span></p>
							<p><input type="radio" name="func" value="shangchang" emptyInfo="please choose function"/><span><@s.property value="%{getText('front.search.function.store')}"/></span></p>
							<p><input type="radio" name="func" value="zhiliaoshangchang" emptyInfo="please choose function"/><span><@s.property value="%{getText('front.search.function.treatment.store')}"/></span></p>
							<p><input type="radio" name="func" value="yuchangzhiliao" emptyInfo="please choose function"/><span><@s.property value="%{getText('front.search.function.treatment.beach')}"/></span></p>
						</div>
						<div class="text_part_func">
							<p><input type="radio" name="func" value="gongyuan" emptyInfo="please choose function"/><span><@s.property value="%{getText('front.search.function.garden.hotel')}"/></span></p>
							<p><input type="radio" name="func" value="kaojindaxue" emptyInfo="please choose function"/><span><@s.property value="%{getText('front.search.function.college')}"/></span></p>
						</div>
					</div>
					<input type="submit" class="search_btn" name="hotel_sh" value="" />
				</form>
				<div class="clear"></div>
			</div>
		</div>
	</div>
</#macro>

<#macro search_hotel>
	<div id="search">
		<ul id="search_title">
			<li id="stab2" class="hover"><@s.property value="%{getText('front.search.hotel')}"/></li>
		</ul>
		<!-- The Search Content -->
		<div id="tabcontent">
			<div id="con_stab_1">
				<form name="hotelSearchForm" class="search_bar" action="${base}/search/hotelSearch.html" method="post" onsubmit="return validateForm(this)">
					<div class="single_part">
						<div class="s_title"><@s.property value="%{getText('front.search.location')}"/></div>
						<p><input type="radio" name="location" value="downtown" /><span><@s.property value="%{getText('front.search.location.dalian')}"/></span></p>
						<p><input type="radio" name="location" value="jinshitan" /><span><@s.property value="%{getText('front.search.location.jst')}"/></span></p>
						<p><input type="radio" name="location" value="lvshun" /><span><@s.property value="%{getText('front.search.location.ls')}"/></span></p>
					</div>
					<div class="single_part">
						<div class="s_title"><@s.property value="%{getText('front.search.star')}"/></div>
						<p><input type="radio" name="level" value="3star" /><span><@s.property value="%{getText('front.search.star3')}"/></span></p>
						<p><input type="radio" name="level" value="4star" /><span><@s.property value="%{getText('front.search.star4')}"/></span></p>
						<p><input type="radio" name="level" value="5star" /><span><@s.property value="%{getText('front.search.star5')}"/></span></p>
						<p><input type="radio" name="level" value="express_hotel" /><span><@s.property value="%{getText('front.search.star.express')}"/></span></p>
						<p><input type="radio" name="level" value="apartment_hotel" /><span><@s.property value="%{getText('front.search.star.dormitory')}"/></span></p>
						<p><input type="radio" name="level" value="nursing_hotel" /><span><@s.property value="%{getText('front.search.star.nursing')}"/></span></p>
					</div>
					<div class="single_part_func">
						<div class="s_title"><@s.property value="%{getText('front.search.function')}"/></div>
						<div class="text_part_func">
							<p><input type="radio" name="func" value="huizhanzhongxinfujin" /><span><@s.property value="%{getText('front.search.function.exhibition')}"/></span></p>
							<p><input type="radio" name="func" value="yuchang" /><span><@s.property value="%{getText('front.search.function.beach')}"/></span></p>
							<p><input type="radio" name="func" value="zhiliao" /><span><@s.property value="%{getText('front.search.function.treatment')}"/></span></p>
							<p><input type="radio" name="func" value="shangchang" /><span><@s.property value="%{getText('front.search.function.store')}"/></span></p>
							<p><input type="radio" name="func" value="zhiliaoshangchang" /><span><@s.property value="%{getText('front.search.function.treatment.store')}"/></span></p>
							<p><input type="radio" name="func" value="yuchangzhiliao" /><span><@s.property value="%{getText('front.search.function.treatment.beach')}"/></span></p>
						</div>
						<div class="text_part_func">
							<p><input type="radio" name="func" value="gongyuan" /><span><@s.property value="%{getText('front.search.function.garden.hotel')}"/></span></p>
							<p><input type="radio" name="func" value="kaojindaxue" /><span><@s.property value="%{getText('front.search.function.college')}"/></span></p>
						</div>
					</div>
					<input type="submit" class="search_btn" name="hotel_sh" value="" />
				</form>		
			</div>
		</div>
	</div>
</#macro>

<#macro search_tour>
	<div id="search">
		<ul id="search_title">
			<li id="stab1" class="hover"><@s.property value="%{getText('front.search.tour')}"/></li>
		</ul>
		<!-- The Search Content -->
		<div id="tabcontent">
			<div id="con_stab_1">
				<form name="tourSearchForm" class="search_bar" action="${base}/search/tourSearch.html" name="sch_form" method="post">
					<div class="tra_style">
						<div class="s_title"><@s.property value="%{getText('front.search.vacation.type')}"/></div>
						<div class="text_part">
							<p><input type="checkbox" id="ttselector" onClick="selectAllType()" /><span><@s.property value="%{getText('front.search.vacation.type.all')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="2" /><span><@s.property value="%{getText('front.search.vacation.type.therapy')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="3" /><span><@s.property value="%{getText('front.search.vacation.type.child')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="4" /><span><@s.property value="%{getText('front.search.vacation.type.romantic')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="5" /><span><@s.property value="%{getText('front.search.vacation.type.luxurious')}"/></span></p>
						</div>
						<div class="text_part2">
							<p><input type="checkbox" name="travel_type" value="6" /><span><@s.property value="%{getText('front.search.vacation.type.family')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="7" /><span><@s.property value="%{getText('front.search.vacation.type.foodie')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="8" /><span><@s.property value="%{getText('front.search.vacation.type.sport')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="9" /><span><@s.property value="%{getText('front.search.vacation.type.event')}"/></span></p>
							<p><input type="checkbox" name="travel_type" value="10" /><span><@s.property value="%{getText('front.search.vacation.type.learn')}"/></span></p>
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
					<div class="hotel_part">
						<div class="s_title"><@s.property value="%{getText('front.search.hotel')}"/></div>
						<p><input type="checkbox" id="hselector" onclick="selectAllHotel()" /><span><@s.property value="%{getText('front.search.hotel.all')}"/></span></p>
						<p>
							<input type="checkbox" name="level" value="3star" /><span><@s.property value="%{getText('front.search.hotel.star3')}"/></span>
							<input type="checkbox" name="level" value="4star" /><span><@s.property value="%{getText('front.search.hotel.star4')}"/></span>
							<input type="checkbox" name="level" value="5star" /><span><@s.property value="%{getText('front.search.hotel.star5')}"/></span>
						</p>
						<p><input type="checkbox" name="level" value="express_hotel" /><span><@s.property value="%{getText('front.search.hotel.express')}"/></span></p>
						<p><input type="checkbox" name="level" value="apartment_hotel" /><span><@s.property value="%{getText('front.search.hotel.dormitory')}"/></span></p>
						<p><input type="checkbox" name="level" value="nursing_hotel" /><span><@s.property value="%{getText('front.search.hotel.nursing')}"/></span></p>
					</div>
					<div class="time_part">
						<div class="s_title"><@s.property value="%{getText('front.search.date.title')}"/></div>
						<p><@s.property value="%{getText('front.search.date.travel')}"/>:</p>
						<p><input id="search_dater" type="checkbox" name="notnecessary" onchange="hdiien_input()" /><@s.property value="%{getText('front.search.date.no')}"/></p>
						<div id="start_time" class="time_ch"><@s.property value="%{getText('front.search.date.from')}"/>:<input name="start_time" id="fromDate" type="text"/></div>
						<div id="end_time" class="time_ch"><@s.property value="%{getText('front.search.date.to')}"/>:<input name="end_time" id="toDate" type="text"/></div>
						
						<div align="left">
							<p><span class="p_people"><@s.property value="%{getText('front.search.date.people')}"/></span></p>
							<p><span class="p_nums"><@s.property value="%{getText('front.search.date.adult')}"/>:</span><input class="short" type="text" name="adult_n"/></p>
							<p><span class="p_nums"><@s.property value="%{getText('front.search.date.child')}"/>:</span><input class="short" type="text" name="child_n"/></p>
						</div>
					</div>
					<div class="single_part">
						<div class="s_title"><@s.property value="%{getText('front.search.guide.require')}"/></div>
						<p><input type="radio" name="guide" value="airport" /><span><@s.property value="%{getText('front.search.guide.airport')}"/></span></p>
						<p><input type="radio" name="guide" value="tour" /><span><@s.property value="%{getText('front.search.guide.tour')}"/></span></p>
						<p><input type="radio" name="guide" value="fulltime" /><span><@s.property value="%{getText('front.search.guide.fulltime')}"/></span></p>
						<p><input type="radio" name="guide" value="fixed" /><span><@s.property value="%{getText('front.search.guide.fixed')}"/></span></p>
						<p><input type="radio" name="guide" value="no" /><span><@s.property value="%{getText('front.search.guide.no')}"/></span></p>
					</div>
					<input type="submit" class="search_btn" name="travel_sh" value=" " />
					<div class="clear"></div>
				</form>
			</div>
		</div>
	</div>
</#macro>