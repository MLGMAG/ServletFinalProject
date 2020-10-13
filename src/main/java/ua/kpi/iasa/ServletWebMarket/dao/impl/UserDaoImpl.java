package ua.kpi.iasa.ServletWebMarket.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.kpi.iasa.ServletWebMarket.config.HibernateInit;
import ua.kpi.iasa.ServletWebMarket.dao.UserDao;
import ua.kpi.iasa.ServletWebMarket.model.User;

import java.util.List;
import java.util.UUID;

public class UserDaoImpl implements UserDao {
    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
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
    public void delete(UUID uuid) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(UUID uuid) {
        return null;
    }
}
