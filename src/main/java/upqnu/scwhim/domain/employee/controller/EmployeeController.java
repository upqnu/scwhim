package upqnu.scwhim.domain.employee.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import upqnu.scwhim.domain.employee.dto.EmployeeInfoResDto;
import upqnu.scwhim.domain.employee.dto.EmployeeModifyReqDto;
import upqnu.scwhim.domain.employee.service.EmployeeService;
import upqnu.scwhim.domain.employee.dto.EmployeeJoinReqDto;
import upqnu.scwhim.domain.employee.dto.EmployeePositionReqDto;

import java.util.List;

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
    public EmployeeInfoResDto showEmployee(@PathVariable Long employeeId) {
        EmployeeInfoResDto response = employeeService.showEmployee(employeeId);
        return response;
    }

    /**
     * 모든 직원 조회
     * @return
     */
    @Operation(summary = "모든 직원 조회", description = "모든 직원을 조회합니다")
    @GetMapping("")
    public List<EmployeeInfoResDto> showAllEmployees() {
        List<EmployeeInfoResDto> responses = employeeService.showAllEmployees();
        return responses;
    }

    /**
     * 직원 기본정보 변경 (이름, 입사일, 생일 변경)
     * @param employeeId
     * @param request
     */
    @Operation(summary = "직원 기본정보 변경", description = "개별 직원의 기본정보를 변경합니다")
    @Parameter(name = "employeeId / EmployeeModifyReqDto", description = "개별 직원 정보변경 시, 해당 직원의 id 필수 입력 / 변경해야 할 기본정보는 request body로 입력")
    @PutMapping("/{employeeId}")
    public void modifyEmployee(@PathVariable Long employeeId, @RequestBody EmployeeModifyReqDto request) {
        employeeService.modifyEmployee(employeeId, request);
    }

    /**
     * 지웍 포지션 정보 변경 (소속 팀, 직급)
     * @param employeeId
     * @param request
     */
    @Operation(summary = "직원 포지션 정보 변경", description = "개별 직원의 포지션 정보를 변경합니다")
    @Parameter(name = "employeeId / EmployeePositionReqDto", description = "개별 직원 정보변경 시, 해당 직원의 id 필수 입력 / 변경해야 할 포지션 정보는 request body로 입력")
    @PatchMapping("/{employeeId}")
    public void setEmployeePosition(@PathVariable Long employeeId, @RequestBody EmployeePositionReqDto request) {
        employeeService.setEmployeePosition(employeeId, request);
    }

    /**
     * 직원 정보 삭제
     * @param employeeId
     */
    @Operation(summary = "직원 정보 삭제", description = "개별 직원의 정보를 삭제합니다")
    @Parameter(name = "employeeId", description = "개별 직원 정보 삭제 시, 해당 직원의 id 필수 입력")
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}
