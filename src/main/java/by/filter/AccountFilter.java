package by.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AccountFilter", servletNames = {"AccountServlet", "RedactAccServlet",
        "LogoutServlet", "HistoryServlet", "ErrorServlet", "CalculatorServlet"})
public class AccountFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getSession().getAttribute("currentUser") != null) {
            super.doFilter(req, res, chain);
        }
    }
}