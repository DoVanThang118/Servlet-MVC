<%--
  Created by IntelliJ IDEA.
  User: Victor_Ho
  Date: 10/17/2023
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
<h2>Update Student Information</h2>
<form action="student-update" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value=""><br><br>
    <label for="code">Code:</label>
    <input type="text" id="code" name="code" value=""><br><br>
    <label for="birthday">Birthday:</label>
    <input type="text" id="birthday" name="birthday" value=""><br><br>
    <input type="submit" value="Update">
</form>
</body>
</html>

