package model;


import java.io.*;
import java.util.*;

/**
 * 
 */
public class ActeNaissance {
    
    private int idActeNais;
    
    Femme mere;
    Homme pere;
    Citoyen citoyen;
    
    
    public ActeNaissance(int idN) {
        idActeNais = idN;
      }
  
  
  
      public ActeNaissance(int idN, Femme m, Homme p, Citoyen c) {
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