package upqnu.scwhim.employee.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import upqnu.scwhim.team.entity.Team;

import java.time.LocalDate;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Team team;

    public Employee(String name, LocalDate workstartDate, LocalDate birthday) {
        this.name = name;
        this.workstartDate = workstartDate;
        this.birthday = birthday;
    }
}
