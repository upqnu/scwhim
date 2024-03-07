package upqnu.scwhim.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upqnu.scwhim.employee.dto.EmployeeInfoResDto;
import upqnu.scwhim.employee.dto.EmployeeJoinReqDto;
import upqnu.scwhim.employee.dto.EmployeeModifyReqDto;
import upqnu.scwhim.employee.dto.EmployeePositionReqDto;
import upqnu.scwhim.employee.entity.Employee;
import upqnu.scwhim.employee.repository.EmployeeRepository;
import upqnu.scwhim.team.entity.Team;
import upqnu.scwhim.team.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;

    @Transactional
    public void joinEmployee(EmployeeJoinReqDto request) {
        employeeRepository.save(new Employee(request.getName(), request.getWorkstartDate(), request.getBirthday()));
    }

    @Transactional
    public EmployeeInfoResDto showEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(IllegalArgumentException::new);

        EmployeeInfoResDto response = new EmployeeInfoResDto(
                employee.getName(), employee.getTeamName(), employee.getRole(), employee.getWorkstartDate(), employee.getBirthday()
        );

        return response;
    }

    @Transactional
    public List<EmployeeInfoResDto> showAllEmployees() {
        List<Employee> empolyees = employeeRepository.findAll();
        List<EmployeeInfoResDto> allEmployees = new ArrayList<>();
        for (Employee e : empolyees) {
            allEmployees.add(new EmployeeInfoResDto(
                    e.getName(), e.getTeamName(), e.getRole(), e.getWorkstartDate() ,e.getBirthday()
            ));
        }
        return allEmployees;
    }

    @Transactional
    public void modifyEmployee(Long employeeId, EmployeeModifyReqDto request) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(IllegalArgumentException::new);

        employee.modifyEmployee(
                request.getName(), request.getWorkstartDate(), request.getBirthday());
    }

    @Transactional
    public void setEmployeePosition(Long employeeId, EmployeePositionReqDto request) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(IllegalArgumentException::new);

        Team team = teamRepository.findByName(request.getTeamName());

        employee.modifyEmployeePosition(request.getRole(), team, request.getTeamName());
    }

    @Transactional
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(IllegalArgumentException::new);

        employeeRepository.deleteById(employeeId);
    }
}
