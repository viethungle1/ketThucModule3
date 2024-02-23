<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<center>
    <h2>
        <form method="get">
            <input type="hidden" value="search"/>
            <input type="hidden" name="action" value="search"/>
            <input type="text" name="c"/>
            <button type="submit">Search</button>
        </form>
        <a href="/student?action=create">Add New</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>DateOfBirth</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Class</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${list}" var="s">
            <tr>
                <td>${s.name}</td>
                <td>${s.mail}</td>
                <td>${s.dob}</td>
                <td>${s.address}</td>
                <td>${s.phone}</td>
                <td>${s.class_name}</td>
                <td>
                    <a href="/student?action=edit&id=${s.id}">Edit</a>
                    <a href="/student?action=delete&id=${s.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
