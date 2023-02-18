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
			<h1 class="text-primary">Expense Details</h1>
			<a href="/dashboard">Go back</a>
		</div>
		<div>
			<div>
				<p>
					<b>Expense Name:</b>
					<c:out value="${expense.name}" />
				</p>
			</div>
			<div>
				<p>
					<b>Vendor:</b>
					<c:out value="${expense.vendor}" />
				</p>
			</div>
			<div>
				<p>
					<b>Amount Spent:</b>
					<c:out value="${expense.amount}" />
				</p>
			</div>
			<div>
				<p>
					<b>Expense Description:</b>
					<c:out value="${expense.description}" />
				</p>
			</div>
		</div>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>