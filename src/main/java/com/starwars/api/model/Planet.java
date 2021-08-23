package com.starwars.api.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="planet")
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

    public Planet(Long id, String name, String climate, String terrain, int apparitionQuantity) {
        this.id = id;
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.apparitionQuantity = apparitionQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public int getApparitionQuantity() {
        return apparitionQuantity;
    }

    public void setApparitionQuantity(int apparitionQuantity) {
        this.apparitionQuantity = apparitionQuantity;
    }

}
