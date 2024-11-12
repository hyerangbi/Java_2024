<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Sour+Gummy:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

<style>
    .msg{
        font-family: "Do Hyeon", serif;
        font-weight: 400;
        font-style: normal;
    }
</style>
<title>Insert title here</title>
</head>
<body>
    <h1> 채팅 </h1>
    메시지 : <input type="text" name="msg" class="msg"> <br>
    수신자 : <input type="text" name="target" class="target"> <br>

    <button onclick="sendMsg()"> 전송 </button>

    <br>
    <div id="msg-container"><!-- 채팅 기록 공간--></div>

    <script>
        const socket = new WebSocket("ws://localhost:7777/etc/server"); // 어디에 접속할 것인지

        socket.onopen = function(){
            console.log('연결 성공 ! ◝(・▿・)◜')
        }

        socket.onclose = function(){
            console.log(' 연결이 끊어졌습니다 •̀ㅅ•́ ')
        }

        socket.onerror = function(){
            // 에러가 났을 때
            console.log(' 연결 실패 .. (⑅◞‸◟)')
        }

        // socket 연결로부터 데이터가 도착했을 때 실행하는 이벤트
        socket.onmessage = function(ev){
            const receive = JSON.parse(ev.date)

            const msgContainer = document.querySelector("#msg-container");
            msgContainer.innerHTML += (receive.nick + "("+ receive.time+ "<br>" + receive.msg+ "<br>"); // 서버로부터 받은 값
        }

        function sendMsg(){
            const msgData = {
                message : document.querySelector("input[name=msg]").value,
                target: document.querySelector("input[name=target]").value,
            }

            socket.send(JSON.stringify(msgData));
        }
    </script>
</body>
</html>