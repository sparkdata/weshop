package tech.wetech.weshop.common.api;

import org.springframework.beans.factory.annotation.Autowired;
import tech.wetech.weshop.common.query.Query;
import tech.wetech.weshop.common.service.IService;
import tech.wetech.weshop.common.utils.Result;

import java.util.List;

public abstract class BaseApi<T> implements Api<T> {

    @Autowired
    protected IService<T> service;

    @Override
    public Result<List<T>> queryAll() {
        return Result.success(service.queryAll());
    }

    @Override
    public Result<List<T>> queryList(T entity) {
        return Result.success(service.queryList(entity));
    }

    @Override
    public Result<List<T>> queryByCondition(Query<T> query) {
        return Result.success(service.queryByCondition(query));
    }

    @Override
    public Result<T> queryOneByCondtion(Query<T> query) {
        return Result.success(service.queryOneByCondition(query));
    }

    @Override
    public Result<Integer> countByCondition(Query<T> query) {
        return Result.success(service.countByCondition(query));
    }

    @Override
    public Result<T> queryOne(T entity) {
        return Result.success(service.queryOne(entity));
    }

    @Override
    public Result<T> queryById(Integer id) {
        return Result.success(service.queryById(id));
    }

    @Override
    public Result<Integer> create(T entity) {
        return Result.success(service.create(entity));
    }

    @Override
    public Result<Integer> createBatch(List<T> list) {
        return Result.success(service.createBatch(list));
    }

    @Override
    public Result<Integer> updateAll(T entity) {
        return Result.success(service.updateAll(entity));
    }

    @Override
    public Result<Integer> updateNotNull(T entity) {
        return Result.success(service.updateNotNull(entity));
    }

    @Override
    public Result<Integer> delete(T entity) {
        return Result.success(service.delete(entity));
    }

    @Override
    public Result<Integer> deleteById(Integer id) {
        return Result.success(service.deleteById(id));
    }

    @Override
    public Result<Integer> count(T entity) {
        return Result.success(service.count(entity));
    }

    @Override
    public Result<String> sayHello(String name) {
        return Result.success("Hello " + name);
    }
}
