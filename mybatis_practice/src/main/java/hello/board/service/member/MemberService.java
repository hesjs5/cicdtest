package hello.board.service.member;

import hello.board.domain.member.Grade;
import hello.board.domain.member.Member;
import hello.board.repository.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public void saveMember(final String name, final int age, final Grade grade, final String imageName) {
        Member member = Member.builder()
                .name(name)
                .age(age)
                .grade(grade)
                .imageName(imageName)
                .build();
        memberMapper.create(member);
    }
}
