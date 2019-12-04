package tech.wetech.weshop.common.fallback;

import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.enums.CommonResultStatus;
import tech.wetech.weshop.common.query.Query;
import tech.wetech.weshop.common.utils.Result;

import java.util.List;

public abstract class ApiFallback<T> implements Api<T> {

    @Override
    public Result<List<T>> queryAll() {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<List<T>> queryList(T entity) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<List<T>> queryByCondition(Query<T> query) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<T> queryOneByCondtion(Query<T> query) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<Integer> countByCondition(Query<T> query) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<T> queryOne(T entity) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<T> queryById(Integer id) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<Integer> create(T entity) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<Integer> createBatch(List<T> list) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<Integer> updateAll(T entity) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<Integer> updateNotNull(T entity) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<Integer> delete(T entity) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<Integer> deleteById(Integer id) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<Integer> count(T entity) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<String> sayHello(String name) {
        return Result.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }
}
