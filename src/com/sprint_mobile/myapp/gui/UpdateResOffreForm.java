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
import com.mycompany.myapp.entities.ResOffre;
import com.sprint_mobile.myapp.services.ServiceOffre;
import com.sprint_mobile.myapp.services.ServiceResOffre;

/**
 *
 * @author lenovo
 */
public class UpdateResOffreForm  extends Form{
    

    public UpdateResOffreForm(Form previous, ResOffre roffr) {
        setTitle("Éditer ma réservation");
        setLayout(BoxLayout.y());
        
        
        
        TextField tfido = new TextField(String.valueOf(roffr.getIdo()),"Réf offre");
        TextField tfnb = new TextField(String.valueOf(roffr.getNb()),"Places réservées");
        Button btnValider = new Button("Confirmer");
        
        
        btnValider.addActionListener(e -> {
        
         roffr.setIdo(Integer.parseInt(tfido.getText()));
         roffr.setNb(Integer.parseInt(tfnb.getText()));
         if (ServiceResOffre.getInstance().updateResOffre(roffr)){
           System.out.println(roffr.getId());
           new ListResOffresFormF(previous).show();}
        });
        addAll(tfido,tfnb,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
}
}

 
