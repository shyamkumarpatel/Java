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
		<h1>Send an Omikuji</h1>
		<form action="/submit" method="post">
			<div class="form-group mt-3">
				<label>Pick any number from 5 to 25: </label> 
				<input type="number" class="form-control" name="pickNumber">
			</div>
			<c:if test = "${error != null}">
				<small class="alert alert-danger"><c:out value="${error}"></c:out></small>
			</c:if>
			<div class="form-group mt-3">
				<label>Enter a name of any city: </label> 
				<input type="text" class="form-control" name="city">
			</div>
			<div class="form-group mt-3">
				<label>Enter the name of any real person: </label> 
				<input type="text" class="form-control" name="person">
			</div>
			<div class="form-group mt-3">
				<label>Enter professional endeavor or hobby: </label> 
				<input type="text" class="form-control" name="hobby">
			</div>
			<div class="form-group mt-3">
				<label>Enter any type of living thing: </label> 
				<input type="text" class="form-control" name="livingThing">
			</div>
			<div class="form-group mt-3">
				<label>Say something nice to someone: </label>
				<textarea class="form-control" name="somethingNice" rows="3"></textarea>
			</div>
			<div class="form-group mt-1">
				<small class="form-text text-muted">Send and show a friend</small>
			</div>
			<button type="submit" class="btn btn-primary mt-3 mb-3">Submit</button>
		</form>
	</div>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
