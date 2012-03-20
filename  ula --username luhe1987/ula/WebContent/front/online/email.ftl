<@fp.page>
<!-- The Head -->
<@fp.header /><#-- header宏 -->
<!-- The Container  -->
<div id="container">
	<!-- The Banner  -->
	<@fp.banner /><#-- banner宏 -->
	<!-- The Navigation  -->
	<@fp.navigation c_index=false c_city=false c_tour=false c_service=false c_search=false c_contact=true c_online=false/><#-- navigation宏 -->
	<!-- The Main Body -->
	<div id="main_body">
		<!-- The Left -->
		<@fp.main_left_online /><#-- 主体左侧宏，包含关于大连导航，RSS订阅，天气预报-->
		 <!-- The Content -->
            <div id="article_content">
            
            	<div id="page_article_title">
                	<p><@s.property value="%{getText('front.online.email')}"/></p>
                </div>
                
            	<div id="page_article">

            		<div id="hotel">
						<form name="email_online" method="post" action="email" onsubmit="return validateForm(this)">
					
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
								<div class="right"><input type="text" name="phoneNumber" size="40" value = "(+country code) your number" emptyInfo="Please enter phone number"/></div>
							</div>
							
							<div class="line">
								<div class="left">
									<select name="contactType">
										<option value="email">Email</option>
									</select>*
		    					</div>
								<div class="right"><input type="text" name="contactValue" size="40" value="" emptyInfo="Please enter contact info"/></div>
							</div>
					
							<div class="line">
								<div class="left"><@s.property value="%{getText('hotel.booking.note')}"/>*</div>
								<div class="right"><textarea name="remarks" size="40" emptyInfo="Please enter remarks"></textarea></div>
							</div>
							
							<input type="hidden" name="from_user" value ="yes"/>
							
							<div class="line">
								<div><input type="submit" id="submitButton" value="<@s.property value="%{getText('hotel.booking.submit')}"/>" />&nbsp;&nbsp;<input type="reset" id="resetButton" value="<@s.property value="%{getText('front.booking.reset')}"/>" /></div>
							</div>
					
				</form>
			</div>
			
			<#if send_ok?exists && send_ok=="YES">
			<div style="text-align:center;margin-top:25px;color:red;font-size:24px;">OK</div>
			<#elseif send_ok?exists && send_ok=="NO">
			<div style="text-align:center;margin-top:25px;color:red;font-size:24px;">Sorry, Try again later</div>
			<#else>
			</#if>
		</div>
	</div>
            	
            	</div>
            </div>
	</div>
    <!-- The Footer -->
	<@fp.footer /><#-- footer宏 -->
</div>
</@fp.page>