package tech.wetech.weshop.goods.po;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "weshop_brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "list_pic_url")
    private String listPicUrl;

    @Column(name = "simple_desc")
    private String simpleDesc;

    @Column(name = "pic_url")
    private String picUrl;

    @Column(name = "sort_order")
    private Byte sortOrder;

    @Column(name = "is_show")
    private Boolean show;

    @Column(name = "floor_price")
    private BigDecimal floorPrice;

    @Column(name = "app_list_pic_url")
    private String appListPicUrl;

    @Column(name = "is_new")
    private Boolean newly;

    @Column(name = "new_pic_url")
    private String newPicUrl;

    @Column(name = "new_sort_order")
    private Byte newSortOrder;

}
