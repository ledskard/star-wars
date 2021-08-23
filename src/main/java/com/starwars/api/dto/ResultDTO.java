package com.starwars.api.dto;

import java.util.List;

public class ResultDTO {
    private String terrain;
    private String climate;
    private String name;
    private List<String> films;

    public ResultDTO(String terrain, String climate, String name, List<String> films) {
        this.terrain = terrain;
        this.climate = climate;
        this.name = name;
        this.films = films;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

}