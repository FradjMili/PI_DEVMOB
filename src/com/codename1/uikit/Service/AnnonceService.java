/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.codename1.uikit.Entite.Annonce;
import com.codename1.uikit.Entite.Demande;
import com.codename1.uikit.materialscreens.LoginForm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class AnnonceService {
int check;
    public void ajoutAnnonce(Annonce ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/PI_DEEV/web/app_dev.php/jobposts/AddAnn/?titre=" + ta.getTitre() + "&iduserA='1'&description=" + ta.getDescription() + "&speciality=" + ta.getSpeciality() + "&salaire=" + ta.getSalaire() + "&etatannonce=0";// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<Annonce> parseListAnnonceJson(String json) {

        ArrayList<Annonce> listAnnonces = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
             */
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));

            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
             */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Annonce e = new Annonce();

                float id = Float.parseFloat(obj.get("id").toString());
                float salaire = Float.parseFloat(obj.get("salaire").toString());
                float etat = Float.parseFloat(obj.get("etatannonce").toString());
              //  float o = Float.parseFloat(obj.get("etatannonce").toString());

                e.setId((int) id);
                e.setTitre(obj.get("titre").toString());
                e.setDescription(obj.get("description").toString());
                e.setSalaire((int) salaire);
                e.setImage(obj.get("image").toString());
                e.setSpeciality(obj.get("speciality").toString());
                e.setEtatannonce((int) etat);

                java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd");

                java.util.Date datee = null;
                try {
                    datee = format.parse((String) obj.get("datedebut"));
                } catch (java.text.ParseException ex) {
                }
                System.out.println(datee);
                e.setDatedebut(datee);
                try {
                    datee = format.parse((String) obj.get("datefin"));
                } catch (java.text.ParseException ex) {
                }
                System.out.println(datee);
                e.setDatefin(datee);

                System.out.println(e);

                listAnnonce.add(e);

            }

        } catch (IOException ex) {
        }

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        System.out.println(listAnnonce);
        return listAnnonce;

    }

    public ArrayList<Demande> parseListDemandesJson2(String json) {
  Demande e = new Demande();  
        ArrayList<Demande> listAnnonces = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
             */
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));

            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
             */
           List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
  
        
            
//Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
              

                float id = Float.parseFloat(obj.get("id").toString());
                float ida = Float.parseFloat(obj.get("ida").toString());
//                float salaire = Float.parseFloat(obj.get("salaire").toString());

                e.setId((int) id);
                e.setTitre(obj.get("titre").toString());
                e.setMotivation(obj.get("motivation").toString());
                e.setIda((int) ida);

                System.out.println(e);

                list1.add(e);

            }
//
        } catch (IOException ex) {
        }

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        System.out.println(list1);
return list1;

    }
public int parseListDemandesJson(String json) {
  Demande e = new Demande();  
        ArrayList<Demande> listAnnonces = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
             */
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));

            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
             */
//            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("");
  
e.setEtatd((int)Float.parseFloat(tasks.get("etatd").toString()));
            System.out.println(e.getEtatd());
            
            
//Parcourir la liste des tâches Json
//            for (Map<String, Object> obj : list) {
//                //Création des tâches et récupération de leurs données
//              
//
//                float id = Float.parseFloat(obj.get("id").toString());
//                float ida = Float.parseFloat(obj.get("ida").toString());
////                float salaire = Float.parseFloat(obj.get("salaire").toString());
//
//                e.setId((int) id);
//                e.setTitre(obj.get("titre").toString());
//                e.setMotivation(obj.get("motivation").toString());
//                e.setIda((int) ida);
//
//                System.out.println(e);
//
//                list1.add(e);
//
//            }
    list1.add(e);
