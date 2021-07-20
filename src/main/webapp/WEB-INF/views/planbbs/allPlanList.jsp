<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	margin:0px auto;
}
th{
	background: #7FC9CB;
	color:white;
}
td{
	text-align: center;
}
a{
	text-decoration: none;
}
.imgs{
	width:300px;
}
</style>
<c:import url="snsHeader.jsp"></c:import>
</head>
<body>
<br><br><br>
<table>
	<tr>
		<th>이미지</th><th>작성자</th><th>게시글 제목</th>
	</tr>
	<c:forEach var="vo" items="${allplanList}">
	<tr>
		
		<td><img class="imgs" src="${vo.img}"></td><td>${vo.plan_writer}</td><td><a href="myPlanBbsContent.do?bbs_idx=${vo.bbs_idx}&plan_writer=${vo.plan_writer}&day=1&plan_content=${vo.plan_content}&p_idx=${vo.p_idx}">${vo.plan_title}</a></td>
	
	</tr>
	</c:forEach>
	<tr>
		<td colspan="4">${pageStr}</td>
	</tr>
</table>
</section>
</body>
</html>