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
public class HomeForm2 extends Form{
    
    Form current;
    public HomeForm2() {
        current=this; //Back 
        setTitle("make my Trip");
        setLayout(BoxLayout.y());
        
        add(new Label("Vite Réservez votre voyage !"));
       
        Button btnListOffres = new Button("Nos Offres");
        Button btnListResOffres = new Button("Mes résevations");
       
        
       
        btnListOffres.addActionListener(e-> new ListOffresFormF(current).show());
        btnListResOffres.addActionListener(e-> new ListResOffresFormF(current).show());
        addAll(btnListOffres, btnListResOffres);
        
}
}