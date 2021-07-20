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
<h3>공지사항 수정</h3>
<form name="noticeUpdate" action="noticeUpdate.do" method="post">

<div class="container">
	<div class="form-group">
		게시글 번호
		<input type="text" name="n_idx" value="${dto. n_idx }" readonly="readonly" class="form-control">
	</div>
	<div class="form-group">
		작성일
		<input type="text" name="n_wridate" value="${dto.n_writedate }" readonly="readonly" class="form-control">
	</div>
	<div class="form-group">
		제목
		<input type="text" name="n_title" value="${dto.n_title }" class="form-control"> 
	</div>
	<div class="form-group">
		작성자
		<input type="text" name="n_writer" value="${member.id }" readonly="readonly" class="form-control">
	</div>
	<div class="form-group">
		조회수
		<input type="text" name="n_writer" value="${dto.n_readnum }" readonly="readonly" class="form-control">
	</div>
	
	<div class="form-group">
		<textarea rows="6" cols="45" name="n_content" class="form-control">${dto.n_content }</textarea>
	</div>
	<div class="form-group">
		<a href="noticeAllList.do"><input type="button" value="취소" class="btn btn-primary pull-right"></a>
		<input type="submit" value="수정하기" class="btn btn-primary pull-right">
	
	</div>
</div>

</form>
</body>
</html>