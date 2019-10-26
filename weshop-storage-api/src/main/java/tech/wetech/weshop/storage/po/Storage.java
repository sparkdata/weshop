package tech.wetech.weshop.storage.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "weshop_storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文件的唯一索引
     */
    @Column(name = "`key`")
    private String key;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件类型
     */
    private String type;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 文件访问链接
     */
    private String url;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

}
