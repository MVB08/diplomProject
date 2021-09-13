package com.example.diplom.repositories;

import com.example.diplom.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByName(String name);
    List<CustomerEntity> findByPhoneNumber(String phone);

}
