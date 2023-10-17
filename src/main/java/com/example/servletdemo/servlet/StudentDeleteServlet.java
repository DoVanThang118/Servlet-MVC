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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet("/student-delete")
public class StudentDeleteServlet extends HttpServlet {

    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAOImpl();
    }
    private List<Student> studentList = new ArrayList<>();
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteById(id);

        response.sendRedirect("student-list");
    }
}
