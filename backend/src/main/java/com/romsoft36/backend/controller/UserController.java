package com.romsoft36.backend.controller;

import com.romsoft36.backend.dto.CreateUserRequest;
import com.romsoft36.backend.dto.UserResponse;
import com.romsoft36.backend.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(
            @Valid @RequestBody CreateUserRequest request
    ) {
        return userService.createUser(request);
    }
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }
}