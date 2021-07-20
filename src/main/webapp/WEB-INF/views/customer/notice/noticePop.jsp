<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script>

function setCookie(name, value, expiredays){

var todayDate = new Date();

todayDate.setDate(todayDate.getDate() + expiredays);

document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"

}

function closePop(){

setCookie("close","close",1);

window.close();

}

</script>
<style>
.bottom{position:absolute; bottom:0;}
</style>
</head>
<body>
<h1>공지사항</h1>
  <form name="notice_form">
      <div id="divpop1" class="divpop">    
			<c:forEach var="n" items="${lists }">
  
          <div class="title_area">제목 ${n. n_title}</div>
          <div>번호 ${n. n_idx }</div>
						
			<div>작성자 ${n. n_writer}</div>
			<div>작성날짜 ${n. n_writedate}</div>
			 <p>
          	<div>컨텐츠 ${n. n_content}</div>	
           
            </c:forEach>
           <div class="bottom">
              <input type="checkbox" onClick="closePop();">오늘 하루 동안 열지 않음  
           </div>
      </div>
  </form>
</body>
</html>