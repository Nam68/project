<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tbody>
			<c:if test="${empty lists}">
				<tr>
					<td colspan="3" style="text-align: center;">0</td>
				</tr>
			</c:if>
			<c:forEach var="gdto" items="${lists}">
				<tr>
					<td colspan=3>${gdto.bbs_idx}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>