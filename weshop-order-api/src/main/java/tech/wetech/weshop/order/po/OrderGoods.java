package tech.wetech.weshop.order.po;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "weshop_order_goods")
public class OrderGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_sn")
    private String goodsSn;

    @Column(name = "product_id")
    private Integer productId;

    private Short number;

    @Column(name = "market_price")
    private BigDecimal marketPrice;

    @Column(name = "retail_price")
    private BigDecimal retailPrice;

    @Column(name = "is_real")
    private Boolean real;

    @Column(name = "goods_specification_ids")
    private String goodsSpecificationIds;

    @Column(name = "list_pic_url")
    private String listPicUrl;

    @Column(name = "goods_specification_name_value")
    private String goodsSpecificationNameValue;

}
