# rabbitmq-global-error-handler
The main goal of this project is to show how to configure
global error handling for exceptions occurred during receiving 
them on the listeners (getting from the queue).


_Reference_: https://github.com/spring-projects/spring-amqp-samples/blob/master/spring-rabbit-global-errorhandler/src/main/java/org/springframework/amqp/samples/errorhandler/Application.java

# use case
On the rabbitmq queue appears a message that cannot be parsed
to the dtos over the appropriate listener (for example - has 
completely different structure or some fields has other type or
it could have no structure at all - because AMQP propagate 
byte-body messages) we want to log it.

# solution
1. `GlobalErrorConfig`: `@Configuration` class that produces
`org.springframework.util.ErrorHandler` bean.
2. `RejectingErrorHandler`: extension of 
`org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler.DefaultExceptionStrategy`
    * in `isFatal` we perform logging action (only in 
    case of `ListenerExecutionFailedException`)
    
        _Remark_: only if `isFatal` returns true a message is 
        removed from a queue
    
    * in `isUserCauseFatal` we define all exception as fatal
    
# remarks
`ConditionalRejectingErrorHandler.DefaultExceptionStrategy`:
* `isFatal`:
    ```
    @Override
    public boolean isFatal(Throwable t) {
    	Throwable cause = t.getCause();
    	while (cause instanceof MessagingException
    			&& !(cause instanceof
    					org.springframework.messaging.converter.MessageConversionException)
    			&& !(cause instanceof MethodArgumentResolutionException)) {
    		cause = cause.getCause();
    	}
    	if (t instanceof ListenerExecutionFailedException && isCauseFatal(cause)) {
    		if (this.logger.isWarnEnabled()) {
    			this.logger.warn(
    					"Fatal message conversion error; message rejected; "
    					+ "it will be dropped or routed to a dead letter exchange, if so configured: "
    					+ ((ListenerExecutionFailedException) t).getFailedMessage());
    		}
    		return true;
    	}
    	return false;
    }   
    ```
* `isCauseFatal`
    ```
    private boolean isCauseFatal(Throwable cause) {
    			return cause instanceof MessageConversionException
    					|| cause instanceof org.springframework.messaging.converter.MessageConversionException
    					|| cause instanceof MethodArgumentResolutionException
    					|| cause instanceof NoSuchMethodException
    					|| cause instanceof ClassCastException
    					|| isUserCauseFatal(cause);
    		} 
    ```
* `isUserCauseFatal`
    ```
    protected boolean isUserCauseFatal(Throwable cause) {
    			return false;
    		}
    ```