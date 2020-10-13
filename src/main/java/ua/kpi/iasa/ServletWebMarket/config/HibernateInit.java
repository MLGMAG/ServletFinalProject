package ua.kpi.iasa.ServletWebMarket.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateInit {
    private static final SessionFactory sessionFactory;

    private HibernateInit() {
    }

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
