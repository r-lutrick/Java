<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter App</title>
</head>
<body>
    <p>You have visited <a href="/">http://localhost:8080/</a> <c:out value="${count}"/> times</p>
    <a href="/counter">Test another visit?</a><br/>
    <a href="/double">+2 it!</a><br/>
    <a href="/reset">Reset</a>
</body>
</html>