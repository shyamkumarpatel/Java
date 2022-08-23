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
	    <h1> Expense Details</h1>
	    <h4><a href="/books">Go Back</a></h4>
	  </div>
	  <div class="card-body">
		<div class="container">		  
			<div class="row mb-3"">
			    <div class="col-sm">
			      <h4>ID:</h4>
			    </div>
			    <div class="col-sm">
			      <c:out value="${book.getId()}" />
			    </div>
		  </div>
		  <div class="row mb-3">
		    <div class="col-sm">
		      <h4>Title:</h4>
		    </div>
		    <div class="col-sm">
		      <c:out value="${book.getTitle()}" />
		    </div>
		  </div>
  		  <div class="row mb-3">
		    <div class="col-sm">
		      <h4>Author:</h4>
		    </div>
		    <div class="col-sm">
		      <c:out value="${book.getAuthor()}" />
		    </div>
		  </div>
  		  <div class="row mb-3">
		    <div class="col-sm">
		      <h4>Posted by:</h4>
		    </div>
		    <div class="col-sm">
		      <c:out value="${book.getCreator().getUserName()}" />
		    </div>
		  </div>
  		  <div class="row mb-3">
		    <div class="col-sm">
		      <h4><c:out value="${book.getCreator().getUserName()}" />'s thoughts:</h4>
		    </div>
		    <div class="col-sm">
		      <c:out value="${book.getThoughts()}" />
		    </div>
		  </div>
		</div>

		</div>
	  </div>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>