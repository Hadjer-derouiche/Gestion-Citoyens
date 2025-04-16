package model;

import java.time.LocalDate;

import view.MainView;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mairie mairie = new Mairie(1, "senia", "edresse F1");
		Homme citoyen = new Homme(5, "celina", "ikhlef", LocalDate.of(2003, 12, 31), mairie);
		mairie.ajouterCitoyen(citoyen);
		MainView affichage = new MainView(mairie);

	}

}
