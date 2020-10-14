package ua.kpi.iasa.ServletWebMarket.controller;

import ua.kpi.iasa.ServletWebMarket.constant.AllSiteURL;
import ua.kpi.iasa.ServletWebMarket.constant.PagesNaming;
import ua.kpi.iasa.ServletWebMarket.exception.LoginException;
import ua.kpi.iasa.ServletWebMarket.model.User;
import ua.kpi.iasa.ServletWebMarket.service.EnumSingletonService;
import ua.kpi.iasa.ServletWebMarket.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    private final UserService userService = EnumSingletonService.INSTANCE.getUserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        try {
            userService.login(user);
        } catch (LoginException e) {
            req.setAttribute("loginException", true);
            req.getRequestDispatcher(PagesNaming.PATH + PagesNaming.SIGN_IN_PAGE).forward(req, resp);
        }
        req.getSession().setAttribute("user", user);
        resp.sendRedirect(AllSiteURL.PATH + AllSiteURL.PROFILE_PAGE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher(PagesNaming.PATH + PagesNaming.SIGN_IN_PAGE).forward(req, resp);
    }
}
