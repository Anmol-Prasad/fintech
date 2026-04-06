package com.finance.dashboard.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class RecordResponse {
    private Long id;
    private double amount;
    private String type;
    private String category;
    private LocalDate date;
    private String notes;
}
