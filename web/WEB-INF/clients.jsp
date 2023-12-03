<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Clients</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 0 auto;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .add_form{
            display: flex;
            flex-direction: column;
            padding: 15px;
            margin: 15px auto;
            width: 50%;
        }
        input[type="text"], input[type="date"] {
            margin-bottom: 10px;
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ddd;
        }
        button[type="submit"] {
            padding: 10px;
            border-radius: 5px;
            border: none;
            background-color: #28a745;
            color: white;
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="container">
    <a class="navbar-brand" href="index.jsp">Clients</a>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Birthdate</th>
            <th>Address</th>
            <th>Phone number</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="clients" scope="request" type="java.sql.ResultSet"/>
        <%
            try {
                java.sql.ResultSetMetaData result = clients.getMetaData();
                int columnsNumber = result.getColumnCount();
                while (clients.next()) {
                    List<String> list = new ArrayList<>();
                    for (int i = 1; i <= columnsNumber; i++) {
                        String columnValue = clients.getString(i);
                        list.add(columnValue);
                    }
        %>
        <tr>
            <% for(int i = 0; i < columnsNumber; i++){%>
            <td><%= list.get(i) %></td>
            <%}%>
            <td style="display: flex; flex-direction: column">
                <a href="update.jsp?clientId=<%= list.get(0) %>" class="btn btn-info">Edit</a>
                <form action="" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="clientId" value=<%= list.get(0) %>>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </td>
        </tr>
        <%
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        %>
        </tbody>
    </table>
    <form class="add_form" action="" method="post">
        <input type="hidden" name="action" value="add">
        <input type="text" name="firstName" placeholder="First name">
        <input type="text" name="lastName" placeholder="Last name">
        <input type="date" name="birthdate" placeholder="Date of birth">
        <input type="text" name="address" placeholder="Address">
        <input type="text" name="phoneNumber" placeholder="Phone number">
        <input type="text" name="email" placeholder="Email">
        <button type="submit">Add Client</button>
    </form>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
