<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>
<body>
<%@include file="../header.jsp" %>
<h3>공지사항</h3>
<div class="container">
    <div class="form-group">       
  		작성자 <input type="text" id="writer" value="${dto. n_writer }" readonly="readonly" class="form-control">
  		작성일 ${dto.n_writedate} 조회수 ${dto.n_readnum }
    </div>
  
    <div class="form-group">
    	 <label>제목</label>
        <input name="title" id="citle" size="87" value="${dto.n_title}" 
        	readonly="readonly" class="form-control">
    </div>
    <br>
    <div class="form-group">
    	<label>내용</label>
        <textarea name="content" id="content" rows="10" cols="90" 
      		 readonly="readonly" class="form-control">${dto.n_content}</textarea>
    </div>
    <div style="width:650px; text-align: center;" class="form-group">
    <!-- 본인이 쓴 게시물만 수정, 삭제가 가능하도록 처리 -->
	 	 <c:set var="name" value="${sessionScope.memberDTO.id }"/>
   		 <c:if test="${sessionScope.memberDTO.id eq dto.n_writer || name eq 'admin'}">	
        <a href="noticeDelete.do?n_idx=${dto. n_idx}"><button type="button" class="btn btn-primary pull-right">삭제</button></a>
  	    <a href="noticeUpdate.do?n_idx=${dto. n_idx}"><button type="button" class="btn btn-primary pull-right">수정</button></a>
  		  </c:if>
  	  <a href="noticeAllList.do"><button type="button" id="noticeList" class="btn btn-primary pull-right">목록</button></a>
    </div>
</div>
</body>
</html>