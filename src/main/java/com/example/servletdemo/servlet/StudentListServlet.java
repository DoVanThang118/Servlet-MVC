package com.example.servletdemo.servlet;

import com.example.servletdemo.dao.StudentDAO;
import com.example.servletdemo.dao.impl.StudentDAOImpl;
import com.example.servletdemo.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(value = "/student-list")
public class StudentListServlet extends HttpServlet {

    private StudentDAO studentDAO;

    public void init(){
        studentDAO = new StudentDAOImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentDAO.getAll();
        req.setAttribute("students", students);
        req.getRequestDispatcher("student.jsp").forward(req, resp);
    }
}
