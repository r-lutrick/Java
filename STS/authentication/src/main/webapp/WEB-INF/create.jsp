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
	<div>
		<!-- NAVBAR -->
		<div
			class="bg-white border mb-3 px-4 pb-3 pt-2 d-flex align-items-center justify-content-between">
			<h1>
				<i class="text-success">Book</i><b class="text-info">Club</b>
			</h1>
			<div class="gap">
				<a href="/dashboard">Home</a> <a href="/logout">Logout</a>
			</div>
		</div>
		<!-- MAIN -->
		<div
			class="container container-fluid border border-success bg-white p-4">
			<h2 class="text-success mb-4">Add a new book</h2>
			<form:form modelAttribute="book" action="/create" method="POST"
				class="p-3">
				<div class="form-group mb-3">
					<!-- Title -->
					<form:label path='title'>Title:</form:label>
					<form:errors path='title' class="text-danger" />
					<form:input path='title' class="form-control" type='text' />
				</div>
				<div class="form-group mb-3">
					<!-- Language -->
					<form:label path='language'>Language:</form:label>
					<form:errors path='language' class="text-danger" />
					<form:input path='language' class="form-control" type='text' />
				</div>
				<div class="form-group mb-3">
					<!-- Pages -->
					<form:label path='numberOfPages'>Pages:</form:label>
					<form:errors path='numberOfPages' class="text-danger" />
					<form:input path='numberOfPages' class="form-control" type='number' />
				</div>
				<div class="form-group mb-3">
					<!-- Description -->
					<form:label path='description'>Description:</form:label>
					<form:errors path='description' class="text-danger" />
					<form:textarea path='description' class="form-control" type='text' />
				</div>
				<form:hidden path="user" value="${userId}" />
				<button type='submit' class="btn btn-success">Create</button>
			</form:form>
		</div>
	</div>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>