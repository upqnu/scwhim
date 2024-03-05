package upqnu.scwhim.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeModifyReqDto {

    private String name;

    private LocalDate workstartDate;

    private LocalDate birthday;
}
