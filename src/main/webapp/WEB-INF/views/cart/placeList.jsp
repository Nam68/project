<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script>

function saveOk() {
	if(confirm("일정에 추가하겠습니까?")==true){
		window.open('pop.html')
	
	}else{
		return;
	}
}
</script>
</head>
<body>
	<h1>placeList</h1>
	<c:if test="${empty placeLists}">
				<h4>등록된 장소가 없습니다.</h4>
			</c:if>
	<%-- <input name="result" value="${result }"> --%>
	<c:forEach var="pldto" items="${placeLists}" varStatus="pl_idx">
		
		<div>
		<form name="cartAdd" action="intoCart.do">
			<ul>
					<li><input type="text" name="result" value="1"> </li>
					<li><input type="hidden" name="pl_idx" value="${pldto.pl_idx}"></li>
					<li><input type="text" name="pl_name" value="${pldto.pl_name}"></li>
					<li><input type="hidden" name="pl_img" value="${pldto.pl_img}"></li>
					<li><img name="img" src="${pldto.pl_img}"></li>
					<li><button type="submit" id="addBtn"  value="담기" onclick="saveOk();"></button></li>
					
			</ul>
			</form>
		</div>
</c:forEach>
</body>
</html>