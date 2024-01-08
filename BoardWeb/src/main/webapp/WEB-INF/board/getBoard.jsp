<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style>
.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>


<h3>상세화면</h3>


<form name="myForm" action="modifyForm.do">
	<input type="hidden" name="bno" value="${vo.boardNo }">
	<!-- 화면엔 안보여줘도 되니 hidden (파라미터값 받아야되니 input사용) -->
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
				<td><fmt:formatDate value="${vo.writeDate }"
						pattern="yyyy-MM-dd"></fmt:formatDate></td>
				<td>조회수</td>
				<td>${vo.clickCnt }</td>
			</tr>
			<tr>
				<td>이미지</td>
				<td colspan="3"><c:if test="${!empty vo.image}">
						<img width="150px" src="images/${vo.image}">
					</c:if></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><c:choose>
						<c:when test="${logName eq vo.writer }">
							<!-- logName이랑 작성자 확인해서 다르면 비활성화시키도록 -->
							<input type="submit" value="수정">
							<input type="button" onclick="deleteFun()" value="삭제"></td>
				</c:when>
				<c:otherwise>
					<input type="submit" disabled value="수정">
					<input type="button" disabled onclick="deleteFun()" value="삭제">
					</td>
				</c:otherwise>
				</c:choose>
			</tr>
		</tbody>
	</table>
</form>
<br>

<p>
	댓글내용: <input type="text" id="content">
	<button id="addReply">등록</button>
<p>댓글목록</p>

<div id="show">
	<ul id="list">

	</ul>
</div>

<!-- 페이징처리. -->
<div id="paging" class="pagination"></div>

<script src="js/service.js"></script>

<a href="boardList.do">글목록으로</a>
<script src="js/service.js"></script>

<script>
			function deleteFun(){
				console.log(window);
				document.forms.myForm.action = "removeForm.do";
				document.forms.myForm.submit();
			}
		
		const bno = '${vo.boardNo}';		
		let ul = document.querySelector('#list');
		
		
	//< 2.페이지이벤트등록 > --아래<페이지생성>의 aTag에 클릭이벤트등록(콜백함수로) -> 이 함수호출  
	//페이지 클릭하면 => 데이터를 보여주는
	
	let pageInfo = 1; //밖에서 선언한 이유? 댓글삭제했을 시 댓글목록화면 다시 그려주기 위해서	
	function pageList(e){
		e.preventDefault(); //a태그 기본기능:클릭하면 페이지자체가 이동되어버리니 기본기능 막기
		pageInfo = this.getAttribute("href");
		//console.log(pageInfo); //<a>태그 클릭할 때마다 href속성 담아서 축ㄹ력
		
		//페이지목록 보여주는 함수 호출
		showList(pageInfo); //댓글삭제했을 시 댓글목록화면 다시 그려주기 위해서(아래기능 같아서)	
		
		//페이지를 생성하는 함수 호출
		pagingList(pageInfo);
	}
		
		
	//< Ajax호출 >
	function showList(page){
		ul.innerHTML = '';
		const xhtp = new XMLHttpRequest(); //비동기방식 가져오는 객체
		xhtp.open('get', 'replyListJson.do?bno=' + bno + "&page=" + page); // (요청방식,페이지) : 서버에 요청할 페이지 지정
		xhtp.send() //요청시작
		xhtp.onload = function(){ //이벤트실행
			let data = JSON.parse(xhtp.responseText); //json문자열->js의 객체로 변환하여 서버에 전달
	
			//< DOM으로 화면 >: 건수만큼 <li>만들기 --- service.js에 makeLi()로 함수 따로 생성
			data.forEach(reply => {
				let li = makeLi(reply); //--함수호출makeLi(reply = {})
				ul.appendChild(li);
			})
		}
	}
	//페이지목록 보여주는 함수 호출
	showList(pageInfo);
	
	
	
	//< 1.페이지생성 > : 페이징 계산
	let paging = document.querySelector('#paging'); //위에 div확인
	pagingList();
	
	function pagingList(page=1) {
		//다음페이지를 기준으로 페이지 목록 생성
		paging.innerHTML = ''; //위에 div(#paging)에 기존에 있던 값 삭제
		
		let pagingAjax = new XMLHttpRequest();
		pagingAjax.open('get', 'pagingListJson.do?bno='+bno+"&page=" + page);
		pagingAjax.send();
		
		pagingAjax.onload = function(){
			let result = JSON.parse(pagingAjax.responseText); //Ajax자바스크립트 객체(PageDTO에 데이터적용되어 나옴)
			console.log(result);
			
			//"이전"페이지
			if(result.prev){
				let aTag = document.createElement('a');
				aTag.href = result.startPage - 1; //5페이지에 +1 => 6페이지부터 보이게
				aTag.innerText = '이전';
				aTag.addEventListener('click', pageList);
				paging.appendChild(aTag);
			}
			
			//페이지"목록" (5건씩)
			for(let p = result.startPage; p <= result.lastPage; p++){
				let aTag = document.createElement('a');
				
				if(p == page){
					aTag.setAttribute('class', 'active');
				}
				aTag.href = p; //href속성사용
				aTag.innerText = p;
				aTag.addEventListener('click', pageList);
				paging.appendChild(aTag);
			}
			
			//이후페이지(6~) --여기서 또 위 기능사용해야 돼서 위에 함수로 만듦
			if(result.next){
				let aTag = document.createElement('a');
				aTag.href = result.lastPage + 1; //5페이지에 +1 => 6페이지부터 보이게
				aTag.innerText = '다음';
				aTag.addEventListener('click', pageList);
				paging.appendChild(aTag);
			}
		}
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
				//let reply = result.vo;
				//let li = makeLi(reply);
				//ul.appendChild(li);//
				
				pageInfo=1;
				showList(pageInfo);
				pagingList();
				
				document.querySelector('#content').value = '';
			}else if(result.retCode == 'NG'){
				alert('처리중 에러')
			}
		}
		}
		
	</script>
