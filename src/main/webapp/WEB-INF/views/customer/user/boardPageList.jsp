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
		<table border="1" width="1000" height="300" align="center">
			<thead>
			<tr>	
					<th><input type="checkbox" id="allCheck" name="allCheck" >전체선택</th>
					<th>No</th>
					<th>ID</th>
					<th>이름</th>
				
					</tr>
			</thead>
			<tfoot>
				<tr>
					
					<td><input type="button" value="선택삭제" onclick="deleteValue();"></td>
				</tr>			
			</tfoot>	
			
			<tbody>
				<c:if test="${empty list }">
					<tr>
						<td colspan="4">
							등록된 회원이 없습니다.	
						</td>
					</tr>
				</c:if>
				<c:forEach var="user" items="${list }" varStatus="loop">
					<tr>
						<td><input type="checkbox" name="rowCheck" value="${user. idx}"></td>
						<td>${user. idx }</td>
						<td>${user. id}</td>
						<td>${user. name}</td>
						
					</tr>
					</c:forEach>
				
			</tbody>
			
		</table>

	<table>
		<tr>
		    <c:if test="${pageMaker.prev}">
		    <td>
		        <a href='<c:url value="/boardPageList.do?page=${pageMaker.startPage-1}"/>'>&laquo;</a>
		    </td>
		    </c:if>
		    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
		    <td>
		        <a href='<c:url value="/boardPageList.do?page=${idx}"/>'>${idx}</a>
		    </td>
		    </c:forEach>
		    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		    <td>
		        <a href='<c:url value="/boardPageList.do?page=${pageMaker.endPage+1}"/>'>&raquo;</a>
		    </td>
		    </c:if>
		</tr>
	</table>

</body>
</html>