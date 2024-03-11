package upqnu.scwhim.domain.employee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import upqnu.scwhim.domain.team.entity.Team;
import upqnu.scwhim.domain.workrecord.entity.WorkRecord;
import upqnu.scwhim.global.BaseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String teamName;

    @Column(nullable = false)
    private LocalDate workstartDate;

    @Column(nullable = false)
    private LocalDate birthday;

    @Enumerated
    private Role role;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "employee")
    private List<WorkRecord> workRecordList = new ArrayList<>();

    public Employee(String name, LocalDate workstartDate, LocalDate birthday) {
        this.name = name;
        this.workstartDate = workstartDate;
        this.birthday = birthday;
    }

    public void modifyEmployee(
            String name, LocalDate workstartDate, LocalDate birthday) {
        this.name = name;
        this.workstartDate = workstartDate;
        this.birthday = birthday;
    }

    public void modifyEmployeePosition(Role role, Team team, String teamName) {
        this.role = role;
        this.team = team;
        this.teamName = teamName;
    }
}
