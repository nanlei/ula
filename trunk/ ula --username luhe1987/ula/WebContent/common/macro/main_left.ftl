<#-- main_left宏 -->

<#-- 关于大连 -->
<#macro main_left>
		<div id="main_left">
			<div id="left_title"><@s.property value="%{getText('front.dalian.title')}"/></div>
			<div id="left_menu">
				<ul class="left_first_menu">
					<li><a href="${base}/city/intro.html"><@s.property value="%{getText('front.dalian.introduction')}"/></a></li>
					<li><a href="${base}/city/history.html"><@s.property value="%{getText('front.dalian.history')}"/></a></li>
					<li><a href="${base}/city/map.html"><@s.property value="%{getText('front.dalian.map')}"/></a></li>
					<li><a href="javascript:void(0)"><@s.property value="%{getText('front.dalian.site.park')}"/></a></li>
				</ul>
				<ul class="left_second_menu">
					<li><a href="${base}/city/tour/dalian.html"><@s.property value="%{getText('front.dalian.downtown')}"/></a></li>
					<li><a href="${base}/city/tour/lvshun.html"><@s.property value="%{getText('front.dalian.ls')}"/></a></li>
					<li><a href="${base}/city/tour/devzone.html"><@s.property value="%{getText('front.dalian.jst')}"/></a></li>
				</ul>
				<ul class="left_first_menu">
					<li><a href="${base}/city/food-3.html"><@s.property value="%{getText('front.dalian.food')}"/></a></li>
					<#--<li><a href="${base}/city/housing.html"><@s.property value="%{getText('front.dalian.housing')}"/></a></li>-->
					<li><a href="${base}/city/shopping-17.html"><@s.property value="%{getText('front.dalian.shopping')}"/></a></li>
					<li><a href="${base}/city/transportation-21.html"><@s.property value="%{getText('front.dalian.transportation')}"/></a></li>
					<li><a href="${base}/city/therapy-19.html"><@s.property value="%{getText('front.dalian.therapy')}"/></a></li>
					<li><a href="${base}/city/festival-20.html"><@s.property value="%{getText('front.dalian.festival')}"/></a></li>
					<li><a href="${base}/city/exhibition-27.html"><@s.property value="%{getText('front.dalian.exhibition')}"/></a></li>
					<li><a href="javascript:void(0)"><@s.property value="%{getText('front.dalian.other')}"/></a></li>
				</ul>
				<ul class="left_second_menu">
					<li><a href="${base}/city/insurance.html"><@s.property value="%{getText('front.dalian.insurance')}"/></a></li>
					<li><a href="${base}/city/law.html"><@s.property value="%{getText('front.dalian.law')}"/></a></li>
					<li><a href="${base}/city/mobile.html"><@s.property value="%{getText('front.dalian.mobile')}"/></a></li>
					<li><a href="${base}/city/tips.html"><@s.property value="%{getText('front.dalian.tips')}"/></a></li>
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
						<input class="rss_ch" type="radio" name="rss_ornot" value="yes" /><span><@s.property value="%{getText('front.rss.radio.subscribe')}"/></span><br />
						<input class="rss_ch" type="radio" name="rss_ornot" value="no" /><span><@s.property value="%{getText('front.rss.radio.cancel')}"/></span>
						<p align="right">
							<input id="info_submit" name="rss_add" type="button" value="&nbsp;&nbsp;&nbsp;&nbsp;<@s.property value="%{getText('front.rss.submit')}"/>&nbsp;&nbsp;&nbsp;&nbsp;" onclick="rssSubmit()"/>
						</p>
					</form>
				</div>
			</div>
			<div id="left_waether">
				<div id="waether_title">
					<span><@s.property value="%{getText('front.weather.title')}"/><#if locale?string?starts_with('zh')>&nbsp;&nbsp;&nbsp;${weather.UPDATETIME?string("yyyy-MM-dd HH:mm")}</#if></span>
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
					<tr>
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
</#macro>

