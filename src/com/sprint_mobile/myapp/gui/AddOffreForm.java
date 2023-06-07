/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprint_mobile.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Offre;
import com.sprint_mobile.myapp.services.ServiceOffre;

/**
 *
 * @author lenovo
 */
public class AddOffreForm extends Form{
    
   public AddOffreForm(Form previous) {
        setTitle("Nouvelle offre");
        setLayout(BoxLayout.y());
        
        TextField tfDescription = new TextField("","Description");
        TextField tfTarif= new TextField("", "tarif");
        Button btnValider = new Button("Ajouter");
        
        
        btnValider.addActionListener(new  ActionListener() {
            @Override
       
             public void actionPerformed(ActionEvent evt) {
                if ((tfDescription.getText().length()==0)||(tfTarif.getText().length()==0))
                    Dialog.show("Alerte", "Veuiller remplir tous les champs !", new Command("OK"));
                else
                {
                    try{
                        Offre o = new Offre(tfDescription.getText().toString() ,Float.parseFloat(tfTarif.getText()));
                        if( ServiceOffre.getInstance().addOffre(o))
                        {
                           Dialog.show("Succès","Offre ajoutée avec succès",new Command("OK"));
                           new ListOffresForm(previous).show();
                        }else
                            Dialog.show("Erreur", "Server error", new Command("OK"));
                        } catch (NumberFormatException e) {
                        Dialog.show("Erreur de saisie", "Ce champ ne doit comprendre que des chiffres", new Command("OK"));
                    }
                    } 
            }
        });
                
            
       
        
        addAll(tfDescription,tfTarif,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
}
