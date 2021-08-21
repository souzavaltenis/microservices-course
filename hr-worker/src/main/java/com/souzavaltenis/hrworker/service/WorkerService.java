package com.souzavaltenis.hrworker.service;

import com.souzavaltenis.hrworker.model.Worker;
import com.souzavaltenis.hrworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> findAll(){
        return workerRepository.findAll();
    }

    public Worker findById(Long id){
        return workerRepository.findById(id).orElseThrow(() -> new RuntimeException("Worker not found"));
    }
}
