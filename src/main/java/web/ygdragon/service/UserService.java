package web.ygdragon.service;

import web.ygdragon.model.User;
import web.ygdragon.repositories.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepositoryImpl userRepository;

    @Autowired
    public UserService(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.create(user);
    }

    public List<User> findAllUsers() {
        return userRepository.read();
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

    public void deleteById(int id) {
        userRepository.delete(id);
    }

}
