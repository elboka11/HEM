package controllers.users;

import services.users.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Long.valueOf;
import static services.users.UserServiceImpl.getInstance;
import static utiles.UserConstants.USER_ID;

@WebServlet(urlPatterns = "/users/delete")
public class DeleteUsersController extends HttpServlet {
    private final UserService userService = getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.deleteUser(valueOf(req.getParameter(USER_ID)));
        req.getRequestDispatcher("/users/read").forward(req, resp);
    }
}
