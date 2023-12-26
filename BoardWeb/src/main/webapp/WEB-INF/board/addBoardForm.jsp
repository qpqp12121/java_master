<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/menu.jsp"%>
<%@include file="../layout/nav.jsp"%>

	<h3>등록화면</h3>
	<form action="addBoard.do">
		<table class="table"> <!-- <table border="1"> -->
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols="30" rows="10"></textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="<%=logName %>"></td> <!--include file로 menu.jsp있으니(거기에서 자바코드로 session객체에 저장한 logName값 가져와서 변수에 저장했으니 여기선 안 했음-->
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="저장">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
<%@include file="../layout/foot.jsp"%>