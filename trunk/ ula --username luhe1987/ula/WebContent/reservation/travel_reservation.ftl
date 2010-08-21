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
    	<h3>>>旅游线路预订</h3>
    </div>
    
    <div class="right_content">
    
     <p class="content_p"/><form method=post action="travelReserv!reserve.action">

<table align="center">
  <tr>
	<td>旅游人数</td>
	<td><input type="text" name="numOfTourist"/></td>
  </tr>
  <tr>
	<td>出游日期</td>
	<td><input class="Wdate" type="text" onClick="WdatePicker({lang:'en'})" name="startDate"/></td>
  </tr>
  <tr>
	<td>返程日期</td>
	<td><input class="Wdate" type="text" onClick="WdatePicker({lang:'en'})" name="returnDate"/></td>
  </tr>
    <tr>
	<td>最晚答复日期</td>
	<td><input class="Wdate" type="text" onClick="WdatePicker({lang:'en'})" name="replyDeadline"/></td>
  </tr>
  <tr>
	<td>旅游路线/要求</td>
	<td><textarea name="requirements" rows="10" cols="20"></textarea></td>
  </tr>

  </table>
  
  

  <table align="center">
  <tr>
	<td>联系人信息</td>
	<td></td>
  </tr>
  
  <tr>
	<td>姓名</td>
	<td><input type="text" name="contactName"/></td>
  </tr>
    <tr>
	<td>性别</td>
	<td><input type="radio" name="contactGender" value="male"/>男<input type="radio" name="contactGender" value="female"/>女</td>
  </tr>
  <tr>
	<td>手机|电话</td>
	<td><input type="text" name="contactPhone"/></td>
  </tr>
  <tr>
	<td>Email</td>
	<td><input type="text" name="contactEmail"/></td>
  </tr>
  <tr>
	<td colspan="2" align="center"><input type="submit" value ="提交订单"/></td>
  </tr>

  </table>	
</form></p>
     </div> 
    </div>
    
<#include "../global/footer.html">
</body>
</html>






