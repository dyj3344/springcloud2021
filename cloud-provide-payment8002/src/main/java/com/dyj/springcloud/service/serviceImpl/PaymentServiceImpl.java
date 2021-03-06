package com.dyj.springcloud.service.serviceImpl;

import com.dyj.springcloud.dao.PaymentDao;
import com.dyj.springcloud.entites.Payment;
import org.springframework.stereotype.Service;
import com.dyj.springcloud.service.PaymentService;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
