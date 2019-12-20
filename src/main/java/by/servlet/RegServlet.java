package by.servlet;

import by.entity.Calculation;
import by.entity.User;
import by.entity.UserValidator;
import by.repository.HistoryRepository;
import by.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "RegServlet", urlPatterns = "/reg")
public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/pages/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository = new UserRepository().getInstance();
        User user = new User();
        UserValidator userValidator = new UserValidator();
        String email = req.getParameter("email");
        if (userValidator.validEmail(email)) {
            user.setEmail(email);
            req.setAttribute("invalidateEmail", false);
        } else {
            req.setAttribute("invalidateEmail", true);
        }
        String firstName = req.getParameter("firstName");
        if (userValidator.validFirstName(firstName)) {
            user.setFirstName(firstName);
            req.setAttribute("invalidateFirstName", false);
        } else {
            req.setAttribute("invalidateFirstName", true);
        }
        String lastName = req.getParameter("lastName");
        if (userValidator.validLastName(lastName)) {
            user.setLastName(lastName);
            req.setAttribute("invalidateLastName", false);
        } else {
            req.setAttribute("invalidateLastName", true);
        }
        String pass = req.getParameter("pass");
        if (userValidator.validPassword(pass)) {
            user.setPass(pass);
            req.setAttribute("invalidatePass", false);
        } else {
            req.setAttribute("invalidatePass", true);
        }
        String age = req.getParameter("age");
        if (userValidator.validAge(age)) {
            user.setAge(Integer.parseInt(age));
            req.setAttribute("invalidateAge", false);
        } else {
            req.setAttribute("invalidateAge", true);
        }
        if ((boolean) req.getAttribute("invalidateAge") || (boolean) req.getAttribute("invalidatePass") ||
                (boolean) req.getAttribute("invalidateFirstName") || (boolean) req.getAttribute("invalidateLastName") ||
                (boolean) req.getAttribute("invalidateEmail")||getServletContext().getAttribute(user.getEmail())!=null) {
            getServletContext().getRequestDispatcher("/WEB-INF/pages/reg.jsp").forward(req, resp);
            user.minusIncId();
        } else {
            if (user.getPass().equals("adminadmin") && (user.getEmail().equals("admin@a.dm")))
                user.getRole().setName("admin");
            userRepository.add(user);
            resp.sendRedirect("/main");
        }
    }
}
