package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.domain.User;
import com.scientiaunviversity.backend25.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
