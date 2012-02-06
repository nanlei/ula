<@fp.page>
<!-- The Head -->
<@fp.header /><#-- header宏 -->
<!-- The Container  -->
<div id="container">
	<!-- The Banner  -->
	<@fp.banner /><#-- banner宏 -->
	<!-- The Navigation  -->
	<@fp.navigation c_index=false c_city=false c_tour=false c_service=false c_search=true c_contact=false /><#-- navigation宏 -->
	<!-- The Main Body -->
	<div id="main_body">
	<@fp.search_tour />
	</div>
	<div id="re_content">
        	<div id="re_con_title"><span>搜索结果</span></div>
            <div id="re_con_ch_title"><span>尊敬的朋友，按照你选择的以下要求：</span></div>
            <div id="re_con_choose">
            	<table border="0"  cellspacing="0" cellpadding="0">
                	<tr>
                		<td class="item"><@s.property value="%{getText('front.search.vacation.type')}"/></td>
                        <td class="words">
                        <#if displayParameters??>
                        <#if displayParameters.travel_type??>
                        <#list displayParameters.travel_type as tt>
                        	<#switch tt>
                        		<#case "2"><@s.property value="%{getText('front.search.vacation.type.therapy')}"/>&nbsp;&nbsp;<#break>
                        		<#case "3"><@s.property value="%{getText('front.search.vacation.type.child')}"/>&nbsp;&nbsp;<#break>
                        		<#case "4"><@s.property value="%{getText('front.search.vacation.type.romantic')}"/>&nbsp;&nbsp;<#break>
                        		<#case "5"><@s.property value="%{getText('front.search.vacation.type.luxurious')}"/>&nbsp;&nbsp;<#break>
                        		<#case "6"><@s.property value="%{getText('front.search.vacation.type.family')}"/>&nbsp;&nbsp;<#break>
                        		<#case "7"><@s.property value="%{getText('front.search.vacation.type.foodie')}"/>&nbsp;&nbsp;<#break>
                        		<#case "8"><@s.property value="%{getText('front.search.vacation.type.sport')}"/>&nbsp;&nbsp;<#break>
                        		<#case "9"><@s.property value="%{getText('front.search.vacation.type.event')}"/>&nbsp;&nbsp;<#break>
                        		<#case "10"><@s.property value="%{getText('front.search.vacation.type.learn')}"/>&nbsp;&nbsp;<#break>
                        	</#switch>
                        	<#if (displayParameters.travel_type?size>4)&&(tt_index+1)%(displayParameters.travel_type?size/2+1)=0><br></#if>
                        </#list>
                        <#else>
                                                               未选择
                        </#if>
                        <#else>
                                                               未选择
                        </#if>
                        </td>
                        <td class="item"><@s.property value="%{getText('front.search.date.travel')}"/></td>
                        <td class="words">
                        <#if displayParameters??>
                        <#if displayParameters.notnecessary??>
                      	<@s.property value="%{getText('front.search.date.no')}"/>
                        <#else>
                        	<#if displayParameters.start_time[0]?has_content>
                        	<@s.property value="%{getText('front.search.date.from')}"/>&nbsp;&nbsp;${displayParameters.start_time[0]}
                        	<#else>
                        	未选择开始时间&nbsp;&nbsp;
                        	</#if>
                        	<#if displayParameters.end_time[0]?has_content>
                        	<@s.property value="%{getText('front.search.date.to')}"/>&nbsp;&nbsp;${displayParameters.end_time[0]}
                        	<#else>
                        	未选择结束时间&nbsp;&nbsp;
                        	</#if>
                        </#if>
                        </#if>
                        </td>
                    </tr>
                    <tr>
                		<td class="item"><@s.property value="%{getText('front.search.load.sport')}"/></td>
                        <td class="words">
                        <#if displayParameters??>
                        <#if displayParameters.sport_n?has_content>
                        <@s.property value="%{getText('front.search.load.unit')}"/>：${displayParameters.sport_n[0]}
                        <#else>
                                                               未选择
                        </#if>
                        <#else>
                                                               未选择
                        </#if>                    
                        </td>
                        <td class="item"><@s.property value="%{getText('front.search.date.people')}"/></td>
                        <td class="words">
                        <#if displayParameters??>
                        <#if displayParameters.adult_n[0]?has_content>
                        <@s.property value="%{getText('front.search.date.adult')}"/>：${displayParameters.adult_n[0]}&nbsp;&nbsp;
                        <#else>
                                                               未选择成人数
                        </#if>
                        <#else>
                                                               未选择成人数
                        </#if>  
                        <#if displayParameters??>
                        <#if displayParameters.child_n[0]?has_content>
                        <@s.property value="%{getText('front.search.date.child')}"/>：${displayParameters.child_n[0]}&nbsp;&nbsp;
                        <#else>
                                                               未选择儿童数
                        </#if>
                        <#else>
                                                               未选择儿童数
                        </#if>  
                        </td>
                    </tr>
                    <tr>
                		<td class="item">入住酒店</td>
                        <td class="words">
                        <#if displayParameters??>
                        <#if displayParameters.level??>
                        <#list displayParameters.level as ll>
                        <#switch ll>
                        	<#case "3star"><@s.property value="%{getText('front.search.hotel.star3')}"/>&nbsp;&nbsp;<#break>
                        	<#case "4star"><@s.property value="%{getText('front.search.hotel.star4')}"/>&nbsp;&nbsp;<#break>
                        	<#case "5star"><@s.property value="%{getText('front.search.hotel.star5')}"/>&nbsp;&nbsp;<#break>
                        	<#case "express_hotel"><@s.property value="%{getText('front.search.hotel.express')}"/>&nbsp;&nbsp;<#break>
                        	<#case "apartment_hotel"><@s.property value="%{getText('front.search.hotel.dormitory')}"/>&nbsp;&nbsp;<#break>
                        	<#case "nursing_hotel"><@s.property value="%{getText('front.search.hotel.nursing')}"/>&nbsp;&nbsp;<#break>
                        </#switch>
                        </#list>
                        <#else>
                                                               未选择
                        </#if>
                        <#else>
                                                               未选择
                        </#if>
                        </td>
                        <td class="item"><@s.property value="%{getText('front.search.guide.require')}"/></td>
                        <td class="words">
                        <#if displayParameters??>
                        <#if displayParameters.guide?has_content>
                        	<#switch displayParameters.guide[0]>
                        		<#case "airport"><@s.property value="%{getText('front.search.guide.airport')}"/><#break>
                        		<#case "tour"><@s.property value="%{getText('front.search.guide.tour')}"/><#break>
                        		<#case "fulltime"><@s.property value="%{getText('front.search.guide.fulltime')}"/><#break>
                        		<#case "fixed"><@s.property value="%{getText('front.search.guide.fixed')}"/><#break>
                        		<#case "no"><@s.property value="%{getText('front.search.guide.no')}"/><#break>
                        	</#switch>
                        <#else>
                                                               未选择
                        </#if>
                        <#else>
                                                               未选择
                        </#if>  
                        </td>
                    </tr>
                </table>
            </div>
            <div id="re_words_title"><span>符合条件的有：</span></div>
            <div id="re_words">
            	<table border="0" cellspacing="0" cellpadding="0" style="width:500px;float:left;background: url(${base}/images/re_words_con_bg.png) repeat-y left top;">
                	<tr class="words_title">
                    	<td>酒店</td>
                    </tr>
                    <#if hotelList?has_content>
                  	<#list hotelList as hotel>
                    <tr class="words_con">
                    	<td>${hotel.NAME}</td>
                    </tr>
                    </#list>
                    <#if (hotelList?size<tourList?size)>
                    <#list 1..(tourList?size-hotelList?size) as i>
                    <tr class="words_con">
                    	<td>&nbsp;</td>
                    <tr>
                    </#list>
                    </#if>
                    <#else>
                    <tr class="words_con">
                    	<td>暂无搜索结果</td>
                    </tr>
                    </#if>
                </table>
            	<table border="0"  cellspacing="0" cellpadding="0" style="width:500px;float:right;background: url(${base}/images/re_words_con_bg.png) repeat-y left top;"">
                	<tr class="words_title">
                    	<td>旅游行程</td>
                    </tr>
                    <#if tourList?has_content>
                  	<#list tourList as tour>
                    <tr class="words_con">
                    	<td>${tour.TITLE}</td>
                    </tr>
                    </#list>
                    <#if (tourList?size<hotelList?size)>
                    <#list 1..(hotelList?size-tourList?size) as i>
                    <tr class="words_con">
                    	<td>&nbsp;</td>
                    <tr>
                    </#list>
                    </#if>
                    <#else>
                    <tr class="words_con">
                    	<td>暂无搜索结果</td>
                    </tr>
                    </#if>
                </table>
            </div>
            <div class="clear"></div>
            <div id="re_words_bottom"></div>
            <div class="clear"></div>
        </div>
  <!-- The Result Bottom -->
    	<div id="re_bottom">
         	<!-- The Left -->
			<@fp.weather2 weather />
            <!-- The Middle -->
			<div class="contact">
				<table cellpadding="0" cellspacing="0">
					<col width="72" align="center">
					<col width="531" align="center">
					<tr>
						<td class="blue"><@s.property value="%{getText('front.contact.address.title')}"/></td>
						<td><@s.property value="%{getText('front.contact.address')}"/></td>
					</tr>
					<tr>
						<td class="blue"><@s.property value="%{getText('front.contact.telephone.title')}"/></td>
						<td>+86(411) 39791800,39791811</td>
					</tr>
					<tr>
						<td class="blue"><@s.property value="%{getText('front.contact.fax.title')}"/></td>
						<td>+ 86 (411) 39791811</td>
					</tr>
					<tr>
						<td class="blue"><@s.property value="%{getText('front.contact.email.title')}"/></td>
						<td>dalian-joytour@yandex.ru，dalian-joytour@mail.ru</td>
					</tr>
				</table>
			</div>
            <div class="clear"></div>
        </div>
    <!-- The Footer -->
	<@fp.footer /><#-- footer宏 -->
</div>
</@fp.page>