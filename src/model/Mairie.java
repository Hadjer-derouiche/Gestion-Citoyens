package model;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Mairie {
    /**
     * 
     */
	private static int compteurId = 1;
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
    public Mairie( String nomM, String adr) {
        this.idMairie = compteurId++;
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
    
    public Vector<Citoyen> getCitoyens() {
        return listCitoyens;  
    }
    
    
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
    
    public ActeMariage recupererActMar(int id)
    {
    	for(ActeMariage m:listactemariage)
    	{
    		if(m.getIdActMariage()== id)
    			return m ;
    	}
    	return null;
    }
     
   public  Citoyen recupererById (int id)
   {
	   for (Citoyen c : listCitoyens) {
	        if (c.getId() == id) {
	            return c;
	        }
	    }
	   return null;
   }
    
public void declarerDeces(int idCitoyen, LocalDate dateDeces) {
    Citoyen c = recupererById(idCitoyen);
    if (c == null) {
        System.out.println("Aucun citoyen avec cet ID.");
        return;
    }
    if (c.isEstDecede()) {
        System.out.println("Cette personne est déjà décédée.");
        return;
    }

    ActeDeces acte = new ActeDeces( dateDeces, this, c); 
    

    ajouterDeces(acte); 
    c.setActeDeces(acte);

    if (c.estMarie()) {
        Citoyen conjoint = c.getConjoint();
        if (conjoint != null) {
            for (ActeMariage mariage : conjoint.listMar) {
                mariage.setIsValide(false);
            }
        }
    }

    System.out.println("Décès enregistré avec succès pour " + c.getNom() + " " + c.getPrenom());
}
}
