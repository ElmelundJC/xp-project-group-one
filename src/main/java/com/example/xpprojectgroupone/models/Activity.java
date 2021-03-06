/*
USER STORIES: 1, 8, 2, 3

Dette er Data Transfer Object til user stories der omhandler Aktiviteter.
Klassen er hovedsagligt en container der indeholder informationer om Activity objektet

 */



package com.example.xpprojectgroupone.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Activity {
    @Id
    private int id;
    private String name;
    private String description;
    private int ageLimit;
    private int heightLimit;
    private double price;

    //Foreign key
    private int equipmentId;

    public Activity() {
    }

    public Activity(String name, String description, int ageLimit, int heightLimit, double price){
        this.name = name;
        this.description = description;
        this.ageLimit = ageLimit;
        this.heightLimit = heightLimit;
        this.price = price;
    }

    public Activity(int id, String name, String description, int equipmentId, int ageLimit, int heightLimit, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.equipmentId = equipmentId;
        this.ageLimit = ageLimit;
        this.heightLimit = heightLimit;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ageLimit=" + ageLimit +
                ", heightLimit=" + heightLimit +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getHeightLimit() {
        return heightLimit;
    }

    public void setHeightLimit(int heightLimit) {
        this.heightLimit = heightLimit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
