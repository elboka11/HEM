package repositories.Authorization;

import entities.User;
import entities.UserRole;

import java.util.List;
import java.util.Optional;

public class AuthorizationRepositoryImpl implements AuthorizationRepository {
    private static AuthorizationRepository authorizationRepository;

    @Override
    public Optional<UserRole> findUserRole(List<User> users, String userName, String userPassword) {
        return users.stream()
                .filter(user -> user.getUserName().equals(userName) && user.getUserPassword().equals(userPassword))
                .map(User::getUserRole)
                .findAny();
    }

    public static AuthorizationRepository getInstance() {
        if (authorizationRepository == null) {
            authorizationRepository = new AuthorizationRepositoryImpl();
        }
        return authorizationRepository;
    }

    private AuthorizationRepositoryImpl() {
    }
}
