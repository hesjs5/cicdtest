package hello.board.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class GetEmpGroupByDeptnoDTO2 {

    private Long empCount;
    private String dname;
    private Long deptno;

    public GetEmpGroupByDeptnoDTO2() {
    }

    @Builder
    public GetEmpGroupByDeptnoDTO2(Long empCount, String dname, Long deptno) {
        this.empCount = empCount;
        this.dname = dname;
        this.deptno = deptno;
    }
}
