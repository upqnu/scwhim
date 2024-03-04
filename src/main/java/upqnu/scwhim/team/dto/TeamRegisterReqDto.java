package upqnu.scwhim.team.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeamRegisterReqDto {

    @NotBlank(message = "팀 이름은 반드시 입력해야 합니다.")
    private String name;
}