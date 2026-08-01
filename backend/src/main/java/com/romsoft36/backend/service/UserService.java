package com.romsoft36.backend.service;

import com.romsoft36.backend.dto.CreateUserRequest;
import com.romsoft36.backend.dto.UserResponse;
import com.romsoft36.backend.entity.User;
import com.romsoft36.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(CreateUserRequest request) {
        User user = new User();

        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPassword(request.password());

        User savedUser = userRepository.save(user);

        return toResponse(savedUser);
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}