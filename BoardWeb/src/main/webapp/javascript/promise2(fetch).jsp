<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>promise2.jsp</title>
</head>
<body>

	<script>
	
	/* promise.jsp참고 
	  : promise객체 사용하지 않으면 비동기방식은 
	    기다리지 않고 아래 실행해서 처리실패될거임(근데 promise객체 사용하여 순차적으로 실행되도록만듦)
		then then - 계속 순차실행 가능
		
		즉, 비동기로 처리되는 결과를 동기처럼 반환
	    
	  promise함수 더 간단하게 사용하기 위해서
	   
	  fetch() 사용 => 반환 promise 값
	  
	  
	   */
		
	   
	   
	   //fetch() -- 매개값('url', {option객체})
		fetch('8.data.json', {
			method: 'post',
			mode: 'cors',
			headers: { //post방식일 때 필요
				'Content-Type': 'application/x-www-form-urlencoded' //x-www- ... : key value형식으로 보냄
			},
			body: 'x=120&y=200'
		})
		.then(result => {
			console.log(result);
			return result.json(); //받아온 결과json문자열 => javascript의 객체로 변환시켜주는
		})
		.then(json => {
			console.log(json);
		})
		.catch(error => {
			console.error(error);
		})
	
	</script>
</body>
</html>