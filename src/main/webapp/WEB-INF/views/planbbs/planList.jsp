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
        .wrap{width: 100vw; height: 100vh;}
        .header{height: 100px; background-color:#999; overflow: hidden;}
        .header .logo{float: left; width: 200px; height: 100px; background-color: #888;}
        .header nav{float: right;}
        .header nav>ul{margin-right: 20px;}
        .header nav>ul>li{float: left;}
        .header nav>ul>li>a{font-size: 16px; padding: 10px; line-height: 100px; }

        .section{width: 100%; float: left; background-color: #777; height: calc( 100%); overflow: hidden;}
        
        /*.aside{width: 20%; float: left; background-color: #666; height: calc( 100%); overflow: hidden; }*/
        
        /*.footer{width: 100%; background-color: #555; height: 150px; overflow: hidden; bottom:0; position: fixed;}*/
    </style>
   <link rel="stylesheet" type="text/css" href="http://lne8372.cafe24.com/css/loginLayout.css">
<link rel="stylesheet" type="text/css" href="http://lne8372.cafe24.com/css/modalLayout.css">
<script src="http://lne8372.cafe24.com/js/ajaxScript.js"></script>
<script src="http://lne8372.cafe24.com/js/loginScript.js"></script>
</head>
<body>
<div class="modal_back" id="modal_back"></div>
<div class="modal" id="login_modal"></div>
    <div class="wrap">
        <div class="header">
            <h1 class="logo"></h1>
            <nav>
                <ul>
                    <li><a href="myPlanList.do">내플랜보기</a></li>
                    <li><a href="map/placeList.do">메뉴2</a></li>
                    <li><a href="map/planList.do">플랜리스트 테스트</a></li>
                    <li><a href="map/planSaveForm.do">플랜저장 테스트</a></li>
                    <li><label onclick="loginOn()">로그인</label>|<a href="userAgree.do">회원가입</a></li>
                </ul>
            </nav>
        </div>
        <div class="section">
       	<h3>플랜리스트입니다.</h3>
       	<ul>
       		<li><a href="planListForm.do?idx=12&p_idx=21&day=1&idx=${param.idx}">플랜1</a></li>
       	</ul>
        </div>
    </div>
</body>
</html>