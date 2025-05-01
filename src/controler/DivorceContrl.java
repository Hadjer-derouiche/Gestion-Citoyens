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
	
	
	public void actionPerformed(ActionEvent e) {
		
		int id = Integer.parseInt(idActMariage.getText());
		
		ActeMariage acte=mairie.recupererActMar(id);
		LocalDate date =LocalDate.parse(dateM.getText());
		
		
		if ( acte == null) {
            erreur.setText("acte de mariage introuvable avec l’ID fourni.");
            return;
        }
		
		else {
		   acte.setDiv(false);
		   erreur.setForeground(Color.GREEN);
		   erreur.setText("divorce enregistré avec succès !");
	     }
		
	   idActMariage.setText("");
       dateM.setText("");
       
		
	}


}
