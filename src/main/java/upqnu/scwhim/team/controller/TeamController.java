package upqnu.scwhim.team.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import upqnu.scwhim.team.dto.TeamInfoResponse;
import upqnu.scwhim.team.dto.TeamRegisterReqDto;
import upqnu.scwhim.team.service.TeamService;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    /**
     * 팀 등록
     * @param request
     */
    @Operation(summary = "팀 등록 요청", description = "입력된 팀 정보를 저장합니다")
    @Parameter(name = "TeamRegisterReqDto", description = "팀 등록 시, name 필수 입력")
    @PostMapping("")
    public void createTeam(@RequestBody TeamRegisterReqDto request) {
        teamService.createTeam(request);
    }

    /**
     * 개별 팀 조회
     * @param teamId
     * @return
     */
    @Operation(summary = "개별 팀 조회", description = "개별 팀을 조회합니다")
    @Parameter(name = "teamId", description = "개별 팀 조회 시, 해당 팀의 id 필수 입력")
    @GetMapping("/{teamId}")
    public TeamInfoResponse showTeam(@PathVariable Long teamId) {
        TeamInfoResponse response = teamService.showTeam(teamId);
        return response;
    }
}
