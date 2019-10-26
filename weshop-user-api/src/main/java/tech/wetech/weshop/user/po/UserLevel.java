package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "weshop_user_level")
public class UserLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    private String name;

    private String description;

}
