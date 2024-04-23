package org.example.Component.DB;

import org.example.Component.Model.Model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    public static void initDb() {
        Session session = sessionFactory.openSession();
        session.close();
    }

    public static <T extends Model> List<T> all(Class<T> entity) {
        Session session = sessionFactory.openSession();
        System.out.println();
        List<T> result = session.createQuery("FROM " + entity.getName(), entity).getResultList();
        session.close();
        return result;
    }

    public static <T extends Model> T get(Class<T> entity, int id) {
        Session session = sessionFactory.openSession();
        T result = session.get(entity, id);
        session.close();
        return result;
    }

    public static <T extends Model> void create(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
    }

    public static <T extends Model> void update(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(entity);
        transaction.commit();
        session.close();
    }

    public static <T extends Model> void delete(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(entity);
        transaction.commit();
        session.close();
    }
}
