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
	<div class="contianer contianer-fluid">
		<h1>New Ninja</h1>
		<div class="d-flex justify-content-around align-items-center ">
			<div class="col-3">
				<form:form action="/ninja/new" method="post" modelAttribute="ninja">
					<div>
						<form:label path="dojo">Dojo:</form:label>
						<form:errors path="dojo" />
						<form:select path="dojo">
							<c:forEach var="dojo" items="${dojos}">
								<option value="${dojo.id}"><c:out value="${dojo.name}" /></option>
							</c:forEach>
						</form:select>
					</div>
					<div>
						<form:label path="firstName">First Name:</form:label>
						<form:errors path="firstName" />
						<form:input path="firstName" type="text"/>
					</div>
					<div>
						<form:label path="lastName">Last Name:</form:label>
						<form:errors path="lastName" />
						<form:input path="lastName" />
					</div>
					<div>
						<form:label path="age">Age:</form:label>
						<form:errors path="age" />
						<form:input path="age" type="number" />
					</div>
					<button type="submit">Create</button>
				</form:form>
			</div>
		</div>

	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>