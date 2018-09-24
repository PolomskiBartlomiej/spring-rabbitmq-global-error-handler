package com.example.rabbitmqglobalerrorhandler.domain.customer.service


import com.example.rabbitmqglobalerrorhandler.domain.customer.model.Customer
import com.example.rabbitmqglobalerrorhandler.infrastructure.repository.CustomerRepository
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerServiceTest extends Specification {

    def "test save"() {
        given:
        def customer = Customer.builder()
        .firstName("firstName")
        .build()

        and:
        def customerAfterSave = Customer.builder()
        .id(1)
        .firstName("firstName")
        .build()

        and:
        def repository = Mock(CustomerRepository)

        and:
        def service = new CustomerService(repository)

        when:
        service.save(customer)

        then:
        1 * repository.save(customer) >> customerAfterSave
    }

    def "test findAll"() {
        given:
        def repository = Mock(CustomerRepository)

        and:
        def service = new CustomerService(repository)

        when:
        service.findAll()

        then:
        1 * repository.findAll()
    }
}
