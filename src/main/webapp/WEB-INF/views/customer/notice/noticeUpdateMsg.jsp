<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	window.alert('${msg}');
	location.href='noticeUpdate.do?n_idx=${n_idx}';
	console.log('idx > >'+'${n_idx}');
</script>