package model;


import java.io.*;
import java.time.LocalDate;
import java.time.Period;
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
    Vector <ActeMariage> listMar = new Vector<ActeMariage>();
    
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
    
    public void ajouterMar(ActeMariage m) {
        listMar.add(m);
    }
    
    public int age()
    {
    	return Period.between(dateNaiss, LocalDate.now()).getYears();
    }
    public boolean estFemme() {
        return this instanceof Femme;
    }

    public boolean estHomme() {
        return this instanceof Homme;
    }
    
    public boolean estMarie() {
        for (ActeMariage acte : listMar) {
            if (acte.isValide()) {
                return true; 
            }
        }
        return false; 
    }

}