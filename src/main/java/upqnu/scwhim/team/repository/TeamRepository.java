package upqnu.scwhim.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upqnu.scwhim.team.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
