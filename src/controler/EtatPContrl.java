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
                resultat.setText(" Aucune personne trouvée avec cet ID.");
            } else {
                String nomComplet = c.getNom() + " " + c.getPrenom();
                String sexe = c.estFemme() ? "Femme" : "Homme";
                String naissance = c.getDateNaiss().toString();
                String conjoint = "Aucun";

                if (c.getConjoint() != null) {
                    conjoint = c.getConjoint().getNom() + " " + c.getConjoint().getPrenom();
                }

                resultat.setText("<html>- " + nomComplet + " (" + sexe + ")<br>- Né(e) le " + naissance + "<br>- Conjoint : " + conjoint + "</html>");
            }

        } catch (NumberFormatException ex) {
            resultat.setText(" Veuillez entrer un ID valide.");
        }
    }
}
