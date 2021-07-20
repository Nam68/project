<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	window.alert('${msg}');
	location.href='userQnAContent.do?bbs_idx=${bbs_idx}';
	console.log('idx > >'+'${bbs_idx}');
</script>