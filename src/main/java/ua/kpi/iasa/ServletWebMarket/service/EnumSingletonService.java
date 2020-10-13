package ua.kpi.iasa.ServletWebMarket.service;

public enum EnumSingletonService {
    INSTANCE;
    UserService userService;

    EnumSingletonService() {
        userService = new UserService();
    }

    public EnumSingletonService getInstance() {
        return INSTANCE;
    }

    public UserService getUserService() {
        return userService;
    }

}
