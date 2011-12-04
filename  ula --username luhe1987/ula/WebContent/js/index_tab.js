// JavaScript Document
function setTab(name, cursel, n) {
	for (i = 1; i <= n; i++) {
		var menu = document.getElementById(name + i);
		var con = document.getElementById("con_" + name + "_" + i);
		menu.className = i == cursel ? "hover" : "";
		con.style.display = i == cursel ? "block" : "none";
	}
}

function secondNav(nav) {
	var snav = document.getElementById(nav);
	snav.style.display = "block";
}
function hidden_nav(nav) {
	var hnav = document.getElementById(nav);
	hnav.style.display = "none";
}
function hdiien_input() {
	var check = document.getElementById("search_dater");
	var inputbar1 = document.getElementById("start_time");
	var inputbar2 = document.getElementById("end_time");
	if (check.checked) {
		inputbar1.style.display = "none";
		inputbar2.style.display = "none";
	} else {
		inputbar1.style.display = "block";
		inputbar2.style.display = "block";
	}
}

function sport_change(na, n) {
	var sp_n = document.getElementById(na);
	sp_n.value = n;
}
