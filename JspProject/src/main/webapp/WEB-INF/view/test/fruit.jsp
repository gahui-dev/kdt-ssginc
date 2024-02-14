<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>1. FruitServlet - get - fruit.jsp</li>
		<li>1. FruitServlet - post - fruitResult.jsp</li>
		<li>2. fruit.jsp - form - selectbox - post 방식</li>
		<li>3. fruitResult - 선택사항 보여주기 (라디오 박스로 보여주기)s</li>
	</ul>
	
	<h3>getContextPath</h3>
	<p><%= request.getContextPath() %></p>
	<p>${ pageContext.servletContext.contextPath }</p>
	<p>${ param['data-fruit'] }</p>

	<c:set var="selectedOn" value="selected"></c:set>

	<form action="${ pageContext.servletContext.contextPath }/fruit" method="post">
		<select name="data-fruit">
			<option value="-1" <c:if test="${ param['data-fruit'] == -1 }">${ selectedOn }</c:if>>선택하세요 </option>
			<option value="0" <c:if test="${ param['data-fruit'] == 0 }">${ selectedOn }</c:if>>사과 </option>
			<option value="1" <c:if test="${ param['data-fruit'] == 1 }">${ selectedOn }</c:if>>오렌지 </option>
			<option value="2" <c:if test="${ param['data-fruit'] == 2 }">${ selectedOn }</c:if>>포도 </option>
		</select>
		<button type="submit">전송 </button>
	</form>
	
</body>
</html>