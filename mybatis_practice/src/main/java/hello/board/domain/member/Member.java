package hello.board.domain.member;

import lombok.Builder;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class Member {

    private final Long id;
    private final String name;
    private final int age;
    private final Grade grade;
    private final String imageName;
    private final Long teamId;

    @Builder
    public Member(Long id, String name, int age, Grade grade, String imageName, Long teamId) {
        log.info("constructor 호출");
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.imageName = imageName;
        this.teamId = teamId;
    }

    public Long getId() {
        log.info("getId() 호출");
        return id;
    }

    public String getName() {
        log.info("getName() 호출");
        return name;
    }

    public int getAge() {
        log.info("getAge() 호출");
        return age;
    }

    public Grade getGrade() {
        log.info("getGrade() 호출");
        return grade;
    }

    public String getImageName() {
        log.info("getImageName() 호출");
        return imageName;
    }

    public Long getTeamId() {
        log.info("getTeamId() 호출");
        return teamId;
    }
}
