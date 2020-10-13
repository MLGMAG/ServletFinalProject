package ua.kpi.iasa.ServletWebMarket.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, ID> {
    void save(T t);

    void update(T t);

    void removeById(ID id);

    List<T> getAll();

    Optional<T> getById(ID id);
}
