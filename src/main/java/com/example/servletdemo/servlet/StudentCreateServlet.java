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


@WebServlet(value = "/student-create")
public class StudentCreateServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init(){
        studentDAO = new StudentDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Student student = new Student();
            student.setName(req.getParameter("name"));
            student.setCode(req.getParameter("code"));
            String birthday = req.getParameter("birthday");
            student.setBirthday(dateFormat.parse(birthday));
            studentDAO.create(student);
            resp.sendRedirect("/student-list");
        }catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
    }
}
