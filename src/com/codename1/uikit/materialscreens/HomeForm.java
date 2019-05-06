/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.materialscreens;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.uikit.Entite.Annonce;
import com.codename1.uikit.Service.AnnonceService;


/**
 *
 * @author bhk
 */
public class HomeForm {

    Form f;
    TextField tnom;
    TextField tetat;
    TextField tnom1;
    TextField tetat1;
    TextField tnom2;
    Button btnajout,btnaff;

    public HomeForm() {
        f = new Form("home");
        tnom = new TextField("","Titre");
        tetat = new TextField("","Description");
        tnom1 = new TextField("","Salaire");
        tetat1 = new TextField("","Speciality");
        btnajout = new Button("ajouter");
        btnaff=new Button("Affichage");
        f.add(tnom);
        f.add(tetat);
        f.add(tetat1);
        f.add(tnom1);
        f.add(btnajout);
        f.add(btnaff);
        btnajout.addActionListener((e) -> {
            AnnonceService ser = new AnnonceService();
            Annonce t = new Annonce(tetat1.getText(), tetat.getText(), tnom.getText(),Integer.parseInt(tnom1.getText()));
            ser.ajoutAnnonce(t);
            

        });
        btnaff.addActionListener((e)->{
        Affichage a=new Affichage();
        a.getF().show();
        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }

}
