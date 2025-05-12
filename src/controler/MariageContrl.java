package controler;
import java.awt.Color;
import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.*;

import model.ActeMariage;
import model.Citoyen;
import model.Femme;
import model.Homme;
import model.Mairie;




public class MariageContrl implements ActionListener {
	
	JTextField idConjoint,idConjointe,dateM;
	JLabel erreur;
	Mairie mairie;
	
	public MariageContrl(JTextField c1, JTextField c2,JTextField date, JLabel er, Mairie m)
	{
		idConjoint=c1;
		idConjointe=c2;
		dateM=date;
		erreur=er;
		mairie =m;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		int id1 = Integer.parseInt(idConjoint.getText());
		int id2 = Integer.parseInt(idConjointe.getText());
		
		Citoyen f=mairie.recupererById(id2);
		Citoyen h=mairie.recupererById(id1);
		LocalDate date =LocalDate.parse(dateM.getText());
		
		
		if (f == null || h == null) {
            erreur.setText("Citoyen introuvable avec l’ID fourni.");
            return;
        }
		else
		{
			
		}
		if (f.estMarie() || h.estMarie()) {
		    erreur.setText("L'un des deux partenaires est déjà marié.");
		    return;
		}
		
		if(f.age()<18 || h.age()<18)
		{
			erreur.setText("L'un des deux partenaires est mineur.");
			
		}
		
		else if((!f.estFemme()) || (!h.estHomme()) )
		{
			erreur.setText(" Le mariage requiert deux personnes de sexes différents.");
		}
		else {
		   ActeMariage newMar= new ActeMariage(true,1,f,h,date, mairie);
		   mairie.ajouterMar(newMar);
		   f.ajouterMar(newMar);
		   h.ajouterMar(newMar);
		   erreur.setForeground(Color.GREEN);
		   erreur.setText("Mariage enregistré avec succès !");
	     }
		
	   idConjoint.setText("");
       idConjointe.setText("");
       dateM.setText("");
       
		
	}

}
