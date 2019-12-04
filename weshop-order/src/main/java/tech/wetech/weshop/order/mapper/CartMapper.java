package tech.wetech.weshop.order.mapper;

import tech.wetech.weshop.common.mapper.MyMapper;
import tech.wetech.weshop.order.po.Cart;

public interface CartMapper extends MyMapper<Cart> {

    int updateNumberById(Integer number, Integer id);

}
