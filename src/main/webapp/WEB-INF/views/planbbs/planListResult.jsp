<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.fileup { border-radius: 4px; border: none;}
li {list-style: none;}
#upbtn {background-color: #fee599; width: 10vw; border:none; margin-bottom: 5px;}
#imgchange {width: 100%; }
div{width: 500PX;  margin: auto; text-align: center;}

</style>
<form name="fileUpload1" action="fileUpload.do" method="post" enctype="multipart/form-data">
<table>
<tr>
<td >
<c:forEach items="${planList}" var="vo">
<input type="hidden" name="p_idx" value="${vo.p_idx}">
<input type="hidden" name="day" value="${vo.day}">
<input type="hidden" name="pl_idx" value="${vo.pl_idx}">
<img src="${vo.img}" id="imgchange" style="width:300px; height: 300px;">
</tr>
<tr>
<td>
<input type="file" id="planInfoImgchange"  name="img" onclick="planInfoImgClick()" onchange="planInfoImgChange()">
</c:forEach>
<div>
<label>${pageStr}</label>
</div>
</form>