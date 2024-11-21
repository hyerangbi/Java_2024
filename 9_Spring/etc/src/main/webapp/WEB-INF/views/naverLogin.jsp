<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 로그인 </title>
</head>
<body>
	<h1> 로그인 </h1>
	<form action="login">
		<input type="submit" value="로그인"/>
		<input type="button" vaule="네이버로그인"/>
	</form>
	
	<script>
		function naverLogin(){
			const clientId = "p9SHXHG0dQcKzR0AS93k";
			// 리다이렉트 URL 을 utf-8 로 인코딩해서 저장한다.
			const redirectURL = encodingURIComponent("http://localhost:7777/etc/naver-login");

			const state = Math.random().toString(36).substring(2); // 랜덤 값 2개를 가져와야한다.

			const api = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
			apiURL += "&client_id" + clientId;
			apiURL += "&redirect_uri" + redirectURL;
			apiURL += "&state" + state;

			location.href = apiURL; // 요청
		}
	</script>
</body>
</html>