//
        } catch (IOException ex) {
        }

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        System.out.println(list1);
return e.getEtatd();

    }

    ArrayList<Annonce> listAnnonce = new ArrayList<>();
    ArrayList<Demande> list1 = new ArrayList<>();

    public ArrayList<Annonce> getList2() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PI_DEEV/web/app_dev.php/jobposts/allmobile/");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                AnnonceService ser = new AnnonceService();
                listAnnonce = ser.parseListAnnonceJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAnnonce;
    }

    public void supprimer(Annonce ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/PI_DEEV/web/app_dev.php/jobposts/Supprimer/" + ta.getId();// création de l'URL
        System.out.println(ta.getId());
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<Annonce> getMyListAnnonce() {
        ArrayList<Annonce> MylistAnn = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PI_DEEV/web/app_dev.php/jobposts/MyAnn/1");
        //+LoginForm.UserConnected.getId());

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> result : list) {
                        Annonce c = new Annonce();
                        float id = Float.parseFloat(result.get("id").toString());

                        c.setId((int) id);

                        float idu = Float.parseFloat(result.get("iduserA").toString());
                        c.setIduserA((int) idu);

                        c.setTitre(result.get("titre").toString());
                        c.setSpeciality(result.get("speciality").toString());

                        c.setDescription(result.get("description").toString());
                        c.setImage(result.get("image").toString());

                        //                    Date db= Date.valueOf(result.get("datedeb"));
//                      Date df= Date.valueOf(result.get("datefin").toString());
//
//          c.setDatedeb(db);
//                            c.setDatefin(df);
//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
//Date dateStr = simpleDateFormat.parse((String) result.get("datedeb")); 
//c.setDatedeb(dateStr);
                        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                        try {
                            java.util.Date datee = format.parse((String) result.get("datedebut"));
                            System.out.println(datee);
                            c.setDatedebut(datee);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        SimpleDateFormat formatf = new SimpleDateFormat("yyyy/MM/dd");
                        try {
                            java.util.Date dateee = formatf.parse((String) result.get("datefin"));
                            System.out.println(dateee);
                            c.setDatefin(dateee);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        float prix = Float.parseFloat(result.get("salaire").toString());
                        c.setSalaire((int) prix);

                        //c.setDatedeb(          (Date) result.get("datedeb"));
                        MylistAnn.add(c);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        // NetworkManager.getInstance().addToQueue(con); ==> ye5dem toul affichage mayestanech resultat tjih heka 3leh tji ferr8a 

        return MylistAnn;

    }

    public void AddAnn(String titre, String speciality, String description, int salaire, String datedebut, String datefin, String image) {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PI_DEEV/web/app_dev.php/jobposts/AddAnn/?titre=" + titre + "&speciality=" + speciality + "&iduserA=1&description=" + description + "&salaire=" + salaire + "&datedebut=" + datedebut + "&datefin=" + datefin + "&image=" + image + "&etatAnnonce=0");

        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public void UpdatAnn(int id, String titre, String speciality, String description, int salaire, String datedebut, String datefin, String image) {
        System.out.println("dans UpdatAnn service");
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PI_DEEV/web/app_dev.php/jobposts/UpdateAnn/?id=" + id + "&titre=" + titre + "&speciality=" + speciality + "&iduserA=1&description=" + description + "&salaire=" + salaire + "&datedebut=" + datedebut + "&datefin=" + datefin + "&image=" + image + "&etatAnnonce=0");
        con.addResponseListener(e->{
            String str = new String (con.getResponseData());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
    }
    
    
//    public void UpdatAnn(int id, String titre, String speciality, String description, int salaire, String datedebut, String datefin, String image) {
//        System.out.println("dans UpdatAnn service");
//        ConnectionRequest con = new ConnectionRequest();
//        con.setUrl("http://localhost/PI_DEEV/web/app_dev.php/jobposts/UpdateAnn/?id=" + id + "&titre=" + titre + "&speciality=" + speciality + "&iduserA=1&description=" + description + "&salaire=" + salaire + "&datedebut=" + datedebut + "&datefin=" + datefin + "&image=" + image + "&etatAnnonce=0");
//        con.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                AnnonceService ser = new AnnonceService();
//                listAnnonce = ser.parseListAnnonceJson(new String(con.getResponseData()));
//
//                NetworkManager.getInstance().addToQueueAndWait(con);
//            }
//
//        });
//    }

            public int verif(int id, String Motivation) {

                ConnectionRequest con = new ConnectionRequest();
                con.setUrl("http://localhost/PI_DEEV/web/app_dev.php/jobposts/verif/?ida=" + id + "&Motivation=j'accept");
  con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                AnnonceService ser = new AnnonceService();
                check= ser.parseListDemandesJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return check;
   
            }
    
    public ArrayList<Demande> getList3() {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PI_DEEV/web/app_dev.php/jobposts/allmobile2/");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                AnnonceService ser = new AnnonceService();
                list1 = ser.parseListDemandesJson2(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return list1;
    }

    public void validerann(int id) {
        System.out.println("id annonce="+id);
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PI_DEEV/web/app_dev.php/jobposts/validerann/" + id);
//        con.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                AnnonceService ser = new AnnonceService();
//                list1 = ser.parseListDemandesJson(new String(con.getResponseData()));
//            }
//        });
        NetworkManager.getInstance().addToQueueAndWait(con);
       
    }

    public void suppdemande(int id) {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PI_DEEV/web/app_dev.php/jobposts/suppd/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                AnnonceService ser = new AnnonceService();
                list1 = ser.parseListDemandesJson2(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }

    public void supprimerParIdAnnonce(int ida) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/PI_DEEV/web/app_dev.php/jobposts/Supprimer/" + ida;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
}
