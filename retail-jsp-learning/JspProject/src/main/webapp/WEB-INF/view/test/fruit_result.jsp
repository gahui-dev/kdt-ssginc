<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.on { background-color: yellow; }
.off { background-color: transparent; }
.selected {background-color: green; }
</style>
<script>
window.onload = function() {
	const dataFruits = document.getElementsByName('data-fruit');
	
	for(var i = 0; i < dataFruits.length; i++) {
		dataFruits[i].onclick = function() {
			removeClass('data-fruit');
			this.parentElement.className = 'selected';
		}
	}
		
	/* const radios = document.querySelectorAll("input[name='data-fruit']");
	
	radios.forEach((radio) => {		
		radio.parentElement.classList.remove("selected");
		
		radio.addEventListener("change", (e) => {
			const target = e.currentTarget;

			
			if(target.checked) {
				// console.log(target.parentElement);
				// target.parentElement.style.backgroundColor = "red";
				target.parentElement.classList.add("selected");
				
			} 
		})
	}) */
}

function removeClass(name) {
	const dataFruits = document.getElementsByName(name);
	for(var i = 0; i < dataFruits.length; i++) {
		dataFruits[i].parentElement.className = 'off';
	}
}
</script>
</head>
<body>
	${ param['data-fruit'] }
	
	<h3>fruitResult</h3>
	
	<c:set var="checkedOn" value="class='on' checked"></c:set>
	<c:out value="${ checkedOn }" />
	
	<br>
	<form action="${pageContext.servletContext.contextPath}/fruit" method="get">
		<label <c:if test="${ param['data-fruit'] == -1 }">${checkedOn} </c:if>>
			 <input type="radio" name="data-fruit" value="-1" <c:if test="${ param['data-fruit'] == -1 }">${ checkedOn}</c:if>/> : 선택을 안했어요
		</label>
		<label <c:if test="${ param['data-fruit'] == 0 }">${checkedOn} </c:if>>
			 <input type="radio" name="data-fruit" value="0" <c:if test="${ param['data-fruit'] == 0 }">${ checkedOn }</c:if>/> : 사과 
		</label>
		<label <c:if test="${ param['data-fruit'] == 1 }">${checkedOn} </c:if>>
			 <input type="radio" name="data-fruit" value="1" <c:if test="${ param['data-fruit'] == 1 }">${ checkedOn }</c:if>/> : 오렌지
		</label>
		<label <c:if test="${ param['data-fruit'] == 2 }">${checkedOn} </c:if>>
			 <input type="radio" name="data-fruit" value="2" <c:if test="${ param['data-fruit'] == 2 }">${ checkedOn }</c:if>/> : 포도 
		</label>
		<button type="submit">전송</button>
	</form>
	
	<!-- <a href="javascript:history.back();">돌아가기 </a> -->

</body>
</html>