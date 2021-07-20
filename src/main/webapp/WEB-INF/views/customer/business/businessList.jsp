<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="../header.jsp" %>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<style>
.table > thead { background-color: #b3c6ff; }
.table > thead > tr > th { text-align: center; } 
.table-hover > tbody > tr:hover { background-color: #e6ecff; } 
.table > tbody > tr > td { text-align: center; } 
.table > tbody > tr > #title { text-align: left; } 
div > #paging { text-align: center; }
</style>
<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var chkObj = document.getElementsByName("rowCheck");
			var rowCnt = chkObj.length;
			
			$("input[name='allCheck']").click(function(){
				var chk_listArr = $("input[name='rowCheck']");
				for (var i=0; i<chk_listArr.length; i++){
					chk_listArr[i].checked = this.checked;
				}
			});
			$("input[name='rowCheck']").click(function(){
				if($("input[name='rowCheck']:checked").length == rowCnt){
					$("input[name='allCheck']")[0].checked = true;
				}
				else{
					$("input[name='allCheck']")[0].checked = false;
				}
			});
		});
		function deleteValue(){
			var url = "customerUserDelete.do";    // Controller로 보내고자 하는 URL
			var valueArr = new Array();
		    var list = $("input[name='rowCheck']");
		    for(var i = 0; i < list.length; i++){
		        if(list[i].checked){ //선택되어 있으면 배열에 값을 저장함
		            valueArr.push(list[i].value);
		        }
		    }
		    if (valueArr.length == 0){
		    	alert("선택된 글이 없습니다.");
		    }
		    else{
				var chk = confirm("정말 삭제하시겠습니까?");				 
				$.ajax({
				    url : "customerUserDelete.do",            // 전송 URL
				    type : 'POST',                // POST 방식
				    traditional : true,
				    data : {
				    	valueArr : valueArr        // 보내고자 하는 data 변수 설정
				    },
	                success: function(jdata){
	                    if(jdata = 1) {
	                        alert("삭제 성공");
	                        location.replace("customerBizList.do") //페이지 새로고침
	                    }
	                    else{
	                        alert("삭제 실패");
	                    }
	                }
				});
			}
		}
	</script>
</head>
<body>
<h3>사업자 관리</h3>
<form>
	<fieldset>
		<table class="table">
			<thead>
			<tr>	
					<th width="120"><input type="checkbox" id="allCheck" name="allCheck" style="zoom:1.2">전체선택</th>
					<th>No</th>
					<th>ID</th>
					<th>이름</th>
				
					</tr>
			</thead>
		
					
			
			
			<tbody>
				<c:if test="${empty lists }">
					<tr>
						<td colspan="4">
							등록된 회원이 없습니다.	
						</td>
					</tr>
				</c:if>
				<c:forEach var="biz" items="${lists }">
					<tr>
						<td ><input type="checkbox" name="rowCheck" value="${biz. idx}" style="zoom:1.2"></td>
						<td>${biz. idx }</td>
						<td>${biz. id}</td>
						<td>${biz. name}</td>
						
					</tr>
					</c:forEach>
				
			</tbody>
			
		</table>
		<div align="center">
					
						${pageStr }
						&nbsp;&nbsp;&nbsp;&nbsp;
					 <c:if test="${sessionScope.member.id != null}">
     	 			  <a href="userQnAWrite.do">글쓰기</a>
     	 			  &nbsp;&nbsp;&nbsp;&nbsp;
     	 			  <a onclick="deleteValue();">선택삭제</a>
  					  </c:if>	
		</div>
	</fieldset>
	
</form>
</body>
</html>