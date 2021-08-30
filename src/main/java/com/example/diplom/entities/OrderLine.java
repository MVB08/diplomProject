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
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numberOfLine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appliance_id")
    private ApplianceEntity applianceEntity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;
}
