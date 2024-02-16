package services.users;

import entities.User;
import repositories.users.UserRepository;
import repositories.users.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {


    private final UserRepository userRepository = UserRepositoryImpl.getInstance();
    private static UserService userService;

    private UserServiceImpl() {
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public void createUser(User user) {
        userRepository.createUser(user).orElseThrow();
    }

    @Override
    public List<User> readUsers() {
        return userRepository.readUsers().orElseThrow();
    }

    @Override
    public void updateUser(long userId, User user) {
        userRepository.updateUser(userId, user).orElseThrow();
    }

    @Override
    public User deleteUser(Long userId) {
        return userRepository.deleteUser(userId).orElseThrow();
    }

    @Override
    public User getUser(long userId) {
        return userRepository.getUser(userId).orElseThrow();
    }
}
