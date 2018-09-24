package com.example.rabbitmqglobalerrorhandler.app.customer.rabbit.assembler;

import com.example.rabbitmqglobalerrorhandler.app.customer.rabbit.dto.CustomerSaveDto;
import com.example.rabbitmqglobalerrorhandler.domain.customer.model.Customer;
import com.example.rabbitmqglobalerrorhandler.infrastructure.mapper.ModelMapperFactory;
import lombok.NonNull;

/**
 * Created by mtumilowicz on 2018-07-19.
 */
public class CustomerSaveDtoAssembler {
    public static Customer toEntity(@NonNull CustomerSaveDto dto) {
        return ModelMapperFactory.directFieldMapper().map(dto, Customer.class);
    }
}
