function rssSubmit() {
	var email = $.trim($("#email_input").val());
	var emailReg = /^[_a-z0-9]+@([_a-z0-9]+\.)+[a-z0-9]{2,3}$/;
	var selectorFlag = $("input:[name=ree_ornot]:radio:checked").length;
	if (email == "" || email == null) {
		alert("Invalid Email Address!");
	} else if (emailReg.test(email) == false) {
		alert("Invalid Email Address!");
	} else if (selectorFlag == 0) {
		alert("Please Choose Subscribe Or Cancel!");
	} else {
		var selector = $("input:[name=ree_ornot]:radio:checked").val();
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
