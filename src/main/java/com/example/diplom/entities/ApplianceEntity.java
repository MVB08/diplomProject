package com.example.diplom.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "public")
public class ApplianceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String model;

//    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "appliance_id")
//    private OrderEntity orderEntity;

//    @ManyToMany(mappedBy = "appliance_entity")
//    private List<OrderEntity> orderEntities = new ArrayList<>();
}
