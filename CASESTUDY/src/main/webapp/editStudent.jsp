<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/15/2023
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<h1>Edit Student</h1>
<p>
    <a href="/students">Back to student list</a>
</p>
<form method="post">
    <label>
        <input type="text" name="name" id="name" value="${requestScope["student"].getName}">
        <input type="number" name="name" id="age" value="${requestScope["student"].getAge}">
        <input type="text" name="name" id="address" value="${requestScope["student"].getAddress}">
    </label>
    <input type="submit" value="Edit">
</form>
</body>
</html>
