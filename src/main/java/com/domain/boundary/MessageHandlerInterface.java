package com.domain.boundary;

import com.application.transport.request.entities.Products;
import com.domain.entities.dto.DomainRequestEntity;
import com.domain.entities.dto.DomainResponseEntity;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface MessageHandlerInterface {
    public DomainResponseEntity publish(DomainRequestEntity domainRequestEntity) throws Exception;
}
