package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "weshop_admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    @Column(name = "password_salt")
    private String passwordSalt;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private String avatar;

    @Column(name = "admin_role_id")
    private Integer adminRoleId;

}
