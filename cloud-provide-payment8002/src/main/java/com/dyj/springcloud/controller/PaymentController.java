package com.dyj.springcloud.controller;

import com.dyj.springcloud.entites.CommonResult;
import com.dyj.springcloud.entites.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.dyj.springcloud.service.PaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
    int result = paymentService.create(payment);
    log.info("插入结果[{}]",result);
    if(result>0){
        return new CommonResult(200,"插入成功::端口号为"+port,payment);
    }else {
        return new CommonResult(500,"插入失败");
    }
    }

    @GetMapping (value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果[{}]",paymentById+"\t");
        if(paymentById!=null){
            return new CommonResult(200,"查询成功::端口号为"+port,paymentById);
        }else {
            return new CommonResult(500,"查询失败");
        }
    }
}
