package model;


import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class ActeDeces {

    
  
    private int idActeDeces;
    private LocalDate dateDeces;
    
    Mairie mairie;
    Citoyen citoyen;
    
    
    public ActeDeces(int d, LocalDate date) {
		idActeDeces = d;
		dateDeces = date;
	}
	
	public ActeDeces(int d, LocalDate date, Mairie m, Citoyen c) {
		idActeDeces = d;
		dateDeces = date;
		mairie=m;
		citoyen=c;
		
	}
	
    /**
     * getter and setter
     */
    public int getIdActeDeces() {
        return idActeDeces;
    }

    public void setIdActeDeces(int idActeDeces) {
        this.idActeDeces = idActeDeces;
    }

    public LocalDate getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(LocalDate dateDeces) {
        this.dateDeces = dateDeces;
    }

}