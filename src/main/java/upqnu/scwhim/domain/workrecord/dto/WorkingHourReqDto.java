package upqnu.scwhim.domain.workrecord.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.YearMonth;

@Getter
@AllArgsConstructor
public class WorkingHourReqDto {

    @JsonFormat(pattern = "yyyy-MM")
    private YearMonth yearMonth;

    private Long employeeId;
}
