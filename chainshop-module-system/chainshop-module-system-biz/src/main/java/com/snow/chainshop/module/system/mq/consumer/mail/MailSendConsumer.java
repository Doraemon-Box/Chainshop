package com.snow.chainshop.module.system.mq.consumer.mail;

import com.snow.chainshop.framework.mq.core.stream.AbstractStreamMessageListener;
import com.snow.chainshop.module.system.mq.message.mail.MailSendMessage;
import com.snow.chainshop.module.system.mq.message.sms.SmsSendMessage;
import com.snow.chainshop.module.system.service.mail.MailSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 针对 {@link MailSendMessage} 的消费者
 *
 * @author Chainshop
 */
@Component
@Slf4j
public class MailSendConsumer extends AbstractStreamMessageListener<MailSendMessage> {

    @Resource
    private MailSendService mailSendService;

    @Override
    public void onMessage(MailSendMessage message) {
        log.info("[onMessage][消息内容({})]", message);
        mailSendService.doSendMail(message);
    }

}
