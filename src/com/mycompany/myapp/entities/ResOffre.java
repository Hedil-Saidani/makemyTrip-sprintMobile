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
public class ResOffre {
    private int id,ido,idc,nb;

    public ResOffre() {
    }

    public ResOffre(int id, int ido, int idc, int nb) {
        this.id = id;
        this.ido = ido;
        this.idc = idc;
        this.nb = nb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdo() {
        return ido;
    }

    public void setIdo(int ido) {
        this.ido = ido;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    @Override
    public String toString() {
        return "ResOffre{" + "id=" + id + ", ido=" + ido + ", idc=" + idc + ", nb=" + nb + '}';
    }
    
    
    
    
    
    
   
}
