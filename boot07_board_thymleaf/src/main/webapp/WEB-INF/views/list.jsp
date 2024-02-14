<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시판 목록</h3>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<th:block th:with="list=${pageDTO.list}"></th:block>
		
		<%-- <c:set var="list" value="${ pageDTO.list }"></c:set> --%>
		<th:block th:each="dto:${list}">
			<td th:text="${dto.num}"></td>
			<td><a th:href="retrieve?num=${dto.num}">${ dto.title }</a></td>
			<td th:text="${dto.author}"></td>
			<td th:text="${dto.writeday}"></td>
			<td th:text="${dto.readcnt}"></td>
		</th:block>
		
		<c:forEach var="dto" items="${ list }">
			<tr>
				<td>${ dto.num }</td>
				<td><a href="retrieve?num=${dto.num}">${ dto.title }</a></td>
				<td>${ dto.author }</td>
				<td>${ dto.writeday }</td>
				<td>${ dto.readcnt }</td>
			</tr>
		</c:forEach>
		
		<th:block th:with="totalCount=${login.totalCount}, perPage=${login.perPage}, curPage=${pageDTO.curPage}, totalNum=${totalCount / perPage} }"></th:block>
		
	<%-- 	<c:set var="totalCount" value="${ pageDTO.totalCount }" />
		<c:set var="perPage" value="${ pageDTO.perPage }" />
		<c:set var="curPage" value="${ pageDTO.curPage }" />
		<c:set var="totalNum" value="${ totalCount / perPage }" /> --%>
		<c:if test="${totalCount%perPage != 0 }">
			<c:set var="totalNum" value="${ totalNum+1 }" />
		</c:if>
		
		

		<tr>
			<td colspan="5"><c:forEach var="i" begin="1" end="${totalNum}">
					<!-- 현재 페이지면 링크없고 다른 페이지면 링크를 만들어야 한다. -->
					<c:if test="${curPage==i }">
               ${i} &nbsp;
            </c:if>
					<c:if test="${curPage!=i }">
						<a href="list?curPage=${i}">${i }</a>&nbsp;
            </c:if>

				</c:forEach></td>
		</tr>
	</table>

	<a href="write">글쓰기</a>
</body>
</html>