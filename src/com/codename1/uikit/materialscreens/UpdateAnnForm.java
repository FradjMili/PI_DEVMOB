/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.materialscreens;

import com.codename1.capture.Capture;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SignatureComponent;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.File;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import com.codename1.uikit.Service.AnnonceService;
import static com.codename1.uikit.materialscreens.ListAnnForm.specDetails;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.System.out;
import java.util.Date;
import java.util.Set;

public class UpdateAnnForm extends Form {

    Image img = null;
    Image toupload = null;
    Image profilePic = null;
    Label profile = null;
    ImageViewer image = new ImageViewer();
    Slider starRank = new Slider();

    static int SR;
    File file = new File("");
    String type = "";
    int prixx;
    String Filenom;
    private Resources themee = UIManager.initFirstTheme("/theme");

    public UpdateAnnForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());

        specDetails.getId();
    }

    public UpdateAnnForm(Resources theme) {

        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");

        try {
            // LoginForm.setTheme(theme.openLayered("/theme"));
        } catch (Exception e) {
            System.out.println(e);
        }
        Container welcome = FlowLayout.encloseCenter(
                new Label("Modifier", "WelcomeRed")
        );
        Button register = new Button("valider");
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_IMAGE);

        Image profilePic = theme.getImage("user-picture.jpg");
        Image mask = theme.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());

        profile = new Label();
        fab.addActionListener((ActionEvent ev) -> {

            if (ev != null && ev.getSource() != null) {

                try {
                    String fileNameInServer = "";
                    MultipartRequest cr = new MultipartRequest();
                    String filePath = Capture.capturePhoto(-1, -1);
                    System.out.println(filePath);
                    String filenom = "/image";
                    System.out.println(filenom);
                    cr.setUrl("http://localhost/datatable_21/web/uploadimage.php");
                    cr.setPost(true);
                    String mime = "image/jpeg";
                    cr.addData("file", filePath, mime);
                    String out = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
                    cr.setFilename("file", out + ".jpg");

                    fileNameInServer += out + ".jpg";
                    Filenom = fileNameInServer;
                    System.err.println("path2 =" + fileNameInServer.toString());
                    InfiniteProgress prog = new InfiniteProgress();
                    Dialog dlg = prog.showInifiniteBlocking();
                    cr.setDisposeOnCompletion(dlg);
                    NetworkManager.getInstance().addToQueueAndWait(cr);
                    //  try {

                    img = Image.createImage(FileSystemStorage.getInstance().openInputStream(filePath));
                    toupload = img;
                    img.fill(mask.getWidth(), mask.getHeight());
                    profile.setIcon(img);
                    profile.setUIID("ProfilePicTitle");
                    profile.setMask(mask.createMask());
                    refreshTheme();
                    //} catch (IOException e) {
                    //  }
                } catch (IOException ex) {
                }

            }
        }
        );

        getTitleArea().setUIID("Container");
        Picker date = new Picker();
        date.setType(Display.PICKER_TYPE_DATE);

        Image logo = theme.getImage("logo.png");

        //    Image mask = theme.getImage("round-mask.png");
        //    logo = logo.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(logo, "ProfilePic");

        //   profilePicLabel.setMask(mask.createMask());
        TextField tfDep = new TextField(specDetails.getTitre(), "titre", 20, 0);
        TextField tfArr = new TextField(specDetails.getSpeciality(), "speciality", 20, 0);
        TextField tfDescription = new TextField(specDetails.getDescription(), "Description", 20, 0);

        String salaire = Integer.toString(specDetails.getSalaire());
        System.out.println(salaire);
        TextField tfNbr = new TextField(salaire, "Prix", 20, 0);
//        TextField rating = new TextField("", "Rating", 20, 0);

        Validator v = new Validator();
        v.addConstraint(tfDep, new LengthConstraint(2)).
                addConstraint(tfArr, new LengthConstraint(2)).
                addConstraint(tfDescription, new LengthConstraint(2)).
                addConstraint(tfNbr, new LengthConstraint(1));
//                addConstraint(etat, new LengthConstraint(2));                
        // v.addSubmitButtons(register);

        tfDep.getAllStyles().setMargin(LEFT, 0);
        tfArr.getAllStyles().setMargin(LEFT, 0);
        tfDescription.getAllStyles().setMargin(LEFT, 0);
        tfNbr.getAllStyles().setMargin(LEFT, 0);
