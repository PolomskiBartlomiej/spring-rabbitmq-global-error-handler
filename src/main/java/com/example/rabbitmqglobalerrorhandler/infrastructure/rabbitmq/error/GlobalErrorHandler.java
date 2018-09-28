package com.example.rabbitmqglobalerrorhandler.infrastructure.rabbitmq.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ErrorHandler;

/**
 * Created by mtumilowicz on 2018-09-24.
 */
@Configuration
@Slf4j
public class GlobalErrorHandler {
    @Bean
    public ErrorHandler errorHandler(RejectingErrorHandler rejectingErrorHandler) {
        return new ConditionalRejectingErrorHandler(rejectingErrorHandler);
    }
}
