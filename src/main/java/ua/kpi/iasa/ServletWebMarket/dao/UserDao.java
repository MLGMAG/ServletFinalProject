package ua.kpi.iasa.ServletWebMarket.dao;

import ua.kpi.iasa.ServletWebMarket.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserDao extends GenericDao<User, UUID> {
    Optional<User> getByUsername(String username);
    void removeByUsername(String username);
}
