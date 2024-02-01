package hello.board.repository;

import hello.board.domain.member.Grade;
import hello.board.domain.member.Member;
import hello.board.domain.team.Team;
import hello.board.repository.member.MemberMapper;
import hello.board.repository.team.TeamMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Sql("classpath:schema.sql")
class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private TeamMapper teamMapper;

    @Test
    @DisplayName("회원 추가")
    void createTest() {
        // given
        String name = "test";
        int age = 20;
        Grade grade = Grade.BRONZE;
        Member member = Member.builder()
                .name(name)
                .age(age)
                .grade(grade)
                .build();

        // when
        memberMapper.create(member);

        // then
        Long id = member.getId();
        Member actual = memberMapper.findById(id);

        assertEquals(name, actual.getName());
        assertEquals(age, actual.getAge());
        assertEquals(grade, actual.getGrade());
        assertNull(actual.getTeamId());
    }

    @Test
    @DisplayName("벌크 회원 추가")
    void bulkInsertTest() {
        // given
        List<Member> members = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Member member = Member.builder()
                    .name("member" + i)
                    .age(i)
                    .grade(Grade.BRONZE)
                    .build();
            members.add(member);
        }

        // when
        memberMapper.bulkInsert(members);

        // then
        List<Member> actual = memberMapper.findAll();
        assertEquals(10, actual.size());
    }

    @Test
    @DisplayName("팀에 있는 모든 회원 조회")
    void findMembersByTeamIdTest() {
        // given
        Team teamA = Team.nameOf("teamA");
        teamMapper.create(teamA);

        Team teamB = Team.nameOf("teamB");
        teamMapper.create(teamB);

        List<Member> members = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Member member = Member.builder()
                    .name("member" + i)
                    .age(i)
                    .grade(Grade.BRONZE)
                    .teamId(teamA.getId())
                    .build();
            members.add(member);
        }
        memberMapper.bulkInsert(members);

        members = new ArrayList<>();
        for (int i = 6; i <= 10; i++) {
            Member member = Member.builder()
                    .name("member" + i)
                    .age(i)
                    .grade(Grade.SILVER)
                    .teamId(teamB.getId())
                    .build();
            members.add(member);
        }
        memberMapper.bulkInsert(members);

        // when
        List<Member> teamBMembers = memberMapper.findMembersByTeamId(teamB.getId());

        // then
        assertEquals(5, teamBMembers.size());
    }
}