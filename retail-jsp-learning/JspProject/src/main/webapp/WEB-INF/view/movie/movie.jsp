<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie select</title>
</head>
<script>
// alert("a"); 
</script>
<body>
	<script>
	<!-- alert("a"); -->
	</script>
	<h1>movie list</h1>
	<c:set var="selectedOn" value="selected"></c:set>

	<form action="${ pageContext.servletContext.contextPath }/movie"
		method="post">
		<select name="movieInfo">
			<c:forEach var="movie" items="${ requestScope.movielist }">
				<option value="${ movie.m_id }"
					<c:if test="${ param['movieInfo'] == movie.m_id }">${ selectedOn }</c:if>>${ movie.m_name }</option>
			</c:forEach>
		</select>
		<button type="submit">전송</button>
	</form>
</body>
</html>