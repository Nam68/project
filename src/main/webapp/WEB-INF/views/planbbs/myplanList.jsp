<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	margin: auto;
	border-spacing: 0 1vh;
}

body {
	padding-top: 9vh;
}

td {
	
}

.name {
	padding-bottom: 3vh;
	border-bottom-style: solid;
	border-color: #F5F5F7;
}

.img {
	height: 30vh;
}

.imgs {
	float: left;
	padding-bottom: 3vh;
}

.btns {
	height: 5vh;
	background-color: #FFE699;
	border: none;
	color: gray;
	font-weight: bolder;
}

.text {
	width: 100%;
}

.day :hover {
	background-color: #7FC9CB;
}

.day {
	background-color: #FFE699;
}

.day li {
	display: block;
	color: gray;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-weight: bolder;
}

.writer {
	background: #7FC9CB;
	color: white;
	height: 5vh;
	font-weight: bolder;
}

.good {
	padding-top: 2vh;
	padding-bottom: 2vh;
	border-top-style: solid;
	border-color: #F5F5F7;
}
</style>
<style>
.wrap {
	width: 100vw;
	height: 100vh;
}

.header {
	height: 100px;
	background-color: #999;
	overflow: hidden;
}

.header .logo {
	float: left;
	width: 200px;
	height: 100px;
	background-color: #888;
}

.header nav {
	float: right;
}

.header nav>ul {
	margin-right: 20px;
}

.header nav>ul>li {
	float: left;
}

.header nav>ul>li>a {
	font-size: 16px;
	padding: 10px;
	line-height: 100px;
}

.section {
	width: 100%;
	float: left;
	background-color: #777;
	height: calc(100%);
	overflow: hidden;
}

.tabPannel {
	position: relative;
	background-color: #fff;
	width: 775px;
	margin: auto
}

.tab_title {
	width: 100%;
	margin: auto;
}

.tab_title li {
	float: left;
	width: 100px;
	padding: 5px;
	cursor: pointer;
	text-align: center;;
	font-size: 16px;
	font-weight: 100;
	transition: 0.4s;
	border: 1px solid black;
	margin: 5px;
}

.tab_title li:hover {
	background-color: #999;
}

/*.tab_cont {
          clear: both;
          height: 800px;
          width:700px;
          border: 1px solid black;
          background-color: #777;
      }

        .tab_cont div {
          display: none;
          text-align: center;
        }*/

/*.aside{width: 20%; float: left; background-color: #666; height: calc( 100%); overflow: hidden; }*/

/*.footer{width: 100%; background-color: #555; height: 150px; overflow: hidden; bottom:0; position: fixed;}*/
</style>
</head>
<script src="http://lne8372.cafe24.com/js/httpRequest.js"></script>
<script>
	function day(day) {
		var idx = document.getElementsByName("idx")[0].value;
		var p_idx = document.getElementsByName("p_idx")[0].value;

		params = 'idx=' + idx + '&p_idx=' + p_idx + '&day=' + day;

		sendXHR('myplanListViewResult.do', params, showResult, 'GET');
	}

	function showResult() {//응답

		if (XHR.readyState == 4) {

			if (XHR.status == 200) {
				var date = XHR.responseText.trim();
				var newDiv = document.getElementsByClassName("tab_cont")[0];
				newDiv.innerHTML = date;
			}
		}
	}
</script>
<body>
	<c:import url="snsHeader.jsp"></c:import>
	<table>
		<tr>
			<td class=day><c:if test="${days == 1}">
					<li onclick="day(1)">day1</li>
				</c:if> <c:if test="${days == 2}">
					<li onclick="day(1)">day1</li>
					<li onclick="day(2)">day2</li>
				</c:if> <c:if test="${days == 3}">
					<li onclick="day(1)">day1</li>
					<li onclick="day(2)">day2</li>
					<li onclick="day(3)">day3</li>
				</c:if> <c:if test="${days == 4}">
					<li onclick="day(1)">day1</li>
					<li onclick="day(2)">day2</li>
					<li onclick="day(3)">day3</li>
					<li onclick="day(4)">day4</li>
				</c:if> <c:if test="${days == 5}">
					<li onclick="day(1)">day1</li>
					<li onclick="day(2)">day2</li>
					<li onclick="day(3)">day3</li>
					<li onclick="day(4)">day4</li>
					<li onclick="day(5)">day5</li>
				</c:if> <c:if test="${days == 6}">
					<li onclick="day(1)">day1</li>
					<li onclick="day(2)">day2</li>
					<li onclick="day(3)">day3</li>
					<li onclick="day(4)">day4</li>
					<li onclick="day(5)">day5</li>
					<li onclick="day(6)">day6</li>
				</c:if> <c:if test="${days == 7}">
					<li onclick="day(1)">day1</li>
					<li onclick="day(2)">day2</li>
					<li onclick="day(3)">day3</li>
					<li onclick="day(4)">day4</li>
					<li onclick="day(5)">day5</li>
					<li onclick="day(6)">day6</li>
					<li onclick="day(7)">day7</li>
				</c:if></td>
		</tr>
	</table>
	<table>
		<div class="tab_cont">
		<tr>
			<td><input type="hidden" name="idx" value='${param.idx}'>
				<input type="hidden" name=p_idx value='${param.p_idx}'></td>
		</tr>

		<c:forEach var="myplanList" items="${myplanList}">
			<div class=imgs>
			<tr>
				<td><img src="${myplanList.img}" class=img></td>
			</tr>
			<tr>
				<td class="name">${myplanList.pl_name}</td>
			</tr>
			</div>
		</c:forEach>
		</div>
	</table>
</body>
</html>