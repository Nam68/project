<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<style>
h3{
text-align: center;
}
</style>
<%@include file="../header.jsp" %>
</head>
<body>
<h3>공지사항</h3>
<form name="noticeWrite" action="noticeWrite.do" method="post">
<div class="container">
	<div class="form-group">
		작성자
		<input type="text" name="n_writer" value="${member.id}" readonly="readonly" class="form-control">
	</div>
	
	<div class="form-group">
		작성자
		<input type="text" name="n_writer" value="${member.id}" readonly="readonly" class="form-control">
	</div>
	
	<div class="form-group">
		제목
		<input type="text" name="n_title" required="required" class="form-control">
	</div>
	<div class="form-group">
		<textarea rows="8" cols="45" name="n_content" required="required" class="form-control"></textarea>
	</div>
	<div class="form-group">
		<a href="noticeAllList.do">
		<input type="button" value="취소" class="btn btn-primary pull-right"></a>
		<input type="submit" value="글쓰기" class="btn btn-primary pull-right">
		
	</div>
</div>
		
</form>
</body>
</html>