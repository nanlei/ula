$(function() {

	$("#fromDate").datepicker({
		dateFormat : 'yy-mm-dd'
	});
	$("#toDate").datepicker({
		dateFormat : 'yy-mm-dd'
	});
	// $("#snav1").mouseover(function() {
	// $("#city_li").css( {
	// "background" : "url(images/menu_clicked.png) no-repeat left top",
	// "color" : "#3378c4"
	// });
	// });
	// $("#snav1").mouseout(function() {
	// $("#city_li").css( {
	// "color" : "#FFFFFF",
	// "background" : ""
	// });
	// });
	// $("#snav2").mouseover(function() {
	// $("#tour_li").css( {
	// "background" : "url(images/menu_clicked.png) no-repeat left top",
	// "color" : "#3378c4"
	// });
	// });
	// $("#snav2").mouseout(function() {
	// $("#tour_li").css( {
	// "color" : "#FFFFFF",
	// "background" : ""
	// });
	// });
	// $("#snav3").mouseover(function() {
	// $("#special_li").css( {
	// "background" : "url(images/menu_clicked.png) no-repeat left top",
	// "color" : "#3378c4"
	// });
	// });
	// $("#snav3").mouseout(function() {
	// $("#special_li").css( {
	// "color" : "#FFFFFF",
	// "background" : ""
	// });
	// });
	// $("#snav4").mouseover(function() {
	// $("#search_li").css( {
	// "background" : "url(images/menu_clicked.png) no-repeat left top",
	// "color" : "#3378c4"
	// });
	// });
	// $("#snav4").mouseout(function() {
	// $("#search_li").css( {
	// "color" : "#FFFFFF",
	// "background" : ""
	// });
	// });
	// $("#snav5").mouseover(function() {
	// $("#contact_li").css( {
	// "background" : "url(images/menu_clicked.png) no-repeat left top",
	// "color" : "#3378c4"
	// });
	// });
	// $("#snav5").mouseout(function() {
	// $("#contact_li").css( {
	// "color" : "#FFFFFF",
	// "background" : ""
	// });
	// });
});

function rssSubmit(invalid_address, no_option,error) {


	var email = $.trim($("#email_input").val());
	var emailReg = /^[_a-z0-9]+@([_a-z0-9]+\.)+[a-z0-9]{2,3}$/;
	var selectorFlag = $("input:[name=rss_ornot]:radio:checked").length;
	if (email == "" || email == null) {
		alert(invalid_address);
	} else if (emailReg.test(email) == false) {
		alert(invalid_address);
	} else if (selectorFlag == 0) {
		alert(no_option);
	} else {
		var selector = $("input:[name=rss_ornot]:radio:checked").val();
		if (selector == "yes") {
			subscribe(email,error);
		} else {
			cancelSubscribe(email,error);
		}
	}
}
/**
 * 执行订阅操作
 * 
 * @param email
 * @return
 */
function subscribe(email,error) {


	$.ajax({
		type : "POST",
		url : "${base}/subscribe.html",

		data : {
			email : email,
			time : new Date().getTime()
		},
		success : function(data) {

			var jsonData = jQuery.parseJSON(data);
			if(jsonData.result==0 || jsonData.result==1 || jsonData.result==2){
				alert(jsonData.msg);
			}
		},
		error : function(xmlHttpRequest, status, exception) {
			dialogAlert(error);
		}
	});
}
/**
 * 取消订阅操作
 * 
 * @return
 */
function cancelSubscribe(email,error) {

	$.ajax({
		type : "POST",
		url : "${base}/cancelSubscribe.html",
		data : {
			email : email,
			time : new Date().getTime()
		},
		success : function(data) {

			var jsonData = jQuery.parseJSON(data);
			
			if(jsonData.result==0 || jsonData.result==1 || jsonData.result==2){
				alert(jsonData.msg);
			}
		},
		error : function(xmlHttpRequest, status, exception) {

			dialogAlert(error);
		}
	});
}

function selectAllType() {

	if ($("#ttselector").attr("checked") == "checked") {
		selectAll('tourSearchForm', 'travel_type');
	} else {
		unSelectAll('tourSearchForm', 'travel_type');
	}
}

function selectAllHotel() {

	if ($("#hselector").attr("checked") == "checked") {
		selectAll('tourSearchForm', 'level');
	} else {
		unSelectAll('tourSearchForm', 'level');
	}
}