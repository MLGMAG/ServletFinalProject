package ua.kpi.iasa.ServletWebMarket.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.kpi.iasa.ServletWebMarket.config.HibernateInit;
import ua.kpi.iasa.ServletWebMarket.dao.UserDao;
import ua.kpi.iasa.ServletWebMarket.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserDaoImpl implements UserDao {
    @Override
    public Optional<User> getById(UUID id) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Query<User> query = (Query<User>) session.createQuery("FROM User u WHERE u.id=:id");
        query.setParameter("id", id);
        User user = query.uniqueResult();
        session.close();
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Query<User> query = (Query<User>) session.createQuery("FROM User u WHERE u.username=:username");
        query.setParameter("username", username);
        User user = query.uniqueResult();
        session.close();
        return Optional.ofNullable(user);
    }

    @Override
    public void removeByUsername(String username) {
        try (Session session = HibernateInit.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(getByUsername(username).orElseThrow(RuntimeException::new));
            transaction.commit();
        }
    }

    @Override
    public void save(User user) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeById(UUID uuid) {
        try (Session session = HibernateInit.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(getById(uuid).orElseThrow(RuntimeException::new));
            transaction.commit();
        }
    }

    @Override
    public List<User> getAll() {
        Session session = HibernateInit.getSessionFactory().openSession();
        Query<User> query = (Query<User>) session.createQuery("FROM User");
        List<User> list = query.list();
        session.close();
        return list;
    }
}
