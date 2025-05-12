package model;


import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Femme extends Citoyen {
    
    private static String sexe = "Femme";
    
     Vector <ActeNaissance> listeacteNaiss = new Vector<ActeNaissance>();

     /**
     * Default constructor
     */
    public Femme( String n, String p, LocalDate dateNais, Mairie m) {
		super( n, p, dateNais, m);
	}

     
 
     public void ajouterEnfant(ActeNaissance n) {
    	 listeacteNaiss.add(n);
     }

}