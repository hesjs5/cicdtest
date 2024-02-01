package hello.board.repository.team;

import hello.board.domain.team.Team;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamMapper {

    void create(Team team);
}
