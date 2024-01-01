<%@page import="beans.UsrDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/JspTest/TransUsrs" method="post">
	아이디	<input name="u_id" type="text">
	비밀번호	<input name="u_pwd" type="password">
	유저 이름	<input name="u_name" type="text">
	휴대폰 번호<input name="phone" type="text">
	<input type="submit" value="변경">
	</form>
</body>
</html>