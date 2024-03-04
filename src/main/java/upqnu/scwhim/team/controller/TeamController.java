package upqnu.scwhim.team.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import upqnu.scwhim.team.dto.TeamRegisterReqDto;
import upqnu.scwhim.team.service.TeamService;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/team")
    public void createTeam(@RequestBody TeamRegisterReqDto request) {
        teamService.createTeam(request);
    }
}
