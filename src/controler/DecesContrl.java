package controler;

import model.Mairie;
import view.DecesView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class DecesContrl implements ActionListener {
    private DecesView view;
    private Mairie mairie;

    public DecesContrl(DecesView view, Mairie mairie) {
        this.view = view;
        this.mairie = mairie;
        this.view.getBoutonDeclarer().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int id = Integer.parseInt(view.getChampID().getText());
            LocalDate dateDeces = LocalDate.parse(view.getChampDateDeces().getText());

            mairie.declarerDeces(id, dateDeces);

            view.getResultat().setText(" Décès enregistré avec succès !");
        } catch (NumberFormatException ex) {
            view.getResultat().setText(" ID invalide.");
        } catch (Exception ex) {
            view.getResultat().setText(" Erreur : " + ex.getMessage());
        }
    }
}
