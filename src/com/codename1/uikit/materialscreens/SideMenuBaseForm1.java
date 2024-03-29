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

import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;

/**
 * Common code that can setup the side menu
 *
 * @author Shai Almog
 */
public abstract class SideMenuBaseForm1 extends Form {

    public SideMenuBaseForm1(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public SideMenuBaseForm1(String title) {
        super(title);
    }

    public SideMenuBaseForm1() {
    }

    public SideMenuBaseForm1(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }
    
    public void setupSideMenu(Resources res) {
              Image profilePic = res.getImage("");
        //Image mask = res.getImage("round-mask.png");
       //mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
        //profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label("", profilePic, "SideMenuTitle");
        //profilePicLabel.setMask(mask.createMask());

        Container sidemenuTop = BorderLayout.center(profilePicLabel);
        sidemenuTop.setUIID("SidemenuTop");
     
        getToolbar().addComponentToSideMenu(sidemenuTop);
        getToolbar().addMaterialCommandToSideMenu("  Les Annonces", FontImage.MATERIAL_DASHBOARD,  e ->   new ListAnn1Form1(res).show());
        getToolbar().addMaterialCommandToSideMenu("  Mes Demandes", FontImage.MATERIAL_ACCESSIBILITY,  e -> new ListDemandeComn(res).show());
         //   getToolbar().addMaterialCommandToSideMenu("  les Offres", FontImage.MATERIAL_ACCESSIBILITY,  e -> new ListBabyForm(res).show());
        //getToolbar().addMaterialCommandToSideMenu("  Mes Offres", FontImage.MATERIAL_ACCESSIBILITY,  e -> new MyListBaby(res).show());
        // getToolbar().addMaterialCommandToSideMenu("  Ajouter Offre", FontImage.MATERIAL_ACCESSIBILITY,  e -> new AddOffre1(res).show());
// getToolbar().addMaterialCommandToSideMenu("  Ajouter Demande", FontImage.MATERIAL_ACCESSIBILITY,  e -> new AddDemande(res).show());
             getToolbar().addMaterialCommandToSideMenu("  Menu", FontImage.MATERIAL_EXIT_TO_APP,  e -> new First(res).show());
       //getToolbar().getAllStyles().setBgColor(0xE12336);
             getToolbar().addMaterialCommandToSideMenu("  Logout", FontImage.MATERIAL_EXIT_TO_APP,  e -> new LoginForm(res).show());
    }
    
    protected abstract void showOtherForm(Resources res);
}
