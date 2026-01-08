package com.scientiaunviversity.backend25.repositories;

import com.scientiaunviversity.backend25.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
