package com.process.controller;

import static com.process.util.ConstantsUtil.EXCEPTION;
import static com.process.util.ConstantsUtil.SUCCESS;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.process.model.ProductDetail;
import com.process.model.ProductRequest;
import com.process.service.MessageProcessorService;

@Controller
public class MessageProcessorController {

    AtomicInteger messageCounter = new AtomicInteger(0);
    Map<String, ProductDetail> productMap = new HashMap<String, ProductDetail>();

    @Autowired
    MessageProcessorService messageProcessorService;

    @RequestMapping(value = "api/process", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> process(@RequestBody ProductRequest inputRequest){

        if(messageCounter.intValue() >= 50){
            return new ResponseEntity<>("Limit has been reached.", HttpStatus.FORBIDDEN);
        }else{
            String status = messageProcessorService.processProduct(productMap, messageCounter.incrementAndGet(), inputRequest);
            if(SUCCESS.equals(status)){
                return new ResponseEntity<>("Message Processed.", HttpStatus.OK);
            }else if(EXCEPTION.equals(status)){
            	return new ResponseEntity<>("Messge Processesing Failed.", HttpStatus.BAD_REQUEST);
            }else{
                return new ResponseEntity<>("Message Processed. Limit has been reached, Stopping Processing.", HttpStatus.OK);
            }
        }
    }

}
