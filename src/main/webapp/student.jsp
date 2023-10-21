<%@ page import="java.util.List" %>
<%@ page import="com.example.servletdemo.entity.Student" %>
<%--
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <nav class="navbar bg-body-tertiary">
                <div class="container-fluid">
                    <a class="navbar-brand">Navbar</a>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
        <div class="container">
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
        </div>
        <div class="container">
            <div>
                <h2>Student List</h2>
            </div>
            <table  class="table table-striped">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Code</th>
                    <th scope="col">Birthday</th>
                    <th scope="col">Delete</th>
                    <th scope="col">Update</th>
                </tr>
                <% List<Student> students = (List<Student>) request.getAttribute("students");
                    for (Student student : students) {
                %>
                <tr>
                    <td scope="row">
                        <%= student.getId() %>
                    </td>
                    <td>
                        <%= student.getName() %>
                    </td>
                    <td>
                        <%= student.getCode() %>
                    </td>
                    <td>
                        <%= student.getBirthday() %>
                    </td>
                    <td>
                        <form action="student-delete" method="post">
                            <input type="hidden" name="id" value="<%= student.getId() %>">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                    <td>
                        <form action="student-go-update" method="post">
                            <input type="hidden" name="id" value="<%= student.getId() %>">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                </tr>
                <% } %>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </body>
</html>
