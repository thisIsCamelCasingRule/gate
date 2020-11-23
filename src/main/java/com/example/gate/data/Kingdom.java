package com.example.gate.data;

import lombok.Data;

import java.util.UUID;

@Data
public class Kingdom {
    private UUID id;
    private String name;
    private double sqare;
    private int population;
    private int amountOfBuildings;

    public Kingdom(String name, double sqare, int population, int amountOfBuildings) {
        this.name = name;
        this.sqare = sqare;
        this.population = population;
        this.amountOfBuildings = amountOfBuildings;
    }

    public Kingdom() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSqare() {
        return sqare;
    }

    public void setSqare(double sqare) {
        this.sqare = sqare;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getAmountOfBuildings() {
        return amountOfBuildings;
    }

    public void setAmountOfBuildings(int amountOfBuildings) {
        this.amountOfBuildings = amountOfBuildings;
    }
}
