<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="com.jsp.dto.TestMethod" %>
<%@ page import="com.jsp.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마당 서점</title>
<style>
	* {margin: 0; padding: 0; box-sizing: border-box;}
	body {min-height: 100vh; }
	header { width: 100%; background-color: #F4CE14; display: flex; align-items: center; justify-content: space-between; padding: 20px 100px;} 
	header h1 {font-size: 1.2rem; }
	header ul {display: flex; align-items: center; justify-content: center; gap: 20px;}
	header ul li { list-style: none;}
	header ul li a {text-decoration: none; color: #000;}
	main {margin: 20px auto; width: calc(100% - 200px);}
	main h3 {margin: 20px 0;}
	main ul li {margin-left: 20px;}
	table {border-collapse: collapse; width: 100%; }
   	table tr td:first-child {width: 25%;}
  	table tr td {border: 1px solid #000; padding: 4px 10px;}
</style>
</head>
<body>
	<header>
		<h1><%= session.getAttribute("username") %> 님, 안녕하세요</h1>
		<nav>
			<ul>
				<li><a href="main?p=main">홈</a></li>
				<li><a href="main?p=book">도서 정보</a></li>
				<li><a href="main?p=member">회원 정보</a></li>
		<!-- 		<li><a href="main?p=logout">로그아웃</a></li> -->
			</ul>
		</nav>
		
	</header>
	<p>${sessionScope.SESS_MSG}</p>
	<main>	   
		<form action ="${pageContext.servletContext.contextPath}/login" >
		<input type="hidden" name="_method" value="log_out">
		<button type="button">로그아웃</button>
	</form>
	
	   <h3>Scope</h3>
       <ul>
          <li>page : 한번의 요청, 하나의 jsp 응답</li>
          <li>request : 하나의 요청에 대해 응답까지 </li>
          <li>session 범위 : 브라우저 </li>
          <li>context application : 브라우저가 달라도 같은 값 나옴, 애플리케이션 종료(서버 끌 때)될 때 까지?</li>
          <li>*접근 : application > session > request > page</li>
       </ul> 
	   
	   <%--<% 주석 %> --%>
	   
	   <%-- <h3>el Tag</h3>
	   <table>
	      <tr>
	         <td>total</td>
	         <td><%=request.getAttribute("total") %></td>
	      </tr>
	      <tr>
	         <td>requestScope.total</td>
	         <td>${"total"}</td>
	      </tr>
	      <tr>
	         <td>requestScope['total']</td>
	         <td>${requestScope.total}</td>
	      </tr>
	      <tr>
	         <td>requestScope['total']</td>
	         <td>${requestScope['total']}</td>
	      </tr>
	      <tr>
	         <td>requestScope["total"]</td>
	         <td>${requestScope["total"]}</td>
	      </tr>
	      <tr>
	         <td>applicationScope.total = 10</td>
	         <td>${applicationScope.total = 10}</td>
	      </tr>
	      <tr>
	         <td>session 값 가져오기</td>
	         <td>${sessionScope.comment}</td>
	      </tr>
	      <tr>
	         <td>pageScope.name</td>
	         <td>${pageScope.name}</td>
	      </tr>
	      <tr>
	         <td>1+1</td>
	         <td>${1+1}</td>
	      </tr>
	      <tr>
	         <td>pageScope.num1 + 10</td>
	         <td>${pageScope.num1 + 10}</td>
	      </tr>
	      <tr>
	         <td>Integer.toString(10) + "20"</td>
	         <td>${Integer.toString(10) + "20"}</td>
	      </tr>
	      <tr>
	         <td>pageScope['num1']} == 1</td>
	         <td>${pageScope['num1'] == 1}</td>
	      </tr>
	      <tr>
	         <td>pageScope['num1']} > 1</td>
	         <td>${pageScope['num1'] > 1}</td>
	      </tr>
	      <tr>
	         <td>10 eq 10</td>
	         <td>${10 eq 10}</td>
	      </tr>
	      <tr>
	         <td>empty null</td>
	         <td>${ empty null }</td>
	      </tr>
	   </table> --%>
	      
	   
	   
	   <h3>c:if</h3>
	   
	   <c:if test="${true}">
	      <p>여기1</p>
	   </c:if>
	   
	   <c:if test="<%= true %>">
	      <p>여기2</p>
	   </c:if>
	   
	   <h3>http://localhost:9090/jsp-project/main?query1=1200&query2=800&query3=400</h3>
	   <table>
	      <tr>
	         <td>key</td>
	         <td>value</td>
	      </tr>
	      <tr>
	         <td>requestScope</td>
	         <td>${requestScope}</td>
	      </tr>
	      <tr>
	         <td>pageScope</td>
	         <td>${pageScope}</td>
	      </tr>
	      <tr>
	         <td>requestScope</td>
	         <td>${requestScope}</td>
	      </tr>
	      <tr>
	         <td>param</td>
	         <td>${param}</td>
	      </tr>
	      <tr>
	         <td>param.query1</td>
	         <td>${param.query1}</td>
	      </tr>
	      <tr>
	         <td>param.query2</td>
	         <td>${param.query2}</td>
	      </tr>
	      <tr>
	         <td>param.query3</td>
	         <td>${param.query3}</td>
	      </tr>
	      <tr>
	         <td>paramValues</td>
	         <td>${paramValues}</td>
	      </tr>
	      <tr>
	         <td>paramValues.list[0]</td>
	         <td>${paramValues.query1}</td>
	      </tr>
	      <tr>
	         <td>paramValues.list[1]</td>
	         <td>${paramValues.query2}</td>
	      </tr>
	      <tr>
	         <td>paramValues.list[2]</td>
	         <td>${paramValues.query3}</td>
	      </tr>
	      <tr>
	         <td>sessionScope.amount = 1000</td>
	         <td>${ sessionScope.amount = 1000 }</td>
	      </tr>
	   </table>
	   
	   <% int amount = 500; %>
	   
	   <h3>scope</h3>
	   <table>
	      <tr>
	         <td>applicationScope.amount = 4000</td>
	         <td>${ applicationScope.amount = 4000 }</td>
	      </tr>
	      <tr>
	         <td>sessionScope.amount = 3000</td>
	         <td>${ sessionScope.amount = 3000 }</td>
	      </tr>
	      <tr>
	         <td>requestScope.amount = 2000</td>
	         <td>${ requestScope.amount = 2000 }</td>
	      </tr>
	      <tr>
	         <td>pageScope.amount = 1000</td>
	         <td>${ pageScope.amount = 1000 }</td>
	      </tr>
	      <tr>
	         <td>amount</td>
	         <td>${ amount }</td>
	      </tr>
	      <tr>
	         <td>접근</td>
	         <td>pageScope -> requestScope -> sessionScope -> applicationScope</td>
	      </tr>
	   </table>
	   
	   <% request.removeAttribute("total"); %>
	   
	   <h3>c:choose</h3>
	   <p>\${ pageScope.num = 10 } : ${ pageScope.num = 10 }</p>
	   <c:choose>
	      <c:when test="${pageScope.num == 10}">1. \${pageScope.num == 10} 실행</c:when>
	      <c:when test="${pageScope.num == 20}">2. \${pageScope.num == 20} 실행</c:when>
	      <c:when test="${pageScope.num == 30}">3. \${pageScope.num == 30} 실행</c:when>
	      <c:when test="${pageScope.num == 40}">4. \${pageScope.num == 40} 실행</c:when>
	      <c:otherwise>
	         기타 실행
	      </c:otherwise>
	   </c:choose>
	   
	   <h3>c:forEach</h3>
	   <table>
	      <tr>
	         <td>pageScope.status</td>
	         <td>status.begin</td>
	         <td>status.count</td>
	         <td>status.end</td>
	         <td>status.index</td>
	         <td>status.first</td>
	         <td>status.last</td>
	      </tr>
	   <c:forEach begin="${amount}" end="${amount+10}" varStatus="status" step="2">
	      <tr>
	         <td>${ pageScope.status }</td>
	         <td>${ status.count }</td>
	         <td>${ status.begin }</td>
	         <td>${ status.end }</td>
	         <td>${ status.index }</td>
	         <td>${ status.first }</td>
	         <td>${ status.last }</td>
	      </tr>
	   </c:forEach>
	   </table>
	   
	   <h3>c:forEach - ArrayList</h3>
	   <p>pageScope ${ pageScope.number = 6 } 번 반복 </p>
	   
	   <% 
	      long num1 = Long.valueOf(10);
	      num1 = Long.valueOf(10);
	      int num2 = (int)num1;
	      
	      // int num2 = Integer.parseInt(Long.toString(num1));
	      // System.out.println("num2 = " + num2);
	      
	      // int endNum = num2;
	      
	      // pageContext.getAttribute("number") -> Long 타입
	      //int endNum = (Integer)(pageContext.getAttribute("number"));
	      int endNum = Integer.parseInt((pageContext.getAttribute("number")).toString());
	      
	      // int endNum = 5;
	      List<String> arrayList = new ArrayList<>();
	      
	      for(int i = 0; i < endNum; i++) {
	         arrayList.add("hello - " + i);
	      }
	      
	      pageContext.setAttribute("arrayList", arrayList);
	   %>
	   
	   <ul>
	   <c:forEach var="item" items="${ arrayList }">
	      <li>${item}</li>
	   </c:forEach>
	   </ul>
	   
	   <h3>c:set</h3>
	   <p>생성</p>
	   <c:set var="user" value="<%= new com.jsp.dto.UserDTO() %>" scope="page" />
	   <p> \${ pageScope } : ${ pageScope } </p>
	   <p> user.name ? : <c:out value="${user.name}"> </c:out> </p>
	   
	   <p>생성되어 있는 곳에 값 넣기</p>
	   <c:set target="${ pageScope.user }"  property="name" value="이가희 " />
	   <p> user.name ? : <c:out value="${user.name}"> </c:out></p>
	   
	   <p>TestMehod 활용해서 값 넣어보기</p>
	   <c:set var="user1" value="<%= new com.jsp.dto.TestMethod() %>" scope="page" />
	   
	   <% 
	   	TestMethod.setValue1((UserDTO)pageContext.getAttribute("user1"), "이가희2 ");
	   %>
	   <p>user1.name ? : <c:out value="${user1.name}"> </c:out></p>
	   
	   <%
	   	UserDTO user2 = new UserDTO();
	   	user2.setName("이가희3");
	   %>
	   <c:set var="user2" value="<%=user2 %>" />
	   <p>user2.name ? : <c:out value="${user2.name}"> </c:out></p>
	   
	   <p>pageScope total 1</p>
	   <c:set var="total1" value="1111" scope="page" />
	   <c:out value="total1" ></c:out>
	   <p>${ pageScope.total1 }</p>
	   
	   <p>pageScope total 2</p>
	   <c:set var="total2" value="2222" scope="request" />
	   <p>${ requestScope.total2 }</p>
	   <p><c:out value="total2"></c:out></p>
	   
	   <p>pageScope total 3</p>
	   <c:set var="total3" value="3333" scope="session" />
	   <p>${ sessionScope.total3 }</p>
	   <p><c:out value="total3"></c:out></p> 
	   
	</main>
</body>
</html>