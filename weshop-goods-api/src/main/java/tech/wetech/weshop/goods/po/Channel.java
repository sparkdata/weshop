package tech.wetech.weshop.goods.po;

import lombok.Data;

import javax.persistence.*;
@Data
@Table(name = "weshop_channel")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String url;

    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "sort_order")
    private Integer sortOrder;

}
