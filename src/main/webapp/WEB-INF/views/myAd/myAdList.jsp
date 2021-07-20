<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="http://lne8372.cafe24.com/js/ajaxScript.js"></script>
	<style>
		.contentCard {margin: 2% auto; width: 50vw; height: 22vh; position: relative;  border: 0; border-radius: 3vw; box-shadow: 0.7vw 0.7vw 1.2vw #BBBBBB;}
		.contentCard>div {display: inline-block; vertical-align: middle; }
		
		.adButton{position: absolute; text-align: center; width: 10%; height: 10vh; right: 3%; top: 6vh;}
		.adButton>div{margin: 2vh; }
		.adButton>div:hover{cursor: pointer; }
		
		.adImg>img {padding: 2vh; max-width: 8vw; max-height: 8vw; min-width: 8vw; min-height: 8vw;}
		.adTitle {margin-left: 3%;}
		.contentCard>.adInfo {height: 11vh; text-align: center; display: inline-block; width: 40%; position: absolute; right: 15%; top: 5.5vh; }
		.contentCard>.adInfo>div {display: inline-block; }
		.adInfoDetail {display: inline-table; width: 15vw; }
		.contentCard table {display: inline-table; }
		.contentCard>div>div>table td {padding: 1%;}
		
		.adAddButton {width: 2.2vw; color: white; margin: 0 auto; text-align: center; font-size: 2vw; background-color: #7fc9cb; border-radius: 50%;}
		.adAddButton:hover {cursor: pointer;}
	</style>
	<script>
		function adUpdatePage(a_idx, bbs_idx) {
			adUpdateForm.a_idx.value = a_idx;
			adUpdateForm.bbs_idx.value = bbs_idx;
			adUpdateForm.submit();
		}
		function adDel(a_idx) {
			if(!window.confirm('삭제하면 복구가 불가능합니다\n정말 삭제하시겠습니까?')) {
				return;
			}
			let params = 'a_idx='+a_idx;
			sendXHR('myAdDelete.do', params, function() {
				if(XHR.readyState == 4) {
					if(XHR.status == 200) {
						window.alert(XHR.responseText);
						location.reload();
					}
				}
			}, 'GET')
		}
	</script>
	<title>나의 광고 목록</title>
</head>
<%@ include file="businessHeader.jsp" %>
<body>
	<c:forEach var="vo" items="${adList }">
	<div class="contentCard">
		<div class="adImg"><img alt="img" src="${vo.bbs_img }"></div>
		<div class="adTitle">${vo.a_title }</div>
		<div class="adInfo">
			<div>
				<table class="adInfoDetail">
					<tr>
						<th>남은기간</th>
						<th>총예산</th>
					</tr>
					<tr>
						<td>${vo.leftdate }일</td>
						<td>${vo.a_limit }원</td>
					</tr>
					<tr>
						<th>클릭당 비용</th>
						<th>소진율</th>
					</tr>
					<tr>
						<td>${vo.cpc }원</td>
						<td>${vo.rate }%</td>
					</tr>
				</table>
			</div>
			<div>
				<table>
					<tr>
						<th>상태</th>
					</tr>
					<tr>
						<td>${vo.a_permit }</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="adButton">
			<div onclick="adUpdatePage(${vo.a_idx }, ${vo.bbs_idx })">수정</div>
			<div onclick="adDel(${vo.a_idx})">삭제</div>
		</div>
	</div>
	</c:forEach>
	<div class="adAddButton" onclick="location.href='myAdAdd.do'">+</div>
</body>
	<form id="adUpdateForm" action="myAdUpdate.do" method="post">
		<input type="hidden" name="a_idx" value="">
		<input type="hidden" name="bbs_idx" value="">
	</form>
</html>