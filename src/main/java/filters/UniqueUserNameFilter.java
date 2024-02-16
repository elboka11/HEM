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
import static utiles.PagesConstants.USERNAME_ERROR_PAGE;
import static utiles.UserConstants.USERNAME;

@WebFilter(urlPatterns = "/users/create")
public class UniqueUserNameFilter extends HttpFilter {
    private final UserService userService = getInstance();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        Comment

        Optional<User> optionalUser = userService.readUsers().stream()
                .filter(user -> user.getUserName().equals(req.getParameter(USERNAME)))
                .findAny();
        if (optionalUser.isPresent()) {
            req.getRequestDispatcher(USERNAME_ERROR_PAGE).forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }
}
