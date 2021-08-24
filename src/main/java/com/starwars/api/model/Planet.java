package com.starwars.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="planet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planet {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="climate")
    private String climate;
    @Column(name="terrain")
    private String terrain;
    @Column(name="apparitionQuantity")
    private int apparitionQuantity;

}
