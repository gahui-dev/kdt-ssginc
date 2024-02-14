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
		
		$("#btnUpdate").on("click", function() {
			var f = $("#myForm")[0];
			f.action="update"
			f.method="post"
		});
		
		$("#btnDelete").on("click", function() {
			event.preventDefault();
			location.href="delete?num=" + ${board.num};
		})
	})
</script>
</head>
<body>
	<h3>글쓰기 화면</h3>
	<form id="myForm" method="post">
		<input type="hidden" name="num" value="${board.num }" />
		<label>글 번호 : ${board.num }</label>
		<label>작성일 : ${board.writeday }</label>
		<label>조회수 : ${board.readcnt }</label> <br />
		<label>제목 <input type="text" name="title" value="${board.title }"></label> <br />
		<label>작성자 <input type="text" name="author" value="${board.author }"></label><br />
		<label>내용 <textarea rows="20" cols="20" name="content">${board.content }</textarea></label>
		<button id="btnUpdate">수정</button>
		<button id="btnDelete">삭제</button>
	</form>
	<a href="list">목록</a>
</body>
</html>