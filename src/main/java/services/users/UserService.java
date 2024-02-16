package services.users;

import entities.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    List<User> readUsers();

    void updateUser(long userId, User user);

    User deleteUser(Long userId);
    User getUser(long userId);



}
