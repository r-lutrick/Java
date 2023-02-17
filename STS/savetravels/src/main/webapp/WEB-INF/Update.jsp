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
<body>
	<div class="container container-fluid">
		<div class="d-flex justify-content-between align-items-center">
			<h1 class="text-success">Edit Expense</h1>
			<a href="/dashboard">Go back</a>
		</div>
		<div>
			<form:form modelAttribute="expense" action="/expense/edit/{id}"
				method="post" class="form-control p-3" >
				<input type="hidden" name="_method" value="put">
				<div>
					<form:label path="name">Expense Name:</form:label>
					<form:errors path="name" class="text-danger" />
					<form:input path="name" value="${expense.name}" class="form-control mb-3" type='text' />
				</div>
				<div>
					<form:label path="vendor">Vendor:</form:label>
					<form:errors path="vendor" class="text-danger" />
					<form:input path="vendor" value="${expense.vendor}" class="form-control mb-3" type='text' />
				</div>
				<div>
					<form:label path="amount">Amount:</form:label>
					<form:errors path="amount" class="text-danger" />
					<form:input path="amount" value="${expense.amount}" class="form-control mb-3" type='number' />
				</div>
				<div>
					<form:label path="description">Description:</form:label>
					<form:errors path="description" class="text-danger" />
					<form:textarea path="description" value="${expense.description}" class="form-control mb-3"
						type='text' />
				</div>
				<button class="btn btn-primary" type="submit">Update</button>
			</form:form>
		</div>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>