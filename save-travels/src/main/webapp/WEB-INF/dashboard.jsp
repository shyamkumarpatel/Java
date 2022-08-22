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
	<div class="container border border-secondary m-3">
		<h1>Save Travels</h1>
		<table class="table table-hover">
  			<thead>
			    <tr>
			    	<th>Expense</th>
			    	<th></th>
			    	<th>Vendor</th>
			    	<th></th>
			    	<th>Amount</th>
			    	<th></th>
			    	<th>Actions</th>
			    </tr>
	  		</thead>
	  		<tbody>
			    <c:forEach var="travel" items="${travels}">
			        <tr>
			        	<td><a href="/expenses/${travel.getId()}"><c:out value="${travel.getExpense()}"></c:out></a><td>
			        	<td><c:out value="${travel.getVendor()}"></c:out><td>
			        	<td>$<c:out value="${travel.getAmount()}"></c:out><td>
			        	<td>
			        		<div class="d-flex">
				        		<a class="btn btn-warning" href="/expenses/edit/${travel.getId()}">edit</a>
				        		<form action="/expenses/delete/${travel.getId()}" method="post">
	    							<input type="hidden" name="_method" value="delete">
									<button type="submit" class="btn btn-danger mx-1">delete</button>
				        		</form>
			        		</div>
			        	<td>
			        </tr>
		    	</c:forEach>
			</tbody>
	    </table>
	</div>
	<div class="container border border-secondary m-3">
		<h1>Add an expense:</h1>
		<form:form action="/submit" method="post" modelAttribute="newtravel">
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
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
