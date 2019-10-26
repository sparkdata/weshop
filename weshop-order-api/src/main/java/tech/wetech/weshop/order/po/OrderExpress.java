package tech.wetech.weshop.order.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "weshop_order_express")
public class OrderExpress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "shipper_id")
    private Integer shipperId;

    /**
     * 物流公司名称
     */
    @Column(name = "shipper_name")
    private String shipperName;

    /**
     * 物流公司代码
     */
    @Column(name = "shipper_code")
    private String shipperCode;

    /**
     * 快递单号
     */
    @Column(name = "logistic_code")
    private String logisticCode;

    /**
     * 物流跟踪信息
     */
    private String traces;

    @Column(name = "is_finish")
    private Boolean finish;

    /**
     * 总查询次数
     */
    @Column(name = "request_count")
    private Integer requestCount;

    /**
     * 最近一次向第三方查询物流信息时间
     */
    @Column(name = "request_time")
    private Date requestTime;

    /**
     * 添加时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

}
