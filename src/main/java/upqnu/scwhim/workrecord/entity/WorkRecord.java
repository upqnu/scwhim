package upqnu.scwhim.workrecord.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import upqnu.scwhim.employee.entity.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class WorkRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false)
    private LocalDate workDate;

    private LocalDateTime punchinTime; // 출근시간

    private LocalDateTime gohomeTime; // 퇴근시간

    @ManyToOne
    private Employee employee;

    public WorkRecord(LocalDate workDate, LocalDateTime punchinTime, LocalDateTime gohomeTime, Employee employee) {
        this.workDate = workDate;
        this.punchinTime = punchinTime;
        this.gohomeTime = gohomeTime;
        this.employee = employee;
    }
}
