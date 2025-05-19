package controler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.ActeMariage;
import model.Citoyen;
import model.Mairie;

public class DivorceContrl implements ActionListener {
	
	JTextField idActMariage,dateM;
	JLabel erreur;
	Mairie mairie;
	
	public DivorceContrl(JTextField am,JTextField date, JLabel er, Mairie m)
	{
		idActMariage=am;
		dateM=date;
		erreur=er;
		mairie =m;
	}
	
	

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int id = Integer.parseInt(idActMariage.getText());
            ActeMariage acte = mairie.recupererActMar(id);
            LocalDate date = LocalDate.parse(dateM.getText());

            if (acte == null) {
                erreur.setText("Acte de mariage introuvable avec l'ID fourni.");
                return;
            }

            if (!acte.peutDivorcer()) {
                erreur.setText("Un des conjoints est décédé. Divorce impossible.");
                erreur.setForeground(Color.RED);
                return;
            }

            
            acte.enregistrerDivorce();
            erreur.setForeground(Color.GREEN);
            erreur.setText("Divorce enregistré avec succès !");
            idActMariage.setText("");
            dateM.setText("");

        } catch (NumberFormatException ex) {
            erreur.setText("Veuillez entrer un ID et une date valides.");
            erreur.setForeground(Color.RED);
        }
    }


}
