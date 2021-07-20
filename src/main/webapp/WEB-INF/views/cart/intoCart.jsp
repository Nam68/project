<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<form name="cartAdd" action="placeCart.do">

<c:forEach var="cart" items="${placeCart}">
<input type="text" name="pl_idx" value="${cart.pl_idx}">
	<input type="text" name="pl_name" value="${cart.pl_name }">
	<img type="pl_img" value="${cart.pl_img }">
</c:forEach>	
	<h3>Day를 선택하세요.</h3>
<select name="cartday">
<c:forEach var="i" begin="1" end="result">
<option>${i}</option>
</c:forEach>
</select>
<!-- 저장을 누르면 카트에 담김. -->
<button type="submit" onclick="saveOk();">저장</button></form>
<button type="button">취소</button>
</body>
</html>