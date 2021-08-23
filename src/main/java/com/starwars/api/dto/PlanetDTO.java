package com.starwars.api.dto;


public class PlanetDTO {
    private String name;
    private String climate;
    private String terrain;
    private int apparitionQuantity;

    public PlanetDTO(String name, String climate, String terrain, int apparitionQuantity) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.apparitionQuantity = apparitionQuantity;
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
