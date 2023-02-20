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
			<a href="/dashboard">Home</a> <a href="/logout">Logout</a>
		</div>
	</div>
	<!-- MAIN -->
	<div class="container container-fluid">
		<div class="card p-4">
			<h2 class="card-title text-info mb-4">
				<c:out value="${book.title}" />
				details:
			</h2>
			<p class="card-text"><c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/> in <c:out value="${book.language}"/>.</p>
			<p>Here are <c:out value="${book.user.userName}"/>'s thoughts:
			<hr>
			<p><c:out value="${book.description}"/> </p>
			<hr> 
		</div>

	</div>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>