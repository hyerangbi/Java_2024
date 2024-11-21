<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 

<!-- font -->
 <!--btn1 font-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
 <!-- h1 font -->
 <link rel="preconnect" href="https://fonts.googleapis.com">
 <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
 <link href="https://fonts.googleapis.com/css2?family=Hahmlet:wght@100..900&display=swap" rel="stylesheet">


</head>
<body>
	<h3> 공공데이터 활용 </h3>
	<h5><a href="detail?page=publicData">view -> </a></h5>
	<h3> 텍스트 에이더 라이브러리 </h3>
	<h5><a href="detail?page=summernote">view -> </a></h5>
	<h3> 채팅창 : websocket </h3>
	<h5> 닉네임 : <input type="text" name="nick" id=""></h5>
	<h5><button onclick="moveChat">view -> </button></h5>
	
	<h3> 소셜 로그인 : naver </h3>
	<h5><a href="detail?page=naver">view -> </a></h5>

	<script>
		function moveChat(){
			const nick = document.querySelector("#nick").value;
			location.href = "detail?page=chat&nick=" + nick;
		}
	</script>
</body>
</html>