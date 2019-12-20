package by.servlet;

import by.entity.User;
import by.entity.UserValidator;
import by.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthServlet", urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/pages/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository = new UserRepository().getInstance();
        UserValidator userValidator = new UserValidator();
        String pass = req.getParameter("pass");
        if ((!pass.equals("")) && (userValidator.validPassword(pass))) {
            req.setAttribute("invalidatePass", false);
        } else {
            req.setAttribute("invalidatePass", true);
        }
        String email = req.getParameter("email");
        if ((!email.equals(""))) {
            req.setAttribute("invalidateEmail", false);
        } else {
            req.setAttribute("invalidateEmail", true);
        }
        if ((boolean) req.getAttribute("invalidatePass") || (boolean) req.getAttribute("invalidateEmail")) {
            getServletContext().getRequestDispatcher("/WEB-INF/pages/auth.jsp").forward(req, resp);
        } else {
            User user = userRepository.get(email);
            if (user.getPass().equals(pass)) {
                req.getSession().setAttribute("currentUser", user);
            }
            resp.sendRedirect("/main");
        }
    }
}
