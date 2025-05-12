package controler;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;

import model.ActeNaissance;
import model.Citoyen;
import model.Femme;
import model.Homme;
import model.Mairie;

public class NaissanceContrl implements ActionListener {
	JTextField idP,idM,nom,prenom,dateNaiss;
	JLabel erreur;
	JRadioButton femme , homme;
	private Mairie mairie;
	
	public NaissanceContrl (JTextField id1, JTextField id2, JTextField n,JTextField p ,JTextField d,JLabel r, Mairie m)
	{
		idP=id1;
		idM=id2;
		nom=n;
		prenom=p;
		dateNaiss=d;
		erreur=r;
		mairie=m;
	}
	public void actionPerformed(ActionEvent e) {
		String sNom  = nom.getText();
        String sPren = prenom.getText();
        String sDate = dateNaiss.getText();
        LocalDate date = LocalDate.parse(sDate);
        
        int idpp = Integer.parseInt(idP.getText());
		int idmm = Integer.parseInt(idM.getText());
		
		Citoyen pere=mairie.recupererById(idpp);
		Citoyen mere=mairie.recupererById(idmm);
		ActeNaissance newActe = null;
		
		if (pere == null || mere == null) {
            erreur.setText("Un des parents introuvable avec l’ID fourni.");
            return;
        }
        
		if(femme.isSelected())
		{
			Femme newFemme= new Femme(12,sNom, sPren,date,mairie );
			mairie.ajouterCitoyen(newFemme);
			newActe= new ActeNaissance(1,pere,mere,newFemme);
			
		}
		else if(homme.isSelected())
		{
			Homme newHomme = new Homme (13,sNom, sPren, date, mairie );
			mairie.ajouterCitoyen(newHomme);
		    newActe= new ActeNaissance(1,pere,mere,newHomme);
			
		}
		pere.ajouterEnfant(newActe);
		mere.ajouterEnfant(newActe);
		mairie.ajouterNaissance(newActe);
		
		
		
		
	}

}
