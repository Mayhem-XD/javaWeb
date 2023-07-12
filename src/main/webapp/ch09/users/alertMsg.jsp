<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String msg = (String) request.getAttribute("msg");
	String url = (String) request.getAttribute("url");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
    <script>
    	let msg = '<%= msg %>';
    	// let msg = '${msg}$;'
    	let url = '<%= url %>';
    	alert(msg);
    	location.href = url;
    </script>
</body>
</html>