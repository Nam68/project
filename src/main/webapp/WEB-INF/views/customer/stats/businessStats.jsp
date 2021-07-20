<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<%@include file="../header.jsp" %>
</head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Month', 'Pay'],
          ['1월',  ${jan}],
          ['2월',  ${feb} ],
          ['3월',  ${may }],
          ['4월',  ${apr }],
          ['5월',  ${may }],
          ['6월',  ${jun }],
          ['7월',  ${jul }],
          ['8월',  ${aug }],
          ['9월',  ${sept }],
          ['10월',  ${oct }],
          ['11월',  ${nov }],
          ['12월',  ${dec}]
        ]);

        var options = {
          title: '2021년도 월별 매출',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>
<body>
<table class="table">
	<tr>
 	<th>일반 유저 일일 방문자 수 </th>  
	<th>일반 유저 누적 방문자 수</th>
	<th>사업자 방문자수</th>
	<th>사업자 누적 방문자수</th>
	<th>일반회원 가입자 수(투데이)</th>
	<th>일반회원 가입자 수(누적)</th>
	<th>사업자 가입자 수(투데이)</th>
	<th>사업자 가입자 수(누적)</th>
	</tr>
	<tr> 
	<td>${todat} </td>
	<td>${total} </td>
	<td>${us } </td>
	<td>${bi } </td>
	<td>${allus } </td>
	<td>${allbi } </td>
	<td>${todayJoin } </td> 
 	<td>${totalJoin } </td> 
	</tr>
</table>
<div id="curve_chart" style="width: 900px; height: 500px"></div>
</body>
</html>