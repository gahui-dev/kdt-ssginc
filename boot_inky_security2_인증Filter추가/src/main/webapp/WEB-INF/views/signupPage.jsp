<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign Up</title>
</head>
<body>
    <h2>회원가입</h2>
    <form action="/signup" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <div>
            <input type="text" name="name" placeholder="Name"/>
        </div>
        <div>
            <input type="text" name="username" placeholder="*Username"/>
        </div>
        <div>
            <input type="text" name="email" placeholder="*Email"/>
        </div>
        <div>
            <input type="password" name="password" placeholder="Password"/>
        </div>
        <div>
            <input type="text" name="address" placeholder="Address"/>
        </div>
        <div>
            <input type="text" name="phone" placeholder="Phone"/>
        </div>
        <div>
            <input type="text" name="website" placeholder="Website"/>
        </div>
        <div>
            <input type="text" name="company" placeholder="Company"/>
        </div>

        <button type="submit">회원가입</button>
    </form>
</body>
</html>