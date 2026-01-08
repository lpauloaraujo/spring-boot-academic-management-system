package com.scientiaunviversity.backend25.services;

import com.scientiaunviversity.backend25.domain.User;
import com.scientiaunviversity.backend25.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getById(Long id) {
        return Optional.of(userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found")));
    }

    public <T extends User> T create(T user) {
        return userRepository.save(user);
    }

}
