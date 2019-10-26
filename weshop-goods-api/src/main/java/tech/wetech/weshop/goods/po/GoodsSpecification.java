package tech.wetech.weshop.goods.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "weshop_goods_specification")
public class GoodsSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "specification_id")
    private Integer specificationId;

    private String value;

    @Column(name = "pic_url")
    private String picUrl;
}
