<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<h1>List Student</h1>
<p>
    <a href="/students?action=create">Create new student</a>
</p>

<table border="1">
    <tr>
        <td>Name</td>
        <td>Age</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${student}' var="student">
        <tr>
            <td>${student.getName}</td>
            <td>${student.getAge}</td>
            <td>${student.getAddress}</td>
            <td><a href="/students?action=edit&id=${student.getId()}">edit</a></td>
            <td><a href="/students?action=delete&id=${student.getId()}">delete</a></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
