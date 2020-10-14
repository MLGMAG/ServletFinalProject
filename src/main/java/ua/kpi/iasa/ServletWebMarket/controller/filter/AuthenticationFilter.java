package ua.kpi.iasa.ServletWebMarket.controller.filter;

import ua.kpi.iasa.ServletWebMarket.constant.AllSiteURL;
import ua.kpi.iasa.ServletWebMarket.constant.PagesNaming;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession(false);
        System.out.println(session);
        String uri = request.getRequestURI().replace(AllSiteURL.PATH, "");
        if (AllSiteURL.PUBLIC_PAGES.contains(uri)) {
            chain.doFilter(request, response);
        } else if (session != null && session.getAttribute("user") != null) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) resp).sendRedirect(AllSiteURL.PATH + AllSiteURL.SIGN_IN_PAGE);
        }
    }
}
