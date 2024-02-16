package repositories.Authorization;

import entities.User;
import entities.UserRole;

import java.util.List;
import java.util.Optional;

public interface AuthorizationRepository {
    Optional<UserRole> findUserRole(List<User> users, String userName, String userPassword);
}
