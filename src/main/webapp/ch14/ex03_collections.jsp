<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body style="margin: 40px; margin-bottom:40px">
	<h1>내장 객체</h1><hr>
	<table border="1">
		<tr><th>표현식</th><th>결과</th></tr>
		
		<tr><td>\${fruits[0] }</td><td>${fruits[0] }</td></tr>
		<tr><td>\${fruits[1] }</td><td>${fruits[1] }</td></tr>
		<tr><td>\${fruits[2] }</td><td>${fruits[2] }</td></tr>
		<tr><td>\${fruits[3] }</td><td>${fruits[3] }</td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>\${sList[0] }</td><td>${sList[0] }</td></tr>
		<tr><td>\${sList[1] }</td><td>${sList[1] }</td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>\${map.key}</td><td>${map.key}</td></tr>
        <tr><td>\${map.value}</td><td>${map.value}</td></tr>
		
		
        
	</table>
</body>
</html>