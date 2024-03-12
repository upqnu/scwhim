package upqnu.scwhim.domain.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import upqnu.scwhim.domain.employee.entity.Role;

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
