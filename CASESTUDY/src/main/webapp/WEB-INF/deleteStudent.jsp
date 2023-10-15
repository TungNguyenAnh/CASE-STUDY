<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/15/2023
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DeleteStudent</title>

</head>
<body>
<p>
    <a href="/students">Back to student list</a>
</p>
<form method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td>${requestScope["student"].getName()}</td>
        </tr>
        <tr>
            <td>Age:</td>
            <td>${requestScope["student"].getAge()}</td>
        </tr>
        <tr>
            <td>Address:</td>
            <td>${requestScope["student"].getAddress()}</td>
        </tr>
        <tr>
            td><input type="submit" value="Delete student"></td>
            <td><a href="/students">Back to customer list</a></td>
        </tr>

    </table>
</form>
</body>
</html>
