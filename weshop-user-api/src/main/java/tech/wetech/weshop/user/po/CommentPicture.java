package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "weshop_comment_picture")
public class CommentPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "pic_url")
    private String picUrl;

    @Column(name = "sort_order")
    private Boolean sortOrder;

}
