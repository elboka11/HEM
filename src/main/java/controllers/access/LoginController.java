package controllers.access;


import entities.UserRole;
import services.Authorization.AuthorizationService;
import services.Authorization.AuthorizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utiles.UserConstants.*;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private final AuthorizationService authorizationService = AuthorizationServiceImpl.getInstance();
    private UserRole userRole;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        defineInterfaceByUserRole(req, resp, userRole);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userRole = authorizationService.findUserRole(req.getParameter(USERNAME), req.getParameter(USER_PASSWORD));
        defineInterfaceByUserRole(req, resp, userRole);

    }

    private static void defineInterfaceByUserRole(HttpServletRequest req, HttpServletResponse resp, UserRole userRole) throws ServletException, IOException {
        switch (userRole) {
            case USER -> userInterface(req, resp, userRole);
            case ADMIN -> adminInterface(req, resp, userRole);
            default -> req.getRequestDispatcher("/pages/errors/loginError_page.jsp").forward(req, resp);
        }
    }

    private static void adminInterface(HttpServletRequest req, HttpServletResponse resp, UserRole userRole) throws ServletException, IOException {
        req.getSession().setAttribute(USER_ROLE, userRole);
        req.getRequestDispatcher("/pages/interfaces/adminInterface.jsp").forward(req, resp);
    }

    private static void userInterface(HttpServletRequest req, HttpServletResponse resp, UserRole userRole) throws ServletException, IOException {
        req.getSession().setAttribute(USER_ROLE, userRole);
        req.getRequestDispatcher("/pages/interfaces/userInterface.jsp").forward(req, resp);
    }

}
