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
	private static int compteurId = 1;
    private int id;
    private String nom;
    private String prenom;
    private LocalDate dateNaiss;
    private boolean estDecede = false;

  
    
    ActeDeces deces;
    ActeNaissance acteNaiss;
    Mairie mairie;
    Vector <ActeMariage> listMar = new Vector<ActeMariage>();
    
    public Citoyen(String n, String p, LocalDate dateNais) {
    	this.id = compteurId++;
		nom = n;
		prenom = p;
		dateNaiss = dateNais;
	}




	public Citoyen(String n, String p, LocalDate dateNais,Mairie m) {
		this.id = compteurId++;
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

  
    public void setActeDeces(ActeDeces acte) {
        this.deces = acte;
    }

    public boolean isEstDecede() {
        return deces != null;
    }

    public boolean isVivant() {
        return this.deces == null;
    }



    public void setEstDecede(boolean estDecede) { //
        this.estDecede = estDecede;
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

    public void ajouterEnfant(ActeNaissance n) {
    }


    public Citoyen getConjoint() {
        for (ActeMariage mariage : listMar) {
            Citoyen conjoint = mariage.getConjoint(this);
            if (conjoint != null) {
                return conjoint; 
            }
        }
        return null;
    }






    
    public boolean estMarie() {
        for (ActeMariage acte : listMar) {
            if (acte.isValide()) {
                return true; 
            }
        }
        return false; 
    }
    
    public ActeMariage getActeMariage() {
        for (ActeMariage acte : listMar) {
            return acte; 
        }
        return null;
    }
    
    public boolean estDivorce() {
        for (ActeMariage acte : listMar) {
            if (!acte.isValide()&& acte.peutDivorcer()) {
                return true; 
            }
        }
        return false; 
    }
  









}