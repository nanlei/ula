<#-- main_middle宏 -->
<#macro main_middle>
		<div id="main_middle">
			<div id="middle_title"><@s.property value="%{getText('front.production.title')}"/></div>
			<div id="middle_con">
				<#assign counter=1 />
				<#list productList as product>
					<#if counter%3=1><ul></#if>
					<li>
						<a href="">
							<img src="${base}${product.COVER}" alt="<@s.property value="%{getText('front.production.title')}"/>" />
						</a>
						<div class="travel_info">
							<span class="left_words">￥${product.PRICE}</span>
							<a href="#" class="right_words">${product.NAME}>></a>
						</div>
					</li>
					<#if counter%3=0||counter=productList.size()></ul></#if>
					<#assign counter=counter+1 />
				</#list>
			</div>
			<div id="contact">
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
		</div>
</#macro>