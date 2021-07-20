<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>

if(confirm("저장하시겠습니까?")==true){
	window.alert('${msg}');
		location.href="planList.do";
	
}
	

</script>