package com.souzavaltenis.hrpayroll.service;

import com.souzavaltenis.hrpayroll.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer days){
        return new Payment("Bob", 200.0, days);
    }
}
