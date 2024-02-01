package hello.board.domain.member;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Grade {
    IRON("아이언"),
    BRONZE("브론즈"),
    SILVER("실버"),
    GOLD("골드"),
    PLATINUM("플래티넘"),
    EMERALD("에메랄드"),
    DIAMOND("다이아몬드"),
    MASTER("마스터"),
    GRAND_MASTER("그랜드 마스터"),
    CHALLENGER("챌린저")
    ;

    private final String value;

    Grade(String value) {
        this.value = value;
    }

    public static Grade findByName(String name) {
        return Arrays.stream(values())
                .filter(grade -> grade.name().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
