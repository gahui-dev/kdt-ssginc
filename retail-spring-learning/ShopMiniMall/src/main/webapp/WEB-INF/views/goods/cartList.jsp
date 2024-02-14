<%@page import="com.dto.CartDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
   $(document).ready(
         function() {

            // 수정 버튼 이벤트
            $(".updateBtn").on(
                  "click",
                  function() {

                     var num = $(this).attr("data-num");
                     var gAmount = $("#gAmount" + num).text();
                     alert(num + "      " + gAmount);

                     /////////////////////////////////////////////////////////
                     $.ajax({
                        type : 'get',
                        url : "CartUpdateServlet",
                        dataType : "text", // json, xml,
                        data : {
                           num : num,
                           gAmount : gAmount
                        },
                        success : function(data, status, xhr) {
                           var price = $("#gPrice" + num).val();
                           var sum = Number.parseInt(gAmount)
                                 * Number.parseInt(price);

                           $("#sum" + num).text(sum);
                        },
                        error : function(xhr, status, error) {
                           console.log("Error:", error);
                        }
                     });
                     ///////////////////////////////////////////////////////

                  });//end updateBtn

            // 단일 삭제 버튼 이벤트
            $(".deleteBtn").on("click", function() {

            });

            // 전체 선택 이벤트
            $("#allCheck").on("click", function() {

               // allCheck의 체크 여부 확인
               var allCheck = this.checked;

               // check해야될 체크박스 얻기
               //var chk = $(".check");
               $(".check").each(function(idx, ele) {
                  this.checked = allCheck;
               });

            });

            // 전체 삭제 이벤트
            // form 태그 밖에 있는 버튼을  form태그안의 submit 버튼처럼 동작처리
            $("#deleteAll").on("click", function() {

               var f = $("form")[0];
               f.action = "CartDeleteAllServlet";
               f.method = "get";
               f.submit(); // submit 처리
            });

            // 주문 버튼 이벤트
            $(".orderBtn").on("click", function() {
               var num = $(this).attr("data-num");

               location.href = "OrderConfirmServlet?num=" + num;

            });

         });
</script>
<table width="90%" cellspacing="0" cellpadding="0" border="0">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>- 장바구니-</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center"><input type="checkbox"
			name="allCheck" id="allCheck"> <strong>전체선택</strong></td>
		<td class="td_default" align="center"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>



	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>


	>>>
	<form name="myForm">
		<c:forEach var="dto" items="${cartList}" varStatus="status">

			<tr>
				<td class="td_default" width="80">
					<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. --> <input
					type="checkbox" name="check" class="check" value="${dto.num}">
				</td>


				<td class="td_default" width="80">${dto.num}</td>
				<td class="td_default" width="80"><img
					src="images/items/${dto.gImage}.gif" border="0" align="center"
					width="80" /></td>
				<td class="td_default" width="300" style='padding-left: 30px'>${dto.gName}
					<br> <font size="2" color="#665b5f">[옵션 :
						사이즈(${dto.gSize}) , 색상(${dto.gColor})] </font>
				</td>
				<td class="td_default" align="center" width="110"><span
					id="gPrice${dto.num}">${dto.gPrice}</span></td>
				<td class="td_default" align="center" width="90"><input
					class="input_default" type="text" name="gAmount"
					id="gAmount${dto.num}" style="text-align: right" maxlength="3"
					size="2" value="${dto.gAmount}"></input></td>
				<td><input type="button" value="수정" class="updateBtn"
					data-num="${dto.num}" /></td>
				<td class="td_default" align="center" width="80"
					style='padding-left: 5px'><span id="sum${dto.num}"
					data-price="${dto.gPrice}"> ${dto.gAmount * dto.gPrice} </span></td>
				<td><input type="button" value="주문" class="orderBtn"
					data-num="${dto.num}"></td>
				<td class="td_default" align="center" width="30"
					style='padding-left: 10px'><input type="button" value="삭제"
					class="deleteBtn" data-num="${dto.num}"></td>
				<td height="10"></td>
			</tr>

		</c:forEach>
	</form>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5"><a class="a_black" href=""> 전체
				주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<button id="deleteAll">전체 삭제하기</button> &nbsp;&nbsp;&nbsp;&nbsp; <a
			class="a_black" href=""> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>