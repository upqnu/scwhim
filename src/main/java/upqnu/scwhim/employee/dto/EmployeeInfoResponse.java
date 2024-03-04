package upqnu.scwhim.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import upqnu.scwhim.employee.entity.Role;
import upqnu.scwhim.team.entity.Team;

import java.time.LocalDate;

@Getter
//@Setter
@AllArgsConstructor
public class EmployeeInfoResponse {

    private String name;

    private String teamName;

    private LocalDate workstartDate;

    private LocalDate birthday;

    private Team team;

    private Role role;
}
