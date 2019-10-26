package tech.wetech.weshop.goods.query;

import lombok.Data;

@Data
public class GoodsSearchQuery {

    private Integer categoryId;

    private Integer brandId;

    private String keyword;

    private Boolean newly;

    private Boolean hot;

    private String sort;

    private String order;

    /**
     * 页码，从1开始
     */
    private int pageNum;
    /**
     * 页面大小
     */
    private int pageSize;
}
