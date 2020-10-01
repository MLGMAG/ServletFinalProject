package ua.kpi.iasa.ServletWebMarket.dao;

import java.util.List;

public interface GenericDao<T, ID> {
    void save(T t);

    void update(T t);

    void delete(ID id);

    List<T> getAll();

    T getById(ID id);
}
