package services.Authorization;

import entities.UserRole;
import repositories.Authorization.AuthorizationRepository;
import repositories.Authorization.AuthorizationRepositoryImpl;
import services.users.UserService;
import services.users.UserServiceImpl;

public class AuthorizationServiceImpl implements AuthorizationService {
    private static AuthorizationService authorizationService;
    private final UserService userService = UserServiceImpl.getInstance();
    private final AuthorizationRepository authorizationRepository = AuthorizationRepositoryImpl.getInstance();

    @Override
    public UserRole findUserRole(String userName, String userPassword) {
        return authorizationRepository.findUserRole(userService.readUsers(), userName, userPassword).orElseThrow();
    }

    public static AuthorizationService getInstance() {
        if (authorizationService == null) {
            authorizationService = new AuthorizationServiceImpl();
        }
        return authorizationService;
    }

    private AuthorizationServiceImpl() {
    }
}
