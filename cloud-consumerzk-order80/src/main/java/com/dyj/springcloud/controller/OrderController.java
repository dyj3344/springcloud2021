package com.dyj.springcloud.controller;

import com.dyj.springcloud.entites.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    private final static String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @PostMapping("/consumerzk/payment/create")
    public String create(Payment payment){
        return  restTemplate.getForObject( PAYMENT_URL+"/payment/zk",String.class);
    }

}
