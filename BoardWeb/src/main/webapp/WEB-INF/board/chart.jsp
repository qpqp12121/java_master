<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});

      
    //배열안배열형태 [[], [], []....]
    
      let chartData = [['Name', 'countPerName']]; //문자타입(초기값)
      
      //서버에서 데이터 받아오기 위해 Ajax 사용(그래서 json데이터로 -ReplyCountJson()에 만들었음
      const xhtp = new XMLHttpRequest();
      xhtp.open('get', 'replyCountJson.do');
      xhtp.send();
      xhtp.onload = function(){
    	let result = JSON.parse(xhtp.responseText);
    	result.forEach(item => {
    		chartData.push([item.name, item.cnt]);
    	})
    	google.charts.setOnLoadCallback(drawChart);
      }
      
      function drawChart() {

        var data = google.visualization.arrayToDataTable(chartData);
        
        var options = {
          title: 'My Daily Activities'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
</head>
<body>
	<div id="piechart" style="width: 900px; height: 500px;"></div>
</body>
</html>
