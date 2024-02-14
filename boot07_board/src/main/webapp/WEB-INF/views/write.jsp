<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("form").on("submit", function() {
			var result = false;
			if(result) {
				alert("사용자 입력 필수입니다. ");
				event.preventDefault();
			}
		})
	})
</script>
</head>
<body>
	<h3>글쓰기 화면</h3>
	<form method="post">
		<label>제목 <input type="text" name="title"></label>
		<label>작성자 <input type="text" name="author"></label><br>
		<label>내용 <textarea rows="20" cols="20" name="content"></textarea></label>
		<input type="submit" value="저장">
	</form>
	<a href="list">목록</a>
</body>
</html>