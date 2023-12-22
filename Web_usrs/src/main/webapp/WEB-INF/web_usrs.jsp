<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<form action="/Web_usrs/Web/usrs" method="post">
		아이디	<input name ="u_id" type ="text">
		비밀번호	<input name ="pwd" type ="password">
		이름		<input name ="u_name" type ="text">
		생년월일	<input name ="birthday" type ="date">
		전화번호	<input name ="phone" type ="text">
		<input type ="submit" value ="전송">
		</form>
</body>
</html>