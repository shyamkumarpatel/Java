<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Show Expense</title><!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css" />
</head>
<body>
	<div class="card m-3">
	  <div class="card-header d-flex justify-content-between align-items-center">
	    <h1> Expense Details</h1>
	    <h4><a href="/expenses">Go Back</a></h4>
	  </div>
	  <div class="card-body">
		<div class="container">
		  <div class="row mb-3">
		    <div class="col-sm">
		      <h4>Expense Name:</h4>
		    </div>
		    <div class="col-sm">
		      <c:out value="${travel.expense}" />
		    </div>
		  </div>
  		  <div class="row mb-3">
		    <div class="col-sm">
		      <h4>Expense Description:</h4>
		    </div>
		    <div class="col-sm">
		      <c:out value="${travel.description}" />
		    </div>
		  </div>
  		  <div class="row mb-3">
		    <div class="col-sm">
		      <h4>Vendor:</h4>
		    </div>
		    <div class="col-sm">
		      <c:out value="${travel.vendor}" />
		    </div>
		  </div>
  		  <div class="row mb-3">
		    <div class="col-sm">
		      <h4>Amount Spent:</h4>
		    </div>
		    <div class="col-sm">
		      $<c:out value="${travel.amount}" />
		    </div>
		  </div>
		</div>

		</div>
	  </div>
</body>
</html>