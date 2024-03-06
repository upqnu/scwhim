package upqnu.scwhim.team.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import upqnu.scwhim.employee.entity.Employee;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String manager;

    private Integer memberCount;

    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE)
    private List<Employee> teamCrews = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void modifyTeamName(String newTeamName) {
        this.name = newTeamName;
    }

    public void setTeamManagerName(String name) {
        this.manager = name;
    }
}
