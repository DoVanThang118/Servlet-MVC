<%@ page import="java.util.List" %>
<%@ page import="com.example.servletdemo.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Victor_Ho
  Date: 10/13/2023
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h2>Student List</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Code</th>
        <th>Birthday</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        for (Student student : students) {
    %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getCode() %></td>
            <td><%= student.getBirthday() %></td>
            <td>
                <form action="student-delete" method="post">
                    <input type="hidden" name="id" value="<%= student.getId() %>">
                    <input type="submit" value="Delete">
                </form>
            </td>
            <td>
                <form action="student-update" method="post">
                    <input type="hidden" name="id" value="<%= student.getId() %>">
                    <input type="submit" value="Update">
                </form>
            </td>
        </tr>
    <% } %>
</table>

<h2>Add Student</h2>
<form action="student-create" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name">
    <br><br>
    <label for="age">code:</label>
    <input type="text" id="age" name="code">
    <br><br>
    <label for="birthday">Birthday:</label>
    <input type="date" id="birthday" name='birthday'>
    <br><br>
    <input type="submit" value="Add Student">
</form>
</body>
</html>
