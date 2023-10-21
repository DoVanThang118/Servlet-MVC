package com.example.servletdemo.dao.impl;

import com.example.servletdemo.Util.PersistenceUtil;
import com.example.servletdemo.dao.StudentDAO;
import com.example.servletdemo.entity.Student;

import javax.persistence.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    EntityManager en;
    EntityTransaction tran;

    public StudentDAOImpl() {
        en = PersistenceUtil.createEntityManagerFactory().createEntityManager();
        tran = en.getTransaction();
    }

    @Override
    public void create(Student student) {
        try {
            tran.begin();
            en.persist(student);
            tran.commit();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
            tran.rollback();
        }
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        try{
            Query query  = en.createQuery("select s from Student s");
            return query.getResultList();
        }catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
        return students;
    }

    @Override
    public Student findById(int id) {
//        Query query = en.createQuery("SELECT s FROM Student s WHERE s.id = :id");
//        query.setParameter("id", id);
//        try {
//            return (Student) query.getSingleResult();
//        } catch (NoResultException ex) {
//            System.out.println(ex.getMessage());
//            return null;
//        }
        return en.find(Student.class, id);
    }

    @Override
    public List<Student> searchStudent(String keyword) {
        Query query  = en.createQuery("select s from Student s");
        List<Student> students = query.getResultList();
        List<Student> result = new ArrayList<>();
        for (Student user : students) {
            if (user.getName().contains(keyword)) {
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public void deleteById(int id) {
        EntityTransaction transaction = en.getTransaction();
        try {
            transaction.begin();
            Student student = en.find(Student.class, id);
            if (student != null) {
                en.remove(student);
            }
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            transaction.rollback();
        }
    }

    @Override
    public void updateStudent(Student student) {
        EntityTransaction transaction = en.getTransaction();
        try {
            transaction.begin();
            Student existingStudent = en.find(Student.class, student.getId());
            if (existingStudent != null) {
                existingStudent.setName(student.getName());
                existingStudent.setCode(student.getCode());
                existingStudent.setBirthday(student.getBirthday());
                en.merge(existingStudent);
            }
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            transaction.rollback();
        }
    }
}

