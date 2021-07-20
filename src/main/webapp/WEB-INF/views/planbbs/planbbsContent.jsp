<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	margin: auto;
	border-spacing: 0 1vh;
}

body {
	padding-top: 9vh;
}

td {
	border-style: groov
}

.img {
	height: 9vw;
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
.commentImg {width: 3vw;}

input[type="checkbox"]+label {
	display: block;
	width: 24px;
	height: 24px;
	background: url('http://lne8372.cafe24.com/img/heart2.png') no-repeat 0
		0px/contain;
}

input[type='checkbox']:checked+label {
	background: url('http://lne8372.cafe24.com/img/heart.png') no-repeat 0
		1px/contain;
}

input[type="checkbox"] {
	display: none;
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
<script src="http://lne8372.cafe24.com/js/httpRequest.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
	function day(day) {

		var p_idx = document.getElementsByName("p_idx")[0].value;
		var bbs_idx = document.getElementsByName("bbs_idx")[0].value;
		params = 'p_idx=' + p_idx + '&day=' + day + '&bbs_idx=' + bbs_idx;
		sendXHR('day2.do', params, showResult, 'GET');
	}

	function showResult() {//응답

		if (XHR.readyState == 4) {

			if (XHR.status == 200) {
				var date = XHR.responseText.trim();
				var newDiv = document.getElementsByClassName("imgs")[0];
				newDiv.innerHTML = date;
			}
		}
	}

	function goodChange() {
		if (myCheck.checked == true) {
			var idx = document.getElementsByName("idx")[0].value;
			var bbs_idx = document.getElementsByName("bbs_idx")[0].value;
			var params = 'idx=' + idx + '&bbs_idx=' + bbs_idx;

			sendXHR('goodInsert.do', params, null, 'GET');
		} else {
			var idx = document.getElementsByName("idx")[0].value;
			var bbs_idx = document.getElementsByName("bbs_idx")[0].value;
			var params = 'idx=' + idx + '&bbs_idx=' + bbs_idx;
			sendXHR('goodDelete.do', params, null, 'GET');
		}
	}

	function pageChange(cp, day, bbs_idx) {

	}
</script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<c:import url="snsHeader.jsp"></c:import>
</head>
<body>
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
		<tr>
			<td class=writer colspan=2>
					<div>${param.plan_writer}</div>
				</td>
		</tr>
		<tr>
			<td colspan=2><div class="imgs">
					<c:forEach var="vo" items="${myplanContentList}">
						<img src="${vo.img}" class=img>
					</c:forEach>
					${pageStr}
				</div></td>
		</tr>
		<tr>
			<td colspan="2">
				${param.plan_content}
			</td>
		</tr>
		<tr>
			<td class=good colspan=2><input type="checkbox" id="myCheck"
				onclick="goodChange();" ${goodselect==true? 'checked':'' }>
				<label for="myCheck"></label>${count}명이 좋아합니다</td>
		</tr>
		<tr>
			<td colspan=2><c:if test="${!empty  myplanContentList}">
					<textarea rows="5" cols="90" class="text">${param.plan_content}</textarea>
				</c:if></td>
		<tr>

		</tr>
		<c:url var="commentUrl" value="planBbsComment.do">
			<c:param name="bbs_idx">${param.bbs_idx}</c:param>
		</c:url>
		<tr>
			<td colspan=2><a href="${commentUrl}"><input type=button
					class="addCommentBtn" hidden="1" /><img class="commentImg"
					src="http://lne8372.cafe24.com/img/comment.png"></a></td>
		</tr>
		<form action="planbbsDelete.do">
		<tr>
			
				<td><input type="button" value="수정하기" class=btns
					onclick="location.href='planModi.do?bbs_idx=${param.bbs_idx}&plan_content=${param.plan_content}&day=1&p_idx=${param.p_idx}'"></td>
				<td><input type="submit" value="삭제하기" class=btns style="float: right;"></td>
				
		</tr>
		<tr>
			<td><input type="hidden" name="p_idx" value="${param.p_idx}">
				<input type="hidden" name="bbs_idx" value="${param.bbs_idx}">
				<input type="hidden" name="idx" value="${param.idx}"></td>
		</tr>
		</form>
	</table>

</body>
</html>