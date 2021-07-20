<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../header.jsp" %>
<h1>글쓰기</h1>
<form name="userCommentUp" action="userCommentUpdate.do" method="post">
<table>

	<tr>
		<th>게시글 번호</th>
		<td><input type="text" name="n_idx" value="${dto. c_idx }" readonly="readonly"></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="c_writer" value="${member.id }" readonly="readonly"></td>
	</tr>
	<tr>
		<td colspan="4">
			<textarea rows="8" cols="45" name="c_content" >${dto.c_content }</textarea>
		</td>
	</tr>
	<tr>
		<th>작성 날짜</th>
		<td><input type="text" name="c_wridate" value="${dto.c_writedate }" readonly="readonly"> </td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" value="수정하기" class="update_btn">
			<a href="userQnAList.do"><input type="button" value="취소" class="list_btn"></a>
		</td>
	</tr>
	
</table>
</form>
</body>
</html>