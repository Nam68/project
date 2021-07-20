<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h3{
text-align: center;
}
</style>
</head>
<body>
<%@include file="../header.jsp" %>
<h3>수정하기</h3>
<form name="QnAUpdate" action="userQnAUpdate.do" method="post">
<div class="container">
	<div class="form-group">
		게시글 번호
		<input type="text" name="bbs_idx" value="${dto. bbs_idx }" readonly="readonly" class="form-control">
	</div>
	<div class="form-group">
		작성일
		<input type="text" name="q_wridate" value="${dto.q_writedate }" readonly="readonly" class="form-control">
	</div>
	<div class="form-group">
		제목
		<input type="text" name="q_title" value="${dto.q_title }" class="form-control">
	</div>
	<div class="form-group">
		작성자
		<input type="text" name="q_writer" value="${member.id }" readonly="readonly" class="form-control">
	</div>
	<div class="form-group">
		<textarea rows="8" cols="45" name="q_content" class="form-control">${dto.q_content }</textarea>
	</div>
	<div class="form-group">
		<a href="userQnAList.do"><input type="button" value="취소" class="btn btn-primary pull-right"></a>
		<input type="submit" value="수정하기" class="btn btn-primary pull-right">
		
	</div>
</div>

</form>
</body>
</html>