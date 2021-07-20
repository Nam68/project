<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<style>
input[type="checkbox"]+label {
    display: block;
    width: 50px;
    height: 50px;
    background: url('http://lne8372.cafe24.com/img/reqest.png') no-repeat 0 0px / contain;
}

input[type='checkbox']:checked+label {
    background: url('http://lne8372.cafe24.com/img/approve.png') no-repeat 0 1px / contain;
}
input[type="checkbox"] {
    display: none;
}

.table-condensed
</style>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://lne8372.cafe24.com/js/httpRequest.js"></script>
<script>
function permit(a_idx,index){
	var chk=document.getElementsByName("a_permit")[index];
	if(chk.checked==true){
		params='a_idx='+a_idx;
		sendXHR('permitUpdate.do',params,null,'GET');
    }else{
    	params='a_idx='+a_idx;
		sendXHR('permitDelete.do',params,null,'GET');
    }

}
</script>
</head>
<%@include file="../header.jsp" %>
<body>
<h1>광고관리</h1>
<table class="table table-condensed">
	<tr>
		<th class="active">No</th>
		<th class="active">신청자</th>
		<th class="active">광고일정</th>
		<th class="active">광고예산</th>
		<th class="active">상태</th>
	</tr>
	<c:forEach var="vo" items="${adList}" varStatus="status">
	<tr>
		<td>${vo.a_idx}</td>
		<td>${vo.a_writer}</td>
		<td>${vo.a_startdate}~${vo.a_enddate}</td>
		<td>${vo.a_limit}원</td>
		<td><input type="checkbox" id="myCheck${vo.a_idx}" name="a_permit" onclick="permit(${vo.a_idx},${status.index});" ${vo.a_permit == 1?"checked":""}>
		<label for="myCheck${vo.a_idx}"></label></td>
		
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5" style="text-align: center">${pageStr}</td>
	</tr>
</table>
</body>
</html>