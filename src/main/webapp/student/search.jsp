<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h2>
    <form method="get">
        <input type="hidden" name="action" value="search"/>
        <input type="text" name="c"/>
        <button type="submit">Search</button>
    </form>
</h2>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>DateOfBirth</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Class</th>
        </tr>
        <c:forEach items="${find}" var="s">
            <tr>
                <td>${s.name}</td>
                <td>${s.mail}</td>
                <td>${s.dob}</td>
                <td>${s.address}</td>
                <td>${s.phone}</td>
                <td>${s.class_name}</td>
                <td>
                    <a href="/book?action=edit&id=${book.id}">Edit</a>
                    <a href="/student?action=delete&id=${s.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
