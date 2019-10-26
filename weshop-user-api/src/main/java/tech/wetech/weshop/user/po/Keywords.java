package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "weshop_keywords")
public class Keywords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String keyword;

    @Column(name = "is_hot")
    private Boolean hot;

    @Column(name = "is_default")
    private Boolean isDefault;

    @Column(name = "is_show")
    private Boolean show;

    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 关键词的跳转链接
     */
    @Column(name = "`scheme _url`")
    private String schemeUrl;

    private Integer type;

}
