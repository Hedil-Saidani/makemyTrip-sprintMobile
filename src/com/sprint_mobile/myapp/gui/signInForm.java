package com.sprint_mobile.myapp.gui;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import java.io.UnsupportedEncodingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
public class signInForm  extends Form{
     Form current;
    Resources theme;
    Form f1, f2;
    String url;
    ConnectionRequest con;
    
     public signInForm() {
        current=this;
        f1 = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        Button ok=new Button("ok");
        TextField tnom=new TextField();
        tnom.setHint("username");
        TextField tpwd=new TextField();
        tpwd.setHint("password");
        tpwd.setConstraint(TextField.PASSWORD);
        f1.add(tnom);
        f1.add(tpwd);
        f1.add(ok);
        f2 = new Form(new BoxLayout(BoxLayout.Y_AXIS));
        Button  back=new Button("back");
        Label bjr=new Label();
        
        url = "http://localhost/login/login.php";
        //url ="http://ptm.rdi-esprit.com/find_model?id=0";
        //http://ptm.rdi-esprit.com/good-job.png
        con = new ConnectionRequest(url);
        con.setPost(false);
        ok.addActionListener(e -> {
            System.out.println(tnom.getText() + " -- "+tpwd.getText());
            con.addArgument("username", tnom.getText());
            con.addArgument("password", tpwd.getText());
            con.addResponseListener(new ActionListener<NetworkEvent>() {
                @Override
                public void actionPerformed(NetworkEvent evt) {
                    try {
                        // byte[] data = (byte[]) evt.getMetaData();
                        String rep = new String(con.getResponseData(), "utf-8");
                        if (rep.equalsIgnoreCase("welcome")) {
                            bjr.setText("bonjour "+tnom.getText());
                            try{
                                f2.add(bjr);
                                f2.add(back);
                                
                            }catch(Exception e){
                            }
                            f2.show();
                        } else {
                            Dialog.show("Error", "invalid", "OK", "Cancel");
                            
                        }
                    } catch (UnsupportedEncodingException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            });
            NetworkManager.getInstance().addToQueueAndWait(con);
        });

        back.addActionListener(e -> f1.showBack());

        f1.show();
         
         
}



}
