<@fp.page>
<!-- The Head -->
<@fp.header /><#-- header宏 -->
<!-- The Container  -->
<div id="container">
	<!-- The Banner  -->
	<@fp.banner /><#-- banner宏 -->
	<!-- The Navigation  -->
	<@fp.navigation c_index=false c_city=true c_tour=false c_service=false c_search=false c_contact=false c_online=false/><#-- navigation宏 -->
	<!-- The Main Body -->
	<div id="main_body">
		<!-- The Left -->
		<@fp.main_left_tour /><#-- 主体左侧宏，包含关于大连导航，RSS订阅，天气预报-->
		 <!-- The Content -->
            <div id="article_content">
            	<div id="page_article_title">
                	<p>${hotel.NAME}</p>
                </div>
                <div style="text-align:center;margin-top:10px;margin-bottom:10px;">
					<@s.property value="%{getText('front.hotel.location')}"/>：<b>${hotel.LOCATION}</b><br>
					<@s.property value="%{getText('front.hotel.stars')}"/>：<b>${hotel.LEVEL}</b><br>
					<@s.property value="%{getText('front.hotel.func')}"/>：<b>${hotel.FUNC}</b>
				</div>
               
                 <div style="border-top: 1px #CCCCCC dashed;" class="album"/>
                	<#assign pIndex=picIndex/>
	   				<#list albumPicList as albumPic>
						<div style="text-align:center;margin-top:10px;margin-bottom:10px;">
							<img src="${base}${albumPic.PICPATH}" alt="${albumPic.PICNAME}" width="600" height="450"/>
						</div>
					</#list>
				</div>
               
               
                <div style="border-top: 1px #CCCCCC dashed;"/>
            	<div id="page_article">
            		<p>${hotel.CONTENT}</p>
            	</div>
            	
            </div>
            
           <div style="text-align:center; margin-top:15px;">
		        
		        
		        <a style = "font-size:40px; color:#CC6633" href="javascript: history.go(-1)">обратно</a>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		        
		        <a style = "font-size:40px; color:#CC6633" href="javascript:postwith('${base}/special/hotel.html',{hotelName:'${hotel.NAME}'})">бронирование</a> 
		        
			</div>

	</div>
    <!-- The Footer -->
	<@fp.footer /><#-- footer宏 -->
</div>

<script language=javascript>  


	function postwith(to, p) {
	
			var myForm = document.createElement("form");
			myForm.method = "post";
			myForm.action = to;
			for ( var k in p) {
				var myInput = document.createElement("input");
				myInput.setAttribute("name", k);
				myInput.setAttribute("value", p[k]);
				myForm.appendChild(myInput);
			}
			document.body.appendChild(myForm);
			myForm.submit();
			document.body.removeChild(myForm);
		}

</script>  

</@fp.page>