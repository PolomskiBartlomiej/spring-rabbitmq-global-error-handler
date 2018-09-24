package com.example.rabbitmqglobalerrorhandler.infrastructure.rabbitmq.queue;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by mtumilowicz on 2018-07-24.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class QueueNames {
    public final static String CUSTOMERS_CREATE = "customers.create";
}
