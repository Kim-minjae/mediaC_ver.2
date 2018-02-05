package com.mediac.app.service;

import com.mediac.app.entity.User;
import com.mediac.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String userEmail, String userPassword, String userNickname) {
        userRepository.save(new User(userEmail, userPassword, userNickname));
    }

    public Iterable<User> lookup() {
        return userRepository.findAll();
    }

    public long total() {
        return userRepository.count();
    }
}
