package upqnu.scwhim.domain.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import upqnu.scwhim.domain.employee.service.EmployeeCommuteService;
import upqnu.scwhim.domain.workrecord.dto.EmployeeCommuteReqDto;
import upqnu.scwhim.domain.workrecord.dto.WorkRecordResDto;
import upqnu.scwhim.domain.workrecord.dto.WorkingHourReqDto;
import upqnu.scwhim.domain.workrecord.dto.WorkingHourResDto;
import upqnu.scwhim.domain.workrecord.entity.WorkRecord;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeCommuteController {

    private final EmployeeCommuteService employeeCommuteService;

    /**
     * 직원 출근 등록
     * @param request
     */
    @Operation(summary = "직원 출근 등록", description = "특정 직원의 출근시간을 저장합니다")
    @Parameter(name = "EmployeeCommuteReqDto", description = "출근 등록 시, 해당 직원 id 필수 입력")
    @PostMapping("/commute/punchin")
    public void employeePunchIn(@RequestBody EmployeeCommuteReqDto request) {
        employeeCommuteService.employeePunchIn(request);
    }

    /**
     * 직원 퇴근 등록
     * @param request
     */
    @Operation(summary = "직원 퇴근 등록", description = "특정 직원의 퇴근시간을 저장합니다")
    @Parameter(name = "EmployeeCommuteReqDto", description = "퇴근 등록 시, 해당 직원 id 필수 입력")
    @PostMapping("/commute/gohome")
    public void employeeGoHome(@RequestBody EmployeeCommuteReqDto request) {
        employeeCommuteService.employeeGoHome(request);
    }

    /**
     * 전 직원 출퇴근 현황
     * @return
     */
    @Operation(summary = "전 직원 출퇴근 현황", description = "전 직원의 출퇴근 현황을 확인합니다")
    @GetMapping("/commute")
    public List<WorkRecordResDto> showAllEmployeeCommute() {
        List<WorkRecordResDto> allEmployeeCommuteRecord = employeeCommuteService.showAllEmployeeCommute();
        return allEmployeeCommuteRecord;
    }

    /**
     * 개별 직원 날짜별
     * @param request
     * @return
     */
    @Operation(summary = "개별 직원 월별 근무기록 및 총 근무시간 확인", description = "특정 직원의 월별 근무기록 및 총 근무시간 확인합니다")
    @Parameter(name = "WorkingHourReqDto", description = "퇴근 등록 시, 해당 직원 id / 검색하려는 연월 필수 입력")
    @PostMapping("/hours-worked")
    public WorkingHourResDto showEmployeeWorkingHours(@RequestBody WorkingHourReqDto request) {
        WorkingHourResDto workingHour = employeeCommuteService.showEmployeeWorkingHours(request);
        return workingHour;
    }
}
