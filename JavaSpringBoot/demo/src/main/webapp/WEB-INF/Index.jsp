<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
div {
	width: 50%;
	margin-right: auto;
	margin-left: auto;
	display: flex;
	align-items: center;
	justify-content: space-around;
	flex-direction: column;
}

table.solid {
	border-style: solid;
	border-width: 5px;
	width: 50%
}

td.border {
	border-style: solid;
	border-width: 1px;
}
</style>
</head>
<body>
	<div>
		<h1 style="color: pink">Fruit Store</h1>
		<table class="solid">
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="fruit" items="${fruitsAttribute}">
					<c:set var="price" value="${ fruit.price }" />
					<tr style="text-align: center;">
						<td class="border"><c:out value="${fruit.name}"></c:out></td>
						<td class="border"><fmt:formatNumber value="${price}" type="currency" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>