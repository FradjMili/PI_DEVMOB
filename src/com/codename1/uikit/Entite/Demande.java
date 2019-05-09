/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.Entite;

/**
 *
 * @author USER
 */
public class Demande {
     private int id;
     private int ida;
     private int iduserD;
     private int iduserA;
     private String Titre;
     private String Motivation;
      private int etatd;
      private String datedebut;
       private String datefin;

    public String getDatedebut() {
        return datedebut;
    }
    

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }
       

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIda() {
        return ida;
    }

    public void setIda(int ida) {
        this.ida = ida;
    }

    public int getIduserD() {
        return iduserD;
    }

    public void setIduserD(int iduserD) {
        this.iduserD = iduserD;
    }

    public int getIduserA() {
        return iduserA;
    }

    public void setIduserA(int iduserA) {
        this.iduserA = iduserA;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getMotivation() {
        return Motivation;
    }

    public void setMotivation(String Motivation) {
        this.Motivation = Motivation;
    }

    public int getEtatd() {
        return etatd;
    }

    public void setEtatd(int etatd) {
        this.etatd = etatd;
    }
    
      public Demande() {
    }

    public Demande(int id, int ida,  int iduserA, int iduserD, String Titre, int etatd ,String Motivation) {
        this.id = id;
        this.iduserA = iduserA;
        this.iduserD = iduserD;
        this.Titre = Titre;
        this.etatd = etatd;
        this.Motivation = Motivation;
       
    }
    public Demande( int ida,  int iduserA, int iduserD, String Titre, int etatd ,String Motivation) {
       
        this.iduserA = iduserA;
        this.iduserD = iduserD;
        this.Titre = Titre;
        this.etatd = etatd;
        this.Motivation = Motivation;
       
    }
}
