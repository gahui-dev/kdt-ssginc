<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
	<c:set var="pageAmount" value="&amount=${ pageMaker.criteriaAmount }" />
	<c:set var="displayPageAmount" value="&displayPageAmount=${ pageMaker.displayPageAmount }" />
	<%-- <select name="displayPageAmount" onchange="this.form.submit();">
		<option value="5" <c:if test="${ pageMaker.displayPageAmount == 5 }">selected</c:if>>5개씩 보기</option>
		<option value="10" <c:if test="${ pageMaker.displayPageAmount == 10 }">selected</c:if>>10개씩 보기</option>
		<option value="15" <c:if test="${ pageMaker.displayPageAmount == 15 }">selected</c:if>>15개씩 보기</option>
	</select> --%>
	<div>
		<label>
			<input type="radio" name="displayPageAmount" value="5" onClick="this.form.submit();" <c:if test="${ pageMaker.displayPageAmount == 5 }">checked</c:if>>
			5개씩 보기
		</label>
		<label>
			<input type="radio" name="displayPageAmount" value="10" onClick="this.form.submit();" <c:if test="${ pageMaker.displayPageAmount == 10 }">checked</c:if>>
			10개씩 보기
		</label>
		<label>
			<input type="radio" name="displayPageAmount" value="15" onClick="this.form.submit();" <c:if test="${ pageMaker.displayPageAmount == 15 }">checked</c:if>>
			15개씩 보기 
		</label>
	</div>
	<div class="pagination">
		<ul>
		<c:if test="${ pageMaker.prev }">
			<li><a href="${ pageContext.servletContext.contextPath }/test?pageNo=${ pageMaker.startPage - 1}${ pageAmount }${displayPageAmount}s">prev</a></li>
		</c:if>
		
		<c:forEach begin="${ pageMaker.startPage }" end="${ pageMaker.endPage }" varStatus="status">
		<c:choose>
			<c:when test="${ pageMaker.criteriaPageNum == status.index }">
				<li><a href="${ pageContext.servletContext.contextPath }/test?pageNo=${ status.index}${ pageAmount }${displayPageAmount}" class="on">${ status.index }</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${ pageContext.servletContext.contextPath }/test?pageNo=${ status.index}${ pageAmount }${displayPageAmount}">${ status.index }</a></li>
			</c:otherwise>
		</c:choose>
		</c:forEach>
		
		<c:if test="${ pageMaker.next }">
			<li><a href="${ pageContext.servletContext.contextPath }/test?pageNo=${ pageMaker.endPage + 1}${ pageAmount }${displayPageAmount}">next</a></li>
		</c:if>
		</ul>
	</div>
</body>
</html>