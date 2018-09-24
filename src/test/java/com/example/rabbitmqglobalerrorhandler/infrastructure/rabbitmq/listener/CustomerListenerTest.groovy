package com.example.rabbitmqglobalerrorhandler.infrastructure.rabbitmq.listener


import com.example.rabbitmqglobalerrorhandler.app.customer.rabbit.CustomerListener
import com.example.rabbitmqglobalerrorhandler.app.customer.rabbit.dto.CustomerSaveDto
import com.example.rabbitmqglobalerrorhandler.domain.customer.service.CustomerMessageHandler
import spock.lang.Specification 
/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerListenerTest extends Specification {
    def "test onCreate"() {
        given:
        def customerMessageHandler = Mock(CustomerMessageHandler)

        and:
        def listener = new CustomerListener(customerMessageHandler)

        and:
        def dto = CustomerSaveDto.builder()
                .id(1)
                .firstName("firstName")
                .build()

        when:
        listener.onSave(dto)

        then:
        1 * customerMessageHandler.processSave(dto)
    }
}
