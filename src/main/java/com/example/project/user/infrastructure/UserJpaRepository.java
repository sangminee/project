package com.example.project.user.infrastructure;

import com.example.project.user.domain.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByIdAndStatus(long id, UserStatus active);

    Optional<UserEntity> findByEmailAndStatus(String email, UserStatus active);
}
