<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

if(!checkPoupCookie("close")){

	window.open('noticePop.do','n_pop','width=500,height=500');;

}

function checkPoupCookie(cookieName){

var cookie = document.cookie;

// 현재 쿠키가 존재할 경우

if(cookie.length > 0){

// 자식창에서 set해준 쿠키명이 존재하는지 검색

startIndex = cookie.indexOf(cookieName);

// 존재한다면

if(startIndex != -1){

return true;

}else{

// 쿠키 내에 해당 쿠키가 존재하지 않을 경우

return false;

};

}else{

// 쿠키 자체가 없을 경우

return false;

};

}
</script>

</head>
<body>
<%@include file="header.jsp" %>

</body>
</html>