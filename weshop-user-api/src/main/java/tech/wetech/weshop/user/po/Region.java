package tech.wetech.weshop.user.po;

import lombok.Data;
import tech.wetech.weshop.user.enums.RegionTypeEnum;

import javax.persistence.*;

@Data
@Table(name = "weshop_region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "parent_id")
    private Short parentId;

    private String name;

    @Column(name = "type")
    private RegionTypeEnum type;

    @Column(name = "agency_id")
    private Short agencyId;

}
