package com.redqueen.pp31.service;

import com.redqueen.pp31.model.User;
import com.redqueen.pp31.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    UserServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
    @Override
    public User getUser(long id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User not found id == " + id);
        }
        return user;
    }

    @Override
    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
    }
}
