<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
	$(document).ready(
			function() {

				$("#startDate").datepicker();
				$("#endDate").datepicker();

				// jQuery UI Datepicker 한글 변환
				$.datepicker.regional['ko'] = {
					closeText : "닫기",
					prevText : "",
					nextText : "",
					currentText : "오늘",
					monthNames : [ "1월", "2월", "3월", "4월", "5월", "6월", "7월",
							"8월", "9월", "10월", "11월", "12월" ],
					monthNamesShort : [ "1월", "2월", "3월", "4월", "5월", "6월",
							"7월", "8월", "9월", "10월", "11월", "12월" ],
					dayNames : [ "일", "월", "화", "수", "목", "금", "토" ],
					dayNamesShort : [ "일", "월", "화", "수", "목", "금", "토" ],
					dayNamesMin : [ "일", "월", "화", "수", "목", "금", "토" ],
					weekHeader : "Wk",
					dateFormat : "yymmdd",
					firstDay : 0,
					isRTL : false,
					showMonthAfterYear : true,
					changeMonth : true,
					changeYear : true,
					yearRange : 'c:c+100'

					,
					autoSize : true

					,
					beforeShow : function(input) {
						var position = $(input).position();
						setTimeout(function() {
							$("#ui-datepicker-div").css({
								"left" : position.left
							});
						})
					}
				};
				$.datepicker.setDefaults($.datepicker.regional['ko']);

			});
	
	$(function() {
	    //----- OPEN
	    $('[data-popup-open]').on('click', function(e)  {
	        var targeted_popup_class = jQuery(this).attr('data-popup-open');
	        $('[data-popup="' + targeted_popup_class + '"]').fadeIn(350);

	        e.preventDefault();
	    });

	    //----- CLOSE
	    $('[data-popup-close]').on('click', function(e)  {
	        var targeted_popup_class = jQuery(this).attr('data-popup-close');
	        $('[data-popup="' + targeted_popup_class + '"]').fadeOut(350);

	        e.preventDefault();
	    });
	});

</script>
<style type="text/css">
.cart {
	background-color: yellow;
	width: 100%;
}

.cart #cart1 {
	display: flex;
}

ul {
	list-style: none;
}

.tab li {
	float: left;
}

img {
	width: 100px;
}

.popup {
	display: none;
	position: fixed;
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
	background: rgba(0, 0, 0, 0.5);
}

.popup-inner {
	position: absolute;
	width: 50%;
	height: 50%;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	padding: 10px;
	background: #fff;
}

.popup-close {
	position: absolute;
	display: block;
	top: 10px;
	right: 10px;
}
</style>
<script src="js/httpRequest.js"></script>
<script>
	function day(day) {
		//객체값을 가져옴
		var pl_idx = document.getElementsByName("pl_idx")[0].value;
		var pl_name = document.getElementsByName("pl_name")[0].value;
		var pl_img = document.getElementsByName("pl_img")[0].value;

		params = 'pl_idx=' + pl_idx + '&pl_name=' + p_idx + '&pl_img=' + pl_img
				+ '&'${i}'day=' + ${i}day;
				
		sendXHR('cartDay.do', params, showResult, 'GET');
	}

	function showResult() {//응답함수 -> 실행되면 
		if (XHR.readyState == 4) {
			if (XHR.status == 200) {
				var date = XHR.responseText.trim();
				var newDiv = document.getElementsByClassName("tab_cont")[0];
				newDiv.innerHTML = date;
			}
		}
	}
	
</script>
<head>
</head>
<body>
	<!-- save-popup -->
	<main>
		<div class="popup" data-popup="example">
			<div class="popup-inner">
				<div class="popup-contents">
					<a class="popup-close" data-popup-close="example" href="#">X</a>
					<h5>저장하기</h5>
					<form name="planSave" action="planSavemsg.do" method="POST">
						<table>
							<tr>
								<th colspan="2">[${param.startday}~${param.lastday}]</th>
							</tr>
							<tr>
								<th>TITLE</th>
								<td><input type="text" name="p_name"></td>
							</tr>
							<tr>
								<th>MEMO</th>
								<td><textarea rows="10" cols="40" name="p_content"></textarea></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit"
									value="저장"> <input type="reset" value="다시작성"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>

	</main>

	<div class="cart">
		<div id="cart1">
		
		
			<form name="day" action="placeList.do" onsubmit="daysubmit();">
				<ul>
					<li><input type="text" name="startday" class="datePicker"
						id="startDate" placeholder="시작일자를 입력해주세요" value="" /></li>
					<li><input type="text" name="lastday" class="datePicker"
						id="endDate" placeholder="종료일자를 입력해주세요" value="" /><input
						type="submit" value="확인"></li>


					<li><input type="button" value="최단거리 최적화"></li>
					<li><input type="button" value="대중교통 최적화"></li>
				</ul>
			</form>










			<div class="cart-day">
			
				<c:if test="${empty resultdate}">
					<h4>장소를 선택하세요</h4>
				</c:if>
				
				<c:forEach var="key" begin="1" end="${resultdate}">
					<button class="day${key}" onclick="day();">${key}</button>
				</c:forEach>

				<c:forEach items="${placeCart}" var="list">
					<c:forEach items="${list}" var="map">
					${map}
					</c:forEach>	 
				</c:forEach>

			</div>

			<form action="/map/planSaveForm.do">
				<ul>
					<li><input type="submit" value="임시저장"></li>
					<li><a href="#" data-popup-open="example">저장하기</a></li>
					<li><input type="submit" name="reset" value="초기화"></li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>