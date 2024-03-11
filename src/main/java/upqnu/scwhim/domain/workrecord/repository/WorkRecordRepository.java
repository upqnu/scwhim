package upqnu.scwhim.domain.workrecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upqnu.scwhim.domain.employee.entity.Employee;
import upqnu.scwhim.domain.workrecord.entity.WorkRecord;

import java.time.LocalDate;

public interface WorkRecordRepository extends JpaRepository<WorkRecord, Long> {

    WorkRecord findByEmployeeAndWorkDate(Employee employee, LocalDate localDate);

}
