/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprint_mobile.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author lenovo
 */
public class HomeForm  extends Form{
    
    Form current;
    public HomeForm() {
        current=this; //Back 
        setTitle("make my Trip");
        setLayout(BoxLayout.y());
        
        add(new Label("Veuiller sélectionner votre choix !"));
       
        Button btnListTasks = new Button("Offres");
        Button btnListUsers = new Button("Clients");
        Button btnListResOffres = new Button("Réservations d'offres");
        
       
        btnListTasks.addActionListener(e-> new ListOffresForm(current).show());
        btnListUsers.addActionListener(e-> new ListUsersForm(current).show());
        btnListResOffres.addActionListener(e-> new ListResOffresForm(current).show());
        addAll(btnListTasks,btnListUsers,btnListResOffres);
        
        
        
        
}
}
