package tech.wetech.weshop.user.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.wetech.weshop.user.po.Footprint;
import tech.wetech.weshop.user.service.FootprintService;

/**
 * 用户足迹Receiver
 *
 * @author cjbi@outlook.com
 */
@Component
@RabbitListener(queues = "weshop.topic.footprint")
@Slf4j
public class FootprintReceiver {


    @Autowired
    private FootprintService footprintService;

    @RabbitHandler
    public void process(Footprint footprint) {
        log.info("process footprint message,message is:{}", footprint);
        footprintService.create(footprint);
    }

}
