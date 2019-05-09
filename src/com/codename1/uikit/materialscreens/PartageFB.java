package com.codename1.uikit.materialscreens;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.uikit.Entite.Annonce;
import com.codename1.uikit.Service.AnnonceService;
import java.util.ArrayList;
//import com.restfb.Parameter;
//import com.restfb.DefaultFacebookClient;
//import com.restfb.FacebookClient;
//import com.restfb.types.FacebookType;
/**
 *
 * @author Amine
 */
public class PartageFB {
    Form f;

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    

   /* public PartageFB() {
        AnnonceService serviceeva=new AnnonceService();
        ArrayList<Annonce> liste=serviceeva.getList2();
      f =new Form("Annonce", BoxLayout.y());
      for(Annonce t:liste){
                      Container c = new Container(BoxLayout.y());
                     
             Label Titre = new Label(t.getTitre());
            SpanLabel Desc = new SpanLabel(t.getDescription());
            Button par=new Button("Partager sur FB");
               par.addActionListener(e -> {

            String accessToken = "EAAE0ZCreXKZA8BAFtHrCbQVoFiDXwem0FHSfOfUDaqlooeXthHmb3e1ZB4dFkFDfYblBbAmz7Px13pvF6v5GDPBVlxhZAGGrYPULDN4OJe9fTjgUQt5CUQy5X4KGZA9zvI7MF2NDnQNBtwAUYvfk0hKaHEJFHFlSOCnCyzZBnPQP9lonzA5oqzTLhVkH7GdUIZD";

           FacebookClient fbClient = new DefaultFacebookClient(accessToken);
            FacebookType response = fbClient.publish("me/feed", FacebookType.class,
                    //Parameter.with("message","daliyoooo patron"+" "+t.getAdresse())
                    Parameter.with("link", "http://127.0.0.1/datatable_21/web/app_dev.php/home/")
                   // "link", "http://127.0.0.1/Zanimo3/web/app_dev.php/services/Show/"+la.getId()
            );
            Dialog.show("Information","Votre Annonce à été publiée sur facebook","ok",null);
        });
            c.addAll(Titre, Desc,par);
                
                c.getStyle().setBgColor(0x99CCCC);
                c.getStyle().setBgTransparency(255);
                f.add(ComponentGroup.enclose(c));
             
        }
     
    }*/
}