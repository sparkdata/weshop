package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Table(name = "weshop_topic")
public class Topic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String avatar;

    @Column(name = "item_pic_url")
    private String itemPicUrl;

    private String subtitle;

    @Column(name = "topic_category_id")
    private Integer topicCategoryId;

    @Column(name = "price_info")
    private BigDecimal priceInfo;

    @Column(name = "read_count")
    private String readCount;

    @Column(name = "scene_pic_url")
    private String scenePicUrl;

    @Column(name = "topic_template_id")
    private Integer topicTemplateId;

    @Column(name = "topic_tag_id")
    private Integer topicTagId;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Column(name = "is_show")
    private Boolean show;

    private String content;

}
