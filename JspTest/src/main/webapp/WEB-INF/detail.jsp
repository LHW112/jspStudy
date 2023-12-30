<%@page import="beans.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	BoardDTO bdt = (BoardDTO) request.getAttribute("bdt"); 
%>
	<div><%=bdt.getB_title() %></div>
	<div><%=bdt.getB_text() %></div>
</body>
</html>