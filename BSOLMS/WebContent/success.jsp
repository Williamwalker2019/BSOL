<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
<style type="text/css">      
     body{      
        background-image: url(img/bg.jpg);      
        background-size:cover;    
     }
</style>
</head>
<body style="width:1210px;margin:0 auto;">
<% String username=(String) request.getAttribute("username"); %>
	<div style="text-align:center;font-family:YouYuan;font-size:42px;margin-top:150px;">
		您好 <%= username %><BR><BR>
		恭喜您注册成功！
	</div>
	<div style="position:absolute;bottom:50px;left:680px;">
		<Button style="width:150px;height:32px;font-family:FangSong;font-size:20px;" onclick="window.location.href='index.jsp'">返回登陆</Button>
	</div>
</body>
</html>