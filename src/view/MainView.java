package view;

import javax.swing.*;

import controler.MainContrl;

import java.awt.*;
import model.Mairie;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MainView extends JFrame {
	

	Mairie mairie;
	JButton saisieP = new JButton ("Saisie des personnes");
	JButton etatP = new JButton ("Etat de la personne");
	JButton affichageP = new JButton ("Affichage de la liste des personnes");
	JButton mariage = new JButton ("Mariage");
	JButton divorce = new JButton ("Divorce");
	JButton naissance = new JButton ("Naissance");
	JButton deces= new JButton ("Deces");
	JButton quitterP = new JButton ("Quitter le programme ");
	
	JPanel panel= new JPanel();
	JPanel panel2= new JPanel();
	JPanel panelfvt= new JPanel();
	JPanel northPanel= new JPanel();
	JPanel bottomPanel= new JPanel();
	
	JLabel label = new JLabel(" ");
	JLabel nom;
	JLabel gc = new JLabel("Gestion de Citoyens");
	JLabel date;
	JLabel fvt = new JLabel("Fait Votre Choix !");
	

	
    public static String getDateHeureActuelle() {
        LocalDateTime maintenant = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return maintenant.format(formatter);
    }
	
	public MainView (Mairie m )
	{
		mairie=m;
		 setPreferredSize(new Dimension(900,500));
		 this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

	
		
		// north panel
		date= new JLabel (getDateHeureActuelle());
		nom = new JLabel ("Etablissement :" + m.getNomMairie());
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		panel2.add(Box.createHorizontalGlue()); 
		panel2.add(nom);
		panel2.add(Box.createRigidArea(new Dimension(150, 0)));
		panel2.add(gc);
		panel2.add(Box.createRigidArea(new Dimension(150, 0)));
		panel2.add(date);
		panel2.add(Box.createHorizontalGlue());
		for (Component comp : panel2.getComponents()) {
		    comp.setFont(new Font("Arial", Font.BOLD, 16));
		}
		
		panelfvt.setLayout(new BoxLayout(panelfvt, BoxLayout.X_AXIS));
		panelfvt.add(Box.createHorizontalGlue());
		panelfvt.add(Box.createRigidArea(new Dimension(35, 0)));
		panelfvt.add(fvt);
		panelfvt.add(Box.createHorizontalGlue());
		fvt.setFont(new Font("Arial", Font.BOLD, 17));
		
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		northPanel.add(panel2);
		northPanel.add(Box.createRigidArea(new Dimension(0,40)));
		northPanel.add(panelfvt);

		
       //panel center
		panel.setLayout(new GridLayout (3,3, 20, 20));		
		panel.add(saisieP);
		panel.add(etatP);
		panel.add(affichageP);
		panel.add(mariage);
		panel.add(divorce);
		panel.add(naissance);
		panel.add(label);
		panel.add(deces);
		
		
		JButton[] boutons = {
			    saisieP, etatP, affichageP, mariage, divorce, naissance, deces
			};

			for (JButton btn : boutons) {
			    btn.setPreferredSize(new Dimension(150,50)); 
			    btn.setFont(new Font("Arial", Font.BOLD, 12)); 
			    btn.setBackground(new Color(115,115,115)); 
			    btn.setForeground(Color.BLACK);
			    btn.setFocusPainted(false); // Supprime le contour focus
			 
			}
			
			//panel bottom
			
			quitterP.setPreferredSize(new Dimension(500,30));
			quitterP.setBackground(Color.RED);
			quitterP.setForeground(Color.WHITE);
			quitterP.setBorderPainted(false);

			bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			bottomPanel.add(quitterP);
			
			//
			getContentPane().add(Box.createRigidArea(new Dimension(0, 30))); 
			getContentPane().add(northPanel);
			getContentPane().add(Box.createRigidArea(new Dimension(0, 30))); 
			getContentPane().add(panel);
			getContentPane().add(Box.createRigidArea(new Dimension(0, 50))); 
			getContentPane().add(bottomPanel);

			
		// gerer les buttons 
			
			String[] nomsInterfaces = {
				    "saisieP", "etatP", "affichageP", "mariage", "divorce", "naissance", "deces"
				};
			MainContrl c= new MainContrl(m);
			
			for (int i = 0; i < boutons.length; i++) {
			    boutons[i].setActionCommand(nomsInterfaces[i]); // Sert à identifier l'action
			    boutons[i].addActionListener(c);      // Ajoute le contrôleur
			}
	
			
			quitterP.addActionListener(e -> dispose());
			

		 this.show();
		 this.pack();
		
		
		
		
		
	}


	}
	
	
		

