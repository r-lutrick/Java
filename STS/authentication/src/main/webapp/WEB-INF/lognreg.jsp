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
<title>Book Club</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1 class="mb-3 px-4 pb-3 pt-2 bg-dark">
		<i class="text-success">Book</i><b class="text-info">Club</b>
	</h1>
	<div class="container container-fluid">
		<div>
			<div class="border shadow px-5 mb-4">
				<h2 class="text-success my-4"><i>Login</i></h2>
				<form:form action="/login" method="POST" modelAttribute="newLogin">
					<div class="form-group mb-3">
						<form:label path="email">Email:</form:label>
						<form:errors path="email" class="text-danger" />
						<form:input path="email" type="text" class="form-control" />
					</div>
					<div class="form-group mb-3">
						<form:label path="password">Password:</form:label>
						<form:errors path="password" class="text-danger" />
						<form:input path="password" type="password" class="form-control" />
					</div>
					<button type="submit" class="btn btn-success mb-4">Create</button>
				</form:form>
			</div>
			<div class="border shadow px-5">
				<h2 class="text-info my-4"><b>Register</b></h2>
				<form:form action="/register" method="POST" modelAttribute="newUser">
					<div class="form-group mb-3">
						<form:label path="userName">User Name:</form:label>
						<form:errors path="userName" class="text-danger" />
						<form:input path="userName" type="text" class="form-control" />
					</div>
					<div class="form-group mb-3">
						<form:label path="email">Email:</form:label>
						<form:errors path="email" class="text-danger" />
						<form:input path="email" class="form-control" />
					</div>
					<div class="form-group mb-3">
						<form:label path="password">Password:</form:label>
						<form:errors path="password" class="text-danger" />
						<form:input path="password" type="password" class="form-control" />
					</div>
					<div class="form-group mb-3">
						<form:label path="confirm">Confirm Password:</form:label>
						<form:errors path="confirm" class="text-danger" />
						<form:input path="confirm" type="password" class="form-control" />
					</div>
					<button type="submit" class="btn btn-info text-light mb-4">Create</button>
				</form:form>
			</div>
		</div>
	</div>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>