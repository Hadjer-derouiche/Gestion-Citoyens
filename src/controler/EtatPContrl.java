package controler;

import java.awt.event.*;
import javax.swing.*;

import model.Mairie;
import model.Citoyen;

public class EtatPContrl implements ActionListener {

    private JTextField champID;
    private JLabel resultat;
    private Mairie mairie;

    public EtatPContrl(JTextField champID, JLabel resultat, Mairie mairie) {
        this.champID = champID;
        this.resultat = resultat;
        this.mairie = mairie;
    }
    
@Override
public void actionPerformed(ActionEvent e) {
    try {
        int id = Integer.parseInt(champID.getText());
        Citoyen c = mairie.recupererById(id);

        if (c == null) {
        	resultat.setText("Aucune personne trouvée avec cet ID.");
        } else {
            String nomComplet = c.getNom() + " " + c.getPrenom();
            String sexe = c.estFemme() ? "Femme" : "Homme";
            String naissance = c.getDateNaiss().toString();
            String etat = c.isEstDecede() ? "Décédé(e)" : "Vivant(e)";
            String divorce = "";
            if (c.estDivorce()) {
                divorce = "- Situation : Divorcé(e)<br>";
            }
            String conjoint = "Aucun";

            Citoyen conjointPersonne = c.getConjoint();
            System.out.println("Conjoint trouvé ? " + (conjointPersonne != null));
            if (conjointPersonne != null) {
                System.out.println("Conjoint décédé ? " + conjointPersonne.isEstDecede());
            }
            if (conjointPersonne != null) {
                String nomPrenomConjoint = conjointPersonne.getNom() + " " + conjointPersonne.getPrenom();

                if (conjointPersonne.isEstDecede()) {
                    String statut = c.estFemme() ? "Veuve" : "Veuf";
                    conjoint = nomPrenomConjoint + " (" + statut + ")";
                } else if (c.estDivorce()) {
                    conjoint = "Divorcé(e)";
                } else {
                    conjoint = nomPrenomConjoint;
                }
            }



            resultat.setText(
            	    "<html>"
            	    + "- " + nomComplet + " (" + sexe + ")<br>"
            	    + "- Né(e) le " + naissance + "<br>"
            	    + divorce
            	    + "- Conjoint : " + conjoint + "<br>"
            	    + "- État : " + etat
            	    + "</html>"
            	);

        }

    } catch (NumberFormatException ex) {
        resultat.setText("Veuillez entrer un ID valide.");
    }
}


}
