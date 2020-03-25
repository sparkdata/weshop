package tech.wetech.weshop.common.mapper;

import tech.wetech.mybatis.annotation.DeleteEntityProvider;
import tech.wetech.mybatis.mapper.BaseMapper;

/**
 * @author cjbi
 */
public interface MyMapper<T> extends BaseMapper<T> {
    @DeleteEntityProvider(type = MyEntitySqlBuilder.class, method = "delete")
    int delete(T entity);
}
