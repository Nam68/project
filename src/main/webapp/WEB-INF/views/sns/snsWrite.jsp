<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나만의 여행 레시피</title>
    <script src="http://lne8372.cafe24.com/js/ajaxScript.js"></script>
<script>
	function setThumbnail(event) {
		var reader = new FileReader();
		reader.onload = function(event) {
			var img = document.createElement("img");
			img.setAttribute("src", event.target.result);
			document.querySelector("div#image_container").appendChild(img);
		};
		reader.readAsDataURL(event.target.files[0]);
	}

	function reload() {
		location.reload(true);
	}
</script>

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
	
	<!-- Submit 관련 스크립트 -->
	<script>
		function snsSubmit() {
			const targetTable = document.getElementById('imgTable');
			const imgs = targetTable.getElementsByTagName('img');
			let files = new Array();
			for(var i in imgs) {
				if(imgs[i].src != null) {
					files.push(imgs[i].src);	
				}
			}
			
			const form = document.snsWrite;
			let sns_writer = form.sns_writer.value;
			let sns_content = form.sns_content.value;
			
			let data = {
					sns_title:'기본타이틀',
					sns_writer:sns_writer,
					sns_content:sns_content,
					bbs_img:files
				};
			
			
			sendXHRwithJSON('snsWrite.do', data, snsSubmitResult);
		}
		function snsSubmitResult() {
			if(XHR.readyState == 4) {
				if(XHR.status == 200) {
					let data = XHR.responseText;
					window.alert(data);
					location.href='snsList.do';
				}
			}
		}
	</script>
<style>
body {
	padding-top: 10vh;
}

table {
	width: 55vw;
	border-spacing: 0 2vh;
	margin: auto;
}

td {
	
}

#sns_content {
	width: 45vw;
	height: 25vh;
}

#sns_text {
	width: 99%;
	height: 100%;
}

#sns_imgbox {
	width: 15vw;
	height: 35vh;
	border: groove;
}

#image_container {
	grid-template-columns: 1fr 1fr;
}

.image {
	max-height: 10vh;
}
		.businessExampleImg {width: 100%; height: 100%;}
		.imgDiv{width: 15vw; height: 15vw; position: relative;}
		.imgDeleteButton {position: absolute; top: 5%; right: 5%; width: 8%; height: 8%; background-color: rgba(0,0,0,0.4); border-radius: 50%; padding: 2%; vertical-align: middle; text-align: center;}
		.imgDeleteButton:hover {cursor: pointer;}
		.adTitleText{width: 40%; }
		.imgText{text-align: center; height: 30vh; line-height: 30vh; border: 1px solid black; }
		.imgText:hover {cursor: pointer;}		
</style>
</head>

<c:import url="snsHeader.jsp"></c:import>
<body>
	<div  class="adImgTable">
		<table>
			<thead>
				<tr>
					<td colspan="2">SNS 이미지</td>
				</tr>
			</thead>
			<tbody id="imgTable">
				<tr>
					<td><div class="imgDiv">
						<div class="imgText" onclick="imgFileOpen(0)">
							이미지를 등록해주세요
						</div>
					</div></td>
					<td><div class="imgDiv">
						<div class="imgText" onclick="imgFileOpen(1)">
							이미지를 등록해주세요
						</div>
					</div></td>
				</tr>
				<tr>
					<td><div class="imgDiv">
						<div class="imgText" onclick="imgFileOpen(2)">
							이미지를 등록해주세요
						</div>
					</div></td>
					<td><div class="imgDiv">
						<div class="imgText" onclick="imgFileOpen(3)">
							이미지를 등록해주세요
						</div>
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
	<form name="snsWrite">
		<table>
			<tbody>
				<tr hidden="1">
					<th colspan="2"><input type="text" value="${sns_writer}"
						name="sns_writer"></th>
				</tr>
				<tr>
					<td colspan="3" id="sns_content"><input type="text"
						name="sns_content" id="sns_text" required="required"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="올리기" onclick="snsSubmit()"></td>
					<td><input type="button" value="다시작성" onClick="reload()"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>