<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	list.jsp
	리스트: ${xxx}  <br />
	<c:forEach var="dto" items="${xxx}">
		<br /> ${dto.userid} , ${dto.passwd} 
	</c:forEach>
</body>
</html>