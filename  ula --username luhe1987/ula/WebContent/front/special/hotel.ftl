<@fp.page>
<!-- The Head -->
<@fp.header /><#-- header宏 -->
<!-- The Container  -->
<div id="container">
	<!-- The Banner  -->
	<@fp.banner /><#-- banner宏 -->
	<!-- The Navigation  -->
	<@fp.navigation c_index=false c_city=false c_tour=false c_service=true c_search=false c_contact=false c_online=false/><#-- navigation宏 -->
	<!-- The Main Body -->
	<div id="main_body">
		<!-- The Left -->
		<@fp.main_left_special /><#-- 主体左侧宏，包含关于大连导航，RSS订阅，天气预报-->
		<!-- The Content -->
		<div id="article_content">
			<div id="page_article_title">
				<p><@s.property value="%{getText('front.special.hotel')}"/></p>
			</div>
			<div id="hotel">
				<form name="reserveForm" method="post" action="hotelReserve" onsubmit="return validateForm(this)">
					<div class="line">
						<div class="left"><@s.property value="%{getText('hotel.booking.hotelname')}"/>*</div>
						<div class="right"><input type="text" name="hotelName" size="40" value= "${hotelName}" emptyInfo="请输入酒店名称"/></div>
					</div>
					<div class="line">
						<div class="left"><@s.property value="%{getText('hotel.booking.people_num')}"/>*</div>
						<div class="right"><input type="text" name="guestTotal" value ="1" size="40" emptyInfo="请输入入住人数"/></div>
					</div>
					<div class="line">
						<div class="left"><@s.property value="%{getText('hotel.booking.rooms')}"/>*</div>
						<div class="right"><input type="text" name="roomTotal" value="1" size="40" emptyInfo="请输入预定间数"/></div>
					</div>
					<div class="line">
						<div class="left"><@s.property value="%{getText('hotel.booking.from')}"/>*</div>
						<div class="right"><input type="text" name="checkinDate" id = "checkinDate" size="40" readonly="readonly" emptyInfo="请选择入住日期"/></div>
					</div>
					<div class="line">
						<div class="left"><@s.property value="%{getText('hotel.booking.to')}"/>*</div>
						<div class="right"><input type="text" name="checkoutDate" id = "checkoutDate" size="40" readonly="readonly" emptyInfo="请选择离开日期"/></div>
					</div>
					<div class="line">
						<div class="left"><@s.property value="%{getText('hotel.booking.contact')}"/>*</div>
						<div class="right"><input type="text" name="contact" size="40" emptyInfo=""/></div>
					</div>
					<div class="line">
						<div class="left">
							<select name="phoneType">
								<option value="tel"><@s.property value="%{getText('hotel.booking.tel')}"/></option>
								<option value="mobile"><@s.property value="%{getText('hotel.booking.mobile')}"/></option>
    						</select>*
    					</div>
						<div class="right"><input type="text" name="phoneNumber" size="40" emptyInfo="请填写号码"/></div>
					</div>
					<div class="line">
						<div class="left">
							<select name="contactType">
								<option value="icq">ICQ</option>
								<option value="skype">Skype</option>
								<option value="email">Email</option>
							</select>*
    					</div>
						<div class="right"><input type="text" name="contactValue" size="40" emptyInfo="请填写联系方式"/></div>
					</div>
					<div class="line">
						<div class="left"><@s.property value="%{getText('hotel.booking.note')}"/>*</div>
						<div class="right"><input type="text" name="remarks" size="40" emptyInfo="请填写备注说明"/></div>
					</div>
					<div class="line">
						<div><input type="submit" id="submitButton" value="<@s.property value="%{getText('hotel.booking.submit')}"/>" />&nbsp;&nbsp;<input type="reset" id="resetButton" value="<@s.property value="%{getText('front.booking.reset')}"/>" /></div>
					</div>
				</form>
			</div>
			<#if reserveResult?if_exists?string=="success">
			<div style="text-align:center;margin-top:25px;color:red;font-size:24px;"><@s.property value="%{getText('front.booking.success')}"/></div>
			<#elseif reserveResult?if_exists?string=="failure">
			<div style="text-align:center;margin-top:25px;color:red;font-size:24px;"><@s.property value="%{getText('front.booking.error')}"/></div>
			<#else>
			</#if>
		</div>
	</div>
    <!-- The Footer -->
	<@fp.footer /><#-- footer宏 -->
</div>
</@fp.page>