<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>피자 주문 페이지</h1>
	
	<h2>오늘의 날짜</h2>
	<%@ include file="includePage.jsp" %>
	
	<form action="/2_JSP/order.do" method="post">

        <fieldset>
            <legend>주문자 정보</legend>
            <!-- 이름(*), 전화번호(*), 주소(*), 요청사항 -->
            <table>
                <!-- (tr>th+td)*4 -->
                <tr>
                    <th>* 이름</th>
                    <td><input type="text" name="userName" required placeholder="이름을 입력해주세요"></td>
                </tr>
                <tr>
                    <th>* 전화번호</th>
                    <td><input type="text" name="phone" required placeholder="010-1111-2222"></td>
                </tr>
                <tr>
                    <th>* 주소</th>
                    <td><input type="text" name="address" required placeholder="주소를 입력해주세요"></td>
                </tr>
                <tr>
                    <th>요청사항</th>
                    <td><textarea name="message" placeholder="요청사항을 작성해주세요"></textarea></td>
                </tr>
            </table>
        </fieldset>


        <fieldset>
            <legend>주문 정보</legend>
            <!-- 피자종류, 토핑, 사이드 -->
            <table>
                <tr>
                    <th>피자</th>
                    <td>
                        <select name="pizza">
                            <option value="콤비네이션피자">콤비네이션피자</option>
                            <option value="치즈피자">치즈피자</option>
                            <option value="고구마피자">고구마피자</option>
                            <option value="불고기피자">불고기피자</option>
                            <option value="페퍼로니피자">페퍼로니피자</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>토핑</th>
                    <td>
                        <input type="checkbox" name="topping" value="고구마무스"> 고구마무스
                        <input type="checkbox" name="topping" value="콘크림무스"> 콘크림무스
                        <input type="checkbox" name="topping" value="파인애플"> 파인애플 <br>
                        <input type="checkbox" name="topping" value="치즈토핑"> 치즈토핑
                        <input type="checkbox" name="topping" value="치즈크러스트"> 치즈크러스트
                        <input type="checkbox" name="topping" value="치즈바이트"> 치즈바이트
                    </td>
                </tr>
                <tr>
                    <th>사이드</th>
                    <td>
                        <input type="checkbox" name="side" value="콜라"> 콜라
                        <input type="checkbox" name="side" value="사이다"> 사이다
                        <input type="checkbox" name="side" value="핫소스"> 핫소스 <br>
                        <input type="checkbox" name="side" value="피클"> 피클
                        <input type="checkbox" name="side" value="갈릭소스"> 갈릭소스
                        <input type="checkbox" name="side" value="파마산치즈가루"> 파마산치즈가루
                    </td>
                </tr>
            </table>
        </fieldset>

        <br>
        <button type="submit">주문하기</button>
    </form>
	
</body>
</html>