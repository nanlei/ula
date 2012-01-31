$(function() {
	$("#checkinDate").datepicker( {
		dateFormat : 'yy-mm-dd'
	});
	$("#checkoutDate").datepicker( {
		dateFormat : 'yy-mm-dd'
	});
	$("#snav1").mouseover(function(){
		$("#city_li").css({"background":"url(images/menu_clicked.png) no-repeat left top","color":"#3378c4"});
	});
	$("#snav1").mouseout(function(){
		$("#city_li").css({"color":"#FFFFFF","background":""});
	});
	$("#snav2").mouseover(function(){
		$("#tour_li").css({"background":"url(images/menu_clicked.png) no-repeat left top","color":"#3378c4"});
	});
	$("#snav2").mouseout(function(){
		$("#tour_li").css({"color":"#FFFFFF","background":""});
	});
	$("#snav3").mouseover(function(){
		$("#special_li").css({"background":"url(images/menu_clicked.png) no-repeat left top","color":"#3378c4"});
	});
	$("#snav3").mouseout(function(){
		$("#special_li").css({"color":"#FFFFFF","background":""});
	});
	$("#snav4").mouseover(function(){
		$("#search_li").css({"background":"url(images/menu_clicked.png) no-repeat left top","color":"#3378c4"});
	});
	$("#snav4").mouseout(function(){
		$("#search_li").css({"color":"#FFFFFF","background":""});
	});
	$("#snav5").mouseover(function(){
		$("#contact_li").css({"background":"url(images/menu_clicked.png) no-repeat left top","color":"#3378c4"});
	});
	$("#snav5").mouseout(function(){
		$("#contact_li").css({"color":"#FFFFFF","background":""});
	});
});