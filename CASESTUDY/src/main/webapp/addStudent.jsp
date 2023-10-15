<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/15/2023
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add A Student</title>
</head>
<body>
<h1>Add a student</h1>
<p>
    <a href="/students">Back To Student List</a>
</p>
<form method="post">
    <label>
        <input type="text" name="id"><br>
        <input type="text" name="name"><br>
        <input type="number" name="age"><br>
        <input type="text" name="address"><br>

        <input type="submit" value="Add"><br>
        <input type="reset" value="Reset">
    </label>
</form>
</body>
</html>
