package upqnu.scwhim.employee.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upqnu.scwhim.employee.dto.EmployeeJoinReqDto;
import upqnu.scwhim.employee.entity.Employee;
import upqnu.scwhim.employee.repository.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void joinEmployee(EmployeeJoinReqDto request) {
        employeeRepository.save(new Employee(request.getName(), request.getWorkstartDate(), request.getBirthday()));
    }
}
