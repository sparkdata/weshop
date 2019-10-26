package tech.wetech.weshop.user.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "weshop_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "country_id")
    private Short countryId;

    @Column(name = "province_id")
    private Short provinceId;

    @Column(name = "city_id")
    private Short cityId;

    @Column(name = "district_id")
    private Short districtId;

    private String address;

    private String mobile;

    @Column(name = "is_default")
    private Boolean isDefault;

}
