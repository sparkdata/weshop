package tech.wetech.weshop.order.po;

import lombok.Data;
import tech.wetech.weshop.order.enums.OrderStatusEnum;
import tech.wetech.weshop.order.enums.PayStatusEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "weshop_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_sn")
    private String orderSN;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "order_status")
    private OrderStatusEnum orderStatus;

    @Column(name = "shipping_status")
    private Short shippingStatus;

    @Column(name = "pay_status")
    private PayStatusEnum payStatus;

    private String consignee;

    private Short country;

    private Short province;

    private Short city;

    private Short district;

    private String address;

    private String mobile;

    private String postscript;

    @Column(name = "shipping_fee")
    private BigDecimal shippingFee;

    @Column(name = "pay_name")
    private String payName;

    @Column(name = "pay_id")
    private Byte payId;

    /**
     * 实际需要支付的金额
     */
    @Column(name = "actual_price")
    private BigDecimal actualPrice;

    private Integer integral;

    @Column(name = "integral_money")
    private BigDecimal integralMoney;

    /**
     * 订单总价
     */
    @Column(name = "order_price")
    private BigDecimal orderPrice;

    /**
     * 商品总价
     */
    @Column(name = "goods_price")
    private BigDecimal goodsPrice;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "confirm_time")
    private Date confirmTime;

    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 配送费用
     */
    @Column(name = "freight_price")
    private BigDecimal freightPrice;

    /**
     * 使用的优惠券id
     */
    @Column(name = "coupon_id")
    private Integer couponId;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "coupon_price")
    private BigDecimal couponPrice;

    @Column(name = "callback_status")
    private String callbackStatus;

}
