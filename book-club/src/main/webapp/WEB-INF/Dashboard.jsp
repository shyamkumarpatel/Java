<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Share</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="card m-3">
		<div class="card-header d-flex justify-content-between align-items-center">
			<h1>Welcome, ${usersName}</h1>
			<h4><a href="/logout">logout</a></h4>
		</div>
		<div class="card-body d-flex justify-content-between align-items-center">
			<p>Books from everyone's shelves:</p>
			<a href="/books/new">+ Add a book to my shelf!</a>
	  	</div>
	  	<div class="card-body">
					<table class="table table-hover">
  			<thead>
			    <tr>
			    	<th>ID</th>
			    	<th></th>
			    	<th>Title</th>
			    	<th></th>
			    	<th>Author Name</th>
			    	<th></th>
			    	<th>Posted By</th>
			    </tr>
	  		</thead>
	  		<tbody>
			    <c:forEach var="book" items="${books}">
			        <tr>
			        	<td><a href="/books/${book.getId()}"><c:out value="${book.getId()}"></c:out></a><td>
			        	<td><c:out value="${book.getTitle()}"></c:out><td>
			        	<td><c:out value="${book.getAuthor()}"></c:out><td>
			        	<td><c:out value="${book.getCreator().getUserName()}"></c:out><td>
			        </tr>
		    	</c:forEach>
			</tbody>
	    </table>
	  	</div>
	</div>

	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>