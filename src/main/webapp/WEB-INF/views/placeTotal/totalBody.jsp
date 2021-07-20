<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="totalDiv">
	<div>방문자의 취향 통계</div>
	<c:if test="${empty favorite }">
	작성된 통계가 없습니다
	</c:if>
	<c:forEach items="${favorite }" var="favorite">
		<div class="totalBar" style="width:${favorite.value }%;">${favorite.v_name } ${favorite.value }%</div>
	</c:forEach>
</div>
<div class="totalDiv">
	<div>방문자의 거주지 통계</div>
	<c:if test="${empty city }">
	작성된 통계가 없습니다
	</c:if>
	<c:forEach items="${city }" var="city">
		<div class="totalBar" style="width:${city.value }%;">${city.city } ${city.value }%</div>
	</c:forEach>
</div>
<div class="totalDiv">
	<div>방문자의 연령 통계</div>
	<c:if test="${empty total }">
	작성된 통계가 없습니다
	</c:if>
	<c:if test="${!empty total }">
	<div class="totalBar" style="width:${total.under20}%;">20대 이하 ${total.under20}%</div>
	<div class="totalBar" style="width:${total.in30}%;">30대 ${total.in30}%</div>
	<div class="totalBar" style="width:${total.in40}%;">40대 ${total.in40}%</div>
	<div class="totalBar" style="width:${total.in50}%;">50대 ${total.in50}%</div>
	<div class="totalBar" style="width:${total.over60}%;">60대 이상 ${total.over60}%</div>
	</c:if>
</div>
<div class="totalDiv">
	<div>방문자의 성별 통계</div>
	<c:if test="${empty total }">
	작성된 통계가 없습니다
	</c:if>
	<c:if test="${!empty total }">
	<div class="totalBar" style="width:${total.male}%;">남성 ${total.male}%</div>
	<div class="totalBar" style="width:${total.female}%;">여성 ${total.female}%</div>
	</c:if>
</div>