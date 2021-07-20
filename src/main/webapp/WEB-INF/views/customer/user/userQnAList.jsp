<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
.table > thead { background-color: #b3c6ff; }
.table > thead > tr > th { text-align: center; } 
.table-hover > tbody > tr:hover { background-color: #e6ecff; } 
.table > tbody > tr > td { text-align: center; } 
.table > tbody > tr > #title { text-align: left; } 
div > #paging { text-align: center; }

h3{
text-align: center;
}

</style>

<script>
$(document).ready(function(){
    
    let result = '<c:out value="${result}"/>';
    
    checkAlert(result);
    
    function checkAlert(result){
        
        if(result === ''){
            reutrn;
        }
   
        if(result === "delete success"){
            alert("삭제가 완료되었습니다.");
        }
        
    }    
    
});
</script>
</head>
<body>
<%@include file="../header.jsp" %>
<h3>QnA 게시판</h3>
<form>
	<fieldset>
		<table class="table">
			<thead>
			<tr>	
					<th>No</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성날짜</th>
					</tr>
			</thead>
		
			<tbody>
				<c:if test="${empty lists }">
					<tr>
						<td colspan="4">
							등록된 글이 없습니다.	
						</td>
					</tr>
				</c:if>
				<c:forEach var="qna" items="${lists }">
					<tr>
						<td>${qna. bbs_idx}</td>
						
						<c:url var="contentUrl" value="userQnAContent.do">
							<c:param name="bbs_idx">${qna.bbs_idx }</c:param>
						</c:url>
				
						<td><a href="${contentUrl}">${qna.q_title}</a></td>
						<td>${qna. q_writer}</td>
						<td>${qna.q_writedate}</td>
					</tr>
					</c:forEach>
			</tbody>
		</table>
		<div align="center">
						${pageStr }
						&nbsp;&nbsp;&nbsp;&nbsp;
					 <c:if test="${sessionScope.memberDTO.id != null}">
					 	&nbsp;&nbsp;&nbsp;&nbsp;
     	 			  <a href="userQnAWrite.do">글쓰기</a>
  					  </c:if>	
		</div>
	</fieldset>
</form>
</body>
</html>