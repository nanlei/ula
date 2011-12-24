<#-- main_left宏 -->
<#macro main_left>
		<div id="main_left">
			<div id="left_title"><@s.property value="%{getText('front.dalian.title')}"/></div>
			<div id="left_menu">
				<ul class="left_first_menu">
					<li><a href="${base}/city/intro.html"><@s.property value="%{getText('front.dalian.introduction')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.history')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.map')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.site.park')}"/></a></li>
				</ul>
				<ul class="left_second_menu">
					<li><a href="#"><@s.property value="%{getText('front.dalian.downtown')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.ls')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.jst')}"/></a></li>
				</ul>
				<ul class="left_first_menu">
					<li><a href="#"><@s.property value="%{getText('front.dalian.food')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.housing')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.shopping')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.transportation')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.therapy')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.festival')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.exhibition')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.other')}"/></a></li>
				</ul>
				<ul class="left_second_menu">
					<li><a href="#"><@s.property value="%{getText('front.dalian.insurance')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.law')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.mobile')}"/></a></li>
					<li><a href="#"><@s.property value="%{getText('front.dalian.tips')}"/></a></li>
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