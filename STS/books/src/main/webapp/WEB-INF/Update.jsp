<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body style="background-color: #282828">
	<div class="container container-fluid text-white">
		<h1>Edit Book</h1>
		<form:form modelAttribute="book" action="/book/${book.id}/edit"
			method="put">
			<!-- <input type="hidden" name="_method" value="put">  -->
			<!-- Title -->
			<form:errors path='title' class="text-danger"/>
			<form:input class="form-control mb-3" type='text' value='${book.title}'
				path='title'/>
			<!-- Description -->
			<form:errors path='description' class="text-danger"/>
			<form:input class="form-control mb-3" type='text'
				value='${book.description }' path='description'/>
			<!-- Language -->
			<form:errors path='language' class="text-danger"/>
			<form:input class="form-control mb-3" type='text'
				value='${book.language }' path='language'/>
			<!-- Pages -->
			<form:errors path='numberOfPages' class="text-danger"/>
			<form:input class="form-control mb-3" type='number'
				value='${book.numberOfPages }' path='numberOfPages'/>
			<button type='submit' class="btn btn-light">Update</button>
		</form:form>
		<form action="/book/${book.id}/delete" method="post">
			<input type="hidden" name="_method" value="delete"> <input
				class="btn btn-danger" type="submit" value="Delete">
		</form>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>