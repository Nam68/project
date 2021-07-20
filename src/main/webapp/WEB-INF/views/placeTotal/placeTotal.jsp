<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="http://lne8372.cafe24.com/css/loginLayout.css">
	<link rel="stylesheet" type="text/css" href="http://lne8372.cafe24.com/css/modalLayout.css">
	<script src="http://lne8372.cafe24.com/js/ajaxScript.js"></script>
	<title>사업장 통계 조회</title>
	<style>
		.totalBar{background-color:#7FC9CB; max-height:4vh; margin-bottom: 2vh; min-width: 5vw;}
		.totalDiv{border: 3px solid black; width: 80vw; margin: auto; margin-bottom: 3%; padding: 1%; }
	</style>
	<script>
		function showTotal(target) {
			let params = 'pl_idx='+target.value;
			sendXHR('totalUpdate.do', params, showTotalResult, 'GET');
		}
		function showTotalResult() {
			if(XHR.readyState == 4) {
				if(XHR.status == 200) {
					let data = XHR.responseText;
					const total = document.getElementsByClassName('totalResult')[0];
					total.innerHTML = data;
				}
			}
		}
	</script>
</head>
<%@ include file="businessHeader.jsp" %>
	<body>
		<div>
			<select class="placeSelect" onchange="showTotal(this)">
				<option value="-1">선택</option>
				<c:forEach items="${places }" var="dto">
					<option value="${dto.pl_idx }">${dto.pl_name }</option>
				</c:forEach>
			</select>
		</div>
		<div class="totalResult">
			
		</div>
	</body>
</html>