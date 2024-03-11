package upqnu.scwhim.domain.workrecord.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class WorkRecordResDto {

    private LocalDate workDate;

    private LocalDateTime punchInTime;

    private LocalDateTime goHomeTime;

    private Long employeeId;
}
