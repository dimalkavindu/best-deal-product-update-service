package com.domain.service;

import com.domain.boundary.MessageHandlerInterface;
import com.domain.entities.dto.DomainResponseEntity;
import com.domain.entities.dto.DomainRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageHandlerService {

    @Autowired
    MessageHandlerInterface messageHandlerInterface;

    public DomainResponseEntity publishMessage(DomainRequestEntity domainRequestEntity) throws Exception {
        return messageHandlerInterface.publish(domainRequestEntity);
    }
}
