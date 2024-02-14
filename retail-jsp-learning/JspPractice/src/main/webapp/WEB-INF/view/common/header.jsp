<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<header>
	<h1>
		<span>${ sessionScope.name }</span>님 반갑습니다.
	</h1>
	<nav>
		<ul>
			<li><a href="${pageContext.request.contextPath}/main">홈</a></li>

			<c:if test="${ sessionScope.level == 0 }">
				<li><a href="${pageContext.request.contextPath}/register">사원등록</a></li>
			</c:if>
			<li><a href="${pageContext.request.contextPath}/myPage">마이페이지</a></li>
		</ul>
		<button
			onclick="location.href='${pageContext.request.contextPath}/logout'">로그아웃</button>
	</nav>
</header>
</html>