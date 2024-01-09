<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webapp/javascript/promise.jsp</title>
</head>
<body>

	<div id="show"></div>

	<script>
		let show = document.getElementById('show');
		let cnt = 0;
		let interval = setInterval(() => { //1초마다 실행
			const today = new Date();
			let hh = today.getHours();
			let mm = today.getMinutes();
			let ss = today.getSeconds();
			cnt++;
			
			if(cnt >= 20){
				clearInterval(interval);
			}

			show.innerHTML = hh + "시" + mm + "분" + ss + "초<br>";
		}, 1000); 

		//promise 3가지 상태) pendig(초기화) - fulfilled(정상처리완료) / rejected(비정상처리)
		const promise = new Promise(function(resolve, reject){ //매개값2개(성공했을때, 실패했을때) 실행할 함수 //(서버에데이터요청하고호출하는데사용)		
			setTimeout(function(){
				resolve('Success');
				//reject('Fail');
			}, 3000); //promise객체 사용하지 않으면 비동기방식은 3초 기다리지 않고 아래 실행해서 처리실패될거임(근데 promise객체 사용하여 순차적으로 실행되도록만듦)
		}); 

		promise.then(function(result){ //정상처리시 실행될 코드
			console.log('then=> ', result);	
			return 'ok';
		}).then(function(result){
			console.log('second then=> ', result);
		})
		.catch(function(err){
			console.error('error=> ', err);
		});
		
		//promise함수 더 간단하게 사용하기 위해서
		//자바스크립트에서 fetch() 사용 => 반환 promise 값
			
	</script>
</body>
</html>