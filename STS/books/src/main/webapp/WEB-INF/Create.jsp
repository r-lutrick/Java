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
		<h1>New Book</h1>
		<form:form modelAttribute="book" action="/book/new" method="POST"
			class="bg-transparent form-control p-3">
			<!-- Title -->
			<form:errors path='title' class="text-danger"/>
			<form:input path='title' class="form-control mb-3" type='text'
				placeholder='Title' />
			<!-- Description -->
			<form:errors path='description' class="text-danger"/>
			<form:input path='description' class="form-control mb-3" type='text'
				placeholder='Description' />
			<!-- Language -->
			<form:errors path='language' class="text-danger"/>
			<form:input path='language' class="form-control mb-3" type='text'
				placeholder='Language' />
			<!-- Pages -->
			<form:errors path='numberOfPages' class="text-danger"/>
			<form:input path='numberOfPages' class="form-control mb-3"
				type='number' placeholder='Pages' />
			<button type='submit' class="btn btn-light">Create</button>
		</form:form>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>