package tech.wetech.weshop.goods.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "weshop_specification")
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "sort_order")
    private Byte sortOrder;
}
