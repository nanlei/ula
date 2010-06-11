<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#logo{
text-decoration: none;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/nav.css" media="screen" ></link>
<link rel="javascript" type="text/javascript" href="../js/nav.js"></link>
<title>header</title>
</head>
<body id = "header">
<div class="container">	
<a href ="<%=request.getContextPath()%>/" id ="logo">
<b>ULA Project</b>
</a>
    <ul id="topnav"> 
        <li><a href="#" title="公司简介">公司简介</a> 
        <span> 
                <a href="<%=request.getContextPath()%>/group/group!viewAllGroups.action">关于</a> |
      
            </span> 
        </li>
        
        <li> 
            <a href="#" title="小组">Group</a>
            <span> 
                <a href="<%=request.getContextPath()%>/group/group!viewAllGroups.action">My Groups</a> |
                <a href="<%=request.getContextPath()%>/groupPage/groupPage!allUserPages.action">My Pages</a> |
                <a href="<%=request.getContextPath()%>/group/group!preCreateGroup.action">Create a Group</a> | 
            </span> 
        </li> 
        <li> 
            <a href="#" title="广播">Broadcast</a>
            <span> 
                <a href="<%=request.getContextPath()%>/broadcast/broadcast!history.action">From Me</a> |
                <a href="<%=request.getContextPath()%>/broadcast/follow!friendsMsg.action">From Friends</a> | 
            </span> 
        </li> 
        <li> 
            <a href="#" title="笔记">Notes</a>
            <span> 
                <a href="<%=request.getContextPath()%>/note/note!preview.action" title ="我的笔记">My notes</a> |
                <a href="<%=request.getContextPath()%>/note/note!preAdd.action" title ="添加新笔记">Add new notes</a> |
                <a href="<%=request.getContextPath()%>/note/note!preExport.action" title ="导出笔记">Export notes</a> |
            </span> 
        </li> 
        <li><a href="#" title="文件库">FileStore</a>
        <span> 
                <a href="../upload/upload!preUpload.action" title ="上传文件">Upload</a> |
                <a href="<%=request.getContextPath()%>/download/file!view.action" title ="所有文件">All files</a> |
            </span> 
        </li> 
    </ul> 	
</div> 
<br><br><br><br>
</body>
</html>