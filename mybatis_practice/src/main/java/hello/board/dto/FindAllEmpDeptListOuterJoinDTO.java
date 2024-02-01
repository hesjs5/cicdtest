package hello.board.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class FindAllEmpDeptListOuterJoinDTO {

    private Long empno;
    private String ename;
    private Long deptno;
    private String dname;
    private String loc;

    public FindAllEmpDeptListOuterJoinDTO() {
    }

    @Builder
    public FindAllEmpDeptListOuterJoinDTO(Long empno, String ename, Long deptno, String dname, String loc) {
        this.empno = empno;
        this.ename = ename;
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
}
