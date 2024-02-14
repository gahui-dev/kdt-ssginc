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
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.username" var="username"/>
	</sec:authorize>
	
    <p>로그인 되었습니다.</p>
	<p><strong>${username}</strong> 님 반갑습니다.
	<form action="/logout" method="post">
	  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      <button>로그아웃</button>	
	</form>
	<a href="update">수정</a><br>
	<a href="delete">삭제</a><br>
 
</body>
</html>