<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proj Mingle - 프로젝트 생성</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">

</head>
<body>
<div class="wrap">
<jsp:include page="./layout/header.jsp"/>
	<section class="left">
		<jsp:include page="./layout/project.jsp"/>
	</section>
	
	<section class="right">
		<article class="create_project">
			<div class="title">
				<h2>프로젝트 생성</h2>
			</div>
			<form action="${pageContext.request.contextPath}/createProject" method="post">
				<label>프로젝트명</label>
				<input type="text" name="title" placeholder="프로젝트명" required/>
				<label>프로젝트 리더</label>
				<input type="text" name="reader" value="${ sessionScope.name }" disabled />
				<label>프로젝트 목적</label>
				<input type="text" name="purpose" placeholder="프로젝트 목적" required />
				<label>프로젝트 일정</label>
				<div>
					<input type="date" name="s_date" placeholder="시작일자" min="2023-01-01" required /> -
					<input type="date" name="e_date" placeholder="마감일자" min="2023-01-01" required />
				</div>
				<label>프로젝트 내용</label>
				<input type="text" name="content" placeholder="간단한 프로젝트 내용을 적어주세요" required/>
				
				<div class="buttons">
					<button type="submit" class="primary">추가하기 </button>
					<button type="reset" class="primary reversal">초기화 </button>
				</div>		
			</form>
		</article>
	</section>
</div>
<script>
window.onload = test();

function test() {
	document.getElementsByName("s_date").valueAsDate = new Date().toISOString().substring(0, 10);
	console.log(document.getElementsByName("s_date"));
	console.log(document.getElementsByName("s_date").valueAsDate);
}
</script>
</body>