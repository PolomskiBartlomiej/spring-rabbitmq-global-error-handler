# rabbitmq-global-error-handler
The main goal of this project is to show how to configure
global error handling for exceptions occurred during receiving 
them on the listeners (getting from the queue).


_Reference_: https://github.com/spring-projects/spring-amqp-samples/blob/master/spring-rabbit-global-errorhandler/src/main/java/org/springframework/amqp/samples/errorhandler/Application.java

# use case
On the rabbitmq queue appears a message that cannot be parsed
to the dtos over the appropriate listener (for example - has 
completely different structure or some fields has other type or
because AMQP propagate byte-body messages - it could have no 
structure at all) we want to log it.

# solution
1. `GlobalErrorConfig`: `@Configuration` class that produces
`org.springframework.util.ErrorHandler` bean.
2. `RejectingErrorHandler`: extension of 
`org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler.DefaultExceptionStrategy`
    * in `isFatal` override we perform logging action (only in 
    case of `ListenerExecutionFailedException`)
    
        _Remark_: only if `isFatal` returns true a message is 
        removed from a queue
    
    * in `isUserCauseFatal` override we define all exception as fatal;
    
        _Remark_: take a look at implementation of `isFatal`,
        `isCauseFatal` in the superclass