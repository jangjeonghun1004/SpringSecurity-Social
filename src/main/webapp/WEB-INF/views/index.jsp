<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h1>Welcome, ${name}!</h1>
    <p>Your email: ${email}</p>

    <c:if test="${empty name}">
         <a href="/login">Login</a>
    </c:if>

    <c:if test="${name != ''}">
         <a href="/logout">Logout</a>
    </c:if>

</body>
</html>
