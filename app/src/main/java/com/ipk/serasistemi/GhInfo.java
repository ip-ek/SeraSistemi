package com.ipk.serasistemi;

public class GhInfo {
    private int id;
    private String name;
    private int current_heat; //json ile aynı olmalı
    private int target_heat; //json ile aynı olmalı
    private int status;

    public GhInfo(int id, String name, int current_heat, int target_heat, int status) {
        this.id = id;
        this.name = name;
        this.current_heat = current_heat;
        this.target_heat = target_heat;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHeat() {
        return current_heat;
    }

    public void setCurrentHeat(int current_heat) {
        this.current_heat = current_heat;
    }

    public int getTargetHeat() {
        return target_heat;
    }

    public void setTargetHeat(int target_heat) {
        this.target_heat = target_heat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
