<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	document.addEventListener("DOMContentLoaded", function() {
	    const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'bookListJson.do');
		xhtp.send();
		xhtp.onload = function(){
			let data = JSON.parse(xhtp.responseText);
			console.log(data)
			
			
			data.forEach(info => {
					let tr = document.createElement('tr');
					let td = document.createElement('td');
					td.innerHTML = info;
					tr.appendChild(td);
			}) 
			document.querySelector('.tbody').appendChild(tr);
		
	
			/* fetch('bookList.do', {
				headers: {
					Accept: "application / json",
				},
				method: "GET",
			})
			.then(str => str.json())
			.then(data => {
			
				data.forEach(info => {
					let tr = document.createElement('tr');
					let td = document.createElement('td');
					td.innerHTML = info;
					tr.appendChild(td);
					document.querySelector('.tbody').appendChild(tr);
				})
			})
			.catch(reject => console.log(reject)); */
			
		}
	});//end
</script>
</head>
<body>
	<h3>책목록</h3>

	<table class="table">
		<thead>
			<tr>
				<th>도서코드</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
				<th><button>삭제</button></th>
			</tr>
		</thead>
		<tbody class="tbody">


		</tbody>
	</table>


</body>
</html>