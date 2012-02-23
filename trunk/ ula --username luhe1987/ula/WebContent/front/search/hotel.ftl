<@fp.page>
<!-- The Head -->
<@fp.header /><#-- header宏 -->
<!-- The Container  -->
<div id="container">
	<!-- The Banner  -->
	<@fp.banner /><#-- banner宏 -->
	<!-- The Navigation  -->
	<@fp.navigation c_index=false c_city=false c_tour=false c_service=false c_search=true c_contact=false c_online=false/><#-- navigation宏 -->
	<!-- The Main Body -->
	<div id="main_body">
	<@fp.search_hotel />
	</div>
	<div id="re_content">
        	<div id="re_con_title"><span>搜索结果</span></div>
            <div id="re_con_ch_title"><span>尊敬的朋友，按照你选择的以下要求：</span></div>
            <div id="re_con_choose">
            	<table border="0"  cellspacing="0" cellpadding="0">
                	<tr>
                		<td class="item"><@s.property value="%{getText('front.search.location')}"/></td>
                        <td class="words">
                        <#if displayParameters??>
                        <#if displayParameters.location??>
                        <#switch displayParameters.location[0]?string>
                        	<#case "downtown"><@s.property value="%{getText('front.search.location.dalian')}"/><#break>
                        	<#case "jinshitan"><@s.property value="%{getText('front.search.location.jst')}"/><#break>
                        	<#case "lvshun"><@s.property value="%{getText('front.search.location.ls')}"/><#break>
                        </#switch>
                        <#else>
                                                               未选择
                        </#if>
                        <#else>
                                                               未选择
                        </#if>
                        </td>
                        <td class="item"></td>
                        <td class="words"></td>
                    </tr>
                    <tr>
                		<td class="item"><@s.property value="%{getText('front.search.star')}"/></td>
                        <td class="words">
                        <#if displayParameters??>
                        <#if displayParameters.level??>
                        <#switch displayParameters.level[0]?string>
                        	<#case "3star"><@s.property value="%{getText('front.search.star3')}"/><#break>
                        	<#case "4star"><@s.property value="%{getText('front.search.star4')}"/><#break>
                        	<#case "5star"><@s.property value="%{getText('front.search.star5')}"/><#break>
                        	<#case "express_hotel"><@s.property value="%{getText('front.search.express')}"/><#break>
                        	<#case "apartment_hotel"><@s.property value="%{getText('front.search.dormitory')}"/><#break>
                        	<#case "nursing_hotel"><@s.property value="%{getText('front.search.nursing')}"/><#break>
                        </#switch>
                        <#else>
                                                               未选择
                        </#if>
                        <#else>
                                                               未选择
                        </#if>                    
                        </td>
                        <td class="item"></td>
                        <td class="words"></td>
                    </tr>
                    <tr>
                		<td class="item"><@s.property value="%{getText('front.search.function')}"/></td>
                        <td class="words">
                        <#if displayParameters??>
                        <#if displayParameters.func??>
                        <#switch displayParameters.func[0]?string>
                        	<#case "huizhanzhongxinfujin"><@s.property value="%{getText('front.search.function.exhibition')}"/><#break>
                        	<#case "yuchang"><@s.property value="%{getText('front.search.function.beach')}"/><#break>
                        	<#case "zhiliao"><@s.property value="%{getText('front.search.function.treatment')}"/><#break>
                        </#switch>
                        <#else>
                                                               未选择
                        </#if>
                        <#else>
                                                               未选择
                        </#if>
                        </td>
                        <td class="item"></td>
                        <td class="words"></td>
                    </tr>
                </table>
            </div>
            <div id="re_words_title"><span>符合条件的有：</span></div>
            <div id="re_words">
            	<table border="0"  cellspacing="0" cellpadding="0">
                	<tr class="words_title">
                    	<td>酒店名称</td>
                    	<td>操作</td>
                    </tr>
                    <#if hotelList?has_content>
                  	<#list hotelList as hotel>
                    <tr class="words_con">
                    	<td>${hotel.NAME}</td>
                    	<td><a href="${base}/hotel-${hotel.ID}.html">点击查看</a></td>
                    </tr>
                    </#list>
                    <#else>
                    <tr class="words_con">
                    	<td>暂无搜索结果</td>
                    	<td>暂无搜索结果</td>
                    </tr>
                    </#if>
                </table>
            </div>
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