package org.example.Component.DB;

import org.example.Component.Exception.EntityNotFoundException;
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

    public static List<?> all(Class<?> entity) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User", entity).getResultList();
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

    public static Object get(Class<?> entity, int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(entity, id);
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

    public static void create(Object entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

    public static void update(Object record) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(record);
            transaction.commit();
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

    public static void delete(Object record) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(record);
            transaction.commit();
            System.out.println("Record deleted successfully: " + record.getClass().getSimpleName());
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }
}
