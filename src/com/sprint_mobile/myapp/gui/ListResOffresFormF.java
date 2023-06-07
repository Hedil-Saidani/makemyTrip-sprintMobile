/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprint_mobile.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.ResOffre;
import com.sprint_mobile.myapp.services.ServiceResOffre;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class ListResOffresFormF extends Form{
    Form current;
    Resources theme;
    
    public ListResOffresFormF(Form previous) {
        current=this;
        Resources theme = UIManager.initFirstTheme("/theme");
        setTitle("Mes réservations");
       ArrayList<ResOffre> list =ServiceResOffre.getInstance().getAllResOffres();
       for(ResOffre roffr : list) {
       setLayout(BoxLayout.y());
        Container cnt1 = new Container(BoxLayout.x());
        Container cnt2 = new Container(BoxLayout.y());
        Label Réf = new Label("Réf offre : " + roffr.getIdo());
        Label nb = new Label ("Places réservées : " + roffr.getNb());
       cnt2.addAll(Réf,nb);
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
       {if (ServiceResOffre.getInstance().deleteResOffre(roffr.getId())){
           System.out.println(roffr.getId());
           new ListResOffresFormF(previous).show();}
       }
       }); 
       
       modifier.addActionListener(m-> {
       new UpdateResOffreForm(previous, roffr).show();
       });
            
                
       
       }
       /* SpanLabel sp = new SpanLabel();
        sp.setText(ServiceOffre.getInstance().getAllOffres().toString());
        add(sp); */
        
            
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());     
       
    }
}
