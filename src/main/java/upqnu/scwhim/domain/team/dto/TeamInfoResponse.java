package upqnu.scwhim.domain.team.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
//@Setter
@AllArgsConstructor
public class TeamInfoResponse {

    private String name;

    private String manager;

    private Integer memberCount;

//    private List<Employee> teamCrews;
}
