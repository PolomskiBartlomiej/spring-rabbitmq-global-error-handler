package com.example.rabbitmqglobalerrorhandler.domain.customer.service;

import com.example.rabbitmqglobalerrorhandler.app.customer.rabbit.assembler.CustomerSaveDtoAssembler;
import com.example.rabbitmqglobalerrorhandler.app.customer.rabbit.dto.CustomerSaveDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

/**
 * Created by mtumilowicz on 2018-07-30.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Component
public class CustomerMessageHandler {
    CustomerService customerService;

    public void processSave(@NonNull CustomerSaveDto dto) {
        customerService.save(CustomerSaveDtoAssembler.toEntity(dto));
    }
}
