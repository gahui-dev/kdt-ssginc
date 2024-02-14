<%@page import="com.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				border="0">

				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td height="1" colspan="8" bgcolor="CECECE"></td>
				</tr>
				<tr>
					<td height="10"></td>
				</tr>

				<tr>

					<!--  for 시작 -->
					<!-- JSTL로 변경하기 -->
					<c:forEach var="dto" items="${goodsList}" varStatus="status">
						<td>
							<table style='padding: 15px'>
								<tr>
									<td><a href="goodsRetrieve?gCode=${dto.gCode}"> <img
											src="images/items/${dto.gImage}.gif" border="0"
											align="center" width="200">
									</a></td>
								</tr>
								<tr>

									<td height="10">
								</tr>
								<tr>
									<td class="td_default" align="center"><a class="a_black"
										href="goodsRetrieve?gCode=${dto.gCode}"> ${dto.gName}<br>
									</a> <font color="gray"> -------------------- </font></td>

								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_gray" align="center">${dto.gContent}</td>
								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_red" align="center"><font color="red"><strong>
												${dto.gPrice} </strong></font></td>
								</tr>
							</table>
						</td>
						<!-- if 시작 -->
						<c:if test="${status.count%4==0}">
							<tr>
								<td height="10">
							</tr>
						</c:if>
						<!-- if 끝 -->

					</c:forEach>
					<!--  for 끝 -->
			</table>
		</td>
	</tr>
	<tr>
		<td height="10">
	</tr>
</table>