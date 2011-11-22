<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="../css/default.css" media="screen" ></link>
<script type="text/javascript">
	function addComponent() {
		var table = document.getElementById("uploadTable");
		var newRowx = table.insertRow(table.rows.length); 
		var cellx = newRowx.insertCell(0);
		var celly = newRowx.insertCell(1);
		cellx.innerHTML = "Title:";
		celly.innerHTML = "<input type='text' name='title' size='50'>";
		var newRowy = table.insertRow(table.rows.length); 
		var cellx = newRowy.insertCell(0);
		var celly = newRowy.insertCell(1);
		cellx.innerHTML = "File:";
		celly.innerHTML = "<input type='file' name='upload' size='50'>";
	}

	function delComponent(){
	var table = document.getElementById("uploadTable")
	if(table.rows.length>2){
	document.getElementById("uploadTable").deleteRow(table.rows.length-1)
	document.getElementById("uploadTable").deleteRow(table.rows.length-1)
	}
  }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload</title>
</head>
<body>

<div class ="container">
<form method=post action="upload.action" enctype="multipart/form-data">
<table id="uploadTable">
	<tr>
		<td>Title:</td>
		<td><input type="text" name="title" size="50"></td>
	</tr>
	<tr>
		<td>File:</td>
		<td><input type="file" name="upload" size="50"></td>
	</tr>
</table>
<br>

<input type="submit" value="upload" class="upload"></form>
<span class="addButton">
<input type="button" onclick="addComponent();" value="添加文件">
&nbsp;&nbsp;
<input type="button" onclick="delComponent();" value="删除文件">
</span>
</div>


</body>
</html>