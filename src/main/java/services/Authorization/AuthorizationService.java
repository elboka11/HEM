package services.Authorization;

import entities.UserRole;

public interface AuthorizationService {
    UserRole findUserRole(String userName, String userPassword);
}
