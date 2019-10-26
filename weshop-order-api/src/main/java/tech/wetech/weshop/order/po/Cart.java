package tech.wetech.weshop.order.po;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "weshop_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "goods_sn")
    private String goodsSn;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "market_price")
    private BigDecimal marketPrice;

    @Column(name = "retail_price")
    private BigDecimal retailPrice;

    private Short number;

    /**
     * product表对应的goods_specification_ids
     */
    @Column(name = "goods_specification_ids")
    private String goodsSpecificationIds;

    private Boolean checked;

    @Column(name = "list_pic_url")
    private String listPicUrl;

    /**
     * 规格属性组成的字符串，用来显示用
     */
    @Column(name = "goods_specification_name_value")
    private String goodsSpecificationNameValue;

}
