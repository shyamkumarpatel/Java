<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Book Share</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="card m-3">
	  <div class="card-header d-flex justify-content-between align-items-center">
	    <h1>Add a Book to Your Shelf!</h1>
	    <h4><a href="/books">Back to the shelves</a></h4>
	  </div>
	  <div class="card-body">
			<form:form action="/submit" method="post" modelAttribute="newBook">
			
				<div class="form-group mt-3">
					<form:label path="title">Title: </form:label> 
					<form:input type="text" class="form-control" path="title"/>
					<form:errors path="title"/>
				</div>
				<div class="form-group mt-3">
					<form:label path="author">Author: </form:label> 
					<form:input path="author" type="text" class="form-control"/>
					<form:errors path="author"/>
				</div>
				<div class="form-group mt-3">
					<form:label path="thoughts">My thoughts: </form:label>
					<form:textarea class="form-control" path="thoughts" rows="3"/>
					<form:errors path="thoughts"/>
				</div>
				
				<form:hidden path="creator" value="${userId}" />
				<button type="submit" class="btn btn-primary mt-3 mb-3">Submit</button>
			</form:form>
	  </div>
	</div>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>