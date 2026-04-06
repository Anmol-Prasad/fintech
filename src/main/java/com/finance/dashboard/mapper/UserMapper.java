package com.finance.dashboard.mapper;

import com.finance.dashboard.dto.CreateUserRequest;
import com.finance.dashboard.dto.UserResponse;
import com.finance.dashboard.entity.User;
import com.finance.dashboard.entity.enums.Role;
import com.finance.dashboard.entity.enums.Status;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(CreateUserRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .role(Role.valueOf(request.getRole()))
                .status(Status.ACTIVE)
                .build();
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name(),
                user.getStatus().name()
        );
    }
}
