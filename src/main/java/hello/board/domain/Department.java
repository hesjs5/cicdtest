package hello.board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Department {

    private int deptno;
    private String dname;
    private String loc;

    public Department() {
    }

    @Builder
    public Department(String dname, String loc) {
        this.dname = dname;
        this.loc = loc;
    }
}
