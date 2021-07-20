<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
table {
	margin: auto;
	border-spacing: 0 1vh;
}

.img {
	height: 30vh;
	float: left;
}

.imgs {
	float: left;
	padding-bottom: 3vh;
}

.name {
	padding-bottom: 3vh;
	border-bottom-style: solid;
	border-color: #F5F5F7;
}
</style>
<c:forEach items="${myplanList}" var="mpl">
	<table>
		<div class=imgs>
		<tr>
			<td><img src='${mpl.img}' class=img></td>
		</tr>
		<tr>
			<td class=name>${mpl.pl_name}</td>
		</tr>
		</div>
	</table>
</c:forEach>