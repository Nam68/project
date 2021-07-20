<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
.con{
	width: 800px;
	margin: 0px auto;
	height: 500px;
	padding: 10px;
}
.con h2{
	text-align: center;
	margin-top: 20px;
	margin-bottom: 20px;
}
.con .sel{
	margin-top: 50px;
	width: 640px;
	height: 400px;
	display: flex;
	justify-content: space-around;
	align-items: center;
	margin-left: 80px;
}
.sign_user{
	width: 218px;
	height: 218px;
	background-image: url(../img/character/customer.png);
	background-repeat: no-repeat;
	background-position: 100%;
}
.sign_ceo{
	width: 218px;
	height: 218px;
	background-image: url(../img/character/owner.png);
	background-repeat: no-repeat;
	background-position: 100%;
}
.sel a{
	text-decoration: none;
	color: black;
	border: 1px solid #bebebe;
	padding: 20px;
}
.sel h3{
	margin: 0px;
	text-align: center;
}
</style>
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
	<div class="con">
		<div class="title"><h2>회원가입</h2></div>
		<div class="sel">
			<a href="signup.do?type=2"><h3>일반 회원가입</h3><div class="sign_user"></div></a>
			<a href="signup.do?type=3"><h3>사장님 회원가입</h3><div class="sign_ceo"></div></a>
		</div>
	</div>
	
</body>
</html>