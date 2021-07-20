<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="vo" items="${todayCart }">
<div class="placeCartContent">
	<span class="placeCartDelete" onclick="placeCartDelete(${vo.pl_idx})">X</span>
	<div>
		<img alt="placeImg" src="${vo.pl_img }" class="placeCartImg">
	</div>
	<div>${vo.pl_name }</div>
</div>
</c:forEach>