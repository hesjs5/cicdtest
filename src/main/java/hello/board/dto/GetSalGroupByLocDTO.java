package hello.board.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetSalGroupByLocDTO {

    private String loc;
    private BigDecimal avgSal;

    public GetSalGroupByLocDTO() {
    }

    @Builder
    public GetSalGroupByLocDTO(String loc, BigDecimal avgSal) {
        this.loc = loc;
        this.avgSal = avgSal;
    }
}
