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
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body style="background-color: #e7e7e7;">
	<!-- NAVBAR -->
	<div
		class="bg-white border mb-3 px-4 pb-3 pt-2 d-flex align-items-center justify-content-between">
		<h1>
			<i class="text-success">Book</i><b class="text-info">Club</b>
		</h1>
		<div class="gap">
			<a href="/create">Add New Book</a> <a href="/logout">Logout</a>
		</div>
	</div>
	<!-- MAIN -->
	<div class="container container-fluid">
		<h2 class="text-info mb-4">Edit Book</h2>
		<form:form modelAttribute="book" action="/book/${book.id}/edit"
			method="post">
			<input type="hidden" name="_method" value="put">
			<!-- Title -->
			<form:errors path='title' class="text-danger" />
			<form:input class="form-control mb-3" type='text'
				value='${book.title}' path='title' />
			<!-- Language -->
			<form:errors path='language' class="text-danger" />
			<form:input class="form-control mb-3" type='text'
				value='${book.language }' path='language' />
			<!-- Pages -->
			<form:errors path='numberOfPages' class="text-danger" />
			<form:input class="form-control mb-3" type='number'
				value='${book.numberOfPages }' path='numberOfPages' />
			<!-- Description -->
			<form:errors path='description' class="text-danger" />
			<form:textarea class="form-control mb-3" type='text'
				value='${book.description }' path='description' />
			<form:hidden path="user" value="${userId}"/>
			<button type='submit' class="btn btn-info">Update</button>
		</form:form>
	</div>

	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>