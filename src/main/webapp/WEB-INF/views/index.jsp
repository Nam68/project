<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="http://lne8372.cafe24.com/js/ajaxScript.js"></script>
    <link rel="stylesheet" type="text/css" href="http://lne8372.cafe24.com/css/loginLayout.css">
	<link rel="stylesheet" type="text/css" href="http://lne8372.cafe24.com/css/modalLayout.css">
    <link rel="stylesheet" href="reset.css">
    
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <title>1조 프로젝트</title>
    <style>
         .wrap{width: 100vw; height: 100vh;}
        .header{height: 100px; background-color:#7fc9cb; overflow: hidden;}
        .header .logo{float: left; width: 200px; height: 100px; background-color: #fee599; text-align: center;}
        .header nav{float: right;}
        .header nav>ul{margin-right: 20px; list-style: none;margin: 0;padding: 0; overflow: hidden;}
        .header nav>ul>li{float: left; padding: 14px 16px;}
        .header nav>ul>li:hover {background-color: lightgray; opacity: 0.7 }
        .header nav>ul>li>a{font-size: 16px; padding: 14px 16px; line-height: 100px; text-align: center; text-decoration: none;font-weight: 500;color:black;}
		.header nav>ul>li>a:hover{color:red;}
		
        .section{width: 80%; float: left; background-color: #777; height: calc( 100% - 250px); overflow: hidden;}
        
        .aside{width: 20%; float: left; background-color:#b3d1ffe8;  height: calc( 100% - 250px); overflow: auto; }
        
        .footer{width: 100%; background-color: #7fc9cb; height: 150px; overflow: hidden; margin:0 auto;}
        
        li{list-style-type: none;}
        
        /* 왼쪽 여행지 리스트 관련 CSS */
        .placeItem {margin: 5%; z-index: 10; }
        .placeItem:hover {opacity: 0.3; }
        .placeItemImg {width: 45%; display: inline-block; padding: 5px; vertical-align: middle; z-index: 10; }
        .placeItemImg img {width: 100%; max-height: 10vh; z-index: 10;}
        .placeItemButton {display: inline-block; z-index: 10;}
        
        /* 여행지 리스트 자세히 보기 CSS */
        .placeInfo {width: 0; top: 100px; right: 18.5%; z-index: 8; border-radius:12px;  position: absolute; background-color: #ffffffaa; height: calc( 100% - 225px); overflow:auto; transition: all 0.5s; }
        .placeInfo>span {position: absolute; top: 50%; left: 1%; }
        .placeInfo>div {width: 80%; margin: 5% auto; text-align: center;}
        .pl_img{width: 100%; height: 100%;padding-top: 80px;}
        .placeItemTitle{margin-bottom: 5px;}
        .placeImgs {width: 90%; height: 100%;margin: 5px auto;}
        .placeInfoImg {width: 15vw; height: 15vw; margin-top: 50px; }
        .placeInfoImgPageButton>div {display: inline-block; background-color: #777; margin-right: 6px; width: 10px; height: 10px; border-radius: 50%;}
        .placeInfoStar, .placeInfoLike {display: inline-block; }
        .placeInfoLikeBtn:hover {cursor: pointer;}
        .placeInfoStar>div, .placeInfoLike>div {display: inline-block; }
        .placeInfoCart {background-color:#7fc9cb; width: 50%; padding: 3%; margin: 5% auto; border-radius: 4px; font-size: 1vw; }
        .placeInfoCart:hover{cursor: pointer;}
        .like_btn {width: 2vw; }
        .placeItemAdd{background-color: #fee599; width: 3vw;border-radius: 4px;text-align: center; margin-top: 5px;}
        .placeItemAdd:hover {background-color: white; text-align: center;}
        .placeInfoCloseButton:hover{cursor: pointer;}
        .placeInfoReviewWrite:hover{cursor: pointer;}
        
        /*login*/
        .loginbtn{background-color:#FA8072; width: 5vw; margin-bottom: 5px;}
        
        /* 검색창 관련 CSS */
        .placeSearchResult {width: 13.8vw; height:23vh; position: absolute; top:14.4vh; right:2.3vw; background-color: white; display: none;}
        .searchResultText:hover {background-color: #AAA;}
        #placeSearchTextfield {width: 70%; border: none; margin-left: 50px; margin-top: 10px;border-radius: 4px;}
        
        /* 장바구니 관련 CSS */
        .cartItemDiv {width: 10%; display: inline-block; }
        .cartItemDiv>img {height: 8vh; overflow: hidden;}
        .dayButton{background: #b3d1ff;}/*day tab버튼 감싸는 뒷배경*/
		.daylibtn{float:left; padding-top: 20px;}
		.daylibtn.one { height: 100%;} /*버튼들을 감싸고 있는 div (최단거리쪽)*/
		.daylibtn.two {float:right;  width: 7vw; height:100%; padding-right: 100px;}/*버튼들을 감싸고 있는 div (저장하기)*/
		.cart-day{float:left;  width: 70vw; text-align: center;}/*카트 아이템 담기는 공간*/
		
		/*daySelect 버튼 (확인, 저장하기, 초기화)*/
		.cartbtn{border-radius: 4px; border: none;}
		#dayOk{background-color: #fee599;width: 10vw; margin-left: 7px; margin-top: 5px;}
		#daySave{background-color: 	#FA8072; width: 5vw; margin-bottom: 5px;}
		#dayReset{background-color: #FA8072; padding: 1px 6px; width: 5vw;}
		#short{background-color: #FA8072; padding: 1px 6px; width: 10vw; margin-left: 6.5px; margin-top: 5px;}
        #dayOk:hover{background-color: white; border:#fee599 solid 0.5px;}
        #daySave:hover{background-color: white; border:#FA8072 solid 1px;}
        #dayReset:hover{background-color: white; border:#FA8072 solid 1px;}
        #short:hover{background-color: white; border:#FA8072 solid 1px;}
        
        .datePicker{border-radius: 5px; border: none;}
        
        /*저장하기 popup*/
        .popup {display: none; position: fixed; width: 100%; height: 100%; top: 0; left: 0; background: rgba(0, 0, 0, 0.5); }
		.popup-inner { border:#fee599 double 2px; position: absolute; width: 30vw; height: 20vw; top: 50%; left: 50%; transform: translate(-50%, -50%); padding: 10px; background: #fff;border-radius: 12px; }
		#memobtn{background-color: #fee599}
		.popup-contents{margin-bottom: 20px; padding-left: 10px; }
		.popup-close {position: absolute; display: block; top: 10px; right: 10px; text-decoration: none; }
		.saveTitle{padding-left: 50px; }
		
        /* 맵 관련 CSS */
        #map {}
        
        /* 리뷰 관련 CSS */
        #review_modal {width: 20vw; height: 50vh; top: 25vh; left: 40vw; text-align: center;}
        #review_modal>h4 {font-size: 2.5vw;}
        .reviewBody{border: 1px solid black; overflow: auto; width: 90%; margin: 3% auto; padding: 3%; border-radius: 0.5vw;}
        .reviewContent>div{display: inline-block;}
        .reviewContent{position: relative; text-align: left; margin-left: 2%; margin-right: 2%;}
    </style>
    <!-- 윈도우창 닫기 관련 스크립트 -->
    <script>
	    window.onbeforeunload = function(event) {
	    	window.alert('hi');
	    	sendXHR('saveFavorite.do', null, null, 'GET');
	    	return '';
	    }
    </script>
    
    <!-- 로그인 코드 -->
    <script>
    	let loginCheck = 0;
		let loginIdx = ${empty sessionScope.memberDTO? 0:sessionScope.memberDTO.idx};
	    function loginOn() {
	    	modal_back.style.display = 'block';
	    	login_modal.style.display = 'block';
	    	
	    	login_modal.innerHTML = 
	    		'<span class="modal_close" onclick="loginOff()">X</span>'+
	    		'<div>'+
	    			'<div>Log in</div>'+
	    			'<div>id : <input type="text" id="loginId"></div>'+
	    			'<div>pwd : <input type="password" id="loginPwd"></div>'+
	    			'<div>'+
	    			'<div><input type="button" value="OK" onclick="loginSubmit()"></div>'+
	    			'<div><input type="button" value="Cancel" onclick="loginCancel()"></div>'+
	    			'</div>'+
	    		'</div>';
	    }
	    function loginOff() {
	    	modal_back.style.display = 'none';
	    	login_modal.style.display = 'none';
	    	login_modal.innerHTML = '';
	    }
	    function loginSubmit() {
	    	let params = 'id='+loginId.value+'&pwd='+loginPwd.value;
	    	sendXHR('mainLoginSubmit.do', params, loginSubmitResult, 'POST');
	    }
	    function loginSubmitResult() {
	    	if(XHR.readyState == 4) {
	    		if(XHR.status == 200) {
	    			let data = JSON.parse(XHR.responseText);
	    			window.alert(data.msg);
	    			
	    			//로그인 정보
	    			loginCheck = data.idx;
	    			loginIdx = data.idx;
	    			
	    			const loginSection = document.getElementsByClassName('loginDiv')[0];
	    			
	    			//열려 있던 장소 정보창 닫기
	    			const infoPannel = document.getElementsByClassName('placeInfo')[0];
	    			infoPannel.style.width = '0';
	    			
	    			loginCancel();
	    		}
	    	}
	    }
	    function loginCancel() {
	    	loginOff();
	    	loginId.value = '';
	    	loginPwd.value = '';
	    }
    </script>
    
    <!-- 로그아웃 스크립트 -->
	<script>
		function logoutSubmit() {
			if(window.confirm('로그아웃 하시겠습니까?')) {
				sendXHR('logoutSubmit.do', null, logoutResult, 'GET');
			}
		}
		function logoutResult() {
			if(XHR.readyState == 4) {
				if(XHR.status == 200) {
					window.alert(XHR.responseText);
					location.reload();
				}
			}
		}
	</script>
    
    <!-- 왼쪽 정보창에 대한 스크립트 -->
    <script>
    	let placeJson;
    
    	window.onload = function() {
    		const tempItem = document.getElementsByClassName('placeItem');
    		for(var i in tempItem) {
    			tempItem[i].addEventListener('click', itemCallback);
    			tempItem[i].myParam = tempItem[i].getElementsByTagName('input')[0].value;
    		}
    	}
    	function itemCallback(evt) {
    		let params = 'pl_idx='+evt.currentTarget.myParam;
    		const infoPannel = document.getElementsByClassName('placeInfo')[0];
    		infoPannel.style.width = '20%';
    		
    		sendXHR('openPlaceInfo.do', params, openPlaceInfo, 'GET');
    	}
    	function openPlaceInfo() {
    		if(XHR.readyState == 4) {
    			if(XHR.status == 200) {
    				placeJson = JSON.parse(XHR.responseText);
    				moveMap(placeJson.imgList[0].pl_lat, placeJson.imgList[0].pl_lng);
    				inputJsonValue();
    			}
    		}
    	}
    	function inputJsonValue() {
    		const placeName = document.getElementsByClassName('placeInfoTitle')[0];
    		placeName.innerHTML = placeJson.imgList[0].pl_name;
    		
    		const placeImg = document.getElementsByClassName('placeInfoImg')[0].getElementsByTagName('img')[0];
    		placeImg.src = placeJson.imgList[0].pl_img;
    		
    		const placePage = document.getElementsByClassName('placeInfoImgPageButton')[0];
    		let pagingBtn = '';
    		for(var i in placeJson.imgList) {
    			 pagingBtn += '<div class="placeInfoImgPageNumber" onclick="imgPaging('+i+')"></div>'; 
    		}
    		placePage.innerHTML = pagingBtn;
    		
    		const placeContent = document.getElementsByClassName('placeInfoContent')[0];
    		placeContent.innerHTML = placeJson.imgList[0].pl_content;
    		
    		const placeStar = document.getElementsByClassName('placeInfoStar')[0].getElementsByTagName('div')[1];
    		placeStar.innerHTML = placeJson.imgList[0].pl_star;
    		
    		
    		const placeLikeBtn = document.getElementsByClassName('placeInfoLikeBtn')[0];
    		if(placeJson.imgList[0].user_like > 0) {
    			placeLikeBtn.innerHTML = like_pushed;
    		} else {
    			placeLikeBtn.innerHTML = like_yet;
    		}
    		placeLikeBtn.addEventListener('click', likeToggle);
    		placeLikeBtn.myParam = placeJson.imgList[0].pl_idx;
    		
    		
    		const placeLike = document.getElementsByClassName('placeInfoLike')[0].getElementsByTagName('div')[1];
    		placeLike.innerHTML = placeJson.imgList[0].pl_like;
			
    		const placeReview = document.getElementsByClassName('placeInfoReview')[0];
    		if(placeJson.imgList[0].review == null) {
    			placeReview.innerHTML = '등록된 리뷰가 없습니다';
    		} else {
    			placeReview.innerHTML = placeJson.imgList[0].review;	
    		}
    		
    		const placeInfoOff = document.getElementsByClassName('placeInfoCloseButton')[0];
    		placeInfoOff.addEventListener('click', function() {
    			const infoPannel = document.getElementsByClassName('placeInfo')[0];
        		infoPannel.style.width = '0';
    		});
    		
    		const placeCart = document.getElementsByClassName('placeInfoCart')[0];
    	}
    	function imgPaging(ip) {
    		const placeImg = document.getElementsByClassName('placeInfoImg')[0].getElementsByTagName('img')[0];
    		placeImg.src = placeJson.imgList[ip].pl_img;
    		
    	}
    </script>
    
    <!-- 좋아요 관련 스크립트 -->
    <script>
    	let like_pushed = '<img alt="like" src="http://lne8372.cafe24.com/img/heart.png" class="like_btn">';
    	let like_yet = '<img alt="like" src="http://lne8372.cafe24.com/img/heart2.png" class="like_btn">';
    	function likeToggle(evt) {
    		const placeLikeBtn = document.getElementsByClassName('placeInfoLikeBtn')[0];
    		let likeInfo = placeLikeBtn.innerHTML;
    		if(likeInfo == like_pushed) {
    			placeLikeBtn.innerHTML = like_yet;
    			let params = 'pl_idx='+evt.currentTarget.myParam+'&idx='+loginIdx;
	    		sendXHR('likeDelete.do', params, likeToggleResult, 'GET');
    		} else {
    			if(loginIdx == 0 && loginCheck == 0) {
    				window.alert('로그인 후 이용 가능합니다');
    				return;
    			} else {
    				placeLikeBtn.innerHTML = like_pushed;
    				let params = 'pl_idx='+evt.currentTarget.myParam+'&idx='+loginIdx;
    	    		sendXHR('likeAdd.do', params, likeToggleResult, 'GET');
    			}
    		}
    	}
    	function likeToggleResult() {
    		if(XHR.readyState == 4) {
				if(XHR.status == 200) {
					let data = XHR.responseText;
					const placeLike = document.getElementsByClassName('placeInfoLike')[0].getElementsByTagName('div')[1];
		    		placeLike.innerHTML = data;
				}
			}
    	}
    </script>
    
    <!-- 검색에 대한 스크립트 -->
    <script>
    	function onSearchResultOn(search) {
    		if(event.keyCode == 13) { //엔터는 13
    			location.href='placeSearchText.do?keyValue='+search.value;
    		} else if(search.value == '') { 
    			const searchResultWindow = document.getElementsByClassName('placeSearchResult')[0];
        		searchResultWindow.style.display = 'none';
    		} else {
    			sendXHR('placeFastSeach.do', 'keyValue='+search.value, searchResult, 'GET');	
    		}
    	}
    	function searchResult() { //keydown 이벤트 반응
    		if(XHR.readyState == 4) {
    			if(XHR.status == 200) {
    				let data = JSON.parse(XHR.responseText);
    				searchResultShow(data);
    			}
    		}
    	}
    	function searchResultShow(data) { //가져온 결과를 사용자에게 보여주는 메서드
    		if(data.length == 0) {
    			return;
    		}
    		const searchResultWindow = document.getElementsByClassName('placeSearchResult')[0];
    		searchResultWindow.style.display = 'block';
    		let searchText = '';
    		for(var temp in data) {
    			searchText +=  
    				'<div class="searchResultText" onclick="searchForClick(\''+data[temp].pl_idx+'\')">'+
    					data[temp].pl_name+
    				'</div>';
    		}
    		searchResultWindow.innerHTML = searchText;
    	}
    	function searchForClick(pl_idx) { //검색 결과를 클릭하면 발생
    		location.href='placeSearchIdx.do?pl_idx='+pl_idx;
    	}
    </script>
    
    <!-- 맵에 관련된 스크립트 -->
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBPg6sDuTdTWAWj17NeU9JkTVNEs3gJfIU&callback=initMap&libraries=&v=weekly&libraries=places&region=KR"
      async
    ></script>
    <script>
    	let map;
    	function initMap() {
    		map = new google.maps.Map(document.getElementById("map"), {
    		    center: { lat: 33.361, lng: 126.529 },
    			zoom: 11,
    		});
    	}
    	function moveMap(pl_lat, pl_lng) {
    		var target = { lat: pl_lat, lng: pl_lng };
    		map = new google.maps.Map(document.getElementById("map"), {
    		    center: target,
    			zoom: 14
    		});
    		
    		marker = new google.maps.Marker({
    			map: map,
    			animation: google.maps.Animation.BOUNCE,
    			position: target
    		});
    	}
    </script>
       
     <!-- 거리별 재배치 -->
    <script>	
	  	const labels = "123456789";
	  	let labelIndex = 0;
	  	function pathMake(son) {
	  		
	  		  const myLatLng = { lat: 33.37820509181021, lng: 126.56475596411839 };
	  		  const map = new google.maps.Map(document.getElementById("map"), {
	  		    zoom: 10,
	  		    center: myLatLng,
	  		  });
	  		  
	  		  
	  		  var locations = [];
	
	  		  for(var i=0;i<son.length;i++){
	  		  	locations.push([son[i].pl_idx, son[i].pl_lat, son[i].pl_lng]);
	  		  	//window.alert(locations[0][i]);
	  		  }
	  		  
	  		  var infowindow = new google.maps.InfoWindow();
	  		  var marker, i;
	  		  
	  		for(var i=0;i<locations.length;i++) {  
	  			marker = new google.maps.Marker({
	  					position: new google.maps.LatLng(locations[i][1], locations[i][2]),
	  					label: labels[labelIndex++ % labels.length],
	  					map: map
	  			});
	  		}
	  		
	  		var lineSymbol = {
	  				  path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW
	  				};
	  		for(var i=0;i<locations.length-1;i++){
	  			var line = new google.maps.Polyline({
	  				  path: [{lat: locations[i][1], lng: locations[i][2]}, {lat: locations[i+1][1], lng: locations[i+1][2]}],
	  				  icons: [{
	  				    icon: lineSymbol,
	  				    offset: '100%'
	  				  }],
	  				  map: map
	  				});
	  		}
	  		
	  	}
    	function calculateDistance() {
    		let params = 'day='+totalDate;
    		sendXHR('calculateDistance.do', params, calculateDistanceResult, 'GET');
    	}
		function calculateDistanceResult() {
			if(XHR.readyState == 4) {
				if(XHR.status == 200) {
					let data = JSON.parse(XHR.responseText);
					let cartData = data.placeCart;
					let mapCost = data.mapcost;
					
					
					
					
					
					
					//mapCost를 이어붙일 것!!
					
					
					
					
					
					
					
					let cartDiv = ''; 
					for(var i = 0; i < cartData.length; i++) {
						let tempText = 
							'<div class="cartItemDiv">'+
								'<span onclick="deletePlace('+cartData[i].pl_idx+')">X</span>'+
								'<input type="hidden" name="cartPl_idx" value="'+cartData[i].pl_idx+'">'+
								'<div>'+cartData[i].pl_name+'</div>'+
								'<img alt="placeImg" src="'+cartData[i].pl_img+'">'+
							'</div>';
						cartDiv += tempText;	
					}
						
					const cartday = document.getElementsByClassName('cart-day')[0];
					cartday.innerHTML = cartDiv;
					
					pathMake(cartData);
				}
			}
		}
    </script>
    
   <!-- 카트 관련된 스크립트 -->
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
					dateFormat : "yy-mm-dd",
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
	        if(loginIdx == 0 && loginCheck == 0) {
	        	window.alert('로그인 후 사용 가능합니다');
	        	return;
	        }
	        
	    	const placeHidden = document.getElementsByName('cartPl_idx');
	        if(placeHidden == null || placeHidden.length == 0) {
	        	window.alert('장소를 하나 이상 선택해주세요');
	        	return;
	        }
	    	
	        var targeted_popup_class = jQuery(this).attr('data-popup-open');
	        $('[data-popup="' + targeted_popup_class + '"]').fadeIn(350);

			const infoPannel = document.getElementsByClassName('placeInfo')[0];
			infoPannel.style.width = '0';
			
	        cartP_title.value = startDate.value+'~'+endDate.value;
	        
	        e.preventDefault();
	    });

	    //----- CLOSE
	    $('[data-popup-close]').on('click', function(e)  {
	        var targeted_popup_class = jQuery(this).attr('data-popup-close');
	        $('[data-popup="' + targeted_popup_class + '"]').fadeOut(350);

	        e.preventDefault();
	    });
	});
	
	let totalDate;
	function daySubmit() {
		let startday = new Date(dayForm.startday.value);
		let lastday = new Date(dayForm.lastday.value);
		
		if(startday > lastday){
			window.alert("시작일이 종료일보다 클 수 없습니다.");	
		}
		totalDate = ((lastday - startday) / 1000 / 60 / 60 /24)+1;
		if(totalDate<=7){
			dayResult();
		}else{
			window.alert("여행 일수를 확인하세요!\n (최대 여행 일수 7일)");	
		}
	}
	function dayResult() {
		let resultData = '';
		for(var i = 1; i <= totalDate; i++) {
			resultData += '<span class="cartDay" onclick="cartDayClick('+i+')">Day'+i+'</span>';
		}
		totalDate = 1;
		
		const target = document.getElementsByClassName('dayButton')[0];
		target.innerHTML = resultData;
		
		const targetSpan = document.getElementsByClassName('cartDay')[0];
		targetSpan.style.background = '#fee599';
	}
	function cartDayClick(targetDay) {
		const extraSpan = document.getElementsByClassName('cartDay');
		for(var i = 0; i < extraSpan.length; i++) {
			extraSpan[i].style.background = '#7fc9cb';
		}
		
		totalDate = targetDay;
		const targetSpan = document.getElementsByClassName('cartDay')[targetDay-1];
		targetSpan.style.background = '#fee599';
		
		let params = 'day='+targetDay;
		sendXHR('dayChange.do', params, placeCartResult, 'GET');
	}
	</script>
	
	<!-- 카트에 담기 관련된 스크립트 -->
	<script>
		function placeDuplicationCheck() {
			let placeIdx = placeJson.imgList[0].pl_idx;
			const placeHidden = document.getElementsByName('cartPl_idx');
			for(var i = 0; i < placeHidden.length; i++) {
				if(placeHidden[i].value == placeIdx) {
					return false;
				}
			}
			return true;			
		}
		function placeCountCheck() {
			const placeHidden = document.getElementsByName('cartPl_idx');
			if(placeHidden.length >= 8) {
				return false;
			} else {
				return true;
			}
		}
		function placeDateCheck() {
			let startText = startDate.value;
			let endText = endDate.value;
			if(startText == '' || endText == '') {
				return false;
			}
			return true;
		}
		function placeCartInput() {
			let duplCheck = placeDuplicationCheck();
			if(!duplCheck) {
				window.alert('장소는 중복해서 선택할 수 없습니다');
				return;
			}
			
			let countCheck = placeCountCheck();
			if(!countCheck) {
				window.alert('장소는 8개 이상 선택할 수 없습니다');
				return;
			}
			
			let dateCheck = placeDateCheck();
			if(!dateCheck) {
				window.alert('날짜를 선택해주세요');
				return;
			}
			
			let placeName = placeJson.imgList[0].pl_name;
			let placeIdx = placeJson.imgList[0].pl_idx;
			let placeImg = placeJson.imgList[0].pl_img;
			let placeLat = placeJson.imgList[0].lat
			let pl_lat = placeJson.imgList[0].pl_lat;
			let pl_lng = placeJson.imgList[0].pl_lng;
			
			let data = {
					 pl_name:placeName,
					 pl_idx:placeIdx,
					 pl_img:placeImg,
					 resultdate:totalDate,
					 pl_lat:pl_lat,
					 pl_lng:pl_lng
			};
			
			sendXHRwithJSON('placeCart.do', data, placeCartResult);
		}
		function placeCartResult() {
			if(XHR.readyState == 4) {
				if(XHR.status == 200) {
					let data = XHR.responseText.trim();
					const cartday = document.getElementsByClassName('cart-day')[0];
					cartday.innerHTML = data;
				}
			}
		}
		function deletePlace(pl_idx) {
			let params = 'pl_idx='+pl_idx+'&resultdate='+totalDate;
			sendXHR('deletePlace.do', params, placeCartResult, 'GET');
		}
	</script>
	
	<!-- 플랜 저장 스크립트 -->
	<script>
		function planSaveSubmit() {
			let p_name = document.getElementsByName('p_name')[0].value;
			let p_content = document.getElementsByName('p_content')[0].value;
			let params = 'p_name='+p_name+'&p_content='+p_content;
			
			sendXHR('planSavemsg.do', params, planSaveResult, 'POST');
		}
		function planSaveResult() {
			if(XHR.readyState == 4) {
				if(XHR.status == 200) {
					window.alert(XHR.responseText);
					const saveContent = document.getElementsByName('p_content')[0];
					savePopup.style.display = 'none';
					saveContent.value = '';
				}
			}
		}
	</script>
	
	<!-- 리뷰 관련 스크립트 -->
	<script>
		function reviewModalOn() {
			let placeIdx = placeJson.imgList[0].pl_idx;
			let params = 'pl_idx='+placeIdx;
			sendXHR('reviewList.do', params, reviewModelOnResult, 'GET');
		}
		function reviewModelOnResult() {
			if(XHR.readyState == 4) {
				if(XHR.status == 200) {
					modal_back.style.display = 'block';
					review_modal.style.display = 'block';
					let reviewBody = 
						'<span class="modal_close" onclick="reviewModalOff()">X</span>'+
						'<h4>review</h4>'+
						'<div>'+
							'<select class="reviewStarSelect">'+
								'<option value="0.0">0.0</option>'+
								'<option value="0.5">0.5</option>'+
								'<option value="1.0">1.0</option>'+
								'<option value="1.5">1.5</option>'+
								'<option value="2.0">2.0</option>'+
								'<option value="2.5">2.5</option>'+
								'<option value="3.0">3.0</option>'+
								'<option value="3.5">3.5</option>'+
								'<option value="4.0">4.0</option>'+
								'<option value="4.5">4.5</option>'+
								'<option value="5.0">5.0</option>'+
							'</select>'+
							'<input type="text" class="reviewContent">'+
							'<input type="button" class="reviewWriteBtn" value="리뷰작성" onclick="reviewWrite()">'+
						'</div>';
					reviewBody += XHR.responseText;
					review_modal.innerHTML = reviewBody;
				}
			}
		}
		function reviewModalOff() {
			modal_back.style.display = 'none';
			review_modal.style.display = 'none';
			review_modal.innerHTML - '';
		}
		function reviewWrite() {
			let reviewStar = document.getElementsByClassName('reviewStarSelect')[0].value;
			let reviewCon = document.getElementsByClassName('reviewContent')[0].value;
			let placeIdx = placeJson.imgList[0].pl_idx;
			
			let params = 'star='+reviewStar+'&review='+reviewCon+'&pl_idx='+placeIdx;
			sendXHR('reviewWrite.do', params, reviewWriteResult, 'GET');
		}
		function reviewWriteResult() {
			if(XHR.readyState == 4) {
				if(XHR.status == 200) {
					let data = XHR.responseText;
					window.alert(data);
	    			//열려 있던 장소 정보창 닫기
	    			const infoPannel = document.getElementsByClassName('placeInfo')[0];
	    			infoPannel.style.width = '0';
	    			reviewModalOff();
				}
			}
		}
	</script>
	
	
	<!-- SNS오픈 -->
	<script>
		function snsOpen() {
			if(loginIdx == null || loginIdx == '' || loginIdx == 0) {
				window.alert('로그인 후 이용 가능합니다');
				return;
			} else {
				window.open('snsList.do');
			}
		}
	</script>
</head>
<body>
 
</body>
	<div class="modal_back" id="modal_back"></div>
	<div class="modal" id="login_modal"></div>
	<div class="modal" id="date_modal"></div>
	<div class="modal" id="review_modal"></div>
</html>