package controler;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import model.Mairie;
import model.Citoyen;

public class EtatPContrl implements ActionListener {

    private JTextField champID;
    private JPanel resultat;
    private Mairie mairie;

    public EtatPContrl(JTextField champID, JPanel resultat, Mairie mairie) {
        this.champID = champID;
        this.resultat = resultat;
        this.mairie = mairie;
    }

@Override
public void actionPerformed(ActionEvent e) {
    resultat.removeAll();
    resultat.setLayout(new BoxLayout(resultat, BoxLayout.Y_AXIS));

    try {
        int id = Integer.parseInt(champID.getText());
        Citoyen c = mairie.recupererById(id);

        if (c == null) {
            resultat.add(new JLabel("Aucune personne trouvée avec cet ID."));
        } else {
            String nomComplet = c.getNom() + " " + c.getPrenom();
            String sexe = c.estFemme() ? "Femme" : "Homme";
            String naissance = c.getDateNaiss().toString();
            String etat = c.isEstDecede() ? "Décédé(e)" : "Vivant(e)";
            Citoyen conjoint = c.getConjoint();

            // Affichage des infos de base
            resultat.add(new JLabel("- " + nomComplet + " (" + sexe + ")"));
            resultat.add(new JLabel("- Né(e) le " + naissance));
            resultat.add(new JLabel("- État : " + etat));

            // Si la personne est vivante → afficher la situation matrimoniale
            if (!c.isEstDecede()) {
                String etatMarital;

                if (c.estDivorce()) {
                    etatMarital = "Divorcé(e)";
                } else if (conjoint != null) {
                    if (conjoint.isEstDecede()) {
                        etatMarital = c.estFemme() ? "Veuve" : "Veuf";
                    } else {
                        etatMarital = "Marié(e)";
                    }
                } else {
                    etatMarital = "Célibataire";
                }

                resultat.add(new JLabel("- Situation : " + etatMarital));
            }

            // Si la personne a un conjoint (vivant ou mort), on l'affiche toujours
            if (conjoint != null) {
                String nomPrenomConjoint = conjoint.getNom() + " " + conjoint.getPrenom();
                resultat.add(new JLabel("- Conjoint : " + nomPrenomConjoint));
            }
        }
    } catch (NumberFormatException ex) {
        resultat.add(new JLabel("Veuillez entrer un ID valide."));
    }

    resultat.revalidate();
    resultat.repaint();
}
}