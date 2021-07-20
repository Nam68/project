<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <script src="http://lne8372.cafe24.com/js/ajaxScript.js"></script>
	<title>플레이스 추가</title>
	<style>
	.businessExampleImg {width: 100%; height: 100%;}
	.imgDiv{width: 10vw; height: 10vw; position: relative;}
	.imgDeleteButton {position: absolute; top: 5%; right: 5%; width: 8%; height: 8%; background-color: rgba(0,0,0,0.4); border-radius: 50%; padding: 2%; vertical-align: middle; text-align: center;}
	.imgDeleteButton:hover {cursor: pointer;}
	
	body>form>div{width: 35%; margin: 1% auto; padding: 1%; }
	body>div{width: 50%; margin: 1% auto; padding: 1%; text-align: center; }
	body>div>div>table{margin: auto; }
	
	#businessPlaceContent{resize: none; }
	
	#favoriteChkTd{width: 15vw; }
	.favoriteChk{margin-right: 15%; }
	.placeText{width: 40%; }
	.imgText{font-size: 0.8vw; text-align: center; height: 10vw; line-height: 10vw; border: 1px solid black; }
	
	.placeImgAndContent{width: 100vw;}
	.placeImgAndContent>div{display: inline-block; vertical-align: top;}
	
	.reviewBody{border: 1px solid black; overflow: auto; width: 90%; margin: 3% auto; padding: 3%; border-radius: 0.5vw;}
    .reviewContent>div{display: inline-block;}
    .reviewContent{position: relative; text-align: left; margin-left: 2%; margin-right: 2%;}
    .reviewDelete{position: absolute; right: 10%;}
	</style>
	<!-- 윈도우창 관련 스크립트 -->
    <script>
	    window.onbeforeunload = function() {
	    	sendXHR('allTempImgDelete.do', null, null, 'GET');
	    }
    </script>
	<!-- 주소 관련 스크립트 (수정 절대X) -->
	<script>
		function goPopup(){
		    var pop = window.open("jusoPopup.do","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
		}
		function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
				, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
			// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
			document.form.roadAddrPart1.value = roadAddrPart1;
		}
	</script>
	<!-- 주소 API와 구글지도를 연동하는 스크립트 -->
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBPg6sDuTdTWAWj17NeU9JkTVNEs3gJfIU&callback=initMap&libraries=&v=weekly&libraries=places&region=KR"
      async
    ></script>
    <script>
    	let map;
    	function addrToGeometry(placename) {
    		var service = new google.maps.places.PlacesService(map);
    		var request = {
    			query:placename,
    			fields:['geometry']	
    		}
    		service.findPlaceFromQuery(request, callbackText);
    	}
    	function callbackText(results, status) {
    		if (status == google.maps.places.PlacesServiceStatus.OK) {
    			let lat = results[0].geometry.location.lat();
    			let lng = results[0].geometry.location.lng();
    			addConfirm(lat, lng);
    		}
    	}
    	function initMap() {
    		map = new google.maps.Map(document.getElementById("map"), {
    		    center: { lat: 33.361, lng: 126.529 },
    			zoom: 11,
    		});
    	}
    </script>
	<!-- 이미지 관련 스크립트 -->
	<script>
		function imgInputChange(index) {
			const imgTd = document.getElementsByClassName('imgDiv')[index];
			const imgFile = document.getElementsByClassName('businessImgButton')[0].getElementsByTagName('input')[index];
			var file = imgFile.files[0];
			
			var formdata = new FormData();
			formdata.append('file', file);
			formdata.processData = false;
		    formdata.contentType = false;
		    
		    sendXHRwithFile('tempImgUpdate.do', formdata, function() {
		    	if(XHR.readyState == 4) {
		    		if(XHR.status == 200) {
		    			let data = XHR.responseText;
		    			imgTd.innerHTML =
		    				'<div class="imgDeleteButton" onclick="imgDelete('+index+')">X</div>'+
		    				'<img alt="example" src="'+data+'" class="businessExampleImg">';
		    		}
		    	}
		    });
		}
		function imgDelete(fileIndex) {
			const targetDiv = document.getElementsByClassName('imgDiv')[fileIndex];
			const imgFile = document.getElementsByClassName('businessImgButton')[0].getElementsByTagName('input')[fileIndex];
			const imgSrc = targetDiv.getElementsByTagName('img')[0].src;
			
			targetDiv.innerHTML = '<div class="imgText" onclick="imgFileOpen('+fileIndex+')">이미지를 등록해주세요</div>';
			imgFile.value = '';
			
			let params = 'path='+imgSrc;
			sendXHR('tempImgDelete.do', params, null, 'GET');
		}
		
		function imgFileOpen(fileIndex) {
			document.getElementsByClassName('businessImgButton')[0].getElementsByTagName('input')[fileIndex].click();
		}
	</script>
	<!-- 등록 폼에 관련된 스크립트 -->
	<script>
		let nameInfo;
		let addrInfo;
		let telInfo;
		let contentInfo;
		function businessPlaceAdd() {
			//사업장명 체크
			nameInfo = document.form.businessPlaceName.value;
			if(nameInfo == null || nameInfo == '') {
				window.alert('사업장명을 입력해주세요');
				return;
			}
			
			//주소 체크
			addrInfo = document.form.roadAddrPart1.value;
			if(addrInfo == null || addrInfo == '') {
				window.alert('주소를 입력해주세요');
				return;
			}
			
			//사업장 소개 체크
			contentInfo = document.getElementById('businessPlaceContent').value;
			if(contentInfo == '우리 가게만의 매력을 전해보세요') {
				contentInfo = '';
			}
			
			addrToGeometry(addrInfo); //주소를 지리정보로 바꿈
		}
		
		function checkboxCheck() { //체크박스 체크 개수 체크
			let chks = document.form.favorite;
			var count = 0;
			for(var i in chks) {
				if(chks[i].checked == true) {
					count++;
				}
				if(count > 3) {
					window.alert('체크는 3개까지만 가능합니다');
					event.preventDefault();
					return;
				}
			}
		}
		function textAreaClear(target) {
			if(target.value == '우리 가게만의 매력을 전해보세요') {
				target.value = '';
			}
		}
		
		function addConfirm(lat, lng) { //체크 후 최종 진행
			const targetTable = document.getElementById('imgTable');
			const imgs = targetTable.getElementsByTagName('img');
			let files = new Array();
			for(var i in imgs) {
				if(imgs[i].src != null) {
					files.push(imgs[i].src);	
				}
			}
			
			if(files.length == 0) {
				window.alert('이미지는 하나 이상 등록해주세요');
				return;
			}
			
			let chks = document.form.favorite;
			let checked = new Array();
			let vList = new Array();
			for(var i in chks) {
				if(chks[i].checked == true) {
					checked.push(chks[i].value);
				}
				if(chks[i].value != null) {
					vList.push(chks[i].value);
				}
			}
			
			let data = {
				pl_name:nameInfo,
				pl_lat:lat,
				pl_lng:lng,
				pl_content:contentInfo,
				owner:${sessionScope.memberDTO.idx},
				pl_img:files,
				v_idx:checked,
				vList:vList
			};
			
			sendXHRwithJSON('businessPlaceAdd.do', data, function() {
				if(XHR.readyState == 4) {
					if(XHR.status == 200) {
						window.alert(XHR.responseText);
						document.listForm.submit();
					}
				}	
			});
			
		}
	</script>