<#-- 旅游行程 -->
<#macro main_left_tour>
		<div id="main_left">
			<div id="left_title"><@s.property value="%{getText('front.nav.jounery.tour')}"/></div>
			<div id="left_menu">
				<ul class="left_first_menu">
					<li><a href="${base}/tour/business.html"><@s.property value="%{getText('front.tour.business')}"/></a></li>
					<li><a href="${base}/tour/camping.html"><@s.property value="%{getText('front.tour.camping')}"/></a></li>
					<li><a href="${base}/tour/foodie.html"><@s.property value="%{getText('front.tour.foodie')}"/></a></li>
					<li><a href="${base}/tour/family.html"><@s.property value="%{getText('front.tour.family')}"/></a></li>
					<li><a href="${base}/tour/therapy.html"><@s.property value="%{getText('front.tour.therapy')}"/></a></li>
					<li><a href="${base}/tour/newyear.html"><@s.property value="%{getText('front.tour.newyear')}"/></a></li>
					<li><a href="${base}/tour/learn.html"><@s.property value="%{getText('front.tour.learn')}"/></a></li>
					<li><a href="${base}/tour/romantic.html"><@s.property value="%{getText('front.tour.romantic')}"/></a></li>
					<li><a href="${base}/tour/rural.html"><@s.property value="%{getText('front.tour.rural')}"/></a></li>
					<li><a href="${base}/tour/event.html"><@s.property value="%{getText('front.tour.event')}"/></a></li>
					<li><a href="${base}/tour/sport.html"><@s.property value="%{getText('front.tour.sport')}"/></a></li>
					<li><a href="${base}/tour/hotspring.html"><@s.property value="%{getText('front.tour.hotspring')}"/></a></li>
					<li><a href="${base}/tour/exhibition.html"><@s.property value="%{getText('front.tour.exhibition')}"/></a></li>
					<li><a href="${base}/tour/luxurious.html"><@s.property value="%{getText('front.tour.luxurious')}"/></a></li>
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
						<input class="rss_ch" type="radio" name="rss_ornot" value="yes" /><span><@s.property value="%{getText('front.rss.radio.subscribe')}"/></span><br />
						<input class="rss_ch" type="radio" name="rss_ornot" value="no" /><span><@s.property value="%{getText('front.rss.radio.cancel')}"/></span>
						<p align="right">
							<input id="info_submit" name="rss_add" type="button" value="&nbsp;&nbsp;&nbsp;&nbsp;<@s.property value="%{getText('front.rss.submit')}"/>&nbsp;&nbsp;&nbsp;&nbsp;" onclick="rssSubmit()"/>
						</p>
					</form>
				</div>
			</div>
			<div id="left_waether">
				<div id="waether_title">
					<span><@s.property value="%{getText('front.weather.title')}"/><#if locale?string?starts_with('zh')>&nbsp;&nbsp;&nbsp;${weather.UPDATETIME?string("yyyy-MM-dd HH:mm")}</#if></span>
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
					<tr>
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
</#macro>

<#-- 特色服务 -->
<#macro main_left_special>
		<div id="main_left">
			<div id="left_title"><@s.property value="%{getText('front.nav.special.service')}"/></div>
			<div id="left_menu">
				<ul class="left_first_menu">
					<li><a href="${base}/special/visa.html"><@s.property value="%{getText('front.special.visa')}"/></a></li>
                    <li><a href="${base}/special/hotel.html"><@s.property value="%{getText('front.special.hotel')}"/></a></li>
                    <li><a href="${base}/special/supplier.html"><@s.property value="%{getText('front.special.supplier')}"/></a></li>
                    <li><a href="javascript:void(0)"><@s.property value="%{getText('front.special.commission')}"/></a></li>
				</ul>
				<ul class="left_second_menu">
				    <li><a href="${base}/special/carrental.html"><@s.property value="%{getText('front.special.carrental')}"/></a></li>
                	<li><a href="${base}/special/ticketbooking.html"><@s.property value="%{getText('front.special.ticketbooking')}"/></a></li>
                	<li><a href="${base}/special/translation.html"><@s.property value="%{getText('front.special.translation')}"/></a></li>
                	<li><a href="${base}/special/shipping.html"><@s.property value="%{getText('front.special.shipping')}"/></a></li>
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
						<input class="rss_ch" type="radio" name="rss_ornot" value="yes" /><span><@s.property value="%{getText('front.rss.radio.subscribe')}"/></span><br />
						<input class="rss_ch" type="radio" name="rss_ornot" value="no" /><span><@s.property value="%{getText('front.rss.radio.cancel')}"/></span>
						<p align="right">
							<input id="info_submit" name="rss_add" type="button" value="&nbsp;&nbsp;&nbsp;&nbsp;<@s.property value="%{getText('front.rss.submit')}"/>&nbsp;&nbsp;&nbsp;&nbsp;" onclick="rssSubmit()"/>
						</p>
					</form>
				</div>
			</div>
			<div id="left_waether">
				<div id="waether_title">
					<span><@s.property value="%{getText('front.weather.title')}"/><#if locale?string?starts_with('zh')>&nbsp;&nbsp;&nbsp;${weather.UPDATETIME?string("yyyy-MM-dd HH:mm")}</#if></span>
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
					<tr>
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
</#macro>

