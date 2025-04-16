package model;


import java.io.*;
import java.util.*;

/**
 * 
 */
public class ActeMariage {
    
    private boolean div;
    private int idActMariage;
    
    Femme Conjointe;
    Homme Conjoint;
    Mairie mairie;

    public ActeMariage(boolean d, int idm) {
		div = d;
		idActMariage = idm;
	}
    
    


	public ActeMariage(boolean d, int idm, Femme cf, Homme ch, Mairie m) {
		div = d;
		idActMariage = idm;
		Conjointe = cf;
		Conjoint = ch;
		mairie = m;
	}
	
     
    /**
     * getter and setter
     */
    public boolean isDiv() {
        return div;
    }

    public void setDiv(boolean div) {
        this.div = div;
    }

    public int getIdActMariage() {
        return idActMariage;
    }

    public void setIdActMariage(int idActMariage) {
        this.idActMariage = idActMariage;
    }
     
     
}