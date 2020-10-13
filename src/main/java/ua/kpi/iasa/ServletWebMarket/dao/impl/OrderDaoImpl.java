package ua.kpi.iasa.ServletWebMarket.dao.impl;

import ua.kpi.iasa.ServletWebMarket.dao.OrderDao;
import ua.kpi.iasa.ServletWebMarket.model.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void save(Order order) {

    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void removeById(UUID uuid) {

    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Optional<Order> getById(UUID uuid) {
        return Optional.empty();
    }
}
