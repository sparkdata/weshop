package tech.wetech.weshop.goods.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "weshop_related_goods")
public class RelatedGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "related_goods_id")
    private Integer relatedGoodsId;
}
