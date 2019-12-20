package by.filter;

import by.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter", servletNames = {"AdminServlet", "UsersServlet", "UserServlet"})
public class AdminFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (((User) req.getSession().getAttribute("currentUser")).getRole().getName().equals("admin")) {
            super.doFilter(req, res, chain);
        }
    }
}
