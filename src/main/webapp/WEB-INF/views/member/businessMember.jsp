<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="/semi/css/mainLayout.css">
<style>
       .header{height: 100px; background-color:#7fc9cb; overflow: hidden;}
        .header .logo{float: left; width: 200px; height: 100px; background-color: #fee599; text-align: center;}
        .header nav{float: left; }
        .header nav>ul{margin-right: 20px; list-style: none;margin: 0;padding: 0; overflow: hidden;}
        .header nav>ul>li{float: left; padding: 14px 16px;}
        .header nav>ul>li:hover {background-color: lightgray; opacity: 0.7 }
        .header nav>ul>li>a{font-size: 16px; padding: 14px 16px; line-height: 100px; text-align: center; text-decoration: none;font-weight: 500;color:black;}
		.header nav>ul>li>a:hover{color:red; cursor: pointer;}
section{
	display: flex;
	justify-content: center;
}
article{
	height: auto;
	width: 860px;
}
h2{
	margin-top: 100px;
	margin-bottom: 70px;
	text-align: center;
}
h4{
	margin: 0px;
	margin-top: 30px;
}
h6{
	margin: 0px;
	margin-top: 5px;
	color: red;
}
.ul{
	width: 860px;
	list-style: none;
	padding: 0px;
	margin-left: 176px;
}
input[type=text]{
	width: 500px;
	height: 34px;
	border: none;
	border-bottom: 2px solid black;
	margin-right: 10px;
	margin-top: 5px;
	background-color: #fafafa;
	outline: none;
}
input[type=password]{
	width: 500px;
	height: 34px;
	border: none;
	border-bottom: 2px solid black;
	margin-right: 10px;
	margin-top: 5px;
	background-color: #fafafa;
	outline: none;
}
li input[type=button] {
	width: 80px;
	height: 36px;
	background-color: #464646;
	border: none;
	border-radius: 5px;
	color: white;
	padding-top: 3px;
	outline: none;
}
input[type=submit]{
	width: 508px;
	height: 38px;
	padding: 0px;
	background-color: #464646;
	border: none;
	border-radius: 5px;
	color: white;
	margin-top: 10px;
	margin-bottom: 20px;
	margin-left: 176px;
}
strong{
	color: #DF534C;
}
</style>
<script>
	
	function kjh_telCheck() {
		var tv = document.getElementById('tel').value;
		var hre = 'tel.jsp?tel='+tv;
		window.open(hre, 'telCheck', 'width=330px, height=250px, top=170px, left=520px');
	}
	
	function kjh_checkPw() {
		var pw = document.getElementById('pw').value;
		
		if(pw.length<8 || pw.length>16) {
			window.alert('비밀번호는 8글자 이상, 16글자 이하만 사용 가능합니다.');
		}
		if(document.getElementById('pw').value!='' && document.getElementById('pw2').value!='') {
			if(document.getElementById('pw').value==document.getElementById('pw2').value) {
				document.getElementById('check').innerHTML = '비밀번호가 일치합니다.';
				document.getElementById('check').style.color = 'green';
			} else {
				document.getElementById('check').innerHTML = '비밀번호가 일치하지 않습니다.';
				document.getElementById('check').style.color = 'red';
			}
		}
	}
</script>
</head>
<body>
	<div class="header">
            <nav>
                <ul>
                <!--<li><a href="goMyPage.do">마이페이지</a></li>-->  
                    <li><a onclick="snsOpen()">TRIP SNS</a></li>
                    <li><a href="customerForm.do" target="_blank">고객센터</a></li>
                </ul>
            </nav>
        </div>

	<section>
		<article>
			<h2>회 원 가 입</h2>
			<form name="memberOk" method="post" action="memberOk.do">
				<ul class="ul">
					<li><h4>ID <strong>&#42;</strong></h4><input type="text" name="id"></li>
					<li><h4>비밀번호 <strong>&#42;</strong></h4><input type="password" id="pw" name="pwd" onchange="checkPw()"><h6>비밀번호는 8글자에서 16글자 사이로 입력해 주세요 *</h6></li>
					<li><h4>비밀번호 확인 <strong>&#42;</strong></h4><input type="password" id="pw2" name="pwd2" onchange="kjh_checkPw()"><span id="check"></span></li>
					<li><h4>이름 <strong>&#42;</strong></h4><input type="text" name="name"></li>
					
					<li><h4>계좌번호 <strong>&#42;</strong></h4><input type="text" id="nick" name="account" ></li>
					<li><h4>주소 <strong>&#42;</strong></h4><input type="text" id="nick" name="addr" ></li>
					<li>
  						<h4>연락처 <strong>&#42;</strong></h4><input type="text" name="tel" id="tel">
  						<h6>' - ' 빼고 입력해 주세요 *</h6>
  					</li>
					<li><h4>질문 <strong>&#42;</strong></h4><select name="question">
					<c:forEach var="con" items="${question}">
					<option value="${con.q_idx }">${con.q_content }</option>
					</c:forEach>
					</select></li>
					<li><h4>답변 <strong>&#42;</strong></h4><input type="text" name="answer"></li>
					
				</ul>
				<input type="hidden" name="groupidx" value="3">
				<input type="submit" value="가입하기">
			</form>
		</article>
	</section>
	
	
</body>
</html>