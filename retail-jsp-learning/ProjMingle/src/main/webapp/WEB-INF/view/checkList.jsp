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
	<section class="left">
		<jsp:include page="./layout/project.jsp"/>
	</section>
	
	<section class="checklist">
		<article>
			<div class="title">
				<h2>전체 업무</h2>
				<div>
					<label><input type="radio" name="task" checked />나의 담당 업무</label>
					<label><input type="radio" name="task" />전체 업무 </label>
				</div>
			</div>
			<article class="task">
				<table id="status__table">
					<tr>
						<th>카테고리</th>
						<th>업무명</th>
						<th>담당자 </th>
						<th>진행률</th>
					</tr>
					<tr>
						<td>카테고리</td>
						<td>업무명</td>
						<td>담당자</td>
						<td>진행률</td>
					</tr>
					<tr>
						<td>카테고리</td>
						<td>업무명</td>
						<td>담당자</td>
						<td>진행률</td>
					</tr>
					<tr>
						<td>카테고리</td>
						<td>업무명</td>
						<td>담당자</td>
						<td>진행률</td>
					</tr>
				</table>
			</article>
		</article>
		<article class="checklist">
		
			<div class="title">
				<h2>체크리스트</h2>
				<button class="primary reversal">체크리스트 추가</button>
			</div>
			<table id="status__table">
				<tr>
					<th>체크리스트 제목</th>
					<th>업무명</th>
					<th>진행률</th>
					<th>이슈사항</th>
					<th>시작일</th>
					<th>종료일</th>
				</tr>
				<tr>
					<td>체크리스트 제목</td>
					<td>업무명</td>
					<td><input type="text" placeholder="진행률을 입력해주세요" value="0.0"/></td>
					<td><input type="text" placeholder="이슈사항을 입력해주세요" /></td>
					<td>시작일</td>
					<td>종료일</td>
					<td>
						<button class="primary reversal">수정</button>
						<button class="primary reversal">저장</button>
						<button class="primary reversal">삭제</button>
					</td>
				</tr>
				<tr>
					<td>체크리스트 제목</td>
					<td>업무명</td>
					<td><input type="text" placeholder="진행률을 입력해주세요" value="0.0"/></td>
					<td><input type="text" placeholder="이슈사항을 입력해주세요" /></td>
					<td>시작일</td>
					<td>종료일</td>
					<td>
						<button class="primary reversal">수정</button>
						<button class="primary reversal">저장</button>
						<button class="primary reversal">삭제</button>
					</td>
				</tr>
				<tr>
					<td>체크리스트 제목</td>
					<td>업무명</td>
					<td><input type="text" placeholder="진행률을 입력해주세요" value="0.0"/></td>
					<td><input type="text" placeholder="이슈사항을 입력해주세요" /></td>
					<td>시작일</td>
					<td>종료일</td>
					<td>
						<button class="primary reversal">수정</button>
						<button class="primary reversal">저장</button>
						<button class="primary reversal">삭제</button>
					</td>
				</tr>
				<tr>
					<td>체크리스트 제목</td>
					<td>업무명</td>
					<td><input type="text" placeholder="진행률을 입력해주세요" value="0.0"/></td>
					<td><input type="text" placeholder="이슈사항을 입력해주세요" /></td>
					<td>시작일</td>
					<td>종료일</td>
					<td>
						<button class="primary reversal">수정</button>
						<button class="primary reversal">저장</button>
						<button class="primary reversal">삭제</button>
					</td>
				</tr>
			</table>
		</article>		
	</section>
</div>
</body>