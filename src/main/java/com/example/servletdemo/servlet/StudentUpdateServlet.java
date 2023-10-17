package com.example.servletdemo.servlet;

import com.example.servletdemo.dao.StudentDAO;
import com.example.servletdemo.dao.impl.StudentDAOImpl;
import com.example.servletdemo.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/student-update")
public class StudentUpdateServlet extends HttpServlet {

    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("student-list");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Student student = new Student();
            student.setName(request.getParameter("name"));
            student.setCode(request.getParameter("code"));
            String birthday = request.getParameter("birthday");
            student.setBirthday(dateFormat.parse(birthday));
            studentDAO.updateStudent(student);

            response.sendRedirect("student-list");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
