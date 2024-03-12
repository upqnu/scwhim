package upqnu.scwhim.domain.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import upqnu.scwhim.domain.employee.entity.Role;

@Getter
@Setter
@AllArgsConstructor
public class EmployeePositionReqDto {

    private String teamName;

    private Role role;
}
