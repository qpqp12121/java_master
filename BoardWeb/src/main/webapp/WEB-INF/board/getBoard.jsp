<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../layout/menu.jsp"></jsp:include>
<jsp:include page="../layout/nav.jsp"></jsp:include>

	<h3>상세화면</h3>

	<% //GetBoardControl에 vo로 setAttribute값 담았으니 vo에 있는 값을 읽어오겠다
	BoardVO vo = (BoardVO) request.getAttribute("vo"); 
	%>
	
	<form name ="myForm" action="modifyForm.do">
	<input type="hidden" name="bno" value="${vo.boardNo }"> <!-- 화면엔 안보여줘도 되니 hidden (파라미터값 받아야되니 input사용) -->
	<table class="table">
		<tbody>
			<tr>
				<td>글번호</td>
				<td colspan="3">${vo.boardNo }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${vo.title }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">${vo.content }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td colspan="3">${vo.writer }</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
				<td>조회수</td>
				<td>${vo.clickCnt }</td>
			</tr>
			<tr>
				<td>이미지</td>
				<td colspan="3">
					<c:if test="${!empty vo.image}">
					<img width="150px" src="images/${vo.image}">
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<c:choose>
						<c:when test="${logName eq vo.writer }"> <!-- logName이랑 작성자 확인해서 다르면 비활성화시키도록 -->
							<input type="submit" value="수정">
							<input type="button" onclick="deleteFun()" value="삭제"></td>
						</c:when>
						<c:otherwise>
							<input type="submit" disabled value="수정">
							<input type="button" disabled onclick="deleteFun()" value="삭제"></td>
						</c:otherwise>	
						</c:choose>
			</tr>
		</tbody>
	</table>
	</form>
		<br>
		<a href="boardList.do">글목록으로</a>
		<script>
			function deleteFun(){
				console.log(window);
				document.forms.myForm.action = "removeForm.do";
				document.forms.myForm.submit();
			}
		</script>
		
<jsp:include page="../layout/foot.jsp"></jsp:include>