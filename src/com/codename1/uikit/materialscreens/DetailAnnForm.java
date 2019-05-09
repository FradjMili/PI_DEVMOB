/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.codename1.uikit.materialscreens;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.Entite.Annonce;
import com.codename1.uikit.Entite.Demande;
import com.codename1.uikit.Service.AnnonceService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a user profile in the app, the first form we open after the
 * walkthru
 *
 * @author Shai Almog
 */
public class DetailAnnForm extends SideMenuBaseForm {

    AnnonceService s = new AnnonceService();
    private Image img;
    private ImageViewer imgv;
    private EncodedImage enc;
    private Resources theme = UIManager.initFirstTheme("/theme");

    public DetailAnnForm(Resources res) {
        super(BoxLayout.y());

        getUnselectedStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_RADIAL);
        getUnselectedStyle().setBackgroundGradientEndColor(0xffffff);
        getUnselectedStyle().setBackgroundGradientStartColor(0x000000);
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("user-picture.jpg");

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_ARROW_BACK);
        menuButton.addActionListener(e -> new ListAnn1Form1(res).show());
        Label tit = new Label("" + ListAnn1Form1.specDetails.getTitre(), "Title");

        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                new Label("", "SubTitle"),
                                tit
                        )
                ),
                GridLayout.encloseIn(2)
        );

        // FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        //fab.getAllStyles().setMarginUnit(Style.UNIT_TYPE_PIXELS);
        //fab.getAllStyles().setMargin(BOTTOM, completedTasks.getPreferredH() - fab.getPreferredH() / 2);
        tb.setTitleComponent(titleCmp);

        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);

        Annonce Sp = new Annonce();

        System.out.println("test");

        // for (EntitySpecialiste spec : Sp.getListPediatre()) {
        //   System.out.println("test2");
        // addButtonBottom(profilePic, "ok", 0xd997f1, true);
        //}
        System.out.println("detail");

        addButtonBottom(profilePic, ListAnn1Form1.specDetails, 0xd997f1, true);

        //addButtonBottom(profilePic, ListEvForm.specDetails , 0xF69602, true);
    }

    Annonce e = ListAnn1Form1.specDetails;

    public boolean testID_Ev_Part() {
        boolean test = false;

        AnnonceService se = new AnnonceService();

        System.out.println("l id mte3 eve   " + ListAnn1Form1.specDetails.getId());

        if (ListAnn1Form1.specDetails.getId() == 0) {
            test = true;
        }

        System.out.println("_______booooolean est   " + test);
        return test;
    }

    public boolean testIDU_Part() {
        boolean test = false;

        AnnonceService se = new AnnonceService();

        return test;
    }

    private void addButtonBottom(Image arrowDown, Annonce spec, int color, boolean first) {

        Container finishLandingPage = new Container(BoxLayout.y());

//        MultiButton finishLandingPage = new MultiButton(text);    
//        finishLandingPage.setEmblem(arrowDown.scaledHeight(50));
//        finishLandingPage.setUIID("Container");
//        finishLandingPage.setUIIDLine1("TodayEntry");
//        finishLandingPage.setIcon(createCircleLine(color, finishLandingPage.getPreferredH(),  first));
//        finishLandingPage.setIconUIID("Container");
//arrowDown.scaledWidth(100);
//finishLandingPage.add(arrowDown.scaledHeight(100));
        try {
            enc = EncodedImage.create("/giphy.gif");
        } catch (IOException ex) {
            System.out.println("error encoder");
        }

        System.out.println(spec.getImage());

        img = URLImage.createToStorage(enc, spec.getImage(), "http://localhost" + spec.getImage(), URLImage.RESIZE_SCALE);

        img.fill(500, 100);
        imgv = new ImageViewer(img.fill(300, 100));

        finishLandingPage.add(imgv);
        Label l = new Label(spec.getTitre() + " ");

        Label prixx = new Label("Prix :" + String.valueOf(spec.getSalaire()));

        l.getAllStyles().setFgColor(0xF69602);

        prixx.getAllStyles().setFgColor(0x57d973);

        SpanLabel l3 = new SpanLabel("Description:  " + spec.getDescription());
        l3.getAllStyles().setBackgroundGradientEndColor(0xF69602);

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date datedeb = spec.getDatedebut();
        Date datefin = spec.getDatefin();

        String datedebstring = format.format(datedeb);
        String datefinstring = format.format(datefin);

        Label df = new Label("De " + datedebstring + " au " + datefinstring);
        finishLandingPage.add(df);

        df.getAllStyles().setFgColor(0xf6ff00);

        finishLandingPage.add(prixx);

        finishLandingPage.add(l3);

        /**
         * *********** userr    **********
         */
        /* Button par=new Button("Partager sur FB");
               par.addActionListener(e -> {

            String accessToken = "EAAE0ZCreXKZA8BAEXm3SIVLv5nNpDtrkoEaCgZASlejkhYoktA1fodsdvyLYjJjWqCesOknxUardEYInFRIb68MzcnEhib3UpYtFrW9PZAqZCugfJzmZBCTn8pVHVFvDenRU8zPl1gAATX2bR5ZB8Ekska2eAjYr1fsiqduHsKvLcpXgNUVsY5O5bgyuj494t4ZD";

            FacebookClient fbClient = new DefaultFacebookClient(accessToken);
            FacebookType response = fbClient.publish("me/feed", FacebookType.class,
                    //Parameter.with("message","daliyoooo patron"+" "+t.getAdresse())
                    Parameter.with("link", "http://127.0.0.1/datatable_21/web/app_dev.php/home/")
                   // "link", "http://127.0.0.1/Zanimo3/web/app_dev.php/services/Show/"+la.getId()
            );
            Dialog.show("Information","Votre Evenement à été publiée sur facebook","ok",null);
        });*/
        Button loginButton = new Button(">> Postuler ");
        finishLandingPage.add(loginButton);

        loginButton.getAllStyles().setFgColor(0x000fff);
        loginButton.addActionListener(e -> {
             // s.(spec.getId(), "ahla");
             
             int check=s.verif(spec.getId(), "ahla");
             
             System.out.println("ahlaaaaaa "+check);
         if (check!=-1)
                {
                 Dialog D  = new Dialog();
                 D.show("Success! ", "l'ajout n'est pas effectueé","ok",null);
                 
                }
                else{
           Dialog D  = new Dialog();
                 D.show("Success! ", "'ajout effectueé","ok",null);
                 }
        });

        add(FlowLayout.encloseIn(finishLandingPage));

    }

    @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();
    }

}
