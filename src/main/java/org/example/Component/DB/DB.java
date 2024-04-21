package org.example.Component.DB;

import org.example.Component.Exception.EntityNotFoundException;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DB {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


}
