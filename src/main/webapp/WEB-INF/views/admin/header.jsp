<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://lne8372.cafe24.com/css/loginLayout.css">
<link rel="stylesheet" type="text/css" href="http://lne8372.cafe24.com/css/modalLayout.css">
<script src="http://lne8372.cafe24.com/js/ajaxScript.js"></script>
<script src="http://lne8372.cafe24.com/js/loginScript.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>





<style>

#li1{
		float: left;
		line-height: 30px;
		text-align: center;
	
}
.nav {
  list-style-type: none;
  text-align: center;
  margin: 0;
  padding: 0;
  position: relative;
  display: inline-block;

}
.nav li {
  display: inline-block;
  font-size: 20px;
  padding: 20px;

}
h1{
 text-align: center;
}

</style>
    <!-- 로그아웃 스크립트 -->
	<script>
		function logoutSubmit() {
			if(window.confirm('로그아웃 하시겠습니까? \n변경사항이 저장되지 않을 수 있습니다')) {
				sendXHR('logoutSubmit.do', null, logoutResult, 'GET');
			}
		}
		function logoutResult() {
			if(XHR.readyState == 4) {
				if(XHR.status == 200) {
					window.alert(XHR.responseText);
					location.reload();
				}
			}
		}
	</script>
</head>

<body>
<h1 class="page-header"><a href="customerForm.do">고객센터</a></h1>
<nav class="navbar navbar-default navbar-static">
	<c:set var="name" value="${sessionScope.memberDTO.id }"/>
<c:choose> 
	<c:when test="${name eq 'admin'}">	
	<div id="dropdown" class="container-fluid">
	<ul class="nav nav-tabs">
	
		<li id="li1">
			사용자
			<ul>
			


				<li><a href="customerUserList.do">회원관리</a></li>
				
				<li><a href="userQnAList.do">QnA</a></li>
			</ul>
		</li>
		
		<li id="li1" role="presentation" class="active">사업자
			<ul>
				<li><a href="customerBizList.do">사업자관리</a></li>
				<li><a href="customerBizList.do">광고관리</a></li>
			</ul>	
		</li>
	
		<li id="li1">통계
			<ul>
				<li><a href="userStats.do">이용자통계</a></li>
				<li><a href="customerBizStats.do">관리자통계</a></li>
			</ul>
		</li>
		<li id="li1">공지사항
				<ul>
				<li><a href="noticeAllList.do">공지사항</a></li>
			</ul>
		</li>
		
		<li id="li1">정보 관리
		<ul>
		<li id="li1"><a href="pwd.do">비밀번호변경&nbsp;&nbsp;</a></li>
		<li id="li1"><a href="adminFavorite.do">테마관리&nbsp;&nbsp;</a></li>
		<li id="li1"><a href="businessPage.do">장소정보관리&nbsp;&nbsp;</a></li>
		</ul>
		</li>
	<li id="li1" role="presentation">
		<c:if test="${sessionScope.member != null}">${sessionScope.memberDTO.id }님<a href="logout.do"> 로그아웃</a></c:if>
		
	</li>
	</ul>
	</div>	
	</c:when> 
	
	<c:otherwise> 
			<div  class="container-fluid">
	<ul id="ul1" class="nav nav-tabs" >
		<li id="li1">QnA
			<ul>
				<li><a href="userQnAList.do">QnA</a></li>
			</ul>
		</li>
		<li id="li1">공지사항
				<ul>
				<li><a href="noticeAllList.do">공지사항</a></li>
			</ul>
		</li>
	
	<li>
		<c:if test="${sessionScope.memberDTO != null}">${sessionScope.memberDTO.id }님<a onclick="logoutSubmit()"> 로그아웃</a></c:if>
		<c:if test="${sessionScope.memberDTO == null}"><a onclick="loginOn()">로그인</a></c:if>
	</li>
	<li>
	
	</li>
	</ul>
	</div>
	</c:otherwise>
</c:choose>

<br>
<br>
</nav>
</body>
<div class="modal_back" id="modal_back"></div>
<div class="modal" id="login_modal"></div>
</html>
