<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$.ajax('bookList.do', {
			method: 'get',
			dataType: 'json',
			success: function(result){
				console.log(result)
				$(result).each((idx, book) => {
					let tr = $('<tr />').append($('<td />').text(book.bookCode),
							 $('<td />').text(book.bookName),
							 $('<td />').text(book.bookAuthor),
							 $('<td />').text(book.bookPress),
							 $('<td />').text(book.bookPrice)
							);
							$('.tbody').append(tr);
				});
			},
			error: function(err){
				console.log(err);
			}
		})
	});

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