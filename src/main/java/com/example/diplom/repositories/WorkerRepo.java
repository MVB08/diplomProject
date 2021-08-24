package com.example.diplom.repositories;

import com.example.diplom.entities.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepo extends JpaRepository<WorkerEntity,Long> {


}
