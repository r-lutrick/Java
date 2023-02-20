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
		<table class="table table-light">
			<thead>
				<tr>
					<th>Title</th>
					<th>Language</th>
					<th>Pages</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td><a href="/book/${book.id}"> <c:out
									value="${book.title}" />
						</a></td>
						<td><c:out value="${book.language }" /></td>
						<td><c:out value="${book.numberOfPages }" /></td>
						<c:choose>
							<c:when test="${book.user.id == userId}">
								<td class="d-flex"><a class="btn btn-sm btn-info mx-2" href="/book/${book.id}/edit">Edit</a>
									<form action="/book/${book.id}/delete" method="post">
										<input type="hidden" name="_method" value="delete"> <input
											type="submit" value="Delete" class="btn btn-sm btn-danger">
									</form></td>
							</c:when>
							<c:otherwise>
								<td></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>