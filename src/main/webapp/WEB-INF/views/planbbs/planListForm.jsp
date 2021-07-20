<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/reset.css">
    <title>1조 프로젝트</title>
    <style>
    
li:hover{cursor: pointer;}
body {
	padding-top: 9vh;
}

table {
	margin: auto;
}

.menu {
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
li a :hover {
	background-color: #FFE699;
}

.active {
	background-color: #FFE699;
	float: right;
	color: black;
}

.day :hover {
	background-color: #7FC9CB;
}

.day {
	background-color: #FFE699;
	margin: 0px auto;
	text-align: center;
}

.day li {
	display: block;
	color: gray;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-weight: bolder;
}

.tablewrap {
	text-align: center;
}
.planbbsSave{
	background-color: #FFE699;
	border: none;
}
</style>
   <link rel="stylesheet" type="text/css" href="http://lne8372.cafe24.com/css/loginLayout.css">
<link rel="stylesheet" type="text/css" href="http://lne8372.cafe24.com/css/modalLayout.css">
<script src="http://lne8372.cafe24.com/js/ajaxScript.js"></script>
<script src="http://lne8372.cafe24.com/js/loginScript.js"></script>
<script src="js/httpRequest.js"></script>
<script>
function day(day){
	var p_idx=document.getElementsByName("p_idx")[0].value;

	params='p_idx='+p_idx+'&day='+day;
	sendXHR('day.do',params,showResult,'GET');
}

function showResult(){//응답
	
	if(XHR.readyState==4){
		
		if(XHR.status==200){
			var date=XHR.responseText.trim();
			var newDiv=document.getElementsByClassName("tab_cont")[0];
			newDiv.innerHTML=date;
		}
	}
}


function pageChange(cp, day, p_idx) {
	params='cp='+cp+'&p_idx='+p_idx+'&day='+day;
	sendXHR('day.do',params,showResult,'GET');
}

function planInfoImgChange() {
	if(!window.confirm('이미지를 변경하시겠습니까?')) {
		planInfoImgchange.value = '';
		event.preventDefault();
		return;
	} else {
		const form = document.fileUpload1;
		let p_idx = form.p_idx.value;
		let pl_idx = form.pl_idx.value;
		let dayInfo = form.day.value;
		
		var file = planInfoImgchange.files[0];
		var formdata = new FormData();
		
		formdata.append('file', file);
		formdata.append('path', imgchange.src);
		formdata.append('p_idx', p_idx);
		formdata.append('pl_idx', pl_idx);
		formdata.append('day', dayInfo);
		
		formdata.processData = false;
	    formdata.contentType = false;
	    
	    sendXHRwithFile('planBbsImgChange.do', formdata, function() {
	    	if(XHR.readyState == 4) {
	    		if(XHR.status == 200) {
	    			let data = XHR.responseText;
	    			imgchange.src = data;
	    		}
	    	}
	    });
	}
}
</script>
</head>
<body>
<div class="modal_back" id="modal_back"></div>
<div class="modal" id="login_modal"></div>
<%@ include file="snsHeader.jsp" %>
<div class="tablewrap">
        <div class="section">
      	<div class="tabPannel">
      	<table>
      	<tr>
			<td class="day">
                <c:if test="${days == 1}">
                <li onclick="day(1)">day1</li>
                </c:if>
                <c:if test="${days == 2}">
                <li onclick="day(1)">day1</li>
                 <li onclick="day(2)">day2</li>
                </c:if>
                <c:if test="${days == 3}">
                 <li onclick="day(1)">day1</li>
                 <li onclick="day(2)">day2</li>
                 <li onclick="day(3)">day3</li>
                </c:if>
                <c:if test="${days == 4}">
               	 <li onclick="day(1)">day1</li>
                 <li onclick="day(2)">day2</li>
                 <li onclick="day(3)">day3</li>
                 <li onclick="day(4)">day4</li>
                </c:if>
                <c:if test="${days == 5}">
                 <li onclick="day(1)">day1</li>
                 <li onclick="day(2)">day2</li>
                 <li onclick="day(3)">day3</li>
                 <li onclick="day(4)">day4</li>
                 <li onclick="day(5)">day5</li>
                </c:if>
                <c:if test="${days == 6}">
                 <li onclick="day(1)">day1</li>
                 <li onclick="day(2)">day2</li>
                 <li onclick="day(3)">day3</li>
                 <li onclick="day(4)">day4</li>
                 <li onclick="day(5)">day5</li>
                 <li onclick="day(6)">day6</li>
                </c:if>
                <c:if test="${days == 7}">
                 <li onclick="day(1)">day1</li>
                 <li onclick="day(2)">day2</li>
                 <li onclick="day(3)">day3</li>
                 <li onclick="day(4)">day4</li>
                 <li onclick="day(5)">day5</li>
                 <li onclick="day(6)">day6</li>
                 <li onclick="day(7)">day7</li>
                </c:if>
           <br><br>
            </td>
            </tr>
            </table>
            <input type="hidden" name=p_idx value='${p_idx}'>
            <div class="tab_cont">
       
       		


       
       
            </div>
            <div class="tab_sub">
            <br><br><br>
             <form name="planBbsInsert" action="planBbsInsert.do">
            <input type="hidden" name=p_idx value='${p_idx}'>
            <c:forEach var="planList" items="${planList}">
            <input type="hidden" name="plan_writer" value="${planList.id}">
             <input type="hidden" name="plan_title" value="${planList.p_name}">
             <textarea rows="10" cols="90" name="plan_content">${planList.p_content}</textarea>
            </c:forEach>
            <input type="submit" value="Tripstagram 공유">
            
            </form>
            </div>
            
           
</div>
        </div>
    </div>
</body>
</html>