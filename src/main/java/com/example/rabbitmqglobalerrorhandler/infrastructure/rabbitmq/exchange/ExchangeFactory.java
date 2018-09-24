package com.example.rabbitmqglobalerrorhandler.infrastructure.rabbitmq.exchange;

import com.example.rabbitmqglobalerrorhandler.infrastructure.bean.factory.annotation.BeanFactory;
import com.example.rabbitmqglobalerrorhandler.infrastructure.rabbitmq.exchange.qualifier.CustomersExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;

/**
 * Created by mtumilowicz on 2018-07-18.
 */
@BeanFactory
class ExchangeFactory {

    @Bean
    @CustomersExchange
    Exchange customersExchange() {
        return ExchangeBuilder.topicExchange(ExchangeNames.CUSTOMERS)
                .durable(true)
                .build();
    }
}
