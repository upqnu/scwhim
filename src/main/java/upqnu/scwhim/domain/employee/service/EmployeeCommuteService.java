package upqnu.scwhim.domain.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upqnu.scwhim.domain.employee.entity.Employee;
import upqnu.scwhim.domain.employee.repository.EmployeeRepository;
import upqnu.scwhim.domain.workrecord.dto.EmployeeCommuteReqDto;
import upqnu.scwhim.domain.workrecord.dto.WorkRecordResDto;
import upqnu.scwhim.domain.workrecord.entity.WorkRecord;
import upqnu.scwhim.domain.workrecord.repository.WorkRecordRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeCommuteService {

    private final EmployeeRepository employeeRepository;
    private final WorkRecordRepository workRecordRepository;

    @Transactional
    public void employeePunchIn(EmployeeCommuteReqDto request) {

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(IllegalArgumentException::new);

        // 자동으로 오늘 날짜를 wordDate에 입력
        LocalDate today = LocalDate.now();

        // 자동으로 현재 시각을 punchInTime에 입력
        LocalDateTime currentTime = LocalDateTime.now();

        WorkRecord workRecord = workRecordRepository.findByEmployeeAndWorkDate(employee, today);
        if (workRecord == null) workRecordRepository.save(new WorkRecord(today, currentTime, null, employee));
        else {
            if (workRecord.getPunchInTime() != null) throw new IllegalArgumentException();
        }
    }

    @Transactional
    public List<WorkRecordResDto> showAllEmployeeCommute() {
        List<WorkRecord> records = workRecordRepository.findAll();
        List<WorkRecordResDto> allEmployeeCommuteRecord = new ArrayList<>();
        for (WorkRecord wr : records) {
            allEmployeeCommuteRecord.add(new WorkRecordResDto(wr.getWorkDate(), wr.getPunchInTime(), wr.getGoHomeTime(), wr.getEmployee().getId()));
        }
        return allEmployeeCommuteRecord;
    }

}
