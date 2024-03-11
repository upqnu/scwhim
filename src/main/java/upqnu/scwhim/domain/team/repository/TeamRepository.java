package upqnu.scwhim.domain.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upqnu.scwhim.domain.team.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByName(String teamName);
}
