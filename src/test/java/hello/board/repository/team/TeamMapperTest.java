package hello.board.repository.team;

import hello.board.domain.team.Team;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Sql("classpath:schema.sql")
class TeamMapperTest {

    @Autowired
    private TeamMapper teamMapper;

    @Test
    @DisplayName("팀 생성 테스트")
    void createTest() {
        // given
        String name = "teamA";
        Team team = Team.nameOf(name);

        // when
        teamMapper.create(team);

        // then
        assertNotNull(team.getId());
        assertEquals(name, team.getName());
        assertEquals(LocalDate.now(), team.getStartDate());
        assertEquals(LocalDate.now(), team.getEndDate());
    }
}