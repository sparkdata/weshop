package tech.wetech.weshop.order.query;

import lombok.Data;

@Data
public class OrderQuery {
    /**
     * 页码，从1开始
     */
    private int pageNum;
    /**
     * 页面大小
     */
    private int pageSize;

}
