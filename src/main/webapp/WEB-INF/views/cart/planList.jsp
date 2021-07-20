<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="http://lne8372.cafe24.com/js/ajaxScript.js"></script>
<style type="text/css">
ul{
	list-style: none;
	display: inline-block;

}
div{
	display: inline-block;
}
.planList{
	margin: 5px;
	width: 50vw;
	
	}
.planListContent {
	text-align: center;
	display: inline-block;
	vertical-align: middle;
}
.planListImgDiv {
	text-align: center;
	display: inline-block;
	vertical-align: middle;
	width: 20%;
	height: 90%;
}
.planListImgDiv>img {
	max-height: 14vh;
	max-width: 100%;
}
.myPlanContentCard {
	margin: 2% auto; width: 65vw; text-align: center; height: 22vh; position: relative; border: 0; border-radius: 1.5vw; box-shadow: 0.7vw 0.7vw 1.2vw #BBBBBB;
}
body {
	text-align: center;
	margin-top: 6%;
}
</style>
<script>
function planListDelete(p_idx) {
	let params = 'p_idx='+p_idx;
	sendXHR('planDelete.do', params, planListDeleteResult, 'GET');
}
function planListDeleteResult() {
	if(XHR.readyState == 4) {
		if(XHR.status == 200) {
			window.alert(XHR.responseText);
			location.reload();
		}
	}
}
</script>
</head>
<%@ include file="snsHeader.jsp" %>
<body>
<c:if test="${empty planLists}">
<h4>등록된 플랜이 없습니다.</h4>
</c:if>
<c:forEach var="pdto" items="${planLists}">
	<form action="planListForm.do" method="POST">
	<div class="myPlanContentCard">
		<input type="hidden" name="p_idx" value="${pdto.p_idx }">
		<div class="planList">
			<div class="planListImgDiv">
				<img alt="img" src="${pdto.img }">
			</div>
			<div class="planListContent">
				<ul>
					<li>제목 ${pdto.p_name }</li>
					<li>메모 ${pdto.p_content }</li>
				</ul>
			</div>
		</div>
		<div id="plan_li">
		<ul>
			<li><button type="button" onclick="planListDelete(${pdto.p_idx})">삭제</button></li>
			<li><button type="submit" >플랜보기</button></li>
			</ul>
		</div>
	</div>
	</form>		
</c:forEach>	
</body>
</html>