package upqnu.scwhim.domain.team.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import upqnu.scwhim.domain.employee.entity.Employee;
import upqnu.scwhim.global.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Team extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String manager;

    private Integer memberCount;

    @OneToMany(mappedBy = "team")
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
