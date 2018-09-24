package com.example.rabbitmqglobalerrorhandler.app.customer.rest


import com.example.rabbitmqglobalerrorhandler.domain.customer.service.CustomerService
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerControllerTest extends Specification {

    def service = Mock(CustomerService)
    def controller = new CustomerController(service)
    
    def "test findAll"() {
        when:
        controller.findAll()

        then:
        1 * service.findAll()
    }
}
