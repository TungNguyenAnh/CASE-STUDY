<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View customer</title>
</head>
<body>
<h1>Customer details</h1>
<p>
    <a href="/students">Back to student list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["student"].getName()}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${requestScope["student"].getEmail()}</td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>${requestScope["student"].getAddress()}</td>
    </tr>
</table>
</body>
</html>