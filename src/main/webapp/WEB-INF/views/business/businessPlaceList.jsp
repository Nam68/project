<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <script src="http://lne8372.cafe24.com/js/ajaxScript.js"></script>
	<title>플레이스 목록</title>
	<style>
		.placeCard {margin: 2% auto; width: 50vw; height: 22vh; position: relative; border: 0; border-radius: 1.5vw; box-shadow: 0.7vw 0.7vw 1.2vw #BBBBBB;}
		.placeCard>div {display: inline-block; vertical-align: middle;}
		.placeCard img {padding: 2vh; max-width: 8vw; max-height: 8vw; min-width: 8vw; min-height: 8vw;}
		
		.placeCardTitle{margin-left: 3%; font-size: 3vh; }
		.placeCardButton{position: absolute; height: 10vh; right: 3%; top: 6vh;}
		.placeCardButton>div{margin: 2vh; }
		.placeCardButton>div:hover{cursor: pointer; }
		
		.placeAddButton {width: 2.2vw; color: white; margin: 0 auto; text-align: center; font-size: 2vw; background-color: #7fc9cb; border-radius: 50%;}
		.placeAddButton:hover {cursor: pointer;}
		
	</style>
	<script>
		function placeDel(pl_idx) {
			if(!window.confirm('삭제하면 복구가 불가능합니다\n정말 삭제하시겠습니까?')) {
				return;
			}
			let params = 'pl_idx='+pl_idx;
			sendXHR('businessPlaceDelete.do', params, function() {
				if(XHR.readyState == 4) {
					if(XHR.status == 200) {
						window.alert(XHR.responseText);
						location.reload();
					}
				}
			}, 'GET')
		}
		function goUpdatePage(pl_idx) {
			document.updateForm.pl_idx.value = pl_idx;
			document.updateForm.submit();
		}
	</script>
</head>
<%@ include file="businessHeader.jsp" %>
<body>
	<c:if test="${empty list }">
	<div>등록된 장소가 없습니다</div>
	</c:if>
	<c:forEach var="vo" items="${list}">
	<div class="placeCard">
		<div><img alt="img" src="${vo.pl_img }"></div>
		<div class="placeCardTitle">${vo.pl_name }</div>
		<div class="placeCardButton">
			<div onclick="goUpdatePage(${vo.pl_idx })">수정</div>
			<div onclick="placeDel('${vo.pl_idx}')">삭제</div>
		</div>
	</div>
	</c:forEach>
	<div class="placeAddButton" onclick="location.href='businessPlaceAddPage.do'">+</div>
</body>
	<form name="updateForm" action="businessPlaceUpdatePage.do" method="post">
		<input type="hidden" name="pl_idx" value="">
	</form>
</html>