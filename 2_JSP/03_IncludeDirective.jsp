<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>include 지시자 테스트 페이지</h1>
	
	<%@ include file="includePage.jsp" %>
	
	메세지 : <%= msg %>
	<!-- 포함한 페이지에 선언되어있는 변수 공유해서 쓸 수 있음 -->
	
</body>
</html>