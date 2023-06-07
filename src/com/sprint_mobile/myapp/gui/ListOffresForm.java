package com.sprint_mobile.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Offre;
import com.sprint_mobile.myapp.services.ServiceOffre;
import java.util.ArrayList;
import static java.util.concurrent.ThreadLocalRandom.current;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
public class ListOffresForm extends Form{
    Form current;
    Resources theme;
    
    public ListOffresForm(Form previous) {
        current=this;
        Resources theme = UIManager.initFirstTheme("/theme");
        setTitle("Nos offres");
       ArrayList<Offre> list =ServiceOffre.getInstance().getAllOffres();
       for(Offre offr : list) {
       setLayout(BoxLayout.y());
        Container cnt1 = new Container(BoxLayout.x());
        Container cnt2 = new Container(BoxLayout.y());
        Label Réf = new Label("Réf : " + offr.getId());
        Label Description = new Label ("Description : " + offr.getDescription());
        Label Tarif = new Label ("Tarif : " + offr.getTarif());
        
       
        
       cnt2.addAll(Réf,Description,Tarif);
       Button modifier = new Button ("Editer");
       Button supprimer = new Button ("Supprimer");
       cnt1.addAll(cnt2,modifier,supprimer);
       add(cnt1);
       supprimer.addActionListener(e->{
       //Dialog dig = new Dialog("Supression");
       // (dig.show("Suppression","Êtes vous sûr de vouloir supprimer cette offre ? ","Confirmer","Annuler"))
            //dig.dispose();
       //else {
       //dig.dispose();
       {if (ServiceOffre.getInstance().deleteOffre(offr.getId())){
           System.out.println(offr.getId());
           new ListOffresForm(previous).show();}
       }
       }); 
       
       modifier.addActionListener(m-> {
       new UpdateOffreForm(previous, offr).show();
       });
            
                
       
       }
       /* SpanLabel sp = new SpanLabel();
        sp.setText(ServiceOffre.getInstance().getAllOffres().toString());
        add(sp); */
        Button btnAddTask = new Button("Nouvelle offre");
            
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        btnAddTask.addActionListener(e-> new AddOffreForm(current).show());
         
        addAll(btnAddTask);
    }
}

