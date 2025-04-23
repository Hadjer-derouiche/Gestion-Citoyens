package controler;
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
	Mairie mairie;
	
	public MariageContrl(JTextField c1, JTextField c2, Mairie m)
	{
		idConjoint=c1;
		idConjointe=c2;
		mairie =m;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		int id1 = Integer.parseInt(idConjoint.getText());
		int id2 = Integer.parseInt(idConjointe.getText());
		
		Citoyen f=mairie.recupererById(id2);
		Citoyen h=mairie.recupererById(id1);
		LocalDate date =LocalDate.parse(dateM.getText());
		
	   if((f.estFemme()) && (h.estHomme()) )
	   {
		   ActeMariage newMar= new ActeMariage(true,1,f,h,date, mairie);
		   mairie.ajouterMar(newMar);
		   f.ajouterMar(newMar);
		   h.ajouterMar(newMar);
	   }
		
	   idConjoint.setText("");
       idConjointe.setText("");
       
		
	}

}
