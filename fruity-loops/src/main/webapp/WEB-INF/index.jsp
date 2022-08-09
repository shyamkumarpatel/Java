<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Fruit Store</title>
    <!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
</head>
<body>
	<div class="container-fluid border border-secondary m-1">
	    <h1>Fruit Store</h1>
	    <table class="table table-hover">
  			<thead>
			    <tr>
			    	<th scope="col">Name</th>
			    	<th scope="col"></th>
			    	<th scope="col">Price</th>
			    	<th scope="col"></th>
			    </tr>
	  		</thead>
	  		<tbody>
			    <c:forEach var="fruit" items="${fruits}">
			        <tr>
			        	<td><c:out value="${fruit.getName()}"></c:out><td>
			        	<td><c:out value="${fruit.getPrice()}"></c:out><td>
			        </tr>
		    	</c:forEach>
			</tbody>
	    </table>
	</div>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
