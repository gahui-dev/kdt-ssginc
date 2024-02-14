<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/style.css">
</head>
<body>
	<%@ include file ="./common/header.jsp" %>
	<main>
		<form action="${pageContext.request.contextPath}/myPage" method="post">
			<h2>마이 페이지 </h2>
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid"
						value="${ requestScope.userid }" readonly class="readonly"></td>
				</tr>
				<tr>
					<td>비밀번호(*)</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"
						value="${requestScope.name}"></td>
				</tr>
				<tr>
					<td>권한</td>
					<td><select name="level" disabled>
							<c:if test="${ requestScope.level == 0 }">
								<option value="0" selected>운영자</option>
								<option value="1">일반회원</option>
							</c:if>
							<c:if test="${ requestScope.level == 1 }">
								<option value="0">운영자</option>
								<option value="1" selected>일반회원</option>
							</c:if>
					</select></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><select name="gender" disabled>
							<c:choose>
								<c:when test="${ requestScope.gender eq 'M' }">
									<option value="M" selected>남</option>
									<option value="F">여</option>
								</c:when>
								<c:when test="${ requestScope.gender eq 'F'}">
									<option value="M">남</option>
									<option value="F" selected>여</option>
								</c:when>
							</c:choose>
					</select></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone"
						value="${ requestScope.phone }"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type=submit>수정</button>
						<button type="reset">취소</button>
					</td>
				</tr>
			</table>
		</form>
	</main>

</body>
</html>