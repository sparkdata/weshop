package tech.wetech.weshop.order.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "weshop_shipper")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 快递公司名称
     */
    private String name;

    /**
     * 快递公司代码
     */
    private String code;

    /**
     * 排序
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

}
