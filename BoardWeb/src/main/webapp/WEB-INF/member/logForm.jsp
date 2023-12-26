<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/menu.jsp"%>
<%@include file="../layout/nav.jsp"%>

 <%
 	String msg = (String)request.getAttribute("message");
 %>
 
 <% if(msg != null){ %> <!-- 이 조건 안 주면 처음에 로그인화면 누르자마자 위에 null이라고 값이 뜸 -->
 <p><%=msg %></p>
 <%} %>

<form action="login.do"> <!-- 지금은 로그인화면이고 - 로그인처리(기능)으로 넘어가게//아이디 비번 맞으면 -->
<table class="table">
	<tbody>
		<tr>
			<th colspan="2">로그인</th>
		</tr>
	<tr>
	<th>아이디</th><td><input type="text" name="id"></td>
	</tr>
	<tr>
	<th>비밀번호</th><td><input type="password" name="pw"></td>
	</tr>
	<tr>
	<td colspan="2" align="center">
	<input type="submit" value="로그인" class="btn btn-primary">
	<input type="reset" value="초기화"class="btn btn-warning">
	</td>
	</tbody>

</table>
</form>

<%@include file="../layout/foot.jsp"%>