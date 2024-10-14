<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("name");
	String phone = (String)request.getParameter("phone");
	String address = (String)request.getParameter("address");
	String message = (String)request.getParameter("message");
	
	String pizza = (String)request.getParameter("pizza");
	String[] toppings = (String[])request.getParameterValues("topping");
	String[] side = (String[])request.getParameterValues("side");
	String payment = (String)request.getParameter("payment");
	int price = (int)request.getAttribute("price");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 피자 결제 페이지 </h1>
	<h2> 주문내역 </h2>
	<h4> [ 주문자 정보 ] </h4>
	<ul>
		<li>성함 : </li>
		<li>전화번호 : </li>
		<li>주소 : </li>
		<li>요청사항 : </li>
	</ul>

	<br>

	<h4>[ 주문정보 ]</h4>
	<ul>
		<li> 피자 : </li>
		<li> 토핑 : 선택안함</li>
		<li> 토핑 : </li>
		<li> 사이드 : 선택안함</li>
		<li> 사이드 : </li>
		<li> 결제방식 : </li>
	</ul>

	<h3> 위와 같이 주문하셨습니다.</h3>
	<h2> 총 가격 : ? 원</h2>
</body>
</html>