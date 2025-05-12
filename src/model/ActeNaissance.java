package model;


import java.io.*;
import java.util.*;

/**
 * 
 */
public class ActeNaissance {
    
    private int idActeNais;
    
    Citoyen citoyen,mere,pere;
    
    
  
      public ActeNaissance(int idN, Citoyen m, Citoyen p, Citoyen c) {
          idActeNais = idN;
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