package com.example.servletdemo.dao;

import com.example.servletdemo.entity.Student;

import java.util.List;

public interface StudentDAO  {
    void create(Student student);
    List<Student> getAll();

    Student findById(int id);

    void deleteById(int id);

    void updateStudent(Student student);
}
