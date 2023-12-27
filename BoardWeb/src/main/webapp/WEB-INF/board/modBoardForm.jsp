<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="../layout/menu.jsp"></jsp:include>
<jsp:include page="../layout/nav.jsp"></jsp:include>

	<h3>수정화면</h3>

	<form action="modifyBoard.do"> <!-- modifyBoard를 호출할 때 bno, content 파라미터 -->
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
					<td colspan="3">
					<textarea cols="30" rows="4" name="content">${vo.content }</textarea>
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="3">${vo.writer }</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><fmt:formatDate value="${vo.writeDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
					<td>조회수</td>
					<td>${vo.clickCnt }</td>
				</tr>
				<tr>
					<td>이미지</td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<input type="submit" value="저장">
						<input type="button" value="취소">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<br>
	<a href="boardList.do">글목록으로</a>

<jsp:include page="../layout/foot.jsp"></jsp:include>