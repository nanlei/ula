<#-- main_middle宏 -->
<#macro main_middle>
		<div id="main_middle">
			<div id="middle_title"><@s.property value="%{getText('front.production.title')}"/></div>
			<div id="middle_con">
				<#assign counter=1 />
				<#list productList as product>
					<#if counter%3=1><ul></#if>
					<li>
						<a href="${base}/product-${product.ID}.html">
							<img src="${base}${product.COVER}" alt="<@s.property value="%{getText('front.production.title')}"/>" />
						</a>
						<div class="travel_info">
							<span class="left_words">￥${product.PRICE}</span>
							<a href="${base}/product-${product.ID}.html" class="right_words">${product.NAME}>></a>
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

<#macro main_middle_product products>
<div id="page_content">
	<#list products as product>
	<div class="simple_travel_bar">
		<div class="photos">
			<img src="${base}${product.COVERLINK}" alt="${product.TITLE}"  />
		</div>
		<div class="intro">
			<div class="title">
				<div class="tra_name">${product.TITLE}</div>
				<div class="tra_icon_more"><a href="${base}/tour-${product.ID}.html">More</a></div>
			</div>
			<div class="words">
				<p>${product.DESCRIPTION}...</p>
			</div>
		</div>
	</div>
	</#list>
</div>
</#macro>



<#macro tours_by_category tours>
<div id="page_content">
	<#list tours as tour>
	<div class="simple_travel_bar">
		<div class="photos">
			<img src="${base}${tour.COVERLINK}" alt="${tour.TITLE}"  />
		</div>
		<div class="intro">
			<div class="title">
				<div class="tra_name">${tour.TITLE}</div>
				<div class="tra_icon_more"><a href="${base}/tour-${tour.ID}.html">More</a></div>
			</div>
			<div class="words">
				<p>${tour.DESCRIPTION}...</p>
			</div>
		</div>
	</div>
	</#list>
</div>
</#macro>