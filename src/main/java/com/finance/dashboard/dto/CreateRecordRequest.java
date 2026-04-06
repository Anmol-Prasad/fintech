package com.finance.dashboard.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
public class CreateRecordRequest {
    private double amount;
    private String type;      // INCOME / EXPENSE
    private String category;
    private LocalDate date;
    private String notes;
    private Long userId;
}