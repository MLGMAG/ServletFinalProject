package ua.kpi.iasa.ServletWebMarket.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.kpi.iasa.ServletWebMarket.config.HibernateInit;
import ua.kpi.iasa.ServletWebMarket.dao.OrderDao;
import ua.kpi.iasa.ServletWebMarket.model.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void save(Order order) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Order order) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(order);
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
    public List<Order> getAll() {
        Session session = HibernateInit.getSessionFactory().openSession();
        Query<Order> query = (Query<Order>) session.createQuery("FROM Order");
        List<Order> list = query.list();
        session.close();
        return list;
    }

    @Override
    public Optional<Order> getById(UUID id) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Query<Order> query = (Query<Order>) session.createQuery("FROM Order o WHERE o.id=:id");
        query.setParameter("id", id);
        Order order = query.uniqueResult();
        session.close();
        return Optional.ofNullable(order);
    }
}
