/**
 * service.js
 */
function makeLi(reply = {}) {
	//*start
	let li = document.createElement('li');
	let span = document.createElement('span');
	span.innerText = '글번호: ' + reply.replyNo;
	li.appendChild(span);
	span = document.createElement('span');
	span.innerText = ' | ' + reply.reply;
	li.appendChild(span);
	span = document.createElement('span');
	span.innerText = ' | ' + reply.name;
	li.appendChild(span);

	//삭제버튼
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	btn.addEventListener('click', async function() {

		//1.해당되는 댓글번호 DB에서 삭제 -> 2.화면에서도 제거 (DB삭제는 Ajax호출)
		//< fetch()로 작성 > 비동기로 처리되는 결과를 동기처럼 반환
		const promise = await fetch('delReplyJson.do?rno=' + reply.replyNo) //get방식
		const json = await promise.json();
		try {
			if (json.retCode == 'OK') {
				alert('삭제되었습니다')
				showList(pageInfo);
			} else if (result.retCode == 'NG') {
				alert('처리 중 에러.');
			}
		} catch (err) {
			console.error('예외=> ',err);
		}

	//< Ajax비동기방식 사용 >
	/*let delHtp = new XMLHttpRequest(); //Ajax비동기방식 가져오는 객체
	delHtp.open('get', 'delReplyJson.do?rno=' + reply.replyNo) //'댓글삭제컨트롤만들기-front등록하고등등하고 url,param넣기)/reply.replyNo:댓글번호 
	delHtp.send()
	delHtp.onload = function(){
		let result = JSON.parse(delHtp.responseText)
		if(result.retCode == 'OK'){
			alert('삭제되었습니다')
		//2.화면에서 li지우기
			//btn.parentElement.remove(); --이렇게 하면 버튼만 삭제되어
			//bno, page => 페이지리스트, 페이징리스트 (getBoard에서 옮겨서 거기선 콜백함수로 사용하도록)
			showList(pageInfo); //getBoard에 있음
	
		}else if(result.retCode =='NG'){
			alert('처리 중 에러.');
		}
	}//end of onload. */
})
li.appendChild(btn); //*end of event.

return li;
	}