package repositories.users;

import entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> createUser(User user);

    Optional<List<User>> readUsers();

    Optional<User> updateUser(long userId, User user);

    Optional<User> deleteUser(Long userId);
    int getUserId(long userId);

    Optional<User> getUser(long userId);




}
