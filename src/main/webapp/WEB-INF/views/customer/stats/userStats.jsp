<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<style>
.table > thead { background-color: #b3c6ff; }
.table > thead > tr > th { text-align: center; } 
.table-hover > tbody > tr:hover { background-color: #e6ecff; } 
.table > tbody > tr > td { text-align: center; } 
.table > tbody > tr > #title { text-align: left; } 
div > #paging { text-align: center; }

h3{
text-align: center;
}

</style>
<script>
var mixedChart = new Chart(ctx, {
    data: {
        datasets: [{
            type: 'bar',
            label: 'Bar Dataset',
            data: [10, 20, 30, 40]
        }, {
            type: 'line',
            label: 'Line Dataset',
            data: [50, 50, 50, 50],
        }],
        labels: ['January', 'February', 'March', 'April']
    },
    options: options
});
 
</script>
</head>
<body>
<%@include file="../header.jsp" %>
<h3>일반가입자 성별, 연령 통계</h3>
<form>
	<fieldset>
		<table class="table">
			<thead>
					<tr>	
					<th>성별</th>
					<th>인원</th>
					<th>10대</th>
					<th>20대</th>
					<th>30대</th>
					<th>40대</th>
					<th>50대</th>
					<th>60대</th>
					<th>통계</th>
					</tr>
			</thead>
			<tbody>
				<c:if test="${empty lists }">
					<tr>
						<td colspan="4">
							등록된 정보가 없습니다.	
						</td>
					</tr>
				</c:if>	
				<c:forEach var="user" items="${lists }">	
						<td>${user. gen}</td>
						<td>(명)</td>
						<td>${user. over_ten }</td>
						<td>${user. over_twenty }</td>
						<td>${user. over_thirty }</td>
						<td>${user. over_forty }</td>
						<td>${user. over_fifty }</td>
						<td>${user. over_sixty }</td>
						<td>${user. over_ten + user. over_twenty + user.over_thirty + user.over_forty + user. over_fifty + user. over_sixty}</td>		
					</tr>
					
			</tbody>
						<tr>
						<td>${user. gen}</td>
						<td>(%)</td>
						<td>${user. a1 }</td>
						<td>${user. b1 }</td>
						<td>${user. c1 }</td>
						<td>${user. d1 }</td>
						<td>${user. e1 }</td>
						<td>${user. f1 }</td>
						<td>${user. gender / user.gender * 100}%</td>
					</tr>
				</c:forEach>
				
		</table>
	</fieldset>
</form>

</body>
</html>

