<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.img {
	height: 9vw;
}

.imgs {
	float: left;
}
</style>
<div class=imgs>
	<c:forEach var="vo" items="${myplanContentList2}">
		<img src="${vo.img}" class=img>
	</c:forEach>
</div>