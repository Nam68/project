<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
header{}
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
	z-index: 5;
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
body {
	margin-top: 5%;
}
</style>
<header>
	<ul>
		<li><a href="mainPage.do">Home</a></li>
		<li><a href="businessPage.do">사업장 관리</a></li>
		<li><a href="myAdPage.do">광고 관리</a></li>
		<li><a href="placeTotalPage.do">통계정보</a></li>
		<li><a href="customerForm.do" target="_blank">고객센터</a></li>
	</ul>
</header>