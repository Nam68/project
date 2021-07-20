<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script>
	function reload() {
		location.reload(true);
	}
</script>
<style>
td {
	
}

body {
	padding-top: 10vh;
}

table {
	width: 55vw;
	border-spacing:;
	margin: auto;
}

body {
	padding-top: 10vh;
}

table {
	width: 35vw;
}

.c_content {
	width: 35vw;
	height: 20vh;
	padding-bottom: 3vh;
}

.c_text {
	width: 99%;
	height: 100%;
}

.sns_content {
	height: 7vh;
	border-bottom-style: solid;
	border-bottom-color: #F5F5F7;
	padding-bottom: 3vh;
}

.sns_writer {
	height: 3vh;
	font-weight: bolder;
}

.c_writer {
	border-bottom-style: solid;
	border-color: #F5F5F7;
	height: 3vh;
	font-weight: bolder;
}
</style>
</head>
<c:import url="snsHeader.jsp"></c:import>
<body>

	<form id="addComment" name="addComment" action="addComment.do"
		method="post">
		<table>
			<thead>
				<tr>
					<td><input type=text id="bbs_idx" name="bbs_idx"
						value="${dto.bbs_idx}" hidden="1" /></td>
				</tr>
				<tr>
					<td class="sns_writer">${dto.sns_writer}</td>
				</tr>
				<tr>
					<td class="sns_content">${dto.sns_content}</td>
				</tr>
			</thead>
		</table>
		<table>
			<c:if test="${empty clists}">
				<tr>
					<td colspan="3" style="text-align: center;">등록된 게시물이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="vo" items="${clists}">
				<tr>
					<td colspan=3 hidden="1">${vo.bbs_idx}</td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td colspan=2 hidden="1">${vo.c_idx}</td>
				</tr>
				<tr>
					<td colspan=2 class="c_writer">${vo.c_writer}:</td>
				</tr>
				<tr>
					<td colspan=2>${vo.c_content}</td>
				</tr>
				<tr>
					<td colspan=2 hidden="1">${vo.c_writedate}</td>
				</tr>
			</c:forEach>
		</table>
		<table>
			<tbody>
				<!-- 댓글 작성 칸 -->
				<tr hidden="1">
					<th colspan="2"><input type="text" value="${sns_writer}"
						name="c_writer"></th>
				</tr>
				<tr>
					<td colspan="3" class="c_content"><input type="text"
						name="c_content" class="c_text" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="댓글 달기"></td>
					<td><input type="button" value="다시작성" onClick="reload();"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>