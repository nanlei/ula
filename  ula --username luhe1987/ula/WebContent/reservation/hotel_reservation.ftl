<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>乐游旅游</title>
<link href="/ula/css/about.css" rel="stylesheet" type="text/css" />
<!--<script type="text/javascript" src="/ula/js/jquery-1.4.1.min.js"></script>
<script type="text/javascript" src="/ula/js/jquery.jcarousel.pack.js"></script>
<script type="text/javascript" src="/ula/js/jquery-func.js"></script>-->

<script language="javascript" type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>

</head>
<script language=javascript>  
  function my_height(){
	var my_right = document.getElementById("main_right");
	var my_left = document.getElementById("left_menu");
	if(my_left.clientHeight <= my_right.clientHeight){
	my_left.style.height= my_right.clientHeight + "px";
	}
}    


 function checkEmptyInputs(){
           
        var hotelName = document.getElementById('hotelName');
        var guestTotal = document.getElementById('guestTotal');
        var roomTotal = document.getElementById('roomTotal');
        var checkinDate = document.getElementById('checkinDate');
        var checkoutDate = document.getElementById('checkoutDate');
        var name = document.getElementById('name');
        var phoneNumber = document.getElementById('phoneNumber');
        var contact = document.getElementById('contact');
        
        
        if(hotelName.value==""){
            hotelName.focus();
            return false;
        }
        
        if(checkinDate.value==""){
           checkinDate.focus();  
           return false;
        }
        
        if(checkoutDate.value==""){
            checkoutDate.focus();
            return false;
        }
        
        if(name.value==""){
          name.focus();
          return false;
        }
        
        if(phoneNumber.value=="" && contact.value==""){
            phoneNumber.focus();
            return false;
        }
        
        
        return true;
        
   }	

</script>  

</head>
<body onload= "my_height()">

<#include "../global/header.html">

<div id="main">
 <div id="left_menu">
  <ul class="rolinList" id="rolin">
  <li>
  	<div class="menu_title">
    <h2><a href="/ula/special/visa!view.action">签证</a></h2>
    </div>
    <div class="content" style="height:1px;"></div>
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="/ula/reservation/hotelReserv!view.action">宾馆预订</a></h2>
    </div>
    <div class="content" style="height:1px;"></div>
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="/ula/reservation/travelReserv!view.action">旅游路线预订</a></h2>
    </div>
    <div class="content" style="height:1px;"></div>
  </li>
  <li>
  	<div class="menu_title">
    <h2>委托</h2>
    </div>
    <div class="content">
    	<div class="content_item"><a href="/ula/special/ticket!view.action">代订车、船票</a></div>
        <div class="content_item"><a href="/ula/special/carrental!view.action">租车服务</a></div>
        <div class="content_item"><a href="/ula/special/translation!view.action">翻译服务</a></div>
        <div class="content_item"><a href="/ula/special/souvenir!view.action">代邮寄纪念品</a></div>
    </div>
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="/ula/special/russianstudents!view.action">俄罗斯留学生</a></h2>
    </div>
    <div class="content" style="height:1px;"></div>
  </li>
</ul>
  </div>

  
  
    <div id="main_right">
  	<div class="right_title">
    	<h3>>>宾馆预订</h3>
    </div>
    
    <div class="right_content">
    
<p class="content_p"/>

<form method=post action="hotelReserv!reserve.action" onsubmit = "return checkEmptyInputs()">

<table align ="center">

<tr>
	<td>酒店名称</td>
	<td><input type="text" name="hotelName" id = "hotelName"/><#if hotelName?exists>${hotelName} </#if></td>
</tr>

<tr>
	<td>入住人数</td>
	<td><input type="text" name="guestTotal" id = "guestTotal" value ="1"/></td>
</tr>

<tr>
	<td>预定间数</td>
	<td><input type="text" name="roomTotal" id = "roomTotal" value="1"/></td>
</tr>


<tr>
	<td>入住日期</td>
	<td><input class="Wdate" type="text" onClick="WdatePicker({lang:'en'})" name="checkinDate" id = "checkinDate"> </td>
</tr>
<tr>
	<td>离开日期</td>
	<td><input class="Wdate" type="text" onClick="WdatePicker({lang:'en'})" name="checkoutDate" id = "checkoutDate"></td>

<tr>
	<td>联系人</td>
	<td><input type="text" name="name" id = "name"/></td>
</tr>



<tr>
	<td>
    <select name="phoneType">
		<option value="tel">电话</option>
		<option value="mobile">手机</option>
    </select>
     </td>
     <td>
     <input type="text" name="phoneNumber" id = "phoneNumber"/></td>
</tr>

<tr>
    <td>
    <select name="contactType">
		<option value="icq">ICQ</option>
		<option value="skype">Skype</option>
		<option value="email">Email</option>
    </select>
    </td>
    <td>
	<input type="text" name="contact"/>
	</td>
</tr>

</tr>

<tr>
	<td>备注说明</td>
	<td valign="top"><textarea name="remarks" rows="10" cols="25">请注明是否有儿童，是否占床</textarea></td>
</tr>
<tr>
	<td colspan ="2" align ="center"><input type="submit" value="提交订单" /> </td>
</tr>
</table>
  </form></p>
    
    </div> 
    
  </div>

<#include "../global/footer.html">

</body>
</html>


