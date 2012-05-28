<#-- navigation宏 -->
<#macro navigation c_index c_city c_tour c_service c_search c_contact c_online>
    
    <div id="nav">
    	<ul>
    		<li><a<#if c_index> class="clicked"</#if> href="${base}/index.html"><@s.property value="%{getText('front.nav.homepage')}"/></a></li>
    		<li id="city_li"><a <#if c_city> class="clicked"</#if> onmouseover="secondNav('snav1');" onmouseout="hidden_nav('snav1');" href="javascript:void(0)"><@s.property value="%{getText('front.nav.about.dalian')}"/></a></li>
    		<li id="tour_li" <#if locale='ru'> class="sp"</#if>><a<#if c_tour> class="clicked"</#if> onmouseover="secondNav('snav2');" onmouseout="hidden_nav('snav2');" href="javascript:void(0)"><@s.property value="%{getText('front.nav.jounery.tour')}"/></a></li>
    		<li id="special_li"<#if locale='ru'> class="sp"</#if>><a<#if c_service> class="clicked"</#if> onmouseover="secondNav('snav3');" onmouseout="hidden_nav('snav3');" href="javascript:void(0)"><@s.property value="%{getText('front.nav.special.service')}"/></a></li>
    		<li id="search_li"><a<#if c_search> class="clicked"</#if> onmouseover="secondNav('snav4');" onmouseout="hidden_nav('snav4');" href="javascript:void(0)"><@s.property value="%{getText('front.nav.search')}"/></a></li>
    		<li id="contact_li"><a<#if c_contact> class="clicked"</#if> onmouseover="secondNav('snav5');" onmouseout="hidden_nav('snav5');" href="javascript:void(0)"><@s.property value="%{getText('front.nav.contact.us')}"/></a></li>
    		<li id="online_li" <#if locale='ru'> class="sp"</#if>> <a<#if c_online> class="clicked"</#if> onmouseover="secondNav('snav6');" onmouseout="hidden_nav('snav6');" href="javascript:void(0)"><@s.property value="%{getText('front.nav.online.contact')}"/></a></li>
    	</ul>
    </div>
    
 	<div id="nav_sed">
 		<div id="snav1" class="menu1" onmouseover="secondNav('snav1');" onmouseout="hidden_nav('snav1');">
 			<ul class="ul1">
 				<li><a href="${base}/city/intro.html">▪ <@s.property value="%{getText('front.dalian.introduction')}"/></a></li>
 				<li><a href="${base}/city/history.html">▪ <@s.property value="%{getText('front.dalian.history')}"/></a></li>
 				<li><a href="${base}/city/map.html">▪ <@s.property value="%{getText('front.dalian.map')}"/></a></li>
 				<li><a href="javascript:void(0)">▪ <@s.property value="%{getText('front.dalian.site.park')}"/></a></li>
 			</ul>
 			<ul class="ul2">
 				<li><a href="${base}/city/tour/dalian.html"><@s.property value="%{getText('front.dalian.downtown')}"/></a></li>
 				<li><a href="${base}/city/tour/lvshun.html"><@s.property value="%{getText('front.dalian.ls')}"/></a></li>
 				<li><a href="${base}/city/tour/devzone.html"><@s.property value="%{getText('front.dalian.jst')}"/></a></li>
 			</ul>
 			<ul class="ul1">
 				<li><a href="${base}/city/food-3.html">▪ <@s.property value="%{getText('front.dalian.food')}"/></a></li>
 				<#--<li><a href="${base}/city/housing.html">▪ <@s.property value="%{getText('front.dalian.housing')}"/></a></li>-->
 				<li><a href="${base}/city/shopping-17.html">▪ <@s.property value="%{getText('front.dalian.shopping')}"/></a></li>
 				<li><a href="${base}/city/transportation-21.html">▪ <@s.property value="%{getText('front.dalian.transportation')}"/></a></li>
 				<li><a href="${base}/city/therapy-19.html">▪ <@s.property value="%{getText('front.dalian.therapy')}"/></a></li>
 				<li><a href="${base}/city/festival-20.html">▪ <@s.property value="%{getText('front.dalian.festival')}"/></a></li>
 				<li><a href="${base}/city/exhibition-27.html">▪ <@s.property value="%{getText('front.dalian.exhibition')}"/></a></li>
 				<li><a href="javascript:void(0)">▪ <@s.property value="%{getText('front.dalian.other')}"/></a></li>
 			</ul>
 			<ul class="ul2">
 				<li><a href="${base}/city/insurance.html"><@s.property value="%{getText('front.dalian.insurance')}"/></a></li>
 				<li><a href="${base}/city/law.html"><@s.property value="%{getText('front.dalian.law')}"/></a></li>
 				<li><a href="${base}/city/mobile.html"><@s.property value="%{getText('front.dalian.mobile')}"/></a></li>
 				<li><a href="${base}/city/tips.html"><@s.property value="%{getText('front.dalian.tips')}"/></a></li>
 			</ul>
 		</div>
            <div id="snav2" class="menu2"  onmouseover="secondNav('snav2');" onmouseout="hidden_nav('snav2');">
            	<ul class="ul1">
                	<li><a href="${base}/tour/business.html"><@s.property value="%{getText('front.tour.business')}"/></a></li>
					<li><a href="${base}/tour/camping.html"><@s.property value="%{getText('front.tour.camping')}"/></a></li>
					<li><a href="${base}/tour/foodie.html"><@s.property value="%{getText('front.tour.foodie')}"/></a></li>
					<li><a href="${base}/tour/normal.html"><@s.property value="%{getText('front.tour.normal')}"/></a></li>
					<li><a href="${base}/tour/therapy.html"><@s.property value="%{getText('front.tour.therapy')}"/></a></li>
					<li><a href="${base}/tour/newyear.html"><@s.property value="%{getText('front.tour.newyear')}"/></a></li>
					<li><a href="${base}/tour/learn.html"><@s.property value="%{getText('front.tour.learn')}"/></a></li>
					<li><a href="${base}/tour/romantic.html"><@s.property value="%{getText('front.tour.romantic')}"/></a></li>
					<li><a href="${base}/tour/rural.html"><@s.property value="%{getText('front.tour.rural')}"/></a></li>
					<li><a href="${base}/tour/event.html"><@s.property value="%{getText('front.tour.event')}"/></a></li>
					<li><a href="${base}/tour/sport.html"><@s.property value="%{getText('front.tour.sport')}"/></a></li>
					<li><a href="${base}/tour/hotspring.html"><@s.property value="%{getText('front.tour.hotspring')}"/></a></li>
					<li><a href="${base}/tour/individual.html"><@s.property value="%{getText('front.tour.individual')}"/></a></li>
					<li><a href="${base}/tour/luxurious.html"><@s.property value="%{getText('front.tour.luxurious')}"/></a></li>
                </ul>
            </div>
            <div id="snav3" class="menu3" onmouseover="secondNav('snav3');" onmouseout="hidden_nav('snav3');">
            	<ul class="ul1">
                	<li><a href="${base}/special/visa.html">▪ <@s.property value="%{getText('front.special.visa')}"/></a></li>
                    <li><a href="${base}/special/hotel.html">▪ <@s.property value="%{getText('front.special.hotel')}"/></a></li>
                    <li><a href="${base}/special/supplier.html">▪ <@s.property value="%{getText('front.special.supplier')}"/></a></li>
                    <li><a href="javascript:void(0)">▪ <@s.property value="%{getText('front.special.commission')}"/></a></li>
                </ul>
                <ul class="ul2">
                	<li><a href="${base}/special/carrental.html"><@s.property value="%{getText('front.special.carrental')}"/></a></li>
                	<li><a href="${base}/special/ticketbooking.html"><@s.property value="%{getText('front.special.ticketbooking')}"/></a></li>
                	<li><a href="${base}/special/translation.html"><@s.property value="%{getText('front.special.translation')}"/></a></li>
                	<li><a href="${base}/special/shipping.html"><@s.property value="%{getText('front.special.shipping')}"/></a></li>
                </ul>
            </div>
            <div id="snav4" class="menu4"  onmouseover="secondNav('snav4');" onmouseout="hidden_nav('snav4');">
            	<ul class="ul1">
                	<li><a href="${base}/search/hotel.html">▪ <@s.property value="%{getText('front.search.hotel')}"/></a></li>
                    <li><a href="${base}/search/tour.html">▪ <@s.property value="%{getText('front.search.tour')}"/></a></li>
                </ul>
            </div>
            <div id="snav5" class="menu5"  onmouseover="secondNav('snav5');" onmouseout="hidden_nav('snav5');">
            	<ul class="ul1">
                	<li><a href="${base}/contact/russian.html">▪ <@s.property value="%{getText('front.contact.russian')}"/></a></li>
                    <li><a href="${base}/contact/chinese.html">▪ <@s.property value="%{getText('front.contact.chinese')}"/></a></li>
                    <li><a href="${base}/contact/guest.html">▪ <@s.property value="%{getText('front.contact.individual')}"/></a></li>
                </ul>
            </div>
            <div id="snav6" class="menu6"  onmouseover="secondNav('snav6');" onmouseout="hidden_nav('snav6');">
            	<ul class="ul1">
                	<li><a href="${base}/online/chat.html">▪ <@s.property value="%{getText('front.online.chat')}"/></a></li>
                    <li><a href="${base}/online/email.html">▪ <@s.property value="%{getText('front.online.email')}"/></a></li>
                </ul>
            </div>
        </div>

</#macro>