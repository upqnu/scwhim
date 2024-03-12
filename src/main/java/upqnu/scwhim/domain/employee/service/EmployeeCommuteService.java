package upqnu.scwhim.domain.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import upqnu.scwhim.domain.employee.entity.Employee;
import upqnu.scwhim.domain.employee.repository.EmployeeRepository;
import upqnu.scwhim.domain.workrecord.dto.*;
import upqnu.scwhim.domain.workrecord.entity.WorkRecord;
import upqnu.scwhim.domain.workrecord.repository.WorkRecordRepository;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeCommuteService {

    private final EmployeeRepository employeeRepository;
    private final WorkRecordRepository workRecordRepository;

    @Transactional
    public void employeePunchIn(EmployeeCommuteReqDto request) {

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(IllegalArgumentException::new);

        LocalDate today = LocalDate.now();
        LocalDateTime currentTime = LocalDateTime.now();

        WorkRecord workRecord = workRecordRepository.findByEmployeeAndWorkDate(employee, today);
        if (workRecord == null) workRecordRepository.save(new WorkRecord(today, currentTime, null, employee));
        else {
            if (workRecord.getPunchInTime() == null && workRecord.getGoHomeTime() == null) {
                workRecord.logPunchInTime(currentTime);
                workRecordRepository.save(workRecord);
            }

            else throw new IllegalArgumentException();
        }
    }

    @Transactional
    public void employeeGoHome(EmployeeCommuteReqDto request) {

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(IllegalArgumentException::new);

        LocalDate today = LocalDate.now();
        LocalDateTime currentTime = LocalDateTime.now();

        WorkRecord workRecord = workRecordRepository.findByEmployeeAndWorkDate(employee, today);
        if (workRecord != null && workRecord.getPunchInTime() != null && workRecord.getGoHomeTime() == null) {
            workRecord.logGoHomeTime(currentTime);
            workRecordRepository.save(workRecord);
            System.out.println(workRecord.getGoHomeTime());
        }
        else throw new IllegalArgumentException();
    }

    @Transactional
    public List<WorkRecordResDto> showAllEmployeeCommute() {
        List<WorkRecord> records = workRecordRepository.findAll();
        System.out.println(records.size());
        List<WorkRecordResDto> allEmployeeCommuteRecord = new ArrayList<>();
        for (WorkRecord wr : records) {
            Long employeeId = wr.getEmployee().getId();
            System.out.println(employeeId);
            System.out.println(wr.getGoHomeTime());
            allEmployeeCommuteRecord.add(new WorkRecordResDto(wr.getWorkDate(), wr.getPunchInTime(), wr.getGoHomeTime(), employeeId));
        }
        return allEmployeeCommuteRecord;
    }

    @Transactional
    public WorkingHourResDto showEmployeeWorkingHours(WorkingHourReqDto request) {
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(IllegalArgumentException::new);

        List<WorkingHourDetailDto> workingHourDetails = new ArrayList<>();
        final int[] totalWorkTimeInMinutes = {0};
        LocalDate firstDayOfMonth = request.getYearMonth().atDay(1);
        LocalDate lastDayOfMonth = request.getYearMonth().atEndOfMonth();

        for (LocalDate date = firstDayOfMonth; !date.isAfter(lastDayOfMonth); date = date.plusDays(1)) {
            Optional<WorkRecord> optionalRecord = workRecordRepository.findByEmployee_IdAndWorkDate(request.getEmployeeId(), date);

            optionalRecord.ifPresent(record -> {
                        LocalDateTime punchInTime = record.getPunchInTime();
                        LocalDateTime goHomeTime = record.getGoHomeTime();

                        if (punchInTime != null && goHomeTime != null) {
                            Duration duration = Duration.between(punchInTime, goHomeTime);
                            int workTimeInMinutes = (int) duration.toMinutes();
                            totalWorkTimeInMinutes[0] += workTimeInMinutes;
                            workingHourDetails.add(new WorkingHourDetailDto(record.getWorkDate(), workTimeInMinutes));
                        }
                    }
            );
        }

        WorkingHourResDto response = new WorkingHourResDto(request.getEmployeeId(), workingHourDetails, totalWorkTimeInMinutes[0]);
        return response;
    }

}
