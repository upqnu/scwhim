package upqnu.scwhim.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upqnu.scwhim.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
