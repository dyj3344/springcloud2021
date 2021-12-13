package com.dyj.springcloud.controller;

import com.dyj.springcloud.entites.CommonResult;
import com.dyj.springcloud.entites.Payment;
import com.dyj.springcloud.service.PaymentSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentSerivce paymentSerivce;
    @GetMapping(value = "/orderFeign/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentSerivce.getPaymentById(id);
    }
}
