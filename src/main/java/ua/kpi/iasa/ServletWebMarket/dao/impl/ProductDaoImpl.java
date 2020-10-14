package ua.kpi.iasa.ServletWebMarket.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.kpi.iasa.ServletWebMarket.config.HibernateInit;
import ua.kpi.iasa.ServletWebMarket.dao.ProductDao;
import ua.kpi.iasa.ServletWebMarket.model.Color;
import ua.kpi.iasa.ServletWebMarket.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductDaoImpl implements ProductDao {
    @Override
    public Optional<Product> getByName(String name) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Query<Product> query = (Query<Product>) session.createQuery("FROM Product p WHERE p.name=:name");
        query.setParameter("name", name);
        Product product = query.uniqueResult();
        session.close();
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> getByColor(Color color) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Query<Product> query = (Query<Product>) session.createQuery("FROM Product p WHERE p.color=:color");
        query.setParameter("color", color);
        session.close();
        return query.list();
    }

    @Override
    public void save(Product product) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Product product) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
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
    public List<Product> getAll() {
        Session session = HibernateInit.getSessionFactory().openSession();
        Query<Product> query = (Query<Product>) session.createQuery("FROM Product");
        List<Product> list = query.list();
        session.close();
        return list;
    }

    @Override
    public Optional<Product> getById(UUID id) {
        Session session = HibernateInit.getSessionFactory().openSession();
        Query<Product> query = (Query<Product>) session.createQuery("FROM Product p WHERE p.id=:id");
        query.setParameter("id", id);
        Product product = query.uniqueResult();
        session.close();
        return Optional.ofNullable(product);
    }
}
