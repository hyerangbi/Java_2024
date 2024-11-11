<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <!-- include libraries(jQuery, bootstrap) -->
    <script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="http://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" />
    <script type="text/javascript" src="http://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- include summernote css/js -->
<link href="${pageContext.servletContext.contextPath}/resources/summernote.summernote-bs5.min.css" rel="stylesheet">
<script src="${pageContext.servletContext.contextPath}/resources/summernote.summernote-bs5.min.js"></script>
</head>
<body>
	<form  method="post" action="write">
		제목 : <input type="text" name="title">
		<br><br>
		<textarea id="summernote" name="content"></textarea>
		<br>
		<input type="submit" value="작성완료">
	</form>
	
    <script>
    	$(function(){
    		$('#summernote').summernote({
    	        placeholder: '글을 입력하세오.',
    	        tabsize: 2,
    	        height: 400,
    	        width: 800,
    	        toolbar: [
    	          ['style', ['style']],
    	          ['font', ['bold', 'underline', 'clear']],
    	          ['color', ['color']],
    	          ['para', ['ul', 'ol', 'paragraph']],
    	          ['table', ['table']],
    	          ['insert', ['link', 'picture', 'video']],
    	          ['view', ['fullscreen', 'codeview', 'help']]
    	        ]
    			callbacks: {
    				onImageUpload: fileUpload
    			}
    	      });
    	})
      
    	// summernote 에 이미지업로드가 발생하였을 때 동작하는 함수
    	function fileUpload(files){
    		/*
    			summernote 는 이미지를 추가하면 해당 이미지 파일을 전달해준다.
    			callbacks 에 onImageUpload를 작성하지 않을경우 자동으로 이미지를 string 으로 변환하여 준다.
    			callbacks 에 onImageUpload를 작성할 경우 해당 이미지 경로를 직접 작성해주어야 한다.
    			
    			파일 업로드 할 때는 form 태그에서 enType 을 multipart/form-data 형식으로
    			요청했던것 처럼 js 객체에 FomreData 객체를 이용해서 ajax 요청을 전달해준다.
    		*/
    		
    		const fd = new FormData();
    		for(let file of files){
    			fd.append("fileList", file);
    		}
    		
    		insertFile(fd, function(nameList){
    			// 성공하였을 때
    			for (let name of nameList){
    				$()"#summernote").summernote("insertImage","/img/")
    			}
    		})
    	}
    	
    	function insertFile(){
    		$.ajax({
    			data: data,
    			type: "POST",
    			url: "upload",
    			processData: false, // 기본이 true -> 전송하는 data 을 string 으로 변환해서 요청
    			contentType: false, // 
    			dataType: "json", // 데이터 타입을 받을 때  (이 코드는 json 으로 받겠따 !)
    			success: function(res){
    				callback(res)
    			},
    			error: function(){
    				console.log("파일 업로드 api 요청 실패")
    			}
    		})
    	}
    </script>
</body>
</html>