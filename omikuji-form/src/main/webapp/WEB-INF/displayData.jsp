<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Omikuji</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
</head>
<body>
	<div class="container border border-secondary m-3">
		<h1>Here's your Omikuji!</h1>

		<div class="container border border-secondary m-3">
			<h1>In <c:out value="${pickNumber}"></c:out> years, you will live in <c:out value="${city}"></c:out> with <c:out value="${person}"></c:out> as your room mate, <c:out value="${hobby}"></c:out> for a living. 
			The next time you see a <c:out value="${livingThing}"></c:out>, you will have good luck. Also, <c:out value="${somethingNice}"></c:out>
			</h1>
		</div>
		
		 <a href="/home">Go Back</a> 
	</div>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>