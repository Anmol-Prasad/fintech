package com.finance.dashboard.service.impl;
import com.finance.dashboard.dto.DashboardResponse;
import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.enums.RecordType;
import com.finance.dashboard.repository.FinancialRecordRepository;
import com.finance.dashboard.service.DashboardService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final FinancialRecordRepository recordRepo;

    public DashboardServiceImpl(FinancialRecordRepository recordRepo) {
        this.recordRepo = recordRepo;
    }

    @Override
    public DashboardResponse getSummary() {

        List<FinancialRecord> records = recordRepo.findAll();

        double income = 0;
        double expense = 0;

        for(FinancialRecord record : records){
            if(record.getType() == RecordType.INCOME){
                income += record.getAmount();
            } else {
                expense += record.getAmount();
            }
        }

        return new DashboardResponse(income, expense, income - expense);
    }
}