package tech.wetech.weshop.common.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tech.wetech.weshop.common.query.Query;
import tech.wetech.weshop.common.utils.Result;

import java.util.List;

public interface Api<T> {

    @GetMapping("/queryAll")
    Result<List<T>> queryAll();

    @PostMapping(value = "/queryList")
    Result<List<T>> queryList(@RequestBody T entity);

    @PostMapping("/queryList")
    Result<List<T>> queryByCondition(@RequestBody Query<T> query);

    @PostMapping("/queryOneByCriteria")
    Result<T> queryOneByCondtion(@RequestBody Query<T> query);

    @PostMapping("/countByCriteria")
    Result<Integer> countByCondition(@RequestBody Query<T> query);

    @PostMapping("/queryOne")
    Result<T> queryOne(@RequestBody T entity);

    @GetMapping("/queryById")
    Result<T> queryById(@RequestParam("id") Integer id);

    @PostMapping("/create")
    Result<Integer> create(@RequestBody T entity);

    @PostMapping("/createBatch")
    Result<Integer> createBatch(@RequestBody List<T> list);

    @PostMapping("/updateAll")
    Result<Integer> updateAll(@RequestBody T entity);

    @PostMapping("/updateNotNull")
    Result<Integer> updateNotNull(@RequestBody T entity);

    @PostMapping("/delete")
    Result<Integer> delete(@RequestBody T entity);

    @PostMapping("/deleteById")
    Result<Integer> deleteById(@RequestBody Integer id);

    @PostMapping("/count")
    Result<Integer> count(@RequestBody T entity);

    @GetMapping("/sayHello")
    Result<String> sayHello(@RequestParam("name") String name);

}
