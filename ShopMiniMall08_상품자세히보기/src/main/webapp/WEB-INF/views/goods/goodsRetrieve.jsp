<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script> 
<script>
   $(document).ready(function(){
	   
	   //up
	   $("#up").on("click", function(){
		  
		   var gAmount = Number.parseInt( $("#gAmount").val());
		   $("#gAmount").val(gAmount+1);
	   });
	   
	   //down ==> 최저값 1
	   $("#down").on("click", function(){
		   var gAmount = Number.parseInt( $("#gAmount").val());
		   if(gAmount == 1){
			   $("#gAmount").val(1);
		   }else{
			   $("#gAmount").val(gAmount-1);
		   }
		   
	   });
	   
	   //장바구니 버튼 이벤트 처리
	   $("#cartBtn").on("click", function(){
		   // 배열로 반환
		   var f = $("#myForm")[0];
		   console.log(f);
		   // form태그의 action 수정
		   f.action="CartAddServlet";
		   f.method="get";
	   });

	   //구매 버튼 이벤트 처리

   });
</script>
	   
<!--  JSTL 구현 -->    
<form id="myForm" name="goodRetrieveForm" method="GET" action="#">
	    <input type="hidden" name="gImage" value="${goodsRetrieve.gImage}"> 
	    <input type="hidden" name="gCode" value="${goodsRetrieve.gCode}"> 
	    <input type="hidden" name="gName" value="${goodsRetrieve.gName}"> 
	    <input type="hidden" name="gPrice" value="${goodsRetrieve.gPrice}">

	<table width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
		</tr>
		<tr>
			<td>
				<table align="center" width="710" cellspacing="0" cellpadding="0"
					border="0" style='margin-left: 30px'>
					<tr>
						<td class="td_default"><font size="5"><b>- 상품 정보 -</b></font>
							&nbsp;</td>
					</tr>
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
						<td rowspan="7"><img src="images/items/${goodsRetrieve.gImage}.gif"
							border="0" align="center" width="300" /></td>
						<td class="td_title">제품코드</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>
						   ${goodsRetrieve.gCode}
						</td>
					</tr>
					<tr>
						<td class="td_title">상품명</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>
						   ${goodsRetrieve.gName}
						</td>
					</tr>
					<tr>
						<td class="td_title">가격</td>

						<td class="td_red" colspan="2" style='padding-left: 30px'>
						    ${goodsRetrieve.gPrice}
						</td>
					</tr>
					<tr>
						<td class="td_title">배송비</td>
						<td colspan="2"><font color="#2e56a9" size="2"
							style='padding-left: 30px'><b> 무료배송</b> </font> <font size="2">(도서
								산간지역 별도 배송비 추가)</font></td>
					</tr>
					<tr>
						<td class="td_title" rowspan="2">상품옵션</td>
						<td colspan="2" style='padding-left: 30px'><select
							class="select_change" size="1" name="gSize" id="gSize">
								<option selected value="사이즈선택">사이즈선택</option>
								<option value="L">L</option>
								<option value="M">M</option>
								<option value="S">S</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2" style='padding-left: 30px'>
						   <select
							class="select_change" size="1" name="gColor"
							id="gColor">
								<option selected value="색상선택">색상선택</option>
								<option value="navy">navy</option>
								<option value="black">black</option>
								<option value="ivory">ivory</option>
								<option value="white">white</option>
								<option value="gray">gray</option>
						</select></td>
					</tr>

					<tr>
						<td class="td_title">주문수량</td>
						<td style="padding-left: 30px">
						<input type="text" name="gAmount" value="1" id="gAmount"
							style="text-align: right; height: 18px">
					    <img src="images/up.PNG"  id="up"> 
					    <img src="images/down.PNG" id="down"></td>
					</tr>
				</table>

			</td>
		</tr>
	</table>

	<br> <button id="buyBtn">구매</button>
	&nbsp;&nbsp;
	<button id="cartBtn">장바구니</button>
</form>