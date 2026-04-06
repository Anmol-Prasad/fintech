package com.finance.dashboard.service;
import com.finance.dashboard.dto.CreateRecordRequest;
import com.finance.dashboard.dto.RecordResponse;
import java.util.List;

public interface RecordService {
    RecordResponse createRecord(CreateRecordRequest request);
    List<RecordResponse> getAllRecords();
}