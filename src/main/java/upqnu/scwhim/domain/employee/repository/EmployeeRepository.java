package upqnu.scwhim.domain.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upqnu.scwhim.domain.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
