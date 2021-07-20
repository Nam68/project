<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${!empty list }">
<div class="reviewBody">
	<c:forEach var="r" items="${list }">
		<div class="reviewContent"><div class="reviewReview">${r.review }</div> <div class="reivewStar">${r.star }점</div></div>
	</c:forEach>
</div>
</c:if>