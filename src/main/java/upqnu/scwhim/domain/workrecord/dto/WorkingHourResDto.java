package upqnu.scwhim.domain.workrecord.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class WorkingHourResDto {

    private Long employeeId;

    private List<WorkingHourDetailDto> workingHourDetails;

    private int totalWorkTimeInMinutes;
}
