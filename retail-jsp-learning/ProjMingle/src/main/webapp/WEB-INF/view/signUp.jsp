<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProjMingle - 회원가입</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div class="container signInUp">
	<form action="${pageContext.request.contextPath}/signUp" method="post" class="form" autocomplete="off">
		<h1>회원가입</h1>
		
		<label><input type="text" name="mail" placeholder="이메일" id="mail"></label>
		<!-- <button type="submit" class="primary">중복 확인</button>  -->
		<p id="mail_msg" class="message"></p>
		
		<label><input type="password" name="password" placeholder="패스워드" id="password"></label>
		<p id="password_msg" class="message"></p>
		
		<label><input type="password" name="password_check" placeholder="패스워드 확인" id="password_check" disabled></label>
		<p id="password_check_msg" class="message"></p>
		
		<label><input type="text" name="name" placeholder="이름" id="name"></label>
		<p id="name_msg" class="message"></p>
		
		<label><input type="checkbox" name="agree" id="checkbox">회원가입에 동의합니다.</label>
		
		<div class="buttons">
			<button type="submit" class="primary" onclick="return signUp()">등록</button> 
			<button type="button" class="primary reversal" onclick="location='${pageContext.request.contextPath}/signIn'">취소</button> 
		</div>
	</form>
</div>
<script src="${pageContext.request.contextPath}/resources/js/signUp.js"></script> 
</body>
</html>