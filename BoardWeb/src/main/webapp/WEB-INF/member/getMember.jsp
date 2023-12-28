<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>상세화면</h3>

<input type="hidden" name="id" value="${vo.id }">
<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>권한</th>
		</tr>
	</thead>
	<tbody>
	  	<tr>
	  		<td>${vo.id}</td>
	  		<td>${vo.pw }</td>
	  		<td>${vo.name }</td>
	  		<td>${vo.responsibility }</td>
	</tbody>

</table>
<a href="memberList.do">회원목록으로</a>
