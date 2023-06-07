
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sprint_mobile.myapp.services;

import com.codename1.components.ToastBar;
import com.sprint_mobile.myapp.utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Offre;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lenovo
 */
public class ServiceOffre {
    
    public ArrayList<Offre> offres;
    
    public static ServiceOffre instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceOffre() {
         req = new ConnectionRequest();
    }

    public static ServiceOffre getInstance() {
        if (instance == null) {
            instance = new ServiceOffre();
        }
        return instance;
    }

    public boolean addOffre(Offre o) {
        
        System.out.println(o);
        System.out.println("********");
       //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
       String url = Statics.BASE_URL + "/addOffreJSON";
    
       req.setUrl(url);
       req.setPost(false);
       req.addArgument("description", o.getDescription());
       req.addArgument("tarif", o.getTarif()+"");
       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;

       
    }
    

    public ArrayList<Offre> parseOffres(String jsonText){
        try {
            offres=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Offre o = new Offre();
                float id = Float.parseFloat(obj.get("id").toString());
                o.setId((int)id);
                o.setTarif(Float.parseFloat(obj.get("tarif").toString()));
                if (obj.get("description")==null)
                o.setDescription("null");
                else
                    o.setDescription(obj.get("description").toString());
                offres.add(o);
            }
            
            
        } catch (IOException ex) {
            
        }
        return offres;
    }
    
    public ArrayList<Offre> getAllOffres(){
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"/listDQlJSON";
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                offres = parseOffres(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return offres;
    }
    
    
    
    public Offre DetailOffre (int id, Offre offre){
        String url = Statics.BASE_URL+"/showoffreJSON?"+id;
        req.setUrl(url);
        
        String str = new String(req.getResponseData());
       
        req.addResponseListener(((evt) -> {
            
            JSONParser jsonp = new  JSONParser();
            try{
                Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
               
                        
                offre.setDescription(obj.get("description").toString());
                offre.setTarif((float) obj.get("tarif"));
               

            } catch (IOException ex) {
                System.out.println("error related to sql : ( " + ex.getMessage());
            }
            
            System.out.println("data ==="+str);

        }));
                NetworkManager.getInstance().addToQueueAndWait(req);

                return offre;
            }
    
    
    
    
    /*
    public boolean deleteOffre(Integer id){
        String url = Statics.BASE_URL+"/deleteOffreJSON/"+id;
        
        req.setUrl(url);
        
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
    */
    
    public boolean deleteOffre(int id){
        ToastBar.Status status = ToastBar.getInstance().createStatus();
        status.setMessage("Suppresion en cours...");
        status.setShowProgressIndicator(true);
        status.show();
        String url = Statics.BASE_URL+"/deleteOffreJSON/"+id;
        req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);
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
    
    
    
    

    public boolean updateOffre(Offre offre) {
        ToastBar.Status status = ToastBar.getInstance().createStatus();
        status.setMessage("Mise à jour en cours...");
        status.setShowProgressIndicator(true);
        status.show();
       // String url = Statics.BASE_URL+"/api/product/update/"+product.getId();
       String url = Statics.BASE_URL+"/updateOffreJSON/"+offre.getId();
        
        req.setUrl(url);
        req.setPost(true);


        req.addArgument("description",offre.getDescription());
       req.addArgument("tarif", offre.getTarif()+"");
        


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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
    
    
    
    
    
    
    
    
    
        

