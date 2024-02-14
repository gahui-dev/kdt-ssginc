<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="title">
	<h2>참여중인 프로젝트</h2>
	<button class="primary reversal" onclick ="location.href='./createProject'">프로젝트 생성</button>
</div>

<article class="project">
	<form id="projectForm" action="./index" method="get"> 
	<c:forEach var="project" items="${ requestScope.projects }" varStatus="status">
	    <div class="project__card on" onclick="submitForm('${project.project}');">
			<div class="project__info">
				<div>
					<h3>${ project.title }</h3>
					<p><span>${ project.sDate } </span> - <span>${ project.eDate }</span></p>
				</div>
				<span class="project__status">진행상태</span>
			</div>
			<p>${ project.purpose }</p>
		</div>
	</c:forEach>
	</form>
</article>

<script>
function submitForm(project) {
    const form = document.getElementById('projectForm');
    const input = document.createElement('input');
    
    input.type = 'hidden';
    input.name = 'project';
    input.value = project;
    form.appendChild(input);
    form.submit();
}
</script>