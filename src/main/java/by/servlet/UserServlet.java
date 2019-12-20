package by.servlet;

import by.entity.*;
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
import java.util.List;

@WebServlet(urlPatterns = "/user", name = "UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("type") == null) {
            UserRepository userRepository = new UserRepository().getInstance();
            String id = req.getParameter("id");
            int i = Integer.parseInt(id);
            User user = userRepository.get(i);
            if (user!=null) {
                req.setAttribute("userFR", user);
                getServletContext().getRequestDispatcher("/WEB-INF/pages/user.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository = new UserRepository().getInstance();
        HistoryRepository historyRepository = new HistoryRepository().getInstance();
        UserValidator userValidator = new UserValidator();
        String id = req.getParameter("id");
        User user = userRepository.get(Integer.parseInt(id));
        if (user == null) resp.sendRedirect("/users");
        switch (req.getParameter("type")) {
            case "redact":
                String newFirstName = req.getParameter("firstName");
                if (userValidator.validFirstName(newFirstName)) {
                    user.setFirstName(newFirstName);
                    req.setAttribute("invalidateFirstName", false);
                } else {
                    req.setAttribute("invalidateFirstName", true);
                }
                String newLastName = req.getParameter("lastName");
                if (userValidator.validLastName(newLastName)) {
                    user.setLastName(newLastName);
                    req.setAttribute("invalidateLastName", false);
                } else {
                    req.setAttribute("invalidateLastName", true);
                }
                String newPass = req.getParameter("pass");
                if (userValidator.validPassword(newPass)) {
                    user.setPass(newPass);
                    req.setAttribute("invalidatePass", false);
                } else {
                    req.setAttribute("invalidatePass", true);
                }
                String newAge = req.getParameter("age");
                if (userValidator.validAge(newAge)) {
                    user.setAge(Integer.parseInt(newAge));
                    req.setAttribute("invalidateAge", false);
                } else {
                    req.setAttribute("invalidateAge", true);
                }
                String role = req.getParameter("role");
                if (role==null || role.equals("")) role="user";
                if (new RoleValidator().roleValidator(role)) {
                    user.setRole(new Role(role));
                    req.setAttribute("invalidateRole", false);
                } else {
                    req.setAttribute("invalidateRole", true);
                }
                if ((boolean) req.getAttribute("invalidateAge") ||
                        (boolean) req.getAttribute("invalidatePass") ||
                        (boolean) req.getAttribute("invalidateFirstName") ||
                        (boolean) req.getAttribute("invalidateLastName") ||
                        (boolean) req.getAttribute("invalidateRole")) {
                    getServletContext().getRequestDispatcher("/WEB-INF/pages/user.jsp").forward(req, resp);
                } else {
                    userRepository.set(user.getEmail(),user);
                    resp.sendRedirect("/users");
                }
                break;
            case "delete":
                userRepository.delete(user);
                historyRepository.deleteAll(user);
                resp.sendRedirect("/users");
                break;
        }
    }
}
