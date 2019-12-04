package tech.wetech.weshop.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tech.wetech.mybatis.example.Example;
import tech.wetech.mybatis.example.MapperExample;
import tech.wetech.mybatis.example.Sort;
import tech.wetech.weshop.common.mapper.MyMapper;
import tech.wetech.weshop.common.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <T>
 * @author cjbi@outlook.com
 */
public abstract class BaseService<T> implements IService<T> {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected MyMapper<T> mapper;


    @Override
    public List<T> queryAll() {
        return mapper.selectAll();
    }

    @Override
    public List<T> queryList(T entity) {
        return mapper.selectList(entity);
    }

    @Override
    public T queryOne(T entity) {
        return mapper.selectOne(entity);
    }

    @Override
    public T queryById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    private Example<T> toExample(Query<T> query) {
        MapperExample<T> example = mapper.createExample();
        example.setColumns(query.getSelects().toArray(new String[query.getSelects().size()]));
        if (query.getPageSize() != null && query.getPageNumber() != null) {
            example.setPage(query.getPageSize(), query.getPageNumber());
        }
        List<Sort.Order> orders = new ArrayList<>();
        for (Query.Sort.Order order : query.getSort().getOrders()) {
            if (order.getDirection() == Query.Sort.Direction.ASC) {
                orders.add(new Sort.Order(Sort.Direction.ASC, order.getProperty()));
            }
            if (order.getDirection() == Query.Sort.Direction.DESC) {
                orders.add(new Sort.Order(Sort.Direction.DESC, order.getProperty()));
            }
        }
        example.setSort(new Sort(orders));
        return example;

    }

    @Override
    public List<T> queryByCondition(Query<T> query) {
        return mapper.selectByExample(toExample(query));
    }

    @Override
    public T queryOneByCondition(Query<T> query) {
        List<T> ts = mapper.selectByExample(toExample(query));
        if (ts.size() == 0) {
            return null;
        }
        return ts.get(0);
    }

    @Override
    public int countByCondition(Query<T> query) {
        return mapper.countByExample(toExample(query));
    }

    @Override
    public int create(T entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public int createBatch(List<T> list) {
        return mapper.insertAll(list);
    }

    @Override
    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int delete(T entity) {
        return mapper.delete(entity);
    }

    @Override
    public int deleteById(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int count(T entity) {
        return mapper.count(entity);
    }
}
