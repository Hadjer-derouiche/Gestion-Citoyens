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
    private boolean estDecede = false;

  
    
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

  
    public void setActeDeces(ActeDeces acte) {
        this.deces = acte;
    }

    public boolean isEstDecede() {
        return deces != null;
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
        // On parcourt les actes de mariage
        for (ActeMariage mariage : listMar) {
            if (mariage.isValide()) {  // Vérifie si le mariage est valide
                // Cherche l'autre conjoint dans l'acte de mariage
                Citoyen conjoint = mariage.getConjoint(this);  // Utilisation de la méthode getConjoint de ActeMariage
                if (conjoint != null) {
                    return conjoint;  // Si un conjoint est trouvé, on le retourne
                }
            }
        }
        return null;  // Si aucun conjoint valide n'est trouvé
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