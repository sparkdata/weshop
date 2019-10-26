package tech.wetech.weshop.goods.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "weshop_goods_gallery")
public class GoodsGallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "img_desc")
    private String imgDesc;

    @Column(name = "sort_order")
    private Integer sortOrder;

}
