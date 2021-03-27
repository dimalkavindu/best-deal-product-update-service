package com.application.transport.request.transformers;

import com.application.transformer.RequestEntityInterface;
import com.domain.entities.dto.DomainRequestEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RequestTransformer implements RequestEntityInterface {
    @Override
    public Map transform(Object entity) {
        DomainRequestEntity response = (DomainRequestEntity)entity;
        Map<String,Object> mapping = new HashMap<>();

        return mapping;
    }
}

