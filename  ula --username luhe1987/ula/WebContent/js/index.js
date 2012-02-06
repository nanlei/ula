$(function() {
	$("#fromDate").datepicker( {
		dateFormat : 'yy-mm-dd'
	});
	$("#toDate").datepicker( {
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

function rssSubmit() {
	var email = $.trim($("#email_input").val());
	var emailReg = /^[_a-z0-9]+@([_a-z0-9]+\.)+[a-z0-9]{2,3}$/;
	var selectorFlag = $("input:[name=rss_ornot]:radio:checked").length;
	if (email == "" || email == null) {
		alert("Invalid Email Address!");
	} else if (emailReg.test(email) == false) {
		alert("Invalid Email Address!");
	} else if (selectorFlag == 0) {
		alert("Please Choose Subscribe Or Cancel!");
	} else {
		var selector = $("input:[name=rss_ornot]:radio:checked").val();
		if (selector == "yes") {
			subscribe(email);
		} else {
			cancelSubscribe(email);
		}
	}
}
/**
 * 执行订阅操作
 * 
 * @param email
 * @return
 */
function subscribe(email) {
	$.ajax( {
		type : "POST",
		url : "subscribe.action",
		data : {
			email : email,
			time : new Date().getTime()
		},
		success : function(data) {
			var jsonData = jQuery.parseJSON(data);
			if (jsonData.result == 1) {
				alert("Subscribe Successfully!");
			} else if (jsonData.result == 2) {
				alert("Email Address already exists!");
			} else {
				alert("Subscribe Failure!");
			}
		},
		error : function(xmlHttpRequest, status, exception) {
			dialogAlert("Network Error, Please refresh page and try again!");
		}
	});
}
/**
 * 取消订阅操作
 * 
 * @return
 */
function cancelSubscribe(email) {
	$.ajax( {
		type : "POST",
		url : "cancelSubscribe.action",
		data : {
			email : email,
			time : new Date().getTime()
		},
		success : function(data) {
			var jsonData = jQuery.parseJSON(data);
			if (jsonData.result == 1) {
				alert("Cancel Subscribe Successfully!");
			} else if (jsonData.result == 2) {
				alert("Email Address not exists!");
			} else {
				alert("Cancel Subscribe Failure!");
			}
		},
		error : function(xmlHttpRequest, status, exception) {
			dialogAlert("Network Error, Please refresh page and try again!");
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