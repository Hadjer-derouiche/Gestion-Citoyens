package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.Mairie;

public class EtatPView extends JFrame{
	
	Mairie mairie;

	JLabel labelTitre,date, labelCitoyen;
    JTextField id;
    JButton  rechercher, quitter;
    JLabel etat;
    JPanel topPanel;
    
    public static String getDateHeureActuelle() {
        LocalDateTime maintenant = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return maintenant.format(formatter);
    }

     
    public 	EtatPView (Mairie m)
    {
    	mairie =m;

        setTitle("Formulaire de Mariage");
        setPreferredSize(new Dimension(550, 350));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        labelTitre = new JLabel("Formulaire de Mariage");
        labelTitre.setFont(new Font("Arial", Font.BOLD, 18));

        date = new JLabel(getDateHeureActuelle());
        date.setFont(new Font("Arial", Font.BOLD, 14));

        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(labelTitre);
        topPanel.add(Box.createRigidArea(new Dimension(100, 0)));
        topPanel.add(date);
        topPanel.add(Box.createHorizontalGlue());
        
        
        
    }
    

}
