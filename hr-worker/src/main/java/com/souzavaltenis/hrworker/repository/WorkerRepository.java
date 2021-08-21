package com.souzavaltenis.hrworker.repository;

import com.souzavaltenis.hrworker.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
