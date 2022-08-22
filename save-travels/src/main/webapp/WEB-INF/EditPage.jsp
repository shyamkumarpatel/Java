<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Read Share</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
</head>
<body>
	<div class="card m-3">
	  <div class="card-header d-flex justify-content-between align-items-center">
	    <h1>Edit Expense</h1>
	    <h4><a href="/expenses">Go Back</a></h4>
	  </div>
	  <div class="card-body">
		<div class="container">
		  <form:form action="/expenses/edit/${travel.getId()}" method="post" modelAttribute="travel">
    			<input type="hidden" name="_method" value="put">
				<div class="form-group mt-3">
					<form:label path="expense">Expense Name: </form:label> 
					<form:input type="text" class="form-control" path="expense"/>
					<form:errors path="expense"/>
				</div>
				<div class="form-group mt-3">
					<form:label path="vendor">Vendor: </form:label> 
					<form:input path="vendor" type="text" class="form-control"/>
					<form:errors path="vendor"/>
				</div>
				<div class="form-group mt-3">
					<form:label path="amount">Amount: </form:label> 
					<form:input type="number" step="0.01" class="form-control" path="amount"/>
					<form:errors path="amount"/>
				</div>
				<div class="form-group mt-3">
					<form:label path="description">Description: </form:label>
					<form:textarea class="form-control" path="description" rows="3"/>
					<form:errors path="description"/>
				</div>
				<button type="submit" class="btn btn-primary mt-3 mb-3">Submit</button>
			</form:form>
		</div>

		</div>
	</div>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>