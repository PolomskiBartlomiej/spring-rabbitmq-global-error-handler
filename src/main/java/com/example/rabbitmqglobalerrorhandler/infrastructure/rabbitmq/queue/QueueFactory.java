package com.example.rabbitmqglobalerrorhandler.infrastructure.rabbitmq.queue;

import com.example.rabbitmqglobalerrorhandler.infrastructure.bean.factory.annotation.BeanFactory;
import com.example.rabbitmqglobalerrorhandler.infrastructure.rabbitmq.queue.qualifier.CustomersCreateQueue;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * Created by mtumilowicz on 2018-07-17.
 */
@BeanFactory
class QueueFactory {
    @Bean
    @CustomersCreateQueue
    Queue customersCreateQueue() {
        return new Queue(QueueNames.CUSTOMERS_CREATE, false);
    }
}
