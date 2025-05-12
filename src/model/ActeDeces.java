package model;


import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class ActeDeces {

    
	private static int compteurId = 1;
    private int idActeDeces;
    private LocalDate dateDeces;
    
    Mairie mairie;
    Citoyen citoyen;
    
    
    public ActeDeces( LocalDate date) {
    	this.idActeDeces = compteurId++;
		dateDeces = date;
	}
	
	public ActeDeces(LocalDate date, Mairie m, Citoyen c) {
		this.idActeDeces = compteurId++;
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