<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰관리</title>
<script>
function reqCancel(r_idx) {
	let params = 'r_idx='+r_idx;
	sendXHR('reqCancel.do', params, reviewManagerResult, 'GET');
}
function reviewDelete(r_idx) {
	let params = 'r_idx='+r_idx;
	sendXHR('reviewDelete.do', params, reviewManagerResult, 'GET');
}
function reviewManagerResult() {
	if(XHR.readyState == 4) {
		if(XHR.status == 200) {
			window.alert(XHR.responseText);
			location.reload();
		}
	}
}
</script>
</head>
<body>
<%@include file="../header.jsp" %>
<h3>리뷰관리</h3>
<form>
	<fieldset>
		<table class="table">
			<thead>
			<tr>	
					<th>리뷰번호</th>
					<th>장소번호</th>
					<th>회원번호</th>
					<th>리뷰내용</th>
					<th>버튼</th>
					</tr>
			</thead>
		
			<tbody>
				<c:if test="${empty list }">
					<tr>
						<td colspan="4">
							등록된 글이 없습니다.	
						</td>
					</tr>
				</c:if>
				<c:forEach var="r" items="${list }">
					<tr>
						<td>${r.r_idx}</td>
						<td>${r.pl_idx}</td>
						<td>${r.idx}</td>
						<td>${r.review}</td>
						<td>
							<input type="button" value="취소" onclick="reqCancel(${r.r_idx})">
							<input type="button" value="삭제" onclick="reviewDelete(${r.r_idx})">
						</td>
					</tr>
					</c:forEach>
			</tbody>
		</table>
	</fieldset>
</form>
</body>
</html>