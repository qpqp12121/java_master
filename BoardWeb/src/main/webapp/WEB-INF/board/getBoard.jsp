<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<h3>상세화면</h3>

	
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
		
		<p>댓글내용: <input type="text" id="content"><button id="addReply">등록</button>
		<p>댓글목록</p>
		
		<div id ="show">
			<ul id="list">
			
			</ul>
		</div>
		
		<a href="boardList.do">글목록으로</a>
		<script src = "js/service.js"></script>
		<script>
			function deleteFun(){
				console.log(window);
				document.forms.myForm.action = "removeForm.do";
				document.forms.myForm.submit();
			}
		
		const bno = '${vo.boardNo}';		
		let ul = document.querySelector('#list');
		//Ajax호출 (여기부터 js)	
		const xhtp = new XMLHttpRequest(); //비동기방식 가져오는 객체
		xhtp.open('get', 'replyListJson.do?bno=' + bno); // (요청방식,페이지) : 서버에 요청할 페이지 지정
		xhtp.send() //요청시작
		xhtp.onload = function(){ //이벤트실행
			let data = JSON.parse(xhtp.responseText); //json문자열->js의 객체로 변환하여 서버에 전달
			
			//< DOM으로 화면 >  
			//건수만큼 <li>만들기 --- service.js에 makeLi()로 함수 따로 생성
			data.forEach(reply => {
				let li = makeLi(reply); //--함수호출makeLi(reply = {})
				ul.appendChild(li);
			})
		}
		
		// < 등록버튼 이벤트생성 >
		//document.querySelector('#addReply').addEventListener('click', function(){});
		document.querySelector('#addReply').onclick = function(){
			let reply = document.querySelector('#content').value; //사용자입력input 값 
			let replyer = '${logId}' //로그인하면 아이디 값 가져오기

			const addAjax = new XMLHttpRequest();
			addAjax.open('get', 'addReplyJson.do?reply='+reply+'&replyer='+replyer+'&bno='+bno);
			addAjax.send();
			addAjax.onload = function(){
				
				let result = JSON.parse(addAjax.responseText);
				if(result.retCode == 'OK'){
					let reply = result.vo;
					let li = makeLi(reply);
					ul.appendChild(li);//
					
					document.querySelector('#content').value = '';
				}else if(result.retCode == 'NG'){
					alert('처리중 에러')
				}
			}
			}
			
		</script>
		