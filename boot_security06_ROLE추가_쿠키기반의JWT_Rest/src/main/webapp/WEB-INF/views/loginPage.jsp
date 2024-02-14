<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>
<!-- 
Spring Security에서는 기본적으로 CSRF 공격을 방어한다.

CSRF Token을 설정해주지 않으면 jsp에서 보내는 POST 요청을 모두 막기 때문에 로그인, 회원가입 기능이 작동하지 않아 인증 과정을 진행할 수 없다.

이를 위해 JSP에서 POST 요청을 보낼 때 CSRF Token에 값을 넣어 함께 보내고, 
Spring Security가 token 값을 확인하여 자신이 내려준 값이 맞는지 확인하는 방식으로 CSRF 공격을 판단한다.

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
CSRF Token에 값을 넣어주는 코드

POST 요청을 보내도 Token에 담긴 값으로 CSRF 공격이 아니라고 판단하여 POST 요청을 막지 않는다.

 -->
    <form action="/auth" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <h2>로그인</h2>
            <div>
                <input type="text" name="email" placeholder="Email"/>
            </div>
            <div>
                <input type="password" name="password" placeholder="Password"/>
            </div>

            <button type="submit">로그인</button>
            <button type="button" onclick="location.href='signup'">회원가입</button>
    </form>
</body>
</html>