package model;

import java.awt.GraphicsConfiguration;
import java.time.LocalDate;

import view.DivorceView;
import view.MainView;
import view.MariageView;
import view.NaissanceView;


public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mairie mairie = new Mairie(1, "senia", "edresse F1");
		Femme citoyen = new Femme(5, "celina", "ikhlef", LocalDate.of(2003, 12, 31), mairie);
		ActeMariage mariage= new ActeMariage(false, 12);
		ActeNaissance naissance= new ActeNaissance(1);

		mairie.ajouterCitoyen(citoyen);
		MainView affichage = new MainView(mairie);
		
		MariageView affichagemariage=new MariageView(mariage);
		NaissanceView affichagenaissance= new NaissanceView(naissance);
		DivorceView affichageDivorce = new DivorceView();


	}

}
