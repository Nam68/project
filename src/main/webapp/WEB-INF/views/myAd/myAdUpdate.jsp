<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <script src="http://lne8372.cafe24.com/js/ajaxScript.js"></script>
	<title>광고 수정</title>
	<link rel="stylesheet" type="text/css" href="http://lne8372.cafe24.com/css/modalLayout.css">
	<style>
		#url_modal {width: 30vw; height: 20vh; top: 40vh; left: 35vw;}
		#date_modal {width: 30vw; height: 20vh; top: 40vh; left: 35vw;}
		#limit_modal {width: 30vw; height: 20vh; top: 40vh; left: 35vw;}
		.modal_submit {width: 15%; height: 10%; background-color: #7fc9cb; display: inline; margin: 2%; padding:1%;}
		.modal_cancel {width: 15%; height: 10%; background-color: gray; display: inline; margin: 2%; padding:1%;}
		.modal_submit:hover{cursor: pointer;}
		.modal_cancel:hover{cursor: pointer;}		
		.modalButtonSet {padding-top: 5%;}
		
		.businessExampleImg {width: 100%; height: 100%;}
		.imgDiv{width: 15vw; height: 15vw; position: relative;}
		.imgDeleteButton {position: absolute; top: 5%; right: 5%; width: 8%; height: 8%; background-color: rgba(0,0,0,0.4); border-radius: 50%; padding: 2%; vertical-align: middle; text-align: center;}
		.imgDeleteButton:hover {cursor: pointer;}
		
		body>form>div{width: 35%; margin: 1% auto; padding: 1%; }
		body>div{width: 50%; margin: 1% auto; padding: 1%; text-align: center; }
		
		#adContent{resize: none; }
		
		.adTitleText{width: 40%; }
		.imgText{font-size: 0.8vw; text-align: center; height: 30vh; line-height: 30vh; border: 1px solid black; }
		.imgText:hover {cursor: pointer;}
		
		
		.adImgTable>table{margin: auto; }
		
		.adImgAndContent{width: 100vw;}
		.adImgAndContent>div{display: inline-block; vertical-align: top; margin-left: 1%; margin-right: 1%;}
		
		.urlDiv{margin-top: 5%;}
		.othersDiv{margin-top: 5%;}
		.urlDiv>div{margin-right: 4%;}
		.urlDiv div{display: inline-block; }
		.urlRegist{background-color: #7fc9cb;}
		.urlDelete{background-color: gray;}
		.urlRegist:hover {cursor: pointer;}
		.urlDelete:hover {cursor: pointer;}
		
		.timeSetting{margin-bottom: 3%;}
		.timeSetting:hover{cursor: pointer;}
		.budgetSetting{display: inline-block; background-color: #7fc9cb; margin-right: 5%;}
		.budgetSetting:hover{cursor: pointer;}
		.budgetView{display: inline-block;}
		
		.adSubmit{background-color: #7fc9cb; width: 10vw; padding: 1vw; border-radius: 0.8vw;}
	</style>
	<!-- 윈도우창 닫기 관련 스크립트 -->
    <script>
	    window.onbeforeunload = function() {
	    	sendXHR('allTempImgDelete.do', null, null, 'GET');
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
	<!-- 기타 등록사항 -->
	<script>
		<!-- URL 관련 -->
		function urlModalOn() {
			modal_back.style.display = 'block';
			url_modal.style.display = 'block';
			
			url_modal.innerHTML = 
				'<span class="modal_close" onclick="urlModalOff()">X</span>'+
				'<div><span>URL 입력 </span><span><input type="text" class="urlText"></span></div>'+
				'<div class="modalButtonSet">'+
					'<div class="modal_submit" onclick="urlModalSubmit()">등록</div>'+
					'<div class="modal_cancel" onclick="urlModalOff()">닫기</div>'+
				'</div>';
		}
		function urlModalOff() {
			modal_back.style.display = 'none';
			url_modal.style.display = 'none';
		}
		function urlModalSubmit() {
			const url = document.getElementsByClassName('urlDiv')[0].getElementsByTagName('div')[0];
			const urlText = document.getElementsByClassName('urlText')[0];
			if(urlText.value == null || urlText.value == '') {
				window.alert('URL을 입력해주세요');
				return;
			}
			url.innerHTML = '<a href="http://'+urlText.value+'" target="_blank">'+urlText.value+'</a>';
			urlModalOff();
		}
		function urlDel() {
			const url = document.getElementsByClassName('urlDiv')[0].getElementsByTagName('div')[0];
			url.innerHTML = 'URL을 등록하세요!';
		}
	
		<!-- 기간 설정 -->
		function dateModalOn() {
			modal_back.style.display = 'block';
			date_modal.style.display = 'block';
			
			date_modal.innerHTML = 
				'<span class="modal_close" onclick="dateModalOff()">X</span>'+
				'<div>'+
					'<div>시작일</div>'+
					'<input type="date" >'+
				'</div>'+
				'<div>'+
					'<div>종료일</div>'+
					'<input type="date">'+
				'</div>'+
				'<div class="modalButtonSet">'+
					'<div class="modal_submit" onclick="dateModalSubmit()">등록</div>'+
					'<div class="modal_cancel" onclick="dateModalOff()">닫기</div>'+
				'</div>';
		}
		function dateModalOff() {
			modal_back.style.display = 'none';
			date_modal.style.display = 'none';
		}
		function dateModalSubmit() {
			const date = document.getElementById('date_modal').getElementsByTagName('input');
			var date1 = new Date(date[0].value);
			var date2 = new Date(date[1].value);
			if(date[0].value == '' || date[1].value == '' || date1 >= date2) {
				window.alert('날짜를 정확히 입력해주십시오');
				return;
			}
			
			const dateText = document.getElementsByClassName('othersDiv')[0].getElementsByTagName('div')[0].getElementsByTagName('div')[0];
			dateText.innerHTML = date[0].value+' ~ '+date[1].value;
			startInfoHidden.value = date[0].value;
			endInfoHidden.value = date[1].value;
			dateModalOff();
		}

		<!-- 예산 설정 -->
		function limitModalOn() {
			modal_back.style.display = 'block';
			limit_modal.style.display = 'block';
			
			limit_modal.innerHTML = 
				'<span class="modal_close" onclick="limitModalOff()">X</span>'+
				'<div><span>예산 입력 </span><span><input type="text" class="limitText">원</span></div>'+
				'<div class="modalButtonSet">'+
					'<div class="modal_submit" onclick="limitModalSubmit()">등록</div>'+
					'<div class="modal_cancel" onclick="limitModalOff()">닫기</div>'+
				'</div>';
		}
		function limitModalOff() {
			modal_back.style.display = 'none';
			limit_modal.style.display = 'none';
		}
		function limitModalSubmit() {
			let limitText = document.getElementsByClassName('limitText')[0].value;
			for(var i = 0; i < limitText.length; i++) {
				if(limitText.charCodeAt(i) < 48 || limitText.charCodeAt(i) > 57) {
					window.alert('숫자만 입력해주세요');
					return;
				}
			}

			const limit = document.getElementsByClassName('othersDiv')[0].getElementsByTagName('div')[0].getElementsByTagName('div')[2];
			limit.innerHTML = limitText+'원';
			limitModalOff();
		}
	</script>
	<!-- 광고 승인 관련 스크립트 -->
	<script>
		let titleInfo;
		let contentInfo;
		let limitInfo;
		let hrefInfo;
		let startInfo;
		let endInfo;
		function adSubmitCheck() {
			//광고 이름 검사
			if(adTitle.value == null || adTitle.value == '') {
				window.alert('광고명을 입력해주세요');
				return;
			} else {
				titleInfo = adTitle.value;
			}
			
			//광고 문구 검사
			if(adContent.value == null || adContent.value == '우리 가게만의 매력을 전해보세요') {
				contentInfo = '';
			} else {
				contentInfo = adContent.value;
			}
			
			//url 검사
			const url = document.getElementsByClassName('urlDiv')[0].getElementsByTagName('div')[0];
			if(url.innerHTML = 'URL을 등록하세요!') {
				hrefInfo = '';
			} else {
				hrefInfo = url.innerHTML;
			}
			
			//예산 검사
			const limit = document.getElementsByClassName('othersDiv')[0].getElementsByTagName('div')[0].getElementsByTagName('div')[2];
			let limitText = limit.innerHTML;
			let limitNum = limitText.substring(0, limitText.length-1);
			if(limitNum == null || limitNum == '' || limitNum == 0 || limitText == '예산미리보기') {
				window.alert('예산을 설정해주세요');
				return;
			} else {
				limitInfo = limitNum;
			}
			
			//시작일 검사
			const date = document.getElementById('date_modal').getElementsByTagName('input');
			if(startInfoHidden.value == null || startInfoHidden.value == '') {
				window.alert('시작일을 입력해주세요');
				return;
			} else {
				startInfo = startInfoHidden.value;
			}
			
			//종료일 검사
			if(endInfoHidden.value == null || endInfoHidden.value == '') {
				window.alert('종료일을 입력해주세요');
				return;
			} else {
				endInfo = endInfoHidden.value;
			}
			
			adSubmit();
			
		}
		
		function adSubmit() {
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
			
			let data = {
					bbs_idx:${adDTO.bbs_idx},
					a_title:titleInfo,
					a_content:contentInfo,
					a_limit:limitInfo,
					bbs_img:files,
					a_href:hrefInfo,
					a_startdate:startInfo,
					a_enddate:endInfo
				};
			
			
			sendXHRwithJSON('myAdUpdateSubmit.do', data, adSubmitResult);
		}
		function adSubmitResult() {
			if(XHR.readyState == 4) {
				if(XHR.status == 200) {
					let data = XHR.responseText;
					window.alert(data);
					location.href = 'myAdPage.do';
				}
			}
		}
	</script>
</head>
	<div class="modal_back" id="modal_back"></div>
	<div class="modal" id="url_modal"></div>
	<div class="modal" id="date_modal"></div>
	<div class="modal" id="limit_modal"></div>
<%@ include file="businessHeader.jsp" %>
<body>
	<div>
		<div>광고명</div>
		<div>
			<input type="text" id="adTitle" value="${adDTO.a_title }">
		</div>
	</div>
	<div class="adImgAndContent">
		<div>
			<table>
				<thead>
					<tr>
						<td colspan="2">광고 이미지</td>
					</tr>
				</thead>
				<tbody id="imgTable">
					<tr>
						<td><div class="imgDiv">
								<div class="imgDeleteButton" onclick="imgDelete(0)">X</div>
								<img alt="exampleImg" src="${adImgList[0].bbs_img }" class="businessExampleImg" onclick="imgFileOpen(0)">
						</div></td>
						<td><div class="imgDiv">
							<c:if test="${empty adImgList[1] }">
								<div class="imgText" onclick="imgFileOpen(1)">
								이미지를 등록해주세요
								</div>
							</c:if>
							<c:if test="${!empty adImgList[1] }">
								<div class="imgDeleteButton" onclick="imgDelete(1)">X</div>
								<img alt="exampleImg" src="${adImgList[1].bbs_img }" class="businessExampleImg" onclick="imgFileOpen(0)">
							</c:if>
						</div></td>
					</tr>
					<tr>
						<td><div class="imgDiv">
							<c:if test="${empty adImgList[2] }">
								<div class="imgText" onclick="imgFileOpen(2)">
								이미지를 등록해주세요
								</div>
							</c:if>
							<c:if test="${!empty adImgList[2] }">
								<div class="imgDeleteButton" onclick="imgDelete(2)">X</div>
								<img alt="exampleImg" src="${adImgList[2].bbs_img }" class="businessExampleImg" onclick="imgFileOpen(0)">
							</c:if>
						</div></td>
						<td><div class="imgDiv">
							<c:if test="${empty adImgList[3] }">
								<div class="imgText" onclick="imgFileOpen(3)">
								이미지를 등록해주세요
								</div>
							</c:if>
							<c:if test="${!empty adImgList[3] }">
								<div class="imgDeleteButton" onclick="imgDelete(3)">X</div>
								<img alt="exampleImg" src="${adImgList[3].bbs_img }" class="businessExampleImg" onclick="imgFileOpen(0)">
							</c:if>
						</div></td>
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
			<div>
				<table>
					<thead>
						<tr>
							<td colspan="2">광고문구</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><textarea id="adContent" onfocus="textAreaClear(this)"
										cols="60" rows="10">${empty adDTO.a_content? '우리 가게만의 매력을 전해보세요':adDTO.a_content }</textarea></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="urlDiv">
				<div>${empty adDTO.a_href? 'URL을 등록하세요!':adDTO.a_href }</div>
				<div>
					<div class="urlRegist" onclick="urlModalOn()">URL 등록</div>
					<div class="urlDelete" onclick="urlDel()">URL 삭제</div>
				</div>
			</div>
			<div class="othersDiv">
				<div>
					<div class="timeSetting" onclick="dateModalOn()">${adDTO.a_startdate } ~ ${adDTO.a_enddate } </div>
						<input type="hidden" id="startInfoHidden" value="${adDTO.a_startdate }">
						<input type="hidden" id="endInfoHidden" value="${adDTO.a_enddate }">
					<div class="budgetSetting" onclick="limitModalOn()">예산 설정</div>
					<div class="budgetView">${adDTO.a_limit }원</div>
				</div>
			</div>
		</div>
	</div>
	<div class="adSubmit" onclick="adSubmitCheck()">광고 승인(수정) 신청</div>
</body>
</html>