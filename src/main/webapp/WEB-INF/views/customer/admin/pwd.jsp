<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
 <title></title> 
<style>
h3{
text-align: center;
}
</style>
</head>
<body>
<%@include file="../header.jsp" %>
<h3>정보 수정</h3>
<form method="post" action="pwd.do" >
<fieldset>
<table align="center">
	<tr>
 	<td>
 		<label for="id">아 이 디</label>
 		<input type="text" name="id" value="${sessionScope.member.id }"/>
 	</td>
 	</tr>
 	<tr>
 	<td>
 		<label for="pwd">새 비밀번호</label>
 		<input type="password"  name="pwd" />
 	<td>
 	</tr>
 	<tr>
 	<td align="right"><button type="submit">변경</button> <a href="customerForm.do">
 		<button type="button">취소</button></a>
 	</td>
 	</tr>
 	
</table>
</fieldset>
</form>
</body>
</html>