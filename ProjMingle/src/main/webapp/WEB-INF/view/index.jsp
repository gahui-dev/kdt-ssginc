<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proj Mingle</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">

</head>
<body>
<div class="wrap">
<jsp:include page="./layout/header.jsp"/>
	<section>
		<jsp:include page="./layout/project.jsp"/>
	</section>
	
	<section class="status">
		<article class="tasks">
			<div class="title">
				<h2><span></span> 진행현황</h2>
				<div>
					<button class="primary reversal">업무 추가</button>
					<button class="primary reversal">프로젝트 수정</button>
				</div>
			</div>
			<table id="status__table">
				<tr>
					<th>업무명</th>
					<th>담당자</th>
					<th>카테고리</th>
					<th>시작기간</th>
					<th>마감기간</th>
					<th>진행률</th>
				</tr>
				<tr>
					<td>업무명</td>
					<td>담당자</td>
					<td>카테고리</td>
					<td>시작기간</td>
					<td>마감기간</td>
					<td>진행률</td>
				</tr>
				<tr>
					<td>업무명</td>
					<td>담당자</td>
					<td>카테고리</td>
					<td>시작기간</td>
					<td>마감기간</td>
					<td>진행률</td>
				</tr>
				<tr>
					<td>업무명</td>
					<td>담당자</td>
					<td>카테고리</td>
					<td>시작기간</td>
					<td>마감기간</td>
					<td>진행률</td>
				</tr>
			</table>
		</article>
		
		<article class="member">
			<div class="title">
				<h2>참여자</h2>
				<button class="primary reversal">멤버 추가</button>
			</div>
			<div class="member__list">
				<h3>프로젝트 리더</h3>
				<div class="profile">
					<span></span>
					<div>
						<p>참여자 이름</p>
						<span>참여자 메일주소</span>
					</div>
				</div>
				
				<h3>멤버</h3>
				<div class="profile">
					<span></span>
					<div>
						<p>참여자 이름</p>
						<span>참여자 메일주소</span>
					</div>
				</div>
				<div class="profile">
					<span></span>
					<div>
						<p>참여자 이름</p>
						<span>참여자 메일주소</span>
					</div>
				</div>
				<div class="profile">
					<span></span>
					<div>
						<p>참여자 이름</p>
						<span>참여자 메일주소</span>
					</div>
				</div>
			</div>
		</article>
	</section>
</div>
</body>
</html>