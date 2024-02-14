<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	<h1 class="logo"><a href="${pageContext.request.contextPath}/index">ProjMingle</a></h1>
	<div>
		<p><span id="name">${ sessionScope.name }</span>님, 환영합니다 :)</p>
		<nav>
			<ul>
				<li><a href="./index">나의 프로젝트 </a></li>
				<li><a href="./checkList">체크리스트 </a></li>
			</ul>
			<button class="primary" onclick="logout()">로그아웃</button>
		</nav>
	</div>
</header>

<script>
function logout() {
	const checkLogout = confirm("로그아웃 하시겠습니까?");
	if(checkLogout) {
		location.href="./signIn";
	} else {
		return;
	}
}
</script>