package upqnu.scwhim.domain.workrecord.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import upqnu.scwhim.domain.employee.entity.Employee;
import upqnu.scwhim.global.BaseEntity;

import java.time.LocalDateTime;

@Entity(name = "work_record")
@Getter
@NoArgsConstructor
public class WorkRecord extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime punchInTime;

    private LocalDateTime goHomeTime;

    @ManyToOne
    private Employee employee;
}
