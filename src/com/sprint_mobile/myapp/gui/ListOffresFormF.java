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
import com.sprint_mobile.myapp.services.ServiceOffre;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class ListOffresFormF extends Form{
        Form current;
    Resources theme;
    
    public ListOffresFormF(Form previous) {
        current=this;
        Resources theme = UIManager.initFirstTheme("/theme");
        setTitle("Nos offres");
       ArrayList<Offre> list =ServiceOffre.getInstance().getAllOffres();
       for(Offre offr : list) {
       setLayout(BoxLayout.y());
        Container cnt1 = new Container(BoxLayout.x());
        Container cnt2 = new Container(BoxLayout.y());
        Label Description = new Label ("Description : " + offr.getDescription());
        Label Tarif = new Label ("Tarif : " + offr.getTarif());
        Label s = new Label ("********************************************");
        
        
       cnt2.addAll(Description,Tarif,s);
       
       cnt1.addAll(cnt2);
       add(cnt1);
       
            
                
       
       }
       /* SpanLabel sp = new SpanLabel();
        sp.setText(ServiceOffre.getInstance().getAllOffres().toString());
        add(sp); */
           getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }
}
