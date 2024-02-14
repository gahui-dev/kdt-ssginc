<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProjMingle - 로그인</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div class="container signInUp">
	<form action="./signIn" method="post" class="form" name="form" autocomplete="off">
		<h1>ProjMingle</h1>
		<label><input type="text" name="mail" placeholder="이메일" id="mail"></label>
		<label><input type="password" name="password" placeholder="패스워드" id="password"></label>
		<p class="message">${ requestScope.msg }</p>
		<label><input type="checkbox">로그인 정보 기억하기</label>
		<button class="primary" onclick="return signIn()">로그인</button>
		<p><a href="./signUp">아직 회원이 아니신가요?</a></p>
	</form>
</div>
<script>
function signIn() {
	let msg = document.querySelector(".message");
	
	if(document.form.mail.value == "") {
		msg.textContent = "이메일을 입력해주세요 :)";
		document.form.mail.focus();
		return false;
	} else if (document.form.password.value == "") {
		msg.textContent = "패스워드를 입력해주세요 :)";
		document.form.mail.focus();
		return false;
	}
}
</script>
</body>
</html>