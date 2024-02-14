<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>  
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>

   <sec:authorize access="isAnonymous()">
   		<h2>환영합니다.</h2>
    	<a href="login">로그인</a><br>
    	<a href="signup">회원가입</a><br>
   </sec:authorize>
	<sec:authorize access="isAuthenticated()">
	   <sec:authentication property="principal.username" var="username"/>
   		<h2>안녕하세요.${username}</h2>
    	<form action="/logout" method="post">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
          <button type="submit">로그아웃</button>
        </form>
        
        
        <button type="button" onclick="location.href='updateForm'">수정하기</button>
         <form action="/delete" method="get">
            
<%--         	<input type="hidden" name="email" value="${username}" /> --%>
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        	<button type="submit">탈퇴하기</button>
    	</form>
    	<a href="/delete">탈퇴하기2</a>
   </sec:authorize>
   
</body>
</html>