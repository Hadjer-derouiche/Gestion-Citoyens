package controler;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;

import model.ActeNaissance;
import model.Citoyen;
import model.Femme;
import model.Homme;
import model.Mairie;
import view.AffichePView;

public class NaissanceContrl implements ActionListener {
	JTextField idP,idM,nom,prenom,dateNaiss;
	JLabel erreur;
	JRadioButton femme , homme;
	private Mairie mairie;
	private AffichePView affichePView;
	
	public NaissanceContrl (JTextField id1, JTextField id2, JTextField n,JTextField p ,JTextField d,JLabel r,JRadioButton f ,JRadioButton h, Mairie m,AffichePView view)
	{
		idP=id1;
		idM=id2;
		nom=n;
		prenom=p;
		dateNaiss=d;
		erreur=r;
		femme=f;
		homme=h;
		mairie=m;
		affichePView=view;
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
			Femme newFemme= new Femme(sNom, sPren,date,mairie );
			mairie.ajouterCitoyen(newFemme);
			newActe= new ActeNaissance(pere,mere,newFemme);
			
		}
		else if(homme.isSelected())
		{
			Homme newHomme = new Homme (sNom, sPren, date, mairie );
			mairie.ajouterCitoyen(newHomme);
		    newActe= new ActeNaissance(pere,mere,newHomme);
			
		}
		if (affichePView != null) {
		    affichePView.rafraichirTable();
		}
		pere.ajouterEnfant(newActe);
		mere.ajouterEnfant(newActe);
		mairie.ajouterNaissance(newActe);
		idP.setText("");
		idM.setText("");
		  nom.setText("");
	        prenom.setText("");
	        dateNaiss.setText("");
	        femme.setSelected(false);
	        homme.setSelected(false);
		
		
		
	}

}
