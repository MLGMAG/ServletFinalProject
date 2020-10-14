package ua.kpi.iasa.ServletWebMarket.controller;

import ua.kpi.iasa.ServletWebMarket.constant.PagesNaming;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PagesNaming.PATH + PagesNaming.INDEX_PAGE).forward(req, resp);
    }
}
