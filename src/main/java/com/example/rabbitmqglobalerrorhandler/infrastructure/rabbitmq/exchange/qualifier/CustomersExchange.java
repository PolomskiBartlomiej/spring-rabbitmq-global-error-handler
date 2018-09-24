package com.example.rabbitmqglobalerrorhandler.infrastructure.rabbitmq.exchange.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mtumilowicz on 2018-07-16.
 */
@Qualifier
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomersExchange {
}
