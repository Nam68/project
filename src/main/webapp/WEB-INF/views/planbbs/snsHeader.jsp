<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #7FC9CB;
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-weight: bolder;
}

/* Change the link color to #111 (black) on hover */
li a:hover {
	background-color: #FFE699;
}

.active {
	background-color: #FFE699;
	float: right;
	color: gray;
}
</style>
</head>

<body>
	<ul>
		<li><a href="mainPage.do">Home</a></li>
		<li><a href="planList.do">내 플랜</a></li>
		<li><a href="allplanList.do">플랜 피드</a></li>
		<li><a href="mySnsList.do">내 트립스타그램 게시물</a></li>
		<li><a href="snsList.do">트립스타그램</a></li>
		<li class="active"><a href="snsWrite.do">게시물 올리기</a></li>
	</ul>
</body>
</html>