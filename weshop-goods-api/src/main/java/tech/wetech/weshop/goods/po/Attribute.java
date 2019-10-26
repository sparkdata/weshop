package tech.wetech.weshop.goods.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "weshop_attribute")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "attribute_category_id")
    private Integer attributeCategoryId;

    private String name;

    @Column(name = "input_type")
    private Boolean inputType;

    @Column(name = "sort_order")
    private Byte sortOrder;

    private String values;

}
