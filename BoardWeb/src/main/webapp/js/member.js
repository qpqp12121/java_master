/**
 * member.js 
 */

console.log('이거')

$(document).ready(function() {

	//회원목록 출력
	$.ajax('memberListJson.do', {
		method: 'get',
		//data: {bno: 1, rno:2}, //'bno=1&rno=2' 목록보기만 하는 거라 데이터 없엇ㅇ므

		dataType: 'json', //서버의 데이터 포맷 지정

		success: function(result) { //JSON.parse(result)하는 것을 위에서 포맷지정해서X
			console.log(result); // [{키:값, 키:값, ... }, {키:값, 키:값...} ...]
			//결과값으로 테이블 만듦(배열이라 반복문 돌리고 아래에선 등록하면 객체1개니까 그냥 result.vo)
			$(result).each((idx, member) => {
				//tr/td생성

				let img = ''; //이미지액박X
				if (member.image) {
					img = $('<img />').attr({ 'src': 'images/' + member.image, 'style': 'width:80px' });
				}

				let tr = $('<tr />').append($('<td />').text(member.id),
					$('<td />').text(member.name),
					$('<td />').text(member.responsibility), //속성여러개 {}객체로 만들어서 , 로 연결
					$('<td />').html(img)
				);
				$('#list').append(tr);
			});
		},

		error: function(err) {
			console.log(err);
		}

	})


	/*$('input[type="file"]').on('change', function(e){
		console.log(e.target.files[0])
	})*/



	//회원등록
	$('#addBtn').on('click', function() {
		let formData = new FormData(); //multipart요청할 때(=file요청) --  multipart/form-data :  

		formData.append('id', $('input[name="id"]').val());
		formData.append('pw', $('input[name="pw"]').val());
		formData.append('name', $('input[name="name"]').val());
		formData.append('image', $('input[name="image"]')[0].files[0]); //formData (key/value형식으로 넘김


		//entries().확인용-form데이터 키값 보려고 적은 거
		for (let ent of formData.entries()) {
			console.log(ent);
		}


		$.ajax('memberAddJson.do', {
			method: 'post',
			data: formData,
			processData: false, //file등록할 땐 processData & contentType 둘 다 false로 보내야 됨
			contentType: false,
			dataType: 'json', //가져온 데이터 json이면 parsing해서 보내줌

			success: function(result) {

				//등록버튼 누르면 화면에 나오게 (result값 확인해보기!1)
				console.log(result); //retCode: "OK", vo:{키:값, 키:값,...} 출력 (성공시)
				let member = result.vo;
				//이미지액박X
				let img = '';
				if (member.image) {
					img = $('<img />').attr({ 'src': 'images/' + member.image, 'style': 'width:80px' });
				}
				//tr,td만들기
				let tr = $('<tr />').append($('<td />').text(member.id),
					$('<td />').text(member.name),
					$('<td />').text(member.responsibility), //속성여러개 {}객체로 만들어서 , 로 연결
					$('<td />').html(img)
				);
				$('#list').append(tr);
			},
			error: function() {
				console.error(err);
			}
		})
	})
});//end of ready().
