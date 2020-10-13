package ua.kpi.iasa.ServletWebMarket.dao.impl;

import ua.kpi.iasa.ServletWebMarket.dao.ProductDao;
import ua.kpi.iasa.ServletWebMarket.model.Color;
import ua.kpi.iasa.ServletWebMarket.model.Product;

import java.util.List;
import java.util.UUID;

public class ProductDaoImpl implements ProductDao {
    @Override
    public Product getByName(String name) {
        return null;
    }

    @Override
    public List<Product> getByColor(Color color) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getById(UUID uuid) {
        return null;
    }
}
