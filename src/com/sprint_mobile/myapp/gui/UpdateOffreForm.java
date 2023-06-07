/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprint_mobile.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Offre;
import com.sprint_mobile.myapp.services.ServiceOffre;

/**
 *
 * @author lenovo
 */
public class UpdateOffreForm extends Form {
      
    public UpdateOffreForm(Form previous, Offre offr) {
        setTitle("Éditer offre");
        setLayout(BoxLayout.y());
        
        
        /*
        TextField tfDescription= new TextField(offr.getDescription(), "Description");
        TextField tftarif = new TextField(String.valueOf(offr.getTarif()),"Tarif");
        Button btnValider = new Button("Éditer offre");
        
        
        btnValider.addActionListener(e -> {
         
        
         offr.setDescription(tfDescription.getText().toString());
         offr.setTarif(Float.parseFloat(tftarif.getText()));
         if (ServiceOffre.getInstance().updateOffre(offr)){
           System.out.println(offr.getId());
           new ListOffresForm(previous).show();}
       
        });
        
        addAll(tfDescription,tftarif,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                */
        
        
        
        TextField tfDescription= new TextField(offr.getDescription(), "Description");
        TextField tftarif = new TextField(String.valueOf(offr.getTarif()),"Tarif");
        Button btnValider = new Button("Confirmer");
        
        
        btnValider.addActionListener(e -> {
         offr.setDescription(tfDescription.getText().toString());
         offr.setTarif(Float.parseFloat(tftarif.getText()));
         if (ServiceOffre.getInstance().updateOffre(offr)){
           System.out.println(offr.getId());
           new ListOffresForm(previous).show();}
        });
        addAll(tfDescription,tftarif,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
      
      
                
    }
}
