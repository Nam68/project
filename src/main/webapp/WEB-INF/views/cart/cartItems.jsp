<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty placeCart }">
	<div class="cart-day">
		<h4>장소를 선택하세요</h4>
	</div>
</c:if>
<c:forEach items="${placeCart}" var="list">
	<div class="cartItemDiv">
		<span onclick="deletePlace(${list.pl_idx})">X</span>
		<input type="hidden" name="cartPl_idx" value="${list.pl_idx }">
		<div>${list.pl_name }</div>
		<img alt="placeImg" src="${list.pl_img }">
	</div>
</c:forEach>