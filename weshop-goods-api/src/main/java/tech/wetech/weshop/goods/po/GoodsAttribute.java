package tech.wetech.weshop.goods.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "weshop_goods_attribute")
public class GoodsAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "attribute_id")
    private Integer attributeId;

    private String value;

}
