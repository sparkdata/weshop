package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.query.Query;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.TopicApi;
import tech.wetech.weshop.user.po.Topic;

import java.util.List;

@RequestMapping("/wechat/topic")
@RestController
public class WechatTopicController extends BaseController {

    @Autowired
    private TopicApi topicApi;

    @GetMapping("/related")
    public Result<List<Topic>> relatedTopic() {
        Query<Topic> query = new Query();
        query.setPageNumber(1).setPageSize(4);
        return topicApi.queryByCondition(query);
    }

    @GetMapping("/list")
    public Result<List<Topic>> list(Topic topic, Integer pageSize, Integer pageNum) {
        //FIXME 此处需要条件查询
        Query<Topic> query = new Query();
        query.setPageNumber(pageNum).setPageSize(pageSize);
        return topicApi.queryByCondition(query)
            .addExtra("total", topicApi.countByCondition(query));
    }

    @GetMapping
    public Result<Topic> query(Integer id) {
        return topicApi.queryById(id);
    }

}
