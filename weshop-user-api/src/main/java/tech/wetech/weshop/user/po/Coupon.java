package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "weshop_coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String name;

    @Column(name = "type_money")
    private BigDecimal typeMoney;

    @Column(name = "send_type")
    private Byte sendType;

    @Column(name = "min_amount")
    private BigDecimal minAmount;

    @Column(name = "max_amount")
    private BigDecimal maxAmount;

    @Column(name = "send_start_date")
    private Integer sendStartDate;

    @Column(name = "send_end_date")
    private Integer sendEndDate;

    @Column(name = "use_start_date")
    private Integer useStartDate;

    @Column(name = "use_end_date")
    private Integer useEndDate;

    @Column(name = "min_goods_amount")
    private BigDecimal minGoodsAmount;

}
