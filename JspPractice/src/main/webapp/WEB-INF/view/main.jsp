<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.jsp.util.InternalViewResolver"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/style.css">
</head>
<link>
<body>
<%-- 	<%@ include file ="./common/header.jsp" %> --%>
<%-- 	<c:import url="./common/header.jsp"></c:import> --%>
<% pageContext.setAttribute("menuUri", InternalViewResolver.getResolveViewIncludeUrl("common/header")); %>
<c:import url="${ menuUri }"></c:import>
<p> InternalViewResolver.getResolveViewIncludeUrl("common/header"));</p>
	<main class="main">
		<div>
			<c:if test="${ sessionScope.level == 0 }">
				<h1>관리자 전용 페이지입니다. </h1>
			</c:if>
			<c:if test="${ sessionScope.level == 1 }">
				<h1>회원 전용 페이지입니다. </h1>
			</c:if>
		</div>
	</main>
	<p>안녕하세요 <span>찬웅 </span>님 </p>
</body>
</html>