</head>
<%@ include file="businessHeader.jsp" %>
<body>
	<form name="form" id="form" method="post">
		<input type="hidden" id="confmKey" name="confmKey" value="">
		<div>
			<div>사업장명</div>
			<div>
				<input class="placeText" type="text" id="businessPlaceName">
			</div>
		</div>
		<!-- 주소AIP (수정 절대X) -->
		<div>
			<div>주소</div>
			<div>
				<div id="map"></div>
				<input  class="placeText" type="text" id="roadAddrPart1" readonly>
				<input type="button"  value="주소검색" onclick="goPopup();">
			</div>
		</div>
		<!-- 주소AIP 끝 -->
		<div>
			<div>테마</div>
			<div>
				<table>
				<c:forEach var="f" items="${favorite }" varStatus="status">
					<c:if test="${status.index%3==0 }"><tr></c:if>
						<td id="favoriteChkTd">
							<span class="favoriteChk">
								<label>
								<input type="checkbox" name="favorite" value="${f.v_idx }" onclick="checkboxCheck()">${f.v_name }
								</label>
							</span>
						</td>
					<c:if test="${status.index%3==2 }"></tr></c:if>
				</c:forEach>
				</table>
			</div>
		</div>
	</form>
	<div class="placeImgAndContent">
		<div>
			<table>
				<thead>
					<tr>
						<td colspan="2">사업장 이미지</td>
					</tr>
				</thead>
				<tbody id="imgTable">
					<tr>
						<td>
							<div class="imgDiv">
								<div class="imgText" onclick="imgFileOpen(0)">
									이미지를 등록해주세요
								</div>
							</div>
						</td>
						<td>
							<div class="imgDiv">
								<div class="imgText" onclick="imgFileOpen(1)">
									이미지를 등록해주세요
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="imgDiv">
								<div class="imgText" onclick="imgFileOpen(2)">
									이미지를 등록해주세요
								</div>
							</div>
						</td>
						<td>
							<div class="imgDiv">
								<div class="imgText" onclick="imgFileOpen(3)">
									이미지를 등록해주세요
								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="businessImgButton">
				<input type="file" style="display:none;" onchange="imgInputChange(0)">
				<input type="file" style="display:none;" onchange="imgInputChange(1)">
				<input type="file" style="display:none;" onchange="imgInputChange(2)">
				<input type="file" style="display:none;" onchange="imgInputChange(3)">
			</div>
		</div>
		<div>
			<table>
				<thead>
					<tr>
						<td colspan="2">사업장 소개</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><textarea id="businessPlaceContent" onfocus="textAreaClear(this)"
								cols="60" rows="10">우리 가게만의 매력을 전해보세요</textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div>
		<input type="button" value="등록" onclick="businessPlaceAdd()">
		<input type="button" value="취소" onclick="document.listForm.submit()">
	</div>
</body>

	<form action="businessPage.do" method="post" name="listForm">
		<input type="hidden" name="idx" value="${sessionScope.memberDTO.idx }">
	</form>
	
</html>