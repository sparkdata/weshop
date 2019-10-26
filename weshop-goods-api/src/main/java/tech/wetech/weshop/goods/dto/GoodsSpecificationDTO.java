package tech.wetech.weshop.goods.dto;

import lombok.Data;

@Data
public class GoodsSpecificationDTO {

    private Integer id;

    private String name;

    private Integer goodsId;

    private Integer specificationId;

    private String value;

    private String picUrl;
}
