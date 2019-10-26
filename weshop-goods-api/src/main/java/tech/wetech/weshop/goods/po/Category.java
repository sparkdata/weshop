package tech.wetech.weshop.goods.po;

import lombok.Data;
import tech.wetech.weshop.goods.enums.CategoryLevelEnum;

import javax.persistence.*;

/**
 * @author cjbi@outlook.com
 */
@Data
@Table(name = "weshop_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String keywords;

    @Column(name = "front_desc")
    private String frontDesc;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "sort_order")
    private Boolean sortOrder;

    @Column(name = "show_index")
    private Boolean showIndex;

    @Column(name = "is_show")
    private Boolean show;

    @Column(name = "banner_url")
    private String bannerUrl;

    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "wap_banner_url")
    private String wapBannerUrl;

    @Column(name = "level")
    private CategoryLevelEnum level;

    private Integer type;

    @Column(name = "front_name")
    private String frontName;

}
