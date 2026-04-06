package com.finance.dashboard.service;

import com.finance.dashboard.dto.CreateUserRequest;
import com.finance.dashboard.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(CreateUserRequest request);
    List<UserResponse> getAllUsers();
}
