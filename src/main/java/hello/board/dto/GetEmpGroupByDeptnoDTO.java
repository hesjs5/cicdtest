package hello.board.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class GetEmpGroupByDeptnoDTO {

    private Long deptno;
    private Long empCount;

    public GetEmpGroupByDeptnoDTO() {
    }

    @Builder
    public GetEmpGroupByDeptnoDTO(Long deptno, Long empCount) {
        this.deptno = deptno;
        this.empCount = empCount;
    }
}
