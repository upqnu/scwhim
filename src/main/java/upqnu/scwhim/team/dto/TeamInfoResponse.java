package upqnu.scwhim.team.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import upqnu.scwhim.employee.entity.Employee;

import java.util.List;

@Getter
//@Setter
@AllArgsConstructor
public class TeamInfoResponse {

    private String name;

    private String manager;

    private Integer memberCount;

//    private List<Employee> teamCrews;
}
