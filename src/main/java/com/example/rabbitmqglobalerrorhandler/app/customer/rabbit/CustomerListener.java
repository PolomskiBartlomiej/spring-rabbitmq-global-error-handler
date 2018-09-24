package com.example.rabbitmqglobalerrorhandler.app.customer.rabbit;

import com.example.rabbitmqglobalerrorhandler.app.customer.rabbit.dto.CustomerSaveDto;
import com.example.rabbitmqglobalerrorhandler.domain.customer.service.CustomerMessageHandler;
import com.example.rabbitmqglobalerrorhandler.infrastructure.rabbitmq.annotation.RabbitConsumer;
import com.example.rabbitmqglobalerrorhandler.infrastructure.rabbitmq.queue.QueueNames;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@RabbitConsumer
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CustomerListener {

    CustomerMessageHandler customerMessageHandler;

    @RabbitListener(queues = QueueNames.CUSTOMERS_CREATE)
    public void onSave(@NonNull CustomerSaveDto message) {
        customerMessageHandler.processSave(message);
    }
}
