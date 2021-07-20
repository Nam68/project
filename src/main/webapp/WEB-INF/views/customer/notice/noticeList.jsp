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
.table > thead { background-color: #b3c6ff; }
.table > thead > tr > th { text-align: center; } 
.table-hover > tbody > tr:hover { background-color: #e6ecff; } 
.table > tbody > tr > td { text-align: center; } 
.table > tbody > tr > #title { text-align: left; } 
div > #paging { text-align: center; }
</style>
<style>
h3{
text-align: center;
}
</style>
</head>
<body>
<%@include file="../header.jsp" %>
<h3>공지사항</h3>
<form>
	<fieldset>
		<table class="table">
			<thead>
			<tr>	
					<th>No</th>
					<th>제목</th>
					<th>작성날짜</th>
					<th>조회수</th>
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
				<c:forEach var="n" items="${lists }">
					<tr>
						<td>${n. n_idx}</td>
						
						<c:url var="contentUrl" value="noticeContent.do">
							<c:param name="n_idx">${n. n_idx }</c:param>
						</c:url>
				
						<td><a href="${contentUrl}">${n.n_title}</a></td>
						
						<td>${n. n_writedate}</td>
						<td>${n. n_readnum }</td>
					</tr>
					</c:forEach>
					
						
			</tbody>
		</table>
				<div align="center">
					
					${pageStr }
					 &nbsp;&nbsp;&nbsp;&nbsp;
					 &nbsp;&nbsp;&nbsp;&nbsp;
				   
			 <c:set var="name" value="${sessionScope.memberDTO.id }"/>
             <c:if test="${name eq 'admin'}">
     	 	<a href="noticeWrite.do">글쓰기</a>
     	 	  </c:if>	
		</div>
	</fieldset>
</form>

</body>
</html>