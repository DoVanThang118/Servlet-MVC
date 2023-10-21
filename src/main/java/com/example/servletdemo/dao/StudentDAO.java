package com.example.servletdemo.dao;

import com.example.servletdemo.entity.Student;

import java.util.List;

public interface StudentDAO  {
    void create(Student student);
    List<Student> getAll();

    Student findById(int id);
    List<Student> searchStudent(String keyword);

    void deleteById(int id);

    void updateStudent(Student student);
}
