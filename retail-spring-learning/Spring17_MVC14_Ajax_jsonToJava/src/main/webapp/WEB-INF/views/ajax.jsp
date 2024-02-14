<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
.important {
	font-size: xx-large;
	font-weight: bold;
}

.blue {
	color: blue;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	/*
	    ajax 사용
	 */
	$(document).ready(function() {
		$("#main").on("click", function() {
			// ajax 
			$.ajax({
				type : 'get',
				url : "main",
				dataType : "json", // json, xml
				success : function(data, status, xhr) {
					console.log(data);
					console.log("아이디 : ", data.userid);
					console.log("비밀번호 : ", data.passwd);
					console.log("아이디 : ", data["userid"]);
					console.log("비밀번호 : ", data["passwd"]);
				},
				error : function(xhr, status, error) {
					console.log("Error:", error);
				}
			});
		});

		$("#main2").on("click", function() {
			// ajax 
			$.ajax({
				type : 'get',
				url : "main2",
				dataType : "json", // json, xml
				success : function(data, status, xhr) {
					console.log(data);
					data.map(function(row, idx) {
						console.log(row.userid + ": " + row.passwd + "\n");
					})
				},
				error : function(xhr, status, error) {
					console.log("Error:", error);
				}
			});
		});
	});
</script>
</head>
<body>
	<h2>ajax.jsp</h2>
	<button id="main">main</button>
	<button id="main2">main2</button>
	<div id="result"></div>
</body>
</html>