package com.example.project.user.infrastructure;

import com.example.project.user.domain.User;
import com.example.project.user.domain.UserStatus;
import com.example.project.user.service.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {
        return userJpaRepository.save(UserEntity.fromModel(user)).toModel();
    }

    @Override
    public Optional<User> findByIdAndStatus(long id, UserStatus active) {
        return userJpaRepository.findByIdAndStatus(id, active).map(UserEntity::toModel);
    }

    @Override
    public Optional<User> findByEmailAndStatus(String email, UserStatus active) {
        return userJpaRepository.findByEmailAndStatus(email, active).map(UserEntity::toModel);
    }

}
