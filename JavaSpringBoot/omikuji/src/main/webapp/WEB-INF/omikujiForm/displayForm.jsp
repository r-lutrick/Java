<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container container-fluid">
		<h1 style="text-align: center">Here's Your Omikuji!</h1>
		<div class="w-50 mx-auto p-5 border">
			<p>
				In
				<c:out value="${luckyNumber}" />
				years, you will live in
				<c:out value="${city}" />
				with
				<c:out value="${person}" />
				as your roommate,
				<c:out value="${hobby}" />
				for a living. The next time you see
				<c:out value="${livingThing }" />
				you will have good luck. Also,
				<c:out value="${comment}" />
				.
			</p>
		</div>
		<div class="w-50 mx-auto p-5">
			<a class="btn btn-outline-dark" style="float:right" href="/input">go back</a>
		</div>
	</div>
</body>
</html>