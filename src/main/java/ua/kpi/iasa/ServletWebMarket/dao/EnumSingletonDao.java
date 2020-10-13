package ua.kpi.iasa.ServletWebMarket.dao;

import ua.kpi.iasa.ServletWebMarket.dao.impl.OrderDaoImpl;
import ua.kpi.iasa.ServletWebMarket.dao.impl.ProductDaoImpl;
import ua.kpi.iasa.ServletWebMarket.dao.impl.UserDaoImpl;

public enum EnumSingletonDao {
    INSTANCE;
    OrderDao orderDao;
    ProductDao productDao;
    UserDao userDao;

    EnumSingletonDao() {
        orderDao = new OrderDaoImpl();
        productDao = new ProductDaoImpl();
        userDao = new UserDaoImpl();
    }

    public EnumSingletonDao getInstance(){
        return INSTANCE;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
