<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 수정</title>
</head>
<body>
<h1>정보수정</h1>
<div>
	<div>
		<div>비밀번호 질문</div>
		<div>
			<select>
				<c:forEach var="list" items="${q_list }">
					<option value="${list.q_idx }">${list.q_content }</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div>
		<div>답변</div>
		<div>${sessionScope.memberDTO.name }</div>
	</div>
	<div>
		<div>이름</div>
		<div>${sessionScope.memberInfo.account }</div>
	</div>
	<div>
		<div>성별</div>
		<div></div>
	</div>
	<div>
		<div>생년월일</div>
		<div></div>
	</div>
	<div>
		<div>거주지</div>
		<div></div>
	</div>
	<div>
		<div>전화번호</div>
		<div></div>
	</div>
</div>
</body>
</html>