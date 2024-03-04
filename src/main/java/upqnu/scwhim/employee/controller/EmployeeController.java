package upqnu.scwhim.employee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import upqnu.scwhim.employee.dto.EmployeeJoinReqDto;
import upqnu.scwhim.employee.service.EmployeeService;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employee")
    public void joinEmployee(@RequestBody EmployeeJoinReqDto request) {
        employeeService.joinEmployee(request);
    }
}
