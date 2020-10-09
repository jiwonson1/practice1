<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error500.jsp"%>
<%@ page import="java.util.ArrayList, java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>page 지시자 테스트 페이지</h1>
	
	<%
		ArrayList<String> list = new ArrayList<>(); // 텅 빈 리스트
		
		list.add("Servlet"); // 0번인덱스
		list.add("JSP");	 // 1번인덱스
		
		Date today = new Date(); // 기본생성자로 생성시 현재날짜(년월일시분초)에 대한 정보 == 시스템날짜
	%>
	
	<p>
		리스트의 길이 : <%= list.size() %> <br>
		list.get(0) : <%= list.get(0) %> <br>
		오늘날짜 : <%= today %> <br>
		list.get(10) : <%= list.get(10) %>
	</p>
	
	
	
	
	
	
	
</body>
</html>