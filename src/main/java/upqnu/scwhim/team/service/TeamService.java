package upqnu.scwhim.team.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import upqnu.scwhim.team.dto.TeamRegisterReqDto;
import upqnu.scwhim.team.entity.Team;
import upqnu.scwhim.team.repository.TeamRepository;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public void createTeam(@RequestBody TeamRegisterReqDto request) {
        teamRepository.save(new Team(request.getName()));
    }
}
