package ua.kpi.iasa.ServletWebMarket.constant;

import java.util.Arrays;
import java.util.List;

public class AllSiteURL {
    private AllSiteURL() {
    }

    public static final String PATH = "/ServletWebMarket_war";
    public static final String SIGN_IN_PAGE = "/sign-in";
    public static final String REG_PAGE = "/sign-up";
    public static final String START_PAGE = "/";
    public static final String PRODUCTS_PAGE = "/products";
    public static final String PROFILE_PAGE = "/profile";
    public static final String ORDERS_PAGE = "/order";
    public static final String USERS_PAGE = "/users";

    public static final List<String> PUBLIC_PAGES = Arrays.asList(SIGN_IN_PAGE, REG_PAGE, START_PAGE, PRODUCTS_PAGE);
}
