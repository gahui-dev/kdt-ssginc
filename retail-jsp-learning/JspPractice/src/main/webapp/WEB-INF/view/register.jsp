<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/style.css">
</head>
<body>
	<%@ include file ="./common/header.jsp" %>
	<main>
		<form action="${pageContext.request.contextPath}/register" method="post">
			<h2>사원등록</h2>
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" required/></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" required/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" required /></td>
				</tr>
				<tr>
					<td>권한</td>
					<td><select name="level">
							<option value="0">운영자</option>
							<option value="1">일반회원</option>
					</select></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><select name="gender">
							<option value="M">남</option>
							<option value="F">여</option>
					</select></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone" required></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type=submit>등록</button>
						<button type="reset">취소</button>
					</td>
				</tr>
			</table>
		</form>
	</main>
</body>
</html>