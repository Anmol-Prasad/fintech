package com.finance.dashboard.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String role;
    private String status;
}
