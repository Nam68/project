<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
#listReply {
 text-align: center;
}
h3{
text-align: center;
}
</style>
</head>
<body>
<%@include file="../header.jsp" %>
<h3>QnA</h3>
	<div class="container">
		<div class="form-group">
		작성자
		<input type="text" id="writer" value="${dto.q_writer }" readonly="readonly" class="form-control">
		</div>
		<div class="form-group">
		제목
		<input name="title" id="citle" size="80" value="${dto.q_title}" readonly="readonly" class="form-control">
		</div>
		<div class="form-group">
		내용
		<textarea name="content" id="content" rows="10" cols="80" readonly="readonly" class="form-control">${dto.q_content}</textarea>
		</div>
		
		
		<div style="width:650px; text-align: center;">
  	  <!-- 본인이 쓴 게시물만 수정, 삭제가 가능하도록 처리 -->
  	  <c:set var="name" value="${sessionScope.memberDTO.id }"/>
    <c:if test="${sessionScope.memberDTO.id eq dto.q_writer || name eq 'admin'}">
       <a href="userQnADelete.do?bbs_idx=${dto. bbs_idx}"> 
       <button type="button" id="Delete_btn"  class="btn btn-primary pull-right">삭제</button></a>
       <a href="userQnAUpdate.do?bbs_idx=${dto. bbs_idx}">
       <button type="button" id="btnUpdate"  class="btn btn-primary pull-right">수정</button></a>
    
    </c:if>
        <!-- 상세보기 화면에서 게시글 목록화면으로 이동 -->
        <a href="userQnAList.do"><button type="button" id="btnList"  class="btn btn-primary pull-right">목록</button></a>
    </div>
</div>
<br>
	
	 		 <!-- **댓글 목록 출력할 위치 -->	  
    	<div id="listReply">
  		  <c:forEach var="vo" items="${clist}"> 
		<div><input type="hidden" value="${vo.bbs_idx}"></div>
		<div>작성자 : ${vo.c_writer} &nbsp;&nbsp; ${vo.c_writedate } &nbsp;&nbsp;
			<c:set var="name" value="${sessionScope.memberDTO.id }"/>
			<c:if test="${sessionScope.memberDTO.id eq dto.q_writer || name eq 'admin'}">	
				 <a href="#">수정</a>
			  <a href="commentDelete.do?c_idx=${vo. c_idx}">삭제</a></div>
			</c:if>	
		<div><input type="hidden" value="${vo.c_idx}"></div>
		<div><textarea name="content" id="content" rows="4" cols="80">${vo.c_content}</textarea>		
		</div>
		</c:forEach></div>
		<br>
		
 <form id="addComment" name="addComment" action="addAdminComment.do" method="post">
	<table align="center">
		<tr>
		<!-- 게시물번호를 hidden으로 처리 -->
		<td><input type="hidden" name="bbs_idx" value="${dto.bbs_idx}" required="required"></td>
		<td><input type="hidden" value="${sessionScope.memberDTO.id }" required="required" name="c_writer"></td>
		</tr>
		<tr>
 	   <td align="center" style="width:650px;">  
        <br>
        <!-- **로그인 한 회원에게만 댓글 작성폼이 보이게 처리 -->
      	<!-- 댓글 작성 칸 -->
        <c:if test="${sessionScope.memberDTO.id != null}">    
        <textarea rows="5" cols="100" name="c_content" placeholder="댓글을 작성해주세요" required="required"></textarea>
  	   <br>	
		<input type="submit" value="댓글달기">
        </c:if>
  	</td>
  	</tr>
   </table>
</form>
</body>
</html>
