package upqnu.scwhim.domain.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import upqnu.scwhim.domain.employee.service.EmployeeCommuteService;
import upqnu.scwhim.domain.workrecord.dto.EmployeeCommuteReqDto;
import upqnu.scwhim.domain.workrecord.dto.WorkRecordResDto;
import upqnu.scwhim.domain.workrecord.entity.WorkRecord;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeCommuteController {

    private final EmployeeCommuteService employeeCommuteService;

    /**
     * 직원 출근
     * @param request
     */
    @Operation(summary = "직원 출근 등록", description = "특정 직원의 출근시간을 저장합니다")
    @Parameter(name = "EmployeeCommuteReqDto", description = "출근 등록 시, 해당 직원 id 필수 입력")
    @PostMapping("/commute/punchin")
    public void employeePunchIn(@RequestBody EmployeeCommuteReqDto request) {
        employeeCommuteService.employeePunchIn(request);
    }

    @GetMapping("/commute")
    public List<WorkRecordResDto> showAllEmployeeCommute() {
        List<WorkRecordResDto> allEmployeeCommuteRecord = employeeCommuteService.showAllEmployeeCommute();
        return allEmployeeCommuteRecord;
    }
}
