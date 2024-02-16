package mappers;

import entities.User;
import entities.UserRole;

import javax.servlet.http.HttpServletRequest;

import static utiles.UserConstants.*;

public class UserMapper {
    public User userBuilder(HttpServletRequest request) {
        return User.builder()
                .firstName(request.getParameter(FIRST_NAME))
                .secondName(request.getParameter(SECOND_NAME))
                .department(request.getParameter(DEPARTMENT))
                .userName(request.getParameter(USERNAME))
                .userPassword(request.getParameter(USER_PASSWORD))
                .userRole(UserRole.valueOf(request.getParameter(USER_ROLE)))
                .build();

    }
}
