package com.example.rabbitmqglobalerrorhandler.infrastructure.rabbitmq.queue;

import com.example.rabbitmqglobalerrorhandler.infrastructure.bean.factory.annotation.BeanFactory;
import com.example.rabbitmqglobalerrorhandler.infrastructure.rabbitmq.exchange.qualifier.CustomersExchange;
import com.example.rabbitmqglobalerrorhandler.infrastructure.rabbitmq.queue.qualifier.CustomersCreateQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@BeanFactory
class QueueBinder {

    @Bean
    Binding customersCreateQueueBinding(@CustomersCreateQueue Queue queue,
                                        @CustomersExchange Exchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("customers.create")
                .noargs();
    }
}
