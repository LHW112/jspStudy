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
	���̵�	<input name="u_id" type="text">
	��й�ȣ	<input name="u_pwd" type="password">
	���� �̸�	<input name="u_name" type="text">
	�޴��� ��ȣ<input name="phone" type="text">
	<input type="submit" value="����">
	</form>
</body>
</html>