//        etat.getAllStyles().setMargin(LEFT, 0);
//        rating.getAllStyles().setMargin(LEFT, 0);

        Label nomicon = new Label("", "TextField");
        Label Descriptionicon = new Label("", "TextField");
        Label Imageicon = new Label("", "TextField");
        Label Prixicon = new Label("", "TextField");
        Label datee = new Label("", "TextField");
        Label etaticon = new Label("", "TextField");
        Label ratingicon = new Label("", "TextField");

        Picker datedeb = new Picker();
        datedeb.setType(Display.PICKER_TYPE_DATE);

        datedeb.setDate(specDetails.getDatedebut());

        Picker datefin = new Picker();
        datefin.setType(Display.PICKER_TYPE_DATE);
        datefin.setDate(specDetails.getDatefin());

        nomicon.getAllStyles().setMargin(RIGHT, 0);
        Descriptionicon.getAllStyles().setMargin(RIGHT, 0);
        Imageicon.getAllStyles().setMargin(RIGHT, 0);
        Prixicon.getAllStyles().setMargin(RIGHT, 0);
        etaticon.getAllStyles().setMargin(RIGHT, 0);
        ratingicon.getAllStyles().setMargin(RIGHT, 0);

        FontImage.setMaterialIcon(nomicon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(Descriptionicon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(Imageicon, FontImage.MATERIAL_ACCESS_ALARMS, 3);
        FontImage.setMaterialIcon(Prixicon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(datee, FontImage.MATERIAL_ACCESS_ALARMS, 3);
        FontImage.setMaterialIcon(ratingicon, FontImage.MATERIAL_FACE, 3);

        Button goBackToLogin = new Button(" << ");
        goBackToLogin.setUIID("StasForm");
        goBackToLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Toolbar.setGlobalToolbar(false);
                new ListAnnForm(themee).show();

                //   Toolbar.setGlobalToolbar(true);
            }
        });
        // We remove the extra space for low resolution devices so things fit better
        Label spaceLabel;
        if (!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }

        Container by = BoxLayout.encloseY(
                welcome,
                spaceLabel,
                profile,
                fab,
                BorderLayout.center(tfDep).
                        add(BorderLayout.WEST, nomicon),
                BorderLayout.center(tfArr).
                        add(BorderLayout.WEST, Descriptionicon),
                BorderLayout.center(datedeb).
                        add(BorderLayout.WEST, datee),
                BorderLayout.center(datefin).
                        add(BorderLayout.WEST, Imageicon),
                BorderLayout.center(tfDescription).
                        add(BorderLayout.WEST, etaticon)
        );

        TextField prix = new TextField(salaire, "Prix", 4, TextArea.NUMERIC);
        by.add(prix);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                System.out.println("dans l'action performed , enregistrer");
                int prixxx = 0;

                java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd");
                String db = format.format(datedeb.getDate());
                String df = format.format(datefin.getDate());

                java.text.SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyyyMMdd");
                String d1 = format1.format(datedeb.getDate());
                String d2 = format1.format(datefin.getDate());
                String d3 = format1.format(new Date().getTime());
                System.out.println("date lyoum " + d3);

                int a = Integer.parseInt(d1);
                int b = Integer.parseInt(d2);
                int datelyoum = Integer.parseInt(d3);
                int cc = b - a;
                int ddd = datelyoum - a;
                
                System.out.println("avant if action perfermod of enregistrer");
                if (tfDep.getText().length() == 0 || tfDescription.getText().length() == 0 || tfArr.getText().length() == 0 || cc < 0 || ddd < 0) {
                    System.out.println("in if action perf");
                    Dialog.show("Humm", "Vérifiez vos informations...", "J'ai compris", null);
                    
                    System.out.println("date deb" + db);
                    System.out.println("date fin" + df);
                    System.out.println("difference b-a" + cc);
                    System.out.println("difference date deb date lyoium" + ddd);
                    System.out.println(db + "    " + df);
                } else {
                    System.out.println("dans else action perf");
                    System.out.println("loula" + prix.getText());
                    System.out.println("thenya" + tfNbr.getText());
                    AnnonceService se = new AnnonceService();
                    se.UpdatAnn(specDetails.getId(), tfDep.getText(), tfArr.getText(), tfDescription.getText(), Integer.parseInt(prix.getText()), db, df, specDetails.getImage() );
                    Dialog D = new Dialog();
                    D.show("Success! ", "Modification effectueé", "ok", null);

                    //   }
//                        
//        con.setUrl("http://localhost/datatable_21/web/app_dev.php/home/AddEv?nom="+tfDep.getText()+"&prenom="+tfArr.getText()+ "&description=" + tfDescription.getText() + 
//                 "&prix=" +Integer.parseInt(tfNbr.getText())+ "&disponibilite=" + date.getText());
                }

            }
        });

        by.add(register);
        by.add(goBackToLogin);
        add(BorderLayout.CENTER, by);

        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(true);
        register.addActionListener(e->{
            AnnonceService as =new AnnonceService();
       /*     
            spec.setTitre(tfDep.getText());
             sv.UpdatAnn(spec.getId(),spec.getTitre(), spec.getSpeciality(),spec.getDescription(),spec.getDatedebut(),spec.getDatefin(),spec.getImage());
        TextField tfDep = new TextField(specDetails.getTitre(), "titre", 20, 0);
        TextField tfArr = new TextField(specDetails.getSpeciality(), "speciality", 20, 0);
        TextField tfDescription = new TextField(specDetails.getDescription(), "Description", 20, 0);
 TextField tfNbr = new TextField(salaire, "Prix", 20, 0);
       */ });
    }

}
