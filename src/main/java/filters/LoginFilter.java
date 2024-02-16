package filters;

import entities.User;
import services.users.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static services.users.UserServiceImpl.getInstance;
import static utiles.PagesConstants.LOGIN_ERROR_PAGE;
import static utiles.UserConstants.*;


@WebFilter(urlPatterns = "/login")
public class LoginFilter extends HttpFilter {

    private final UserService userService = getInstance();


    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Optional<User> comperedUser = userService.readUsers().stream().filter(user -> user.getUserName().equals(req.getParameter(USERNAME)))
                .filter(user -> user.getUserPassword().equals(req.getParameter(USER_PASSWORD))).findAny();
        if (comperedUser.isPresent()) {
            chain.doFilter(req, res);
        } else {
            req.getRequestDispatcher(LOGIN_ERROR_PAGE).forward(req, res);
        }
    }
}

