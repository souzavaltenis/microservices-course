package com.souzavaltenis.hrpayroll.feignclients;

import com.souzavaltenis.hrpayroll.model.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name="hr-worker", url="localhost:8001", path="/workers")
public interface WorkerFeignClient {

    @GetMapping("/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}
