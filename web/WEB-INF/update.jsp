<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Client</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:useBean id="clientId" scope="request" type="java.lang.String"/>
<div class="container">
    <h1>Edit Client</h1>
    <form action="clients.jsp" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="clientId" value="<%= clientId %>">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="<%= client.getFirstName() %>"><br><br>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="<%= client.getLastName() %>"><br><br>

        <label for="birthdate">Birthdate:</label>
        <input type="date" id="birthdate" name="birthdate" value="<%= client.getBirthdate().toLocalDate() %>"><br><br>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="<%= client.getAddress() %>"><br><br>

        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" value="<%= client.getPhoneNumber() %>"><br><br>

        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="<%= client.getEmail() %>"><br><br>

        <button type="submit" class="btn btn-primary">Update Client</button>
    </form>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- Additional scripts -->
</body>
</html>
