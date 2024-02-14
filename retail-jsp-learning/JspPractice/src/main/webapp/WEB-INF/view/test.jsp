<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/common.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/table.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/pagination.css">
</head>
<body>
	<%@ include file ="./common/header.jsp" %>	
	
<main>
		<h2 class="title">영화 목록</h2>
		<form action="${pageContext.servletContext.contextPath }/test" method="get">
		<select name="amount" onchange="this.form.submit();">
			<option value="5" <c:if test="${ pageMaker.criteriaAmount == 5 }">selected</c:if>>5개씩 보기</option>
			<option value="10" <c:if test="${ pageMaker.criteriaAmount == 10 }">selected</c:if>>10개씩 보기</option>
			<option value="35" <c:if test="${ pageMaker.criteriaAmount == 35 }">selected</c:if>>35개씩 보기</option>
			<option value="70" <c:if test="${ pageMaker.criteriaAmount == 70 }">selected</c:if>>70개씩 보기</option>
			<option value="100" <c:if test="${ pageMaker.criteriaAmount == 100 }">selected</c:if>>100개씩 보기</option>
		</select>
		<input type="hidden" name="pageNo" value="${ param.pageNo }" />
		
		<table>
			<tr>
				<th>영화 번호</th>
				<th>영화 제목</th>
			</tr>
			<c:forEach var="movie" items="${ requestScope.movielist }">
				<tr>
					<td>${ movie.m_id }</td>
					<td>${ movie.m_name }</td>
				</tr>
			</c:forEach>
		</table>

		<!-- 	페이지네이션  -->
		<%@ include file="./common/paging.jsp"%>
		</form>
		
	</main>

	<%-- <%@ include file ="./common/footer.jsp" %> --%>
	<footer>
		<p>footer 영역입니다.</p>
	</footer>
</body>
</html>