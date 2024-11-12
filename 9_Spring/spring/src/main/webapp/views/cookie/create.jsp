<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	쿠키 생성완료
	<c:if test="${not empty cookie.test }">
		${cookie.test.value }
	</c:if>
	
	<script>
		function setCooke(name, value, days){
			const d = new Date(); // 오늘
			d.setTime(d.getTime() + (days * 24 * 60 * 60 * 1000))
			const expires = "expires = " + d.toUTCString();
			document.cookie = name + "=" + value + ";" + expries + ";path/";
		}
		
		setCookie("thema", "black", 30)
	</script>
	
</body>
</html>