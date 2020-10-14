package ua.kpi.iasa.ServletWebMarket.controller;

import ua.kpi.iasa.ServletWebMarket.constant.AllSiteURL;
import ua.kpi.iasa.ServletWebMarket.constant.PagesNaming;
import ua.kpi.iasa.ServletWebMarket.exception.DuplicateUsernameException;
import ua.kpi.iasa.ServletWebMarket.exception.PasswordsMatchException;
import ua.kpi.iasa.ServletWebMarket.exception.RegistrationException;
import ua.kpi.iasa.ServletWebMarket.model.Role;
import ua.kpi.iasa.ServletWebMarket.model.User;
import ua.kpi.iasa.ServletWebMarket.service.EnumSingletonService;
import ua.kpi.iasa.ServletWebMarket.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

public class SignUpServlet extends HttpServlet {

    private final UserService userService = EnumSingletonService.INSTANCE.getUserService();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setPassword(req.getParameter("password"));
        user.setConfirmPassword(req.getParameter("confirmPassword"));
        user.setRole(new HashSet<>());
        try {
            userService.register(user);
        } catch (DuplicateUsernameException e) {
            req.setAttribute("usernameException", true);
            req.getRequestDispatcher(PagesNaming.PATH + PagesNaming.SIGN_UP_PAGE).forward(req, resp);
        } catch (PasswordsMatchException e) {
            req.setAttribute("matchPasswordException", true);
            req.getRequestDispatcher(PagesNaming.PATH + PagesNaming.SIGN_UP_PAGE).forward(req, resp);
        } catch (RegistrationException e) {
            e.printStackTrace();
        }
        req.setAttribute("regSuccess", true);
        req.getRequestDispatcher(PagesNaming.PATH + PagesNaming.SIGN_IN_PAGE).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PagesNaming.PATH + PagesNaming.SIGN_UP_PAGE).forward(req, resp);
    }
}
