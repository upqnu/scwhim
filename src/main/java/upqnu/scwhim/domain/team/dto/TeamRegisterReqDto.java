package upqnu.scwhim.domain.team.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamRegisterReqDto {

    @NotBlank(message = "팀 이름은 반드시 입력해야 합니다.")
    private String name;
}
