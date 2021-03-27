package com.application.controller;

import com.application.transformer.RequestEntityTransformer;
import com.application.transformer.ResponseEntityTransformer;
import com.application.transport.request.entities.Products;
import com.application.transport.request.transformers.RequestTransformer;
import com.application.transport.response.transformers.ResponseTransformer;
import com.application.validator.RequestEntityValidator;
import com.domain.entities.dto.DomainRequestEntity;
import com.domain.entities.dto.DomainResponseEntity;
import com.domain.service.MessageHandlerService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@RestController
@RequestMapping("${base-url.context}/pub")
@Log4j2
public class PubSubController extends BaseController {

    @Autowired
    RequestEntityTransformer requestEntityTransformer;

    @Autowired
    ResponseEntityTransformer responseEntityTransformer;

    @Autowired
    RequestTransformer requestTransformer;

    @Autowired
    ResponseTransformer responseTransformer;

    @Autowired
    MessageHandlerService messageHandlerService;

    @Autowired
    private RequestEntityValidator validator;

    @GetMapping("")
    String hello() {
        return "Hello! Publish Controller is running";
    }

    @PostMapping(value="/publishMessage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> publishJSON(@Validated @RequestBody(required = true) Products products, HttpServletRequest request)throws Exception{

//      TODO: set UUID
        setLogIdentifier(request);

//      TODO: validate the request
//        validator.validate(products);
//        log.info("Request validation success");

//      TODO: request object map to com.domain entity object
        DomainRequestEntity domainRequestEntity = new ModelMapper().map(products, DomainRequestEntity.class);
        log.info("Mapped DomainRequestEntity : "+domainRequestEntity.toString());

//      TODO: transform entity object
//        Map trRequest = requestEntityTransformer.transform(domainRequestEntity, requestTransformer);
//        log.info("Transformed request : "+trRequest.toString());

//      TODO: call com.domain business logic
        DomainResponseEntity domainResponseEntity = messageHandlerService.publishMessage(domainRequestEntity);

//      TODO: transform com.domain response
        Map trResponse = responseEntityTransformer.transform(domainResponseEntity, responseTransformer);
        log.info("Transformed response : "+trResponse.toString());

//      TODO: return response
        return ResponseEntity.status(HttpStatus.OK).body(trResponse);
    }

}
