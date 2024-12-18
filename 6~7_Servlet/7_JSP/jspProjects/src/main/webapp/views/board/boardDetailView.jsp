<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.board.model.vo.Board, com.kh.board.model.vo.Attachment" %>

<%
    Board b = (Board)request.getAttribute("board");

	Attachment at = (Attachment)request.getAttribute("attachment");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    .outer{
        background: black;
        color: white;
        width: 1000px;
        margin: auto;
        margin-top: 50px;
        padding: 10px 0 50px 0px;
    }

    .outer table{
        border: 1px solid white;
        border-collapse: collapse;
    }
    
    .outer > table tr, .outer > table td{
    	border: 1px solid white;
    }
    
    .outer table a{
    	color: white;
    }
</style>

</head>
<body onload="init(<%=b.getBoardNo() %>)">

    <%@ include file="../common/menubar.jsp" %>
    <div class="outer">
        <br>
        <h2 align="center">일반게시글 상세보기</h2>
        <br>

        <table border="1" align="center">
            <tr>
                <th width="70">카테고리</th>
                <td width="70"><%= b.getCategory() %></td>
                <th width="70">제목</th>
                <td width="350"><%= b.getBoardTitle() %></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><%= b.getBoardWriter() %></td>
                <th>작성일</th>
                <td><%= b.getCreateDate() %></td>
            </tr>
            <tr></tr>
                <th>내용</th>
                <td colspan="3">
                    <p style="height: 200px;">
                        <%= b.getBoardContent() %>
                    </p>
                </td>
            </tr>
            <tr>
            	<th>첨부파일</th>
            	<td colspan="3">
                	<%if(at == null) { %> 
	                    첨부파일이 없습니다. 
                    <% } else {%>
	                    <a download="<%=at.getOriginName() %>" href="<%=contextPath%>/<%=at.getFilePath() + at.getChangeName()%>"><%=at.getOriginName() %></a>
                	<%} %>
                </td>
            </tr>
        </table>
        <br>

        <div align="center">
            <a href="<%=contextPath%>/list.bo?cpage=1" class="btn btn-sm btn-secondary"> 목록가기</a>
            <% if(loginUser != null && loginUser.getUserId().equals(b.getBoardWriter())) { %>
                <a href="<%=contextPath %>/updateForm.bo?bno=<%=b.getBoardNo()%>" class="btn btn-sm btn-warning">수정하기</a>
                <a href="" class="btn btn-sm btn-danger">삭제하기</a>
            <% } %>
        </div>

        <br>

        <div id="replay-area">
            <table align="center">
                <thead>
                    <th>
                        <th>댓글작성</th>
                        <td>
                            <textarea id="replay-content" style="resize: none" cols="50" rows="3"></textarea>
                        </td>
                        <td>
                            <button onclick="insertReplay()">댓글등록</button>
                        </td>
                    </th>
                </thead>
                <tbody>
                 <!--    <tr>
                        <td>user05</td>
                        <td>댓글남깁니다.</td>
                        <td>2024-09-26</td>
                    </tr>
                    <tr>
                        <td>user05</td>
                        <td>댓글남깁니다.</td>
                        <td>2024-09-26</td>
                    </tr>
                    <tr>
                        <td>user05</td>
                        <td>댓글남깁니다.</td>
                        <td>2024-09-26</td>
                    </tr> -->
                </tbody>
            </table>

            <script>            	
            	window.onload = function (){            		
            		
            		$.ajax({
            			url:"rlist.bo",
            			data:{
            				bno: <%=b.getBoardNo() %>
            			},
            			success: function(res){
            				console.log(res)
            			}, error: function(){
            				console.log("댓글 조회용 ajax 통신 실패")
            			}
            		})
            	}
            	
                function insertReplay(){
                    const boardNo = <%=b.getBoardNo() %>;
                    const content = document.querySelector("#replay-content").value;

                    $.ajax({
                        url : "rinsert.bo",
                        contentType : "application/json",
                        data: {
                            bno : boardNo,
                            content : content
                        },
                        type : "post",
                        success : function(res){

                        },
                        error : function(){
                            console.log("댓글 작성중 ajax통신 실패")
                        }
                    })
                }
            </script>
        </div>
    </div>
</body>
</html>
