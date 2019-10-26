package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "weshop_feedback")
public class Feedback {
    @Id
    @Column(name = "msg_id")
    private Integer msgId;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "msg_title")
    private String msgTitle;

    @Column(name = "msg_type")
    private Boolean msgType;

    @Column(name = "msg_status")
    private Boolean msgStatus;

    @Column(name = "msg_time")
    private Date msgTime;

    @Column(name = "message_img")
    private String messageImg;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "msg_area")
    private Boolean msgArea;

    @Column(name = "msg_content")
    private String msgContent;

}
