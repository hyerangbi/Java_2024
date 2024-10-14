<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>피자 주문페이지 </h1>
    <h2>오늘의 날짜</h2>
    <%  
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
    %>

    <h4><%=sdf.format(today)%></h4>

    <!--
        주문자정보, 주문정보를 입력받아서
        서버에 결제요청(servlet에 전달)
        controller -> PizzaServlet.java
        응답을 위한 jsp페이지
        pizza -> pizzaPayment.jsp
    -->

    <form action="/JSP/confirmPizza.do" method="get">
        <fieldset>
            <legend> 주문자 정보</legend>

            <table>
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="userName" required></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="phone" required></td>
                </tr>                
                <tr>
                    <td>주소</td>
                    <td><input type="text" name="address" required></td>
                </tr>
                <tr>
                    <td>요청메세지</td>
                    <td><textarea type="text" name="message" required></td>
                </tr>
            </table>
        </fieldset>
        <br>
        <fieldset>
            <legend>주문정보</legend>
            <table>
                <tr>
                    <th>피자</th>
                    <td>
                        <select name="pizza" id="">
                            <option value="">콤비네이션</option>
                            <option value="">포테이토피자</option>
                            <option value="">고구마피자</option>
                            <option value="">페페로니피자</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>토핑</th>
                    <td>
                        <label>
                            <input type="checkbox" name="topping" value="고구마무스"> 고구마무스
                        </label>
                        <label>
                            <input type="checkbox" name="topping" value="치즈크러스트"> 치즈크러스트
                        </label>
                        <label>
                            <input type="checkbox" name="topping" value="베이컨"> 베이컨
                        </label>
                        <label>
                            <input type="checkbox" name="topping" value="페페로니"> 페페로니
                        </label>
                        <label>
                            <input type="checkbox" name="topping" value="까르보나라">까르보나라
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>사이드</th>
                    <td></td>
                        <label>
                            <input type="checkbox" name="side" value="오븐토마토스파게티"> 오븐토마토스파게티
                        </label>
                        <label>
                            <input type="checkbox" name="side" value="오븐크림스파게티"> 오븐크림스파게티
                        </label>
                        <label>
                            <input type="checkbox" name="side" value="치즈볼"> 치즈볼
                        </label>
                        <label>
                            <input type="checkbox" name="side" value="치즈스틱"> 치즈스틱
                        </label>
                        <label>
                            <input type="checkbox" name="side" value="치즈스틱"> 치즈스틱
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>결제방식</th>
                    <td>
                        <input type="radio" name="payment" value="card" checked> 카드결제
                        <input type="radio" name="payment" value="cash"> 현금결제
                    </td>
                </tr>
            </table>
        </fieldset>

        <br>

        <input type="submit" value="주문">
        <input type="reset">
    </form>
</body>
</html>