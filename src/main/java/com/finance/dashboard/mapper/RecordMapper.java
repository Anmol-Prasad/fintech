package com.finance.dashboard.mapper;

import com.finance.dashboard.dto.CreateRecordRequest;
import com.finance.dashboard.dto.RecordResponse;
import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.User;
import com.finance.dashboard.entity.enums.RecordType;
import org.springframework.stereotype.Component;

@Component
public class RecordMapper {

    public FinancialRecord toEntity(CreateRecordRequest req, User user) {
        return FinancialRecord.builder()
                .amount(req.getAmount())
                .type(RecordType.valueOf(req.getType()))
                .category(req.getCategory())
                .date(req.getDate())
                .notes(req.getNotes())
                .createdBy(user)
                .build();
    }

    public RecordResponse toResponse(FinancialRecord record) {
        return new RecordResponse(
                record.getId(),
                record.getAmount(),
                record.getType().name(),
                record.getCategory(),
                record.getDate(),
                record.getNotes()
        );
    }
}