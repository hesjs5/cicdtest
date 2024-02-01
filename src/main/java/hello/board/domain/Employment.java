package hello.board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Employment {

    private int empno;
    private String ename;
    private int sal;
    private int deptno;

    public Employment() {
    }

    @Builder
    public Employment(String ename, int sal) {
        this.ename = ename;
        this.sal = sal;
    }

    public Employment(String ename, int sal, int deptno) {
        this.ename = ename;
        this.sal = sal;
        this.deptno = deptno;
    }
}
