package model;


import java.io.*;
import java.util.*;

/**
 * 
 */
public class ActeNaissance {
    
    private int idActeNais;
    private static int compteurId = 1;
    
    Citoyen citoyen,mere,pere;
    
    
  
      public ActeNaissance( Citoyen m, Citoyen p, Citoyen c) {
          this.idActeNais =compteurId++;
          mere = m;
          pere = p;
          citoyen = c;
      }
  
  
    
    /**
     * getter and setter
     */

    public int getIdActeNais() {
        return idActeNais;
    }

    public void setIdActeNais(int idActeNais) {
        this.idActeNais = idActeNais;
    }
    
    

}