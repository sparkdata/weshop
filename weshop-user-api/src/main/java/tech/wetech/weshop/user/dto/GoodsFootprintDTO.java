package tech.wetech.weshop.user.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class GoodsFootprintDTO {

    private Integer id;

    private Integer userId;

    private Integer goodsId;

    private LocalDate createTime;

    private String name;

    private String listPicUrl;

    private String goodsBrief;

    private BigDecimal retailPrice;

    public String getDisplayTime() {
        if (LocalDate.now().isEqual(createTime)) {
            return "今天";
        }
        if (LocalDate.now().minusDays(1).isEqual(createTime)) {
            return "昨天";
        }
        if (LocalDate.now().minusDays(2).isEqual(createTime)) {
            return "前天";
        }
        return createTime.toString();
    }

}
