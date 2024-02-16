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

import static java.lang.Long.parseLong;
import static services.users.UserServiceImpl.getInstance;
import static utiles.PagesConstants.UPDATE_USERS_PAGE;
import static utiles.UserConstants.*;

@WebServlet(urlPatterns = "/users/update")
public class UpdateUsersController extends HttpServlet {
    private final UserService userService = getInstance();
    private final UserMapper userMapper = new UserMapper();
    private long id;
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = parseLong(req.getParameter(USER_ID));
        user = userService.getUser(id);
        req.setAttribute(FIRST_NAME, user.getFirstName());
        req.setAttribute(SECOND_NAME, user.getSecondName());
        req.setAttribute(DEPARTMENT, user.getDepartment());
        req.setAttribute(USERNAME, user.getUserName());
        req.setAttribute(USER_PASSWORD, user.getUserPassword());
        req.setAttribute(USER_ROLE, user.getUserRole());
        req.getRequestDispatcher(UPDATE_USERS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = userMapper.userBuilder(req);
        userService.updateUser(id, user);
        req.getRequestDispatcher("/users/read").forward(req, resp);
    }
}
