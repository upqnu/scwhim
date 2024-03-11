package upqnu.scwhim.domain.team.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import upqnu.scwhim.domain.employee.entity.Employee;
import upqnu.scwhim.domain.employee.repository.EmployeeRepository;
import upqnu.scwhim.domain.team.entity.Team;
import upqnu.scwhim.domain.team.dto.TeamInfoResponse;
import upqnu.scwhim.domain.team.dto.TeamRegisterReqDto;
import upqnu.scwhim.domain.team.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final EmployeeRepository employeeRepository;

    @Transactional
    public void createTeam(@RequestBody TeamRegisterReqDto request) {
        teamRepository.save(new Team(request.getName()));
    }

    @Transactional
    public TeamInfoResponse showTeam(@PathVariable Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(IllegalArgumentException::new);

        List<Employee> managers = employeeRepository.findAll();
        String managerName = "";
        int memberCount = 0;
        for (Employee e : managers) {
            if (e.getTeamName().equals(team.getName())) {
                managerName = e.getName();
                memberCount++;
            }
        }

        TeamInfoResponse response = new TeamInfoResponse(team.getName(), managerName, memberCount);
        return response;
    }

    @Transactional
    public List<TeamInfoResponse> showAllTeams() {
        List<Team> teams = teamRepository.findAll();
        List<TeamInfoResponse> allTeams = new ArrayList<>();
        for (Team t : teams) {
            allTeams.add(new TeamInfoResponse(
                    t.getName(), t.getManager(), t.getMemberCount()
            ));
        }
        return allTeams;
    }

    @Transactional
    public void modifyTeamName(Long teamId, String newTeamName) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(IllegalArgumentException::new);

        team.modifyTeamName(newTeamName);
    }

    @Transactional
    public void deleteTeam(Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(IllegalArgumentException::new);

        teamRepository.deleteById(teamId);
    }
}
