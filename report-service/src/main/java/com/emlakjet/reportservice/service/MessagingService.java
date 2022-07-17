package com.emlakjet.reportservice.service;



import com.emlakjet.advertiseservice.model.AdvertiseDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {

    private final ReportService reportService;


    public MessagingService(ReportService reportService) {
        this.reportService = reportService;
    }


    @RabbitListener(queues = "adv-queue")
    public void receiveMessage(@Payload AdvertiseDTO advertiseDTO){

        reportService.createReport(advertiseDTO);

    }
}
