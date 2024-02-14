<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie result</title>
<style>
label {
	display: block;
}

.on {
	background-color: yellow;
}

.off {
	background-color: transparent;
}

.selected {
	background-color: green;
}
</style>
<script>
	window.onload = function() {
		const movies = document.getElementsByName('movieInfo');
		for (var i = 0; i < movies.length; i++) {
			movies[i].onclick = function() {
				/* console.log(this); */
				removeClass('movieInfo');
				this.parentElement.className = 'selected';
			}
		}
	}

	function removeClass(name) {
		const movies = document.getElementsByName(name);
		for (var i = 0; i < movies.length; i++) {
			if (!movies[i].parentElement.classList.contains('on')) {
				movies[i].parentElement.className = 'off';
			}
		}
	}
</script>
</head>
<body>
	<h1>movie result</h1>
	<c:set var="checkedOn" value="checked"></c:set>
	<c:set var="styleOn" value="class='on'"></c:set>
	
	<form action="${pageContext.servletContext.contextPath}/movie"
		method="get">
		<c:forEach var="movie" items="${ requestScope.movielist }" varStatus="status">
			
<%-- 			<p>movie.m_id >> ${ movie.m_id } </p>
			<p>param >> ${ param['movieInfo'] } </p> --%>
			<label
				<c:if test="${ movie.m_id == param['movieInfo'] }">${ styleOn } </c:if>>
				<input type="radio" name="movieInfo" value="${ movie.m_id }"
					<c:if test="${ movie.m_id == param['movieInfo'] }">${ checkedOn } </c:if> />
					${ movie.m_id }. ${ movie.m_name }
			</label>
		</c:forEach>

		<button type="submit">전송</button>
	</form>
</body>
</html>