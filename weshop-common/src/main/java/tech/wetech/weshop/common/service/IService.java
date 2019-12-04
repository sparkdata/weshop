package tech.wetech.weshop.common.service;

import tech.wetech.weshop.common.query.Query;

import java.util.List;

/**
 * 通用接口
 *
 * @param <T>
 * @author cjbi@outlook.com
 */
public interface IService<T> {

    List<T> queryAll();

    List<T> queryList(T entity);

    List<T> queryByCondition(Query<T> query);

    T queryOneByCondition(Query<T> query);

    int countByCondition(Query<T> query);

    T queryOne(T entity);

    T queryById(Integer id);

    int create(T entity);

    int createBatch(List<T> list);

    int updateAll(T entity);

    int updateNotNull(T entity);

    int delete(T entity);

    int deleteById(Integer id);

    int count(T entity);

}
