package com.example.diplom.repositories;

import com.example.diplom.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.beans.JavaBean;
@Repository
public interface OrderLineRepo extends JpaRepository<OrderLine,Long> {
}
