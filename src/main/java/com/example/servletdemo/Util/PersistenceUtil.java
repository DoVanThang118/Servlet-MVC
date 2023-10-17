package com.example.servletdemo.Util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static EntityManagerFactory entityManagerFactory;

    public static synchronized EntityManagerFactory createEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpaServlet");
        }
        return  entityManagerFactory;
    }
}