<#-- 联系我们 -->
<#macro main_left_contact>
		<div id="main_left">
			<div id="left_title"><@s.property value="%{getText('front.nav.contact.us')}"/></div>
			<div id="left_menu">
				<ul class="left_first_menu">
                	<li><a href="${base}/contact/russian.html"><@s.property value="%{getText('front.contact.russian')}"/></a></li>
                    <li><a href="${base}/contact/chinese.html"><@s.property value="%{getText('front.contact.chinese')}"/></a></li>
                    <li><a href="${base}/contact/guest.html"><@s.property value="%{getText('front.contact.individual')}"/></a></li>
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
						<input class="rss_ch" type="radio" name="rss_ornot" value="yes" /><span><@s.property value="%{getText('front.rss.radio.subscribe')}"/></span><br />
						<input class="rss_ch" type="radio" name="rss_ornot" value="no" /><span><@s.property value="%{getText('front.rss.radio.cancel')}"/></span>
						<p align="right">
							<input id="info_submit" name="rss_add" type="button" value="&nbsp;&nbsp;&nbsp;&nbsp;<@s.property value="%{getText('front.rss.submit')}"/>&nbsp;&nbsp;&nbsp;&nbsp;" onclick="rssSubmit()"/>
						</p>
					</form>
				</div>
			</div>
			<div id="left_waether">
				<div id="waether_title">
					<span><@s.property value="%{getText('front.weather.title')}"/><#if locale?string?starts_with('zh')>&nbsp;&nbsp;&nbsp;${weather.UPDATETIME?string("yyyy-MM-dd HH:mm")}</#if></span>
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
					<tr>
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
</#macro>

<#macro weather2 w>
<div class="waether">
	<div class="waether_title">
		<span><@s.property value="%{getText('front.weather.title')}"/><#if locale?string?starts_with('zh')>&nbsp;&nbsp;&nbsp;${w.UPDATETIME?string("yyyy-MM-dd HH:mm")}</#if></span>
	</div>
	<table border="0"  cellspacing="0" cellpadding="0">
		<tr>
			<td width="60">
				<img src="http://m.weather.com.cn/img/b${w.IMG1}.gif" width="26" height="26" alt="network error" title="Weather"/>
				<#if w.IMG2?number?int!=99>
				<img src="http://m.weather.com.cn/img/b${w.IMG2}.gif" width="26" height="26" alt="network error" title="Weather"/>
				</#if>
			</td>
			<td width="75"><@s.property value="%{getText('front.weather.today')}"/></td>
			<td>${w.TEMP1}</td>
		</tr>
		<tr>
			<td width="60">
				<img src="http://m.weather.com.cn/img/b${w.IMG3}.gif" width="26" height="26" alt="network error" title="Weather"/>
				<#if w.IMG4?number?int!=99>
				<img src="http://m.weather.com.cn/img/b${w.IMG4}.gif" width="26" height="26" alt="network error" title="Weather"/>
				</#if>
			</td>
			<td width="75"><@s.property value="%{getText('front.weather.tomorrow')}"/></td>
			<td>${w.TEMP2}</td>
		</tr>
	</table>
</div>
</#macro>