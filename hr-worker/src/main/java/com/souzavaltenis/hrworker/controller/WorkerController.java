package com.souzavaltenis.hrworker.controller;

import com.souzavaltenis.hrworker.model.Worker;
import com.souzavaltenis.hrworker.service.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerController {

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment environment;

    @Autowired
    private WorkerService workerService;

    @GetMapping("/configs")
    public ResponseEntity<Void> getConfig(){
        logger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = workerService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("PORT = " + environment.getProperty("local.server.port"));

        Worker worker = workerService.findById(id);
        return ResponseEntity.ok(worker);
    }
}
