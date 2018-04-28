package com.ryz.sh.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private Logger log = LoggerFactory.getLogger(KafkaSender.class);
    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setDate(new Date());
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        kafkaTemplate.send("ryzTopic", gson.toJson(message));
    }
}
