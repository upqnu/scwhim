package upqnu.scwhim.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import upqnu.scwhim.employee.dto.EmployeeInfoResponse;
import upqnu.scwhim.employee.dto.EmployeeJoinReqDto;
import upqnu.scwhim.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Tag(name = "Employee", description = "Employee API")
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * 직원 등록
     * @param request
     */
    @Operation(summary = "직원 등록 요청", description = "입력된 직원 정보를 저장합니다")
    @Parameter(name = "EmployeeJoinReqDto", description = "직원 등록 시, name/workstartDate(입사일)/birthday 필수 입력")
    @PostMapping("")
    public void joinEmployee(@RequestBody EmployeeJoinReqDto request) {
        employeeService.joinEmployee(request);
    }

    /**
     * 개별 직원 조회
     * @param employeeId
     * @return
     */
    @Operation(summary = "개별 직원 조회", description = "개별 직원을 조회합니다")
    @Parameter(name = "employeeId", description = "개별 직원 조회 시, 해당 직원의 id 필수 입력")
    @GetMapping("/{employeeId}")
    public EmployeeInfoResponse showEmployee(@PathVariable Long employeeId) {
        EmployeeInfoResponse response = employeeService.showEmployee(employeeId);
        return response;
    }
}
