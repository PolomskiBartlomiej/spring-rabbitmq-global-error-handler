package com.example.rabbitmqglobalerrorhandler.app.customer.rabbit


import com.example.rabbitmqglobalerrorhandler.app.customer.rabbit.dto.CustomerSaveDto
import com.example.rabbitmqglobalerrorhandler.domain.customer.model.Customer
import com.example.rabbitmqglobalerrorhandler.domain.customer.service.CustomerMessageHandler
import com.example.rabbitmqglobalerrorhandler.domain.customer.service.CustomerService
import spock.lang.Specification 
/**
 * Created by mtumilowicz on 2018-07-23.
 */
class CustomerMessageHandlerTest extends Specification {
    def "test processSave"() {
        given:
        def service = Mock(CustomerService)

        and:
        def handler = new CustomerMessageHandler(service)

        and:
        def dto = CustomerSaveDto.builder()
                .id(1)
                .firstName("firstName")
                .build()

        and:
        def customer = Customer.builder()
                .id(1)
                .firstName("firstName")
                .build()

        when:
        handler.processSave(dto)

        then:
        1 * service.save(customer)
    }
}
