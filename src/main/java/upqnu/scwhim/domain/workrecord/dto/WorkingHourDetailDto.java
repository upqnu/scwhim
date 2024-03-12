package upqnu.scwhim.domain.workrecord.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class WorkingHourDetailDto {

    private LocalDate workDate;

    private int workTimeInMinutes;
}
