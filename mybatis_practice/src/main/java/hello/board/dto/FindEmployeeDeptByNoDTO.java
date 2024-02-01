package hello.board.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class FindEmployeeDeptByNoDTO {

    private String ename;
    private String dname;
    private String loc;

    public FindEmployeeDeptByNoDTO() {
    }

    @Builder
    public FindEmployeeDeptByNoDTO(String ename, String dname, String loc) {
        this.ename = ename;
        this.dname = dname;
        this.loc = loc;
    }
}
