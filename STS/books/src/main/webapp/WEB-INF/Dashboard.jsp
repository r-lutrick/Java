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
<style>
tr {
	cursor: pointer;
}
</style>
</head>
<body style="background-color: #282828">
	<div class="container container-fluid text-white">
		<h1>All Books!</h1>
		<table class="table table-light">
			<thead>
				<tr>
					<th>Title</th>
					<th>Language</th>
					<th>Pages</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr onclick="window.location='/book/${book.id}'">
						<td><c:out value="${book.title}" /></td>
						<td><c:out value="${book.language }" /></td>
						<td><c:out value="${book.numberOfPages }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-light" href="/book/new">Add Book</a>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>