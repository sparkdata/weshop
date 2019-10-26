package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "weshop_collect")
public class Collect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "value_id")
    private Integer valueId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否是关注
     */
    @Column(name = "is_attention")
    private Boolean attention;

    @Column(name = "type_id")
    private Integer typeId;

}
