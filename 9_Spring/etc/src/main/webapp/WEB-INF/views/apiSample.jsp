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

<!-- style-->
<style>
    body{
        background: #f8fcfd;
    }
    h1{
        font-family: "Hahmlet", serif;
        font-style: normal;
    }
    table{
        border-top: 1px solid #ffffff;
        border-bottom: 1px solid #ffffff;
    }
    #btn1{
        border: 3px solid #0032bb;
        border-radius: 5px;
        background: #a3c6fa;
        color: #ffffff;
        font-family: "Do Hyeon", sans-serif;
        font-weight: 400;
        font-style: normal;
        font-size: 16px;
    }
    select{
        width: 50px;
        border: 1px solid #aaaaaa;
        border-radius: 3px;        
        background: #a3c6fa;
    }
</style>
</head>
<body onload="init()">
 <h1> 실시간 대기오염 정보 </h1>
 
 지역 : 
 <select id="location">
    <option>서울</option>
    <option>대전</option>
    <option>대구</option>
    <option>부산</option>
 </select>

 <button id="btn1" class="btn btn-sm btn-primary" onclick="getAirStatusHandler()">
    해당지역 대기오염 정보
 </button>

 <table id="result" class="table">
    <thead>
        <tr>
            <th>측정소명</th>
            <th>측정일시</th>
            <th>통합대기 환경수치</th>
            <th>미세먼지농도</th>
            <th>일산화탄소농도</th>
            <th>일산화질소농도</th>
            <th>오존농도</th>
        </tr>        
    </thead>
    <tbody>
        <!-- 서버로부터 받는 데이터 -->        
    </tbody>
 </table>

 <br><br>

 <script>
    function init(){
        document.getElementById("btn1").click();
    }

    function getAirStatusHandler(){
        // 지역명 포함해서 서버로 ajax 요청
        const location = document.querySelector("#location").value;

        getAirStatus({location: location}, function(getAirStatusList){
            console.log(airStatusList)
            const itemList = airStatusList.response.body.item;

            drawAriBody(document.querySelector("#result tbody"), itemList);
        })
    }

    function getAirStatus(data, callback){
        $.ajax({
            url:"air",
            data : data,
            success : function(result){
                callback(result)
            },
            error: function(){
                consople.log("대기정보 api요청 실패")
            }
        })
    }

    function  drawAriBody(parent, itemArr){
        parent.innerHTML = "";

        for(const item of itemArr){
            parent.innerHTML += ("<tr>"
                                + "<td>"+ item.stationName + "</td>"
                                + "<td>"+ item.dataTime + "</td>"
                                + "<td>"+ item.khaiValue + "</td>"
                                + "<td>"+ item.pm10Value + "</td>"
                                + "<td>"+ item.coValue + "</td>"
                                + "<td>"+ item.no2Value + "</td>"
                                + "<td>"+ item.o3Value + "</td>"
                                +"</tr>")
        }
    }
 </script>
</html>