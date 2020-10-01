package ua.kpi.iasa.ServletWebMarket.dao;

import ua.kpi.iasa.ServletWebMarket.model.User;

import java.util.UUID;

public interface UserDao extends GenericDao<User, UUID> {
    User getById(String id);
    User getByUsername(String username);
}
