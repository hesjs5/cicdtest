package hello.board.repository.member;

import hello.board.domain.member.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("insert into member(name, age, grade) values(#{name}, #{age}, #{grade})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertFromAnnotation(final Member member);

    @Select("select * from member where id = #{id}")
    Member selectFromAnnotation(final Long id);

    void create(final Member member);

    Member findById(final Long id);

    List<Member> findAgeGreaterOrEqualThan(Integer age);

    List<Member> findMembersByTeamId(final Long teamId);

    void bulkInsert(List<Member> members);

    List<Member> findAll();
}
