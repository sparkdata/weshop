package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "weshop_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type_id")
    private Byte typeId;

    @Column(name = "value_id")
    private Integer valueId;

    /**
     * 储存为base64编码
     */
    private String content;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    private Byte status;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "new_content")
    private String newContent;

}
