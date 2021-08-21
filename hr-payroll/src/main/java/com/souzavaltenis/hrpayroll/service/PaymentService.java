package com.souzavaltenis.hrpayroll.service;

import com.souzavaltenis.hrpayroll.feignclients.WorkerFeignClient;
import com.souzavaltenis.hrpayroll.model.Payment;
import com.souzavaltenis.hrpayroll.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, Integer days){
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
