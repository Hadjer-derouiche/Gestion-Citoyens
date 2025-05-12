package controler;

import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.*;

import model.Citoyen;
import model.Femme;
import model.Homme;
import model.Mairie;

public class SaisiPContrl implements ActionListener  {
	
	JTextField nom , prenom, dateNaissance;
	JRadioButton femme , homme;
	private Mairie mairie;

    public SaisiPContrl(Mairie m, JTextField n, JTextField p,JTextField d, JRadioButton f ,JRadioButton h) {
        mairie = m;
        nom=n;
        prenom=p;
        dateNaissance=d;
        femme=f;
        homme=h;
    }
	public void actionPerformed(ActionEvent e) {
		String sNom  = nom.getText();
        String sPren = prenom.getText();
        String sDate = dateNaissance.getText();
        LocalDate date = LocalDate.parse(sDate);
        
		if(femme.isSelected())
		{
			Femme newFemme= new Femme(sNom, sPren,date,mairie );
			mairie.ajouterCitoyen(newFemme);
			
		}
		else if(homme.isSelected())
		{
			Homme newHomme = new Homme (sNom, sPren, date, mairie );
			mairie.ajouterCitoyen(newHomme);
			
		}
		else
		{
			Citoyen newCitoyen= new Citoyen(sNom, sPren, date, mairie);
			mairie.ajouterCitoyen(newCitoyen);
		
		}
		
		
        nom.setText("");
        prenom.setText("");
        dateNaissance.setText("");
        femme.setSelected(false);
        homme.setSelected(false);
	}
	
	


}
