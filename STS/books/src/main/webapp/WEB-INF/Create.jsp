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
		<form class="bg-transparent form-control p-3" action="/process" method="POST">
			<!-- Title -->
			<input class="form-control mb-3" type='text' placeholder='Title' name='title'>
			<!-- Description -->
			<input class="form-control mb-3" type='text' placeholder='Description' name='description'>
			<!-- Language -->
			<input class="form-control mb-3" type='text' placeholder='Language' name='language'>
			<!-- Pages -->
			<input class="form-control mb-3" type='number' placeholder='Pages' name='numberOfPages'>
			<button type='submit' class="btn btn-light">Create</button>
		</form>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>