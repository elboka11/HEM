package controllers.users;

import entities.User;
import mappers.UserMapper;
import services.users.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static services.users.UserServiceImpl.getInstance;
import static utiles.PagesConstants.CREATE_USERS_PAGE;

@WebServlet(urlPatterns = "/users/create")
public class CreateUsersController extends HttpServlet {
    private final UserService userService = getInstance();
    private final UserMapper userMapper = new UserMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(CREATE_USERS_PAGE).forward(req, resp);
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userMapper.userBuilder(req);
        userService.createUser(user);
        req.getRequestDispatcher("/users/read").forward(req, resp);
    }

}
