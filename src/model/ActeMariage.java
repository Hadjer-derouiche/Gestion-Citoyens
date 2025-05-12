package model;


import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class ActeMariage {
    
    private boolean isValide;
    private int idActMariage;
    private LocalDate dateMariage;
    
    Femme Conjointe;
    Homme Conjoint;
    Mairie mairie;

    public ActeMariage(boolean d, int idm) {
		isValide = d;
		idActMariage = idm;
	}
    
    


	public ActeMariage(boolean d, int idm, Citoyen f, Citoyen h,LocalDate date, Mairie m) {
		isValide = d;
		idActMariage = idm;
		Conjointe = (Femme) f;
		Conjoint = (Homme) h;
		dateMariage=date;
		mairie = m;
	}
	
     
    /**
     * getter and setter
     */
    public boolean isValide() {
        return isValide;
    }

    public void setDiv(boolean div) {
        this.isValide = div;
    }

    public int getIdActMariage() {
        return idActMariage;
    }

    public void setIdActMariage(int idActMariage) {
        this.idActMariage = idActMariage;
    }
    

    public void setIsValide(boolean valide) {
        this.isValide = valide;
    }
    public Citoyen getConjoint(Citoyen c) {
        if (c instanceof Femme && c == Conjointe) {
            return Conjoint;
        } else if (c instanceof Homme && c == Conjoint) {
            return Conjointe;
        }
        return null;
    }
    


    public void enregistrerDivorce() {
        this.isValide = false;
    }

    public boolean estDivorce() {
        return !isValide;
    }
    
    public boolean peutDivorcer() {
        return !Conjointe.isEstDecede() && !Conjoint.isEstDecede(); 
    }

    

   

     
     
}