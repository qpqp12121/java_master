<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="show">
 <table class="table">
  <thead>
   <tr>
    <th>센터id</th>
    <th>센터명</th>
    <th>연락처</th>
    <th>시도정보</th>
   </tr>
  </thead>
  <tbody id="list">
  
  </tbody> 
 </table>
</div>

<!-- 공공데이터 json포맷 활용 -->
<script>
//perPage=값 변경하면 됨(전체페이지284)
const url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=10&serviceKey=Rfxlbmk%2FbTRg6cOPl2uS14h56H1MHB8oU1ov6oihHVGU0%2FVWeVftZgTmd3Rk4XNqoI7K2pZc%2Fiers6gHBBu3ug%3D%3D';
const fields = ['id', 'centerName', 'phoneNumber', 'sido'] //화면에 보여줄 key 지정(더 넣고 싶으면 ,'address')

let tbody = document.getElementById('list');
const xhtp = new XMLHttpRequest();
xhtp.open('get', url);
xhtp.send();
xhtp.onload = function(){
	console.log(JSON.parse(xhtp.responseText));
	
	//{currentCount:10, data:Array(10), .... } -> data:[{..}, {..},...] -> {id:'', centerName:'', ...}
	
	let result = JSON.parse(xhtp.responseText); 
	//각데이터마다 tr > td * 4 => tbody에 붙이기
	result.data.forEach(center => {            //데이터 콘솔창에 확인해보면 Object안에 data필드 배열값있음

		console.log(center); //Object의 data필드
		
		let tr = document.createElement('tr');
		tr.addEventListener('click', function(){ //tr누르면 map.do에 매개값 넘기고 =>해당위치지도
			//location.href = 'map.do?x=' + center.lat + '&y=' + center.lng; 
			window.open("map.do?x="+ center.lat + "&y=" + center.lng + "&org=" + center.org); //새탭에서열기(위방법은현재창에서열림) 
		})
		
		fields.forEach(field => {   //fields안에 보여주고 싶은 필드있으면 위에서 더 추가해주면 됨
			let td = document.createElement('td');
			td.innerText = center[field];
			tr.appendChild(td);
		})
		tbody.appendChild(tr);
	})
	
	
}
		 
</script>

</body>
</html>