/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.materialscreens;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.codename1.uikit.Service.AnnonceService;


/**
 *
 * @author bhk
 */
public class Affichage {

    Form f;
    SpanLabel lb;
  
    public Affichage() {
        
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        AnnonceService serviceTask=new AnnonceService();
        lb.setText(serviceTask.getList2().toString());
        
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
