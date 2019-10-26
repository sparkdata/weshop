package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "weshop_ad")
public class Ad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "ad_position_id")
    private Short adPositionId;

    @Column(name = "media_type")
    private Byte mediaType;

    private String name;

    private String link;

    private String content;

    @Column(name = "end_time")
    private Date endTime;

    private Byte enabled;

    @Column(name = "image_url")
    private String imageUrl;

}
