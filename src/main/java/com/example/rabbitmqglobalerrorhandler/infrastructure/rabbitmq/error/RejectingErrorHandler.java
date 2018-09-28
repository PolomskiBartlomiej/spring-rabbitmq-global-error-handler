package com.example.rabbitmqglobalerrorhandler.infrastructure.rabbitmq.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.stereotype.Component;

/**
 * Created by mtumilowicz on 2018-09-28.
 */
@Slf4j
@Component
public class RejectingErrorHandler extends ConditionalRejectingErrorHandler.DefaultExceptionStrategy {

    @Override
    public boolean isFatal(Throwable t) {
        if (t instanceof ListenerExecutionFailedException) {
            log.error("Error during receiving message: " + 
                    new String(((ListenerExecutionFailedException) t).getFailedMessage().getBody()) +
                    " reason: " +
                    t.getLocalizedMessage());
        }
        return super.isFatal(t);
    }

    @Override
    protected boolean isUserCauseFatal(Throwable cause) {
        return true;
    }
}
