package ua.kpi.iasa.ServletWebMarket.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateInit {
    private static final SessionFactory SESSION_FACTORY;

    private HibernateInit() {
    }

    static {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
