package upqnu.scwhim.employee.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import upqnu.scwhim.team.entity.Team;
import upqnu.scwhim.workrecord.entity.WorkRecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String teamName;

    @Column(nullable = false)
    private LocalDate workstartDate;

    @Column(nullable = false)
    private LocalDate birthday;

    @Enumerated
    private Role role;

    @ManyToOne
    private Team team;

    @OneToMany(mappedBy = "employee")
    private List<WorkRecord> records = new ArrayList<>();

    public Employee(String name, LocalDate workstartDate, LocalDate birthday) {
        this.name = name;
        this.workstartDate = workstartDate;
        this.birthday = birthday;
    }
}
