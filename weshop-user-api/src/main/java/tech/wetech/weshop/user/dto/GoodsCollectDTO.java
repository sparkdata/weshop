package tech.wetech.weshop.user.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class GoodsCollectDTO {

    private Integer id;

    private Integer userId;

    private Integer valueId;

    private LocalDateTime createTime;
    /**
     * 是否是关注
     */
    private Boolean attention;

    private Integer typeId;

    private String name;

    private String listPicUrl;

    private String goodsBrief;

    private BigDecimal retailPrice;

}
