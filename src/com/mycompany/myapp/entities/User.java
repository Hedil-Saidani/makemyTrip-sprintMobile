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
public class User {
    
    private int id;
    private String email,password;
    private boolean is_active=true;
    private String name,token,created_at,updated_at,actived_at;
    private int phoneNumber;

    public User() {
    }

    public User(int id, String email, String password, String name, String token, String created_at, String updated_at, String actived_at, int phoneNumber) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.token = token;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.actived_at = actived_at;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getActived_at() {
        return actived_at;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setActived_at(String actived_at) {
        this.actived_at = actived_at;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + ", is_active=" + is_active + ", name=" + name + ", token=" + token + ", created_at=" + created_at + ", updated_at=" + updated_at + ", actived_at=" + actived_at + ", phoneNumber=" + phoneNumber + '}';
    }
    
    
    
}
