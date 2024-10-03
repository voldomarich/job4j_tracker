package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.tracker.tracker.Item;
import ru.job4j.tracker.tracker.Store;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sessionFactory;

    public HbmTracker(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Item add(Item item) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(item);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null && transaction.getStatus().canRollback()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean isUpdated = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                int updatedRows = session.createQuery(
                                "UPDATE Item i SET i.name = :fName WHERE i.id = :fId")
                        .setParameter("fName", item.getName())
                        .setParameter("fId", id)
                        .executeUpdate();
                transaction.commit();
                isUpdated = updatedRows > 0;
            } catch (Exception e) {
                if (transaction != null && transaction.getStatus().canRollback()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
        return isUpdated;
    }

    @Override
    public void delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.createQuery(
                                "DELETE Item i WHERE i.id = :fId")
                        .setParameter("fId", id)
                        .executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null && transaction.getStatus().canRollback()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.createQuery("DELETE FROM Item").executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null && transaction.getStatus().canRollback()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Item> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Item i order by i.id", Item.class)
                    .getResultList();
        }
    }

    @Override
    public List<Item> findByName(String key) {
        try (Session session = sessionFactory.openSession()) {
            Query<Item> query = session.createQuery(
                    "FROM Item i where i.name = :fName", Item.class);
            query.setParameter("fName", key);
            return query.list();
        }
    }

    @Override
    public Item findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Item> query = session.createQuery(
                    "FROM Item i where i.id = :fId", Item.class);
            query.setParameter("fId", id);
            return query.uniqueResult();
        }
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
