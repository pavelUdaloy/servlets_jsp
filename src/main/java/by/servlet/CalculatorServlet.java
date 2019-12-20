package by.servlet;

import by.entity.Calculation;
import by.entity.CalculationValidator;
import by.entity.User;
import by.repository.HistoryRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calc")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("rez", null);
        req.setAttribute("rezHas", false);
        req.setAttribute("invalidateSign", false);
        getServletContext().getRequestDispatcher("/WEB-INF/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HistoryRepository historyRepository = new HistoryRepository().getInstance();
        req.setAttribute("rez", null);
        req.setAttribute("rezHas", false);
        req.setAttribute("invalidateSign", false);
        CalculationValidator calculationValidator = new CalculationValidator();
        Double firstValue = Double.valueOf(req.getParameter("firstValue"));
        Double secondValue = Double.valueOf(req.getParameter("secondValue"));
        String sign = req.getParameter("sign");
        if (calculationValidator.validSign(sign)) {
            Calculation calculation = new Calculation(firstValue,secondValue,sign);
            req.setAttribute("invalidateSign", false);
            req.setAttribute("rezHas", true);
            req.setAttribute("rez", calculation.getRez());
            User currentUser = ((User) req.getSession().getAttribute("currentUser"));
            historyRepository.add(currentUser,calculation);
        } else {
            req.setAttribute("invalidateSign", true);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/pages/calc.jsp").forward(req, resp);
    }
}
