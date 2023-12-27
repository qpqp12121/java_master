<%@page import="com.yedam.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- writeDate형식 바꿀 거 -->

<%-- <%@include file="../layout/menu.jsp"%>
<%@include file="../layout/nav.jsp"%> --%>
<%-- 	<%
	 List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList"); //내장객체 형변환해줘야됨
	%> 이 부분들 아래에 jstl 사용해서 만듦--%> 
	
<%-- <jsp:include page="../layout/menu.jsp"></jsp:include> <!-- 내장되어있는 액션태그358p참고 -->
<jsp:include page="../layout/nav.jsp"></jsp:include> <!-- 위에 자바코드로 한 거랑 기능 같음 --> --%>

	<h3>게시판</h3>
	<!-- EL(Expression Language) : 간단한 연산식 사용가능 & attribute값 읽어올 수 O -->

	<table class="table">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일시</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
		 <c:forEach var="vo" items="${boardList }"> <!-- BoardListControl의 boardList attribute값을 읽어오겠다 -->
			<tr>
				<td>${vo.boardNo }</td>
				<td><a href="getBoard.do?bno=${vo.boardNo }">${vo.title }</a></td>
				<td>${vo.writer }</td>
				<td><fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
				<td>${vo.clickCnt }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

<%-- <jsp:include page="../layout/nav.jsp"></jsp:include> --%>