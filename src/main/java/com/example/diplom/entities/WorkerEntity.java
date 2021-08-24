package com.example.diplom.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "public")
public class WorkerEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String position;
    Long phoneNumber;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id")
    private List<OrderEntity> orderEntityList;
}
