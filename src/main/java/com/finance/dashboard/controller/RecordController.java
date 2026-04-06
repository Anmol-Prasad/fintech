package com.finance.dashboard.controller;
import com.finance.dashboard.dto.CreateRecordRequest;
import com.finance.dashboard.dto.RecordResponse;
import com.finance.dashboard.service.RecordService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public RecordResponse createRecord(@RequestBody CreateRecordRequest request) {
        return recordService.createRecord(request);
    }

    @GetMapping
    public List<RecordResponse> getAllRecords() {
        return recordService.getAllRecords();
    }
}