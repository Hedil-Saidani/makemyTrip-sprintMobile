/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author lenovo
 */
public class Offre {
    private int id;
    private String  description;
    private float tarif;

    public Offre() {
    }

    public Offre(int id, String description, float tarif) {
        this.id = id;
        this.description = description;
        this.tarif = tarif;
    }

     public Offre(String description, float tarif) {
        this.description = description;
        this.tarif = tarif;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public float getTarif() {
        return tarif;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", description=" + description + ", tarif=" + tarif + '}';
    }
    
    
}
