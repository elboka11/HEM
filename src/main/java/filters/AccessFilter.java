package filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static entities.UserRole.ADMIN;
import static utiles.PagesConstants.ACCESS_ERROR_PAGE;
import static utiles.UserConstants.USER_ROLE;

@WebFilter(urlPatterns = {"/users/delete", "/patients/delete", "/users/create", "/patients/create", "/users/read"})
public class AccessFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Object userRole;
        userRole = req.getSession().getAttribute(USER_ROLE);
        if (userRole.equals(ADMIN)) {
            chain.doFilter(req, res);
        } else {
            req.getRequestDispatcher(ACCESS_ERROR_PAGE).forward(req, res);
        }


    }
}
