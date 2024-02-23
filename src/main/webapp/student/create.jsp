<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Minitest_3</title>
</head>
<body>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Mail:</th>
                <td>
                    <input type="text" name="mail" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Date Of Birth:</th>
                <td>
                    <input type="text" name="dob" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="phone" size="45"/>
                </td>
            </tr>
            <tr>
            <tr>
                <th>Class: </th>
                <td>
                    <select name="course">
                        <c:forEach items="${course}" var="c">
                            <option  value="${c.id}">${c.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>






            <tr>
                <td colspan="2" align="center">
                    <button type="submit">Save</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
