package com.example.gate.data;

import lombok.Data;

import java.util.UUID;

@Data
public class Peasant {

    private UUID id;
    private String name;
    private String position;
    private String kingdom;
    private boolean status;

    public Peasant(String name, String position, String kingdom, boolean status) {
        this.name = name;
        this.position = position;
        this.status = status;
        this.kingdom = kingdom;
    }

    public Peasant() {
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position){ this.position = position; }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }
}
