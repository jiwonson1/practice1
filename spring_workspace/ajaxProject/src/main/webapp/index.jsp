<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h1>Spring에서의 AJAX 사용법</h1>
	
	<h3>1. post방식으로 요청 후 응답 결과 받아보기</h3>
	이름 : <input type="text" id="name"> <br>
	나이 : <input type="number" id="age"> <br>
	
	<button onclick="test1();">전송</button>
	
	<div id="result1">응답결과 없음</div>
	
	<script>
		function test1(){
			$.ajax({
				url:"ajax1.do",
				data:{
					name:$("#name").val(),
					age:$("#age").val()
				},
				type:"post",
				success:function(data){
					$("#result1").text(data);
				},
				error:function(){
					console.log("ajax 통신 실패");
				}
			});
		}
	</script>
	
	<h3>2. 조회된 회원 객체를 응답 받아서 출력해보기</h3>
	조회할 회원번호 : <input type="number" id="userNo">
	<button id="btn">조회</button>
	
	<div id="result2">응답결과 없음</div>
	
	<script>
		$(function(){
			$("#btn").click(function(){
				$.ajax({
					url:"ajax2.do",
					data:{userNo:$("#userNo").val()},
					type:"get",
					success:function(m){
						
						console.log(m);
						var value = "<ul>" + 
										"<li>이름 : " + m.userName + "</li>" +
										"<li>아이디 : " + m.userId + "</li>" +
										"<li>나이 : " + m.age + "</li>" +
									"</ul>";
						
						$("#result2").html(value);
						
					},error:function(){
						console.log("ajax 통신 실패");
					}
				})
			})
		})
	</script>
	
	
	<h3>3. 조회된 회원 객체 리스트 응답받아 출력하기</h3>
	<button onclick="test3();">회원 전체 조회 </button>
	
	<table border="1" id="table-area">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
	
	<script>
		function test3(){
			$.ajax({
				url:"ajax3.do",
				success:function(list){
					console.log(list);
					var value = "";
					for(var i in list){
						value += "<tr>" + 
									"<td>" + list[i].userId + "</td>" +
									"<td>" + list[i].userName + "</td>" + 
									"<td>" + list[i].age + "</td>" +
									"<td>" + list[i].phone + "</td>" +
								 "</tr>";
					}
					
					$("#table-area tbody").html(value);
					
				},error:function(){
					console.log("ajax 통신 실패");
				}
			})
		}
	</script>

</body>
</html>