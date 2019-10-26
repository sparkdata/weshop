package tech.wetech.weshop.goods.po;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "weshop_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "goods_specification_ids")
    private String goodsSpecificationIds;

    @Column(name = "goods_sn")
    private String goodsSn;

    @Column(name = "goods_number")
    private Integer goodsNumber;

    @Column(name = "retail_price")
    private BigDecimal retailPrice;
}
