<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>취향 정보 변경</title>
    <script src="http://lne8372.cafe24.com/js/ajaxScript.js"></script>
	<script>
		function favoriteAdd() {
			let v_name = document.getElementsByName('favoriteAdd')[0].value;
			let params = 'v_name='+v_name;
			sendXHR('adminFavoriteAdd.do', params, favoriteResult, 'GET');
		}
		function favoriteDelete() {
			let v_idx = document.getElementsByName('favoriteDelete')[0].value;
			let params = 'v_idx='+v_idx;
			sendXHR('adminFavoriteDelete.do', params, favoriteResult, 'GET');
		}
		function favoriteResult() {
			if(XHR.readyState == 4) {
				if(XHR.status == 200) {
					let data = XHR.responseText;
					window.alert(data);
					location.reload();
				}
			}
		}
	</script>
</head>
<%@include file="header.jsp" %>
	<body>
		<fieldset>
			<legend>취향 정보 변경</legend>
			<div>
				<div>
					<div>추가</div>
					<div>
						<input type="text" name="favoriteAdd">
						<input type="button" value="추가하기" onclick="favoriteAdd()">
					</div>
				</div>
				<div>
					<div>삭제</div>
					<div>
						<select name="favoriteDelete">
							<c:forEach var="dto" items="${list }">
								<option value="${dto.v_idx }">${dto.v_name }</option>
							</c:forEach>
						</select>
						<input type="button" value="삭제하기" onclick="favoriteDelete()">
					</div>
				</div>
			</div>
		</fieldset>
	</body>
</html>