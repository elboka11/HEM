package controllers.users;

import entities.User;
import services.users.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static services.users.UserServiceImpl.getInstance;
import static utiles.PagesConstants.READ_USERS_PAGE;

@WebServlet(urlPatterns = "/users/read")
public class ReadUsersController extends HttpServlet {
    private static final UserService userService = getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.readUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher(READ_USERS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
