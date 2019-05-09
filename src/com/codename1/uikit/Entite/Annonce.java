/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.Entite;

import java.util.Date;

/**
 *
 * @author USER
 */
public class Annonce { 
    private int id;
    private int iduserA;
    private String speciality;
 public java.util.Date datedebut;
    private java.util.Date datefin;
    private String description;
    private String titre;
    private String Image;

    public Annonce(String speciality, String description, String titre, int salaire) {
        this.speciality = speciality;
        this.description = description;
        this.titre = titre;
        this.salaire = salaire;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
    private int salaire;
    private int etatannonce;
    public static Annonce Annoncecourant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIduserA() {
        return iduserA;
    }

    public void setIduserA(int iduserA) {
        this.iduserA = iduserA;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public int getEtatannonce() {
        return etatannonce;
    }

    public void setEtatannonce(int etatannonce) {
        this.etatannonce = etatannonce;
    }

    public Annonce() {
    }

    public Annonce(int id, int iduserA, String speciality, String description, String titre, int salaire, int etatannonce) {
        this.id = id;
        this.iduserA = iduserA;
        this.speciality = speciality;
        this.description = description;
        this.titre = titre;
        this.salaire = salaire;
        this.etatannonce = etatannonce;
    }

   
    public Annonce(int iduserA, String speciality, String description, String titre, int salaire, int etatannonce) {
        this.iduserA = iduserA;
        this.speciality = speciality;
        this.description = description;
        this.titre = titre;
        this.salaire = salaire;
        this.etatannonce = etatannonce;
    }

    public Date getDatedebut() {
        return datedebut;
    }
     

   public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    @Override
    public String toString() {
        return "Annonce{" + "id=" + id + ", iduserA=" + iduserA + ", speciality=" + speciality + ", datedebut=" + datedebut + ", datefin=" + datefin + ", description=" + description + ", titre=" + titre + ", Image=" + Image + ", salaire=" + salaire + ", etatannonce=" + etatannonce + '}';
    }

 

    
    
}
