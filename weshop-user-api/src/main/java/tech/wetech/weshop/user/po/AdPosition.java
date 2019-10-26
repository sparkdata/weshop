package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "weshop_ad_position")
public class AdPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    private String name;

    private Short width;

    private Short height;

    private String desc;

}
