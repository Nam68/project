<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.headerheader {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #7FC9CB;
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	z-index: 5;
}

.lilili {
	float: left;
}

.lilili a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-weight: bolder;
}

/* Change the link color to #111 (black) on hover */
.lilili a:hover {
	background-color: #FFE699;
}

.active {
	background-color: #FFE699;
	float: right;
	color: black;
}
</style>
</head>

<body>
	<ul class="headerheader">
		<li class="lilili"><a href="mainPage.do">Home</a></li>
		<li class="lilili"><a href="planList.do">내 플랜</a></li>
		<li class="lilili"><a href="allplanList.do">플랜 피드</a></li>
		<li class="lilili"><a href="mySnsList.do">내 트립스타그램 게시물</a></li>
		<li class="lilili"><a href="snsList.do">트립스타그램</a></li>
		<li class="active"><a href="snsWrite.do">게시물 올리기</a></li>
	</ul>
</body>
</html>