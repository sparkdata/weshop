package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "weshop_search_history")
public class SearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String keyword;

    /**
     * 搜索来源，如PC、小程序、APP等
     */
    @Column(name = "`from`")
    private String from;

    /**
     * 搜索时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "user_id")
    private Integer userId;

}
