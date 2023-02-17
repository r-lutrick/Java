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
	<div class="container container-fluid mb-5">
		<h1>Save Travels</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope='col'>Expense</th>
					<th scope='col'>Vendor</th>
					<th scope='col'>Amount</th>
					<th scope='col'>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
					<tr>
						<td><c:out value="${expense.name}" /></td>
						<td><c:out value="${expense.vendor}" /></td>
						<td><c:out value="$ ${expense.amount}" /></td>
						<td><a href="/expense/edit/${expense.id}" class="mx-3">Edit</a><a href="/book/delete/${expense.id}" class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container container-fluid">
		<h2>Add an expense:</h2>
		<form:form modelAttribute="expense" action="/expense/new" class="form-control p-3" method='POST'>
			<div>
				<form:label path="name">Expense Name:</form:label>
				<form:errors path="name" class="text-danger" />
				<form:input path="name" class="form-control mb-3" type='text' />
			</div>
			<div>
				<form:label path="vendor">Vendor:</form:label>
				<form:errors path="vendor" class="text-danger" />
				<form:input path="vendor" class="form-control mb-3" type='text' />
			</div>
			<div>
				<form:label path="amount">Amount:</form:label>
				<form:errors path="amount" class="text-danger" />
				<form:input path="amount" class="form-control mb-3" type='number' />
			</div>
			<div>
				<form:label path="description">Description:</form:label>
				<form:errors path="description" class="text-danger" />
				<form:textarea path="description" class="form-control mb-3" type='text' />
			</div>
			<button class="btn btn-primary" type="submit">Submit</button>
		</form:form>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>