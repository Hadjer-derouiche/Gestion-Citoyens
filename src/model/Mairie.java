package model;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Mairie {
    /**
     * 
     */
    private int idMairie;
    private String nomMairie;
    private String adresse;

    Vector<Citoyen> listCitoyens = new Vector<Citoyen>();
    Vector<ActeMariage> listactemariage = new Vector<ActeMariage>();
    Vector<ActeNaissance> listacteNaiss = new Vector<ActeNaissance>();
    Vector<ActeDeces> listDeces = new Vector<ActeDeces>();

    /**
     * Default constructor
     */
    public Mairie(int idM, String nomM, String adr) {
        idMairie = idM;
        nomMairie = nomM;
        adresse = adr;
    }

    public void ajouterCitoyen(Citoyen c) {
        listCitoyens.add(c);
    }

    public void ajouterMar(ActeMariage m) {
        listactemariage.add(m);
    }

    public void ajouterNaissance(ActeNaissance n) {
        listacteNaiss.add(n);
    }

    public void ajouterDeces(ActeDeces n) {
        listDeces.add(n);
    }

    /**
     * getter and setter
     */
    public int getIdMairie() {
        return idMairie;
    }

    public void setIdMairie(int idMairie) {
        this.idMairie = idMairie;
    }

    public String getNomMairie() {
        return nomMairie;
    }

    public void setNomMairie(String nomMairie) {
        this.nomMairie = nomMairie;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}