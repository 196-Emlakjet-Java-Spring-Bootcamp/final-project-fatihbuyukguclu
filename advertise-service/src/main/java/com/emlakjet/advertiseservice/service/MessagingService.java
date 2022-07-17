package com.emlakjet.advertiseservice.service;

import com.emlakjet.advertiseservice.model.Advertise;
import com.emlakjet.advertiseservice.model.AdvertiseDTO;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public MessagingService(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void sendMessage(Advertise advertise){

        AdvertiseDTO advertiseDTO =AdvertiseDTO.builder()
                .id(advertise.getId())
                .viewCount(advertise.getViewCount())
                .build();

        rabbitTemplate.convertAndSend(queue.getName(),advertiseDTO);
    }
}
