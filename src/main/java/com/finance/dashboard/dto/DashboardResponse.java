package com.finance.dashboard.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class DashboardResponse {
    private double totalIncome;
    private double totalExpense;
    private double netBalance;
}
