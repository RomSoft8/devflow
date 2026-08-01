package com.romsoft36.backend.dto;

public record UserResponse(
        Long id,
        String username,
        String email
) {
}