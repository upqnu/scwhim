package upqnu.scwhim.domain.team.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import upqnu.scwhim.domain.team.dto.TeamInfoResponse;
import upqnu.scwhim.domain.team.dto.TeamRegisterReqDto;
import upqnu.scwhim.domain.team.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
@Tag(name = "Team", description = "Team API")
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

    /**
     * 모든 팀 조회
     * @return
     */
    @Operation(summary = "모든 팀 조회", description = "모든 팀을 조회합니다")
    @GetMapping("")
    public List<TeamInfoResponse> showAllTeams() {
        List<TeamInfoResponse> responses = teamService.showAllTeams();
        return responses;
    }

    /**
     * 팀 이름 변경
     * @param teamId
     * @param newTeamName
     */
    @Operation(summary = "팀 이름 변경", description = "개별 팀의 이름을 변경합니다")
    @Parameter(name = "teamId / newTeamName", description = "개별 팀 이름 변경 시, 해당 팀의 id 필수 입력 / 변경해야 할 팀 이름은 request body로 입력")
    @PatchMapping("/{teamId}")
    public void modifyTeamName(@PathVariable Long teamId, @RequestBody String newTeamName) {
        teamService.modifyTeamName(teamId, newTeamName);
    }

    /**
     * 특정 팀 삭제
     * @param teamId
     */
    @Operation(summary = "특정 팀 삭제", description = "특정 팀을 삭제합니다")
    @Parameter(name = "teamId", description = "특정 팀 삭제 시, 해당 팀의 id 필수 입력")
    @DeleteMapping("/{teamId}")
    public void deleteTeam(@PathVariable Long teamId) {
        teamService.deleteTeam(teamId);
    }
}
