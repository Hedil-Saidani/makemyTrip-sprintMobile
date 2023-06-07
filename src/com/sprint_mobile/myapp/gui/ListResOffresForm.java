/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import com.mycompany.myapp.entities.ResOffre;
import com.sprint_mobile.myapp.services.ServiceOffre;
import com.sprint_mobile.myapp.services.ServiceResOffre;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class ListResOffresForm extends Form{
          Form current;
          Resources theme;
          
          
        public ListResOffresForm(Form previous) {
        current=this;
        Resources theme = UIManager.initFirstTheme("/theme");
        setTitle("Réservations d'offres");
       ArrayList<ResOffre> list =ServiceResOffre.getInstance().getAllResOffres();
       for(ResOffre roffr : list) {
       setLayout(BoxLayout.y());
        Container cnt1 = new Container(BoxLayout.x());
        Container cnt2 = new Container(BoxLayout.y());
        Label id = new Label ("Réf réservation : " + roffr.getId());
        Label ido = new Label ("Réf offre : " + roffr.getIdo());
        Label idc = new Label ("Réf client: " + roffr.getIdc());
        Label nb = new Label ("Tarif : " + roffr.getNb());
        //Label s = new Label ("********************************************");
        
        
       cnt2.addAll(id,ido,idc,nb);
       Button supprimer = new Button ("Supprimer");
       cnt1.addAll(cnt2,supprimer);
        //cnt1.addAll(cnt2);
       add(cnt1);
      
       
       supprimer.addActionListener(e->{
           /*
       Dialog dig = new Dialog("Supression");
       if (dig.show("Suppression","Êtes vous sûr de vouloir supprimer cette réservation ? ","Confirmer","Annuler"))
            dig.dispose();
       else {
       dig.dispose();
           */
       if (ServiceResOffre.getInstance().deleteResOffre(roffr.getId())){
           System.out.println(roffr.getId());
           new ListResOffresForm(previous).show();}
       
       }); 
   
       
      
      
      
      
  
       
       
       
       
       /* SpanLabel sp = new SpanLabel();
        sp.setText(ServiceOffre.getInstance().getAllOffres().toString());
        add(sp); */
           getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }
}

}