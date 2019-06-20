package com.zr.demo.producerimpl;

import javax.annotation.Resource;
import javax.jms.Queue;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.zr.demo.producer.IMessageProducerService;

@Service
public class MessageProducerServiceImpl implements IMessageProducerService {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource
    private Queue queue;
    @Override
    public void sendMessage(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

}