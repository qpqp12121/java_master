/**
 * service.js
 */
function makeLi(reply = {}){
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
				btn.addEventListener('click', function(){
					//1.해당되는 댓글번호 DB에서 삭제 -> 2.화면에서도 제거 (DB삭제는 Ajax호출)
					//  (DB)
					let delHtp = new XMLHttpRequest(); //Ajax비동기방식 가져오는 객체
					delHtp.open('get', 'delReplyJson.do?rno=' + reply.replyNo) //'댓글삭제컨트롤만들기-front등록하고등등하고 url,param넣기)/reply.replyNo:댓글번호 
					delHtp.send()
					delHtp.onload = function(){
						let result = JSON.parse(delHtp.responseText)
						if(result.retCode == 'OK'){
							alert('삭제되었습니다')
							btn.parentElement.remove(); //2.화면에서 li지우기
							
						}else if(result.retCode =='NG'){
							alert('처리 중 에러.');
						}
					}
				})
				li.appendChild(btn); //*end
				
				return li;
}