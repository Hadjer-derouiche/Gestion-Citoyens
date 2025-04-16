package model;


import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Citoyen {

    /**
     * 
     */
    private int id;
    private String nom;
    private String prenom;
    private LocalDate dateNaiss;
    
    ActeDeces deces;
    ActeNaissance acteNaiss;
    Mairie mairie;
    
    public Citoyen(int idC, String n, String p, LocalDate dateNais) {
		id = idC;
		nom = n;
		prenom = p;
		dateNaiss = dateNais;
	}




	public Citoyen(int idC, String n, String p, LocalDate dateNais,Mairie m) {
		id = idC;
		nom = n;
		prenom = p;
		dateNaiss = dateNais;
		mairie = m;
	}


    /**
     * getter and setter
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }
    
    
    

}