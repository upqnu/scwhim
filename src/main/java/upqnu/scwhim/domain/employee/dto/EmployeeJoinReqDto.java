package upqnu.scwhim.domain.employee.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeJoinReqDto {

    @NotBlank(message = "직원의 이름은 반드시 입력해야 합니다.")
    private String name;

    @NotBlank(message = "직원의 입사일은 반드시 입력해야 합니다.")
    private LocalDate workstartDate;

    @NotBlank(message = "직원의 생일은 반드시 입력해야 합니다.")
    private LocalDate birthday;
}
