<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="place" items="${placeList }">
	<div class="placeItem">
		<div class="placeItemImg">
			<input type="hidden" value="${place.pl_idx }">
			<img alt="place" src="${place.pl_img }">
		</div>
		<div class="placeItemButton">
			<div class="placeItemTitle">${place.pl_name }</div>
			<div class="placeItemAdd">담기</div>
		</div>
	</div>
</c:forEach>