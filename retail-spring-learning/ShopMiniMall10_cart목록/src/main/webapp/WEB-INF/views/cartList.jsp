<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Main 화면입니다</h1>
<jsp:include page="commons/top.jsp" flush="true" />
<hr>
<jsp:include page="commons/menu.jsp" />
<hr>
<jsp:include page="goods/cartList.jsp" />
</body>
</html>