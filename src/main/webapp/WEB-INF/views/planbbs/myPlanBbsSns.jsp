<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	margin:0px auto;
	width:50vw;

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
</head>
<c:import url="snsHeader.jsp"></c:import>
<body>
<br><br><br>
<table>
	<tr>
		<th>이미지</th><th>제목</th><th>내용</th>
	</tr>
	<c:forEach var="vo" items="${myplanBbsList}">
	<tr>
		<td><img class="imgs" src="${vo.img}"></td>
		<td><a href="myPlanBbsContent.do?bbs_idx=${vo.bbs_idx}&plan_writer=${param.plan_writer}&day=1&plan_content=${vo.plan_content}&p_idx=${vo.p_idx}">${vo.plan_title}</a></td>
		<td>${vo.plan_content}</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="3">${pageStr}</td>
	</tr>
</table>
</body>
</html>