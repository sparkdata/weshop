package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "weshop_footprint")
public class Footprint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "create_time")
    private Date createTime;

}
