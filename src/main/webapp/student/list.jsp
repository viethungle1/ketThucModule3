<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Student Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<center>
        <form method="get">
            <input type="hidden" value="search"/>
            <input type="hidden" name="action" value="search"/>
            <input type="text" name="c" placeholder="Search by name"/>
            <button type="submit">Search</button>
        </form>
    <h3><a href="/student?action=create">Add New</a></h3>
</center>
<div align="center">
    <table class="table table-striped">
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
