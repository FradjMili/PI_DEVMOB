/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.materialscreens;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author USER
 */
public class First extends Form {

    public First(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
          
        getTitleArea().setUIID("Container");
        
        Image profilePic = theme.getImage("2.jpg");
        //Image mask = theme.getImage("logoAllforKids.png");
        //profilePic = profilePic.fill(100,100);
        Label profilePicLabel = new Label(profilePic, "ProfilePic");
        
         Label spaceLabel0 = new Label(" ");
        Button loginButton = new Button("Client");
      // loginButton.setUIID("Events");
        loginButton.getAllStyles().setBgColor(0xE12336);
      //  add(BorderLayout.CENTER,loginButton);
        loginButton.addActionListener(e -> {
           // Toolbar.setGlobalToolbar(false);
         
           new ListAnnForm(theme).show();
           // Toolbar.setGlobalToolbar(true);
 
        });
        
        
        
        
        
          Button loginButton2 = new Button("Freelancer");
       //loginButton.setUIID("Freelancer");
        loginButton2.getAllStyles().setBgColor(0xE12336);
       // add(BorderLayout.CENTER,loginButton2);
        loginButton2.addActionListener(e -> {
           // Toolbar.setGlobalToolbar(false);
         
           new ListAnn1Form1(theme).show();
           // Toolbar.setGlobalToolbar(true);
 
        });
        
        
          
        Container by = BoxLayout.encloseY(
                
                profilePicLabel,
                
          
                loginButton,loginButton2
               
        );
         by.setScrollableY(true);
        by.setScrollVisible(false);
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
       
    }

   
    }
    

