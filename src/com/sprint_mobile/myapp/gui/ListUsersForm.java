/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprint_mobile.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.User;
import com.sprint_mobile.myapp.services.ServiceOffre;
import com.sprint_mobile.myapp.services.ServiceUser;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class ListUsersForm  extends Form{
    
  
        Form current;
        Resources theme;
    
    public ListUsersForm(Form previous) {
        current=this;
        Resources theme = UIManager.initFirstTheme("/theme");
        setTitle("Nos clients");
       ArrayList<User> list =ServiceUser.getInstance().getAllUsers();
       for(User user : list) {
       setLayout(BoxLayout.y());
        Container cnt1 = new Container(BoxLayout.x());
        Container cnt2 = new Container(BoxLayout.y());
        Label name = new Label("Nom&Prénom : " + user.getName());
        Label email = new Label ("Email : " + user.getEmail());
        //Label tel = new Label ("Télephone : " + user.getPhoneNumber());
       Label s = new Label ("********************************************");
        
       cnt2.addAll(name,email,s);
       //Button supprimer = new Button ("Supprimer");
       cnt1.addAll(cnt2);
       add(cnt1);
       
       /*
        supprimer.addActionListener(e->{
       {if (ServiceUser.getInstance().deleteUser(user.getId())){
           System.out.println(user.getId());
           new ListUsersForm(previous).show();}
       }
       }); 
       
      */
     
                getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
       
       }
       
       
      
       /* SpanLabel sp = new SpanLabel();
        sp.setText(ServiceOffre.getInstance().getAllOffres().toString());
        add(sp); */
        
       
       
    }
    
    
    
    
}
