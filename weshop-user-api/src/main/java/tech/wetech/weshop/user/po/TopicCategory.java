package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "weshop_topic_category")
public class TopicCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "pic_url")
    private String picUrl;

}
