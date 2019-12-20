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
import java.util.ArrayList;

@WebServlet(name = "RedactAccServlet",urlPatterns = "/redacc")
public class RedactAccServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/pages/redacc.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository = new UserRepository().getInstance();
        User user = ((User) req.getSession().getAttribute("currentUser"));
        UserValidator userValidator = new UserValidator();
        String newFirstName = req.getParameter("newFirstName");
        if (userValidator.validFirstName(newFirstName)) {
            user.setFirstName(newFirstName);
            req.setAttribute("invalidateFirstName", false);
        } else {
            req.setAttribute("invalidateFirstName", true);
        }
        String newLastName = req.getParameter("newLastName");
        if (userValidator.validLastName(newLastName)) {
            user.setLastName(newLastName);
            req.setAttribute("invalidateLastName", false);
        } else {
            req.setAttribute("invalidateLastName", true);
        }
        String newPass = req.getParameter("newPass");
        if (userValidator.validPassword(newPass)) {
            user.setPass(newPass);
            req.setAttribute("invalidatePass", false);
        } else {
            req.setAttribute("invalidatePass", true);
        }
        String newAge = req.getParameter("newAge");
        if (userValidator.validAge(newAge)) {
            user.setAge(Integer.parseInt(newAge));
            req.setAttribute("invalidateAge", false);
        } else {
            req.setAttribute("invalidateAge", true);
        }
        if ((boolean) req.getAttribute("invalidateAge") || (boolean) req.getAttribute("invalidatePass") ||
                (boolean) req.getAttribute("invalidateFirstName") || (boolean) req.getAttribute("invalidateLastName")) {
            getServletContext().getRequestDispatcher("/WEB-INF/pages/redacc.jsp").forward(req, resp);
        } else {
            if (user.getPass().equals("adminadmin") && (user.getEmail().equals("admin@a.dm")))
                user.getRole().setName("admin");
            userRepository.set(user.getEmail(),user);
            req.getSession().setAttribute("currentUser",user);
            resp.sendRedirect("/main");
        }
    }
}
