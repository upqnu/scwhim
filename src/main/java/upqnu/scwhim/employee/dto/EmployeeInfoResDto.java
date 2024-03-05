package upqnu.scwhim.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import upqnu.scwhim.employee.entity.Role;
import upqnu.scwhim.team.entity.Team;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class EmployeeInfoResDto {

    private String name;

    private String teamName;

    private Role role;

    private LocalDate workstartDate;

    private LocalDate birthday;
}
