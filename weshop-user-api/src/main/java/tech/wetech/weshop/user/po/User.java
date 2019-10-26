package tech.wetech.weshop.user.po;

import lombok.Data;
import tech.wetech.weshop.user.enums.GenderEnum;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "weshop_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    @Column(name = "gender")
    private GenderEnum gender;

    private Date birthday;

    @Column(name = "register_time")
    private Date registerTime;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "user_level_id")
    private Byte userLevelId;

    private String nickname;

    private String mobile;

    @Column(name = "register_ip")
    private String registerIp;

    private String avatar;

    @Column(name = "wechat_open_id")
    private String wechatOpenId;

}
