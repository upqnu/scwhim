package upqnu.scwhim.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import upqnu.scwhim.employee.dto.EmployeeInfoResponse;
import upqnu.scwhim.employee.dto.EmployeeJoinReqDto;
import upqnu.scwhim.employee.entity.Employee;
import upqnu.scwhim.employee.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional
    public void joinEmployee(EmployeeJoinReqDto request) {
        employeeRepository.save(new Employee(request.getName(), request.getWorkstartDate(), request.getBirthday()));
    }

    @Transactional
    public EmployeeInfoResponse showEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(IllegalArgumentException::new);

        EmployeeInfoResponse response = new EmployeeInfoResponse(
                employee.getName(), employee.getTeamName(), employee.getWorkstartDate(),
                employee.getBirthday(), employee.getTeam(), employee.getRole()
        );

        return response;
    }

    @Transactional
    public List<EmployeeInfoResponse> showAllEmployees() {
        List<Employee> empolyees = employeeRepository.findAll();
        List<EmployeeInfoResponse> allEmployees = new ArrayList<>();
        for (Employee e : empolyees) {
            allEmployees.add(new EmployeeInfoResponse(
                    e.getName(), e.getTeamName(), e.getWorkstartDate(), e.getBirthday(), e.getTeam(), e.getRole()
            ));
        }
        return allEmployees;
    }
}
