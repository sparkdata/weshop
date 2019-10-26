package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "weshop_user_coupon")
public class UserCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "coupon_id")
    private Byte couponId;

    @Column(name = "coupon_number")
    private String couponNumber;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "used_time")
    private Date usedTime;

    @Column(name = "order_id")
    private Integer orderId;

}
