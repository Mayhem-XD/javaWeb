<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>

<c:set var="price" value="123456000"></c:set>
<c:set var="now" value="<%= new Date() %>"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fmt tag</title>
</head>
<body>
	<h1>JSTL formatting tag</h1>
	<c:set var="cid2" value="코어 아이디2"></c:set>
	<hr>
	<table border="1">
		<tr><th>표현식</th><th>결과</th></tr>
		
		<tr><td>\${price}</td><td>${price}</td></tr>
		
		<tr><td>숫자(천단위 구분기호 포함)</td><td><fmt:formatNumber type="number" value="${price }"/></td></tr>
		<tr><td>통화(KRW)</td><td><fmt:formatNumber type="currency" currencySymbol="KRW" value="${price }"/></td></tr>
		<tr><td>통화(USD)</td><td><fmt:formatNumber type="currency" currencySymbol="$" value="${price }"/></td></tr>
		<tr><td>퍼센트</td><td><fmt:formatNumber type="percent" value="${price/1000000 }"/></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>일반 날짜</td><td>${now}</td></tr>
		<tr><td>full date</td><td><fmt:formatDate type="date" dateStyle="full" value="${now}"/></td></tr>
		<tr><td>short date</td><td><fmt:formatDate type="date" dateStyle="short" value="${now}"/></td></tr>
		<tr><td>time</td><td><fmt:formatDate type="time" value="${now}"/></td></tr>
		<tr><td>both</td><td><fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /></td></tr>
		<tr><td>pattern(YYYY-MM-dd)</td><td><fmt:formatDate value="${now}" pattern="YYYY-MM-dd" /></td></tr>
		<tr><td>pattern("YYYY-MM-dd HH:mm:ss")</td><td><fmt:formatDate value="${now}" pattern="YYYY-MM-dd HH:mm:ss" /></td></tr>
		<tr><td></td><td></td></tr>
	</table>	
	
</body>
</html>