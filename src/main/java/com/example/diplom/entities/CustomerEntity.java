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
public class CustomerEntity {

    @Id
    Long phoneNumber;
    String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerPhone_number")
    private List<OrderEntity> orderEntityList;
}
