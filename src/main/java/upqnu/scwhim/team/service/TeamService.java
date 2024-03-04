package upqnu.scwhim.team.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import upqnu.scwhim.team.dto.TeamInfoResponse;
import upqnu.scwhim.team.dto.TeamRegisterReqDto;
import upqnu.scwhim.team.entity.Team;
import upqnu.scwhim.team.repository.TeamRepository;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public void createTeam(@RequestBody TeamRegisterReqDto request) {
        teamRepository.save(new Team(request.getName()));
    }

    @Transactional
    public TeamInfoResponse showTeam(@PathVariable Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(IllegalArgumentException::new);

        TeamInfoResponse response = new TeamInfoResponse(team.getName(), team.getManager(), team.getMemberCount());
        return response;
    }
}
