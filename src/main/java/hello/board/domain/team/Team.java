package hello.board.domain.team;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class Team {

    private final Long id;
    private final String name;
    private final LocalDate startDate;
    private final LocalDate endDate;

    private Team(Long id, String name, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Team nameOf(String name) {
        return new Team(0L, name, LocalDate.now(), LocalDate.now());
    }
}
