package com.finance.dashboard.service.impl;
import com.finance.dashboard.dto.CreateRecordRequest;
import com.finance.dashboard.dto.RecordResponse;
import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.User;
import com.finance.dashboard.entity.enums.Role;
import com.finance.dashboard.exception.CustomException;
import com.finance.dashboard.mapper.RecordMapper;
import com.finance.dashboard.repository.FinancialRecordRepository;
import com.finance.dashboard.repository.UserRepository;
import com.finance.dashboard.service.RecordService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService {

    private final FinancialRecordRepository recordRepo;
    private final UserRepository userRepo;
    private final RecordMapper mapper;

    public RecordServiceImpl(FinancialRecordRepository recordRepo,
                             UserRepository userRepo,
                             RecordMapper mapper) {
        this.recordRepo = recordRepo;
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public RecordResponse createRecord(CreateRecordRequest request) {

        User user = userRepo.findById(request.getUserId())
                .orElseThrow(() -> new CustomException("User not found"));

        if(user.getRole() != Role.ADMIN){
            throw new CustomException("Only ADMIN can create records");
        }

        FinancialRecord record = mapper.toEntity(request, user);
        return mapper.toResponse(recordRepo.save(record));
    }

    @Override
    public List<RecordResponse> getAllRecords() {
        return recordRepo.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}