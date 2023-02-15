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

<body class="container container-fluid">
	<h1 style="text-align: center">Send an Omikuji!</h1>
	<form action="/process" method='POST' class="w-50 mx-auto p-5 border">
		<div class="form-group">
			<label>Pick any number from 5 to 25</label><br /> <input
				class="form-control" type="number" name="luckyNumber" value="5" />
		</div>
		<div class="form-group">
			<label>Enter the name of any city.</label><br /> <input
				class="form-control" type="text" name="city" />
		</div>
		<div class="form-group">
			<label>Enter the name of any real person</label><br /> <input
				class="form-control" type="text" name="person" />
		</div>
		<div class="form-group">
			<label>Enter professional endeavor or hobby:</label><br /> <input
				class="form-control" type="text" name="hobby" />
		</div>
		<div class="form-group">
			<label>Enter any type of living thing.</label><br /> <input
				class="form-control" type="text" name="livingThing" />
		</div>
		<div class="form-group">
			<label>Say something nice to someone:</label><br />
			<textarea class="form-control" name="comment" id="comment" cols="50" rows="10"></textarea>
		</div>
		<div class="form-group">
			<i>Send and show a friend</i><br />
			<button type="submit" class="btn btn-outline-dark">Send</button>
		</div>
	</form>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>