<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나만의 여행 레시피</title>
    <script src="http://lne8372.cafe24.com/js/ajaxScript.js"></script>
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script
   src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<script> 
$(document).ready(function(){ 
    var main = $('.bxslider').bxSlider({ 
    pager:true,   //페이징 
    slideWidth: 300,
}); 
  
}); 
</script>
<style>
td {
   
}

#td1 {
   border-style: groove;
}

#td2 {
   border-style: groove;
}

table {
   border-spacing: 0 1vh;
   margin: auto;
   z-index: -8;
}

body {
   padding-top: 9vh;
}

.writer {
   background: #7FC9CB;
   color: white;
   height: 5vh;
   font-weight: bolder;
}

.content {
   border-top-style: solid;
   border-color: #F5F5F7;
   height: 5vh
}

.commentImg {
   min-height: 5vh;
   max-height: 5vh;
   float: right;
}

.goodImg {
   min-height: 5vh;
   max-height: 5vh;
   float: left;
}

.btns {
   padding-bottom: 5vh;
}

.page {
   text-align: center;
}

.bxslider img {
   width: 300vw;
}

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
</style>
<script src="http://lne8372.cafe24.com/js/httpRequest.js"></script>
<script>
function goodChange(bbs_idx,index){
   var chk=document.getElementsByName("good")[index];
   if(chk.checked==true){
      params="bbs_idx="+bbs_idx;
      sendXHR('snsgoodUpdate.do',params,null,'GET');
   }else{
      params="bbs_idx="+bbs_idx;
      sendXHR('snsgoodDelete.do',params,null,'GET');
   }
}   
function adCountUp(bbs_idx, a_idx) {
	let params = 'bbs_idx='+bbs_idx+'&a_idx='+a_idx;
	sendXHR('adCountUp.do', params, null, 'GET');
}
</script>
</head>
<c:import url="snsHeader.jsp"></c:import>
<body>
   <table>
      <tbody>
         <c:if test="${empty lists}">
            <tr>
               <td style="text-align: center;">등록된 게시물이 없습니다.</td>
            </tr>
         </c:if>
         <c:forEach var="dto" items="${lists}" varStatus="status">
            <tr>
               <td colspan=2>${dto.bbs_idx}</td>
               <c:url var="contentUrl" value="snsContent.do">
                  <c:param name="bbs_idx">${dto.bbs_idx}</c:param>
                  <c:param name="sns_writer">${dto.sns_writer}</c:param>
               </c:url>
               <c:url var="deleteUrl" value="deleteContent.do">
                  <c:param name="bbs_idx">${dto.bbs_idx}</c:param>

               </c:url>
            </tr>
            <tr>
               <td class="writer" colspan=2>${dto.sns_writer}</td>

            </tr>
            <tr>
               <td colspan="2">
                  <ul class="bxslider">
                     <div class="snsImgs">
                        <li><img class="snsImg" src="${dto.bbs_img[0] }"></li>
                     </div>

                     <div class="snsImgs">
                        <li><img class="snsImg" src="${dto.bbs_img[1] }"></li>
                     </div>

                     <div class="snsImgs">
                        <li><img class="snsImg" src="${dto.bbs_img[2] }"></li>
                     </div>

                     <div class="snsImgs">
                        <li><img class="snsImg" src="${dto.bbs_img[3] }"></li>
                     </div>
                  </ul>
               </td>
            </tr>
            <tr>
               <td class="content" colspan=4>${dto.sns_content}</td>
            </tr>
            <tr>
               <td><input type="checkbox" id="myCheck${status.index}"
                  name="good" onclick="goodChange(${dto.bbs_idx},${status.index});"
                  <c:forEach var="tt" items="${goodChecklist}">${tt.bbs_idx==dto.bbs_idx ? 'checked':''}</c:forEach>>
                  <label for="myCheck${status.index}"></label></td>
               <td class="btns"><a href="${contentUrl}"> <input
                     type=button class="addCommentBtn" hidden="1" /><img
                     class="commentImg"
                     src="http://lne8372.cafe24.com/img/comment.png"></a></td>
            </tr>
            <tr>
               <!--<td class="buttonBottom" colspan="2"><input type=button
                  value="신고하기" /></td> -->
            </tr>
         </c:forEach>
         
         <!-- 광고 -->
          <c:if test="${!empty ad }">
         <tr>
            <td colspan=2>${ad.bbs_idx}</td>
            <c:url var="contentUrl" value="snsContent.do">
               <c:param name="bbs_idx">${ad.bbs_idx}</c:param>
            </c:url>
            <c:url var="deleteUrl" value="deleteContent.do">
               <c:param name="bbs_idx">${ad.bbs_idx}</c:param>
            </c:url>
         </tr>
         <tr>
            <td class="writer" colspan=2>${ad.a_writer}</td>
         </tr>
         <tr>
            <td colspan="2">
               <ul class="bxslider">
                  <div class="snsImgs">
                     <li><img class="snsImg" src="${ad.bbs_img[0] }"></li>
                  </div>

                  <div class="snsImgs">
                     <li><img class="snsImg" src="${ad.bbs_img[1] }"></li>
                  </div>

                  <div class="snsImgs">
                     <li><img class="snsImg" src="${ad.bbs_img[2] }"></li>
                  </div>

                  <div class="snsImgs">
                     <li><img class="snsImg" src="${ad.bbs_img[3] }"></li>
                  </div>
               </ul>
            </td>
         </tr>
         <tr>
            <td class="content" colspan=4>${ad.a_content}</td>
         </tr>
         <tr>
            <td><a href="${ad.a_href }" target="_blank"
               onclick="adCountUp(${ad.bbs_idx}, ${ad.a_idx})">자세히 보기</a></td>
         </tr>
         <tr>
         </c:if>
            <!-- 광고 끝 -->
         <tr>
            <td colspan=2 class="page">${pageStr}</td>
         </tr>
   </table>
</body>
</html>