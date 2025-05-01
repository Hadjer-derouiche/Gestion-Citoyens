package model;

import java.awt.GraphicsConfiguration;
import java.time.LocalDate;

import view.DivorceView;
import view.MainView;
import view.MariageView;
import view.NaissanceView;
import view.SaisiePView;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mairie mairie = new Mairie(1, "senia", "edresse F1");
		Femme citoyen = new Femme(5, "celina", "ikhlef", LocalDate.of(2003, 12, 31), mairie);
		Homme citoyen2 = new Homme(6, "mohemed", "allel", LocalDate.of(2005, 12, 31), mairie);


		mairie.ajouterCitoyen(citoyen);
		mairie.ajouterCitoyen(citoyen2);
		MainView aff = new MainView(mairie);


	}

}
