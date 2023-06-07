/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprint_mobile.myapp.services;

import com.codename1.components.ToastBar;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Offre;
import com.mycompany.myapp.entities.ResOffre;
import com.sprint_mobile.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lenovo
 */
public class ServiceResOffre {
    
    public ArrayList<ResOffre> resoffres;
    
    public static ServiceResOffre instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceResOffre() {
         req = new ConnectionRequest();
    }

    
     public static ServiceResOffre getInstance() {
        if (instance == null) {
            instance = new ServiceResOffre();
        }
        return instance;
    }

    

    

    public ArrayList<ResOffre> parseResOffres(String jsonText){
        try {
            resoffres=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                ResOffre r = new ResOffre();
                float id = Float.parseFloat(obj.get("id").toString());
                r.setId((int)id);
                float ido = Float.parseFloat(obj.get("ido").toString());
                r.setIdo((int)ido);
                float idc = Float.parseFloat(obj.get("idc").toString());
                r.setIdc((int)idc);
                float nb = Float.parseFloat(obj.get("nb").toString());
                r.setNb((int)nb);
                
                resoffres.add(r);
            }
            
            
        } catch (IOException ex) {
            
        }
        return resoffres;
    }
    
    public ArrayList<ResOffre> getAllResOffres(){
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"/listResoffreJSON";
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resoffres = parseResOffres(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resoffres;
    }
    
    
      
    public boolean deleteResOffre(Integer id){
        ToastBar.Status status = ToastBar.getInstance().createStatus();
        status.setMessage("Suppresion en cours...");
        status.setShowProgressIndicator(true);
        status.show();
        String url = Statics.BASE_URL+"/deleteResOffreJSON/"+id;
        req = new ConnectionRequest();
        req.setUrl(url);
         req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>(){
                @Override
                public void actionPerformed(NetworkEvent evt){
                    resultOK = req.getResponseCode() == 200; 
                    req.removeResponseCodeListener(this);
                }
        });
        
       NetworkManager.getInstance().addToQueueAndWait(req);
       return resultOK;
    }
    
    
    
    
    public boolean updateResOffre(ResOffre roffre) {
        ToastBar.Status status = ToastBar.getInstance().createStatus();
        status.setMessage("Mise à jour en cours...");
        status.setShowProgressIndicator(true);
        status.show();
       // String url = Statics.BASE_URL+"/api/product/update/"+product.getId();
       String url = Statics.BASE_URL+"/updateResOffreJSON/"+roffre.getId();
        req.setUrl(url);
        req.setPost(true);


       req.addArgument("ido",roffre.getIdo()+"");
       req.addArgument("nb", roffre.getNb()+"");
        


        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        status.clear();
        return resultOK;
    }
    
    
    
    
}
