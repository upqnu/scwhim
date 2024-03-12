package upqnu.scwhim.domain.workrecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upqnu.scwhim.domain.employee.entity.Employee;
import upqnu.scwhim.domain.workrecord.entity.WorkRecord;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WorkRecordRepository extends JpaRepository<WorkRecord, Long> {

    WorkRecord findByEmployeeAndWorkDate(Employee employee, LocalDate localDate);

    Optional<WorkRecord> findByEmployee_IdAndWorkDate(Long employeeId, LocalDate workDate);
}
