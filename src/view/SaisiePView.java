package view;

import javax.swing.*;
import java.awt.*;
import model.Citoyen;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class SaisiePView extends JFrame {
	
	Citoyen personne;
	JLabel SP= new JLabel ("Saisie une personne ");
	JLabel date;
	JTextField nom =new JTextField("Entrez le nom ");
	JTextField prenom =new JTextField("Entrez le prenom");
	JTextField dateNaissance =new JTextField("Entrez le nom ");
	ButtonGroup grp = new ButtonGroup();
	JRadioButton r1 = new JRadioButton("Femme"); 
	JRadioButton r2 = new JRadioButton("Homme");
	JPanel centerPanel = new JPanel() ;
	JPanel topPanel = new JPanel() ;
	JPanel bottomPanel = new JPanel() ;
	JButton ajouter = new JButton ("Ajouter");
	JButton quitter = new JButton ("Quitter");
	
	
	
	 public static String getDateHeureActuelle() {
	        LocalDateTime maintenant = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	        return maintenant.format(formatter);
	    }

	  public SaisiePView ()
	  {
		  
		  setPreferredSize(new Dimension(600,450));
		  this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		  
		  SP.setFont(new Font("Arial", Font.BOLD, 18));
		  date= new JLabel (getDateHeureActuelle());
		  date.setFont(new Font("Arial", Font.BOLD, 14));
		  topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		  topPanel.add(Box.createHorizontalGlue()); 
		  topPanel.add(SP);
		  topPanel.add(Box.createRigidArea(new Dimension(100, 0)));
		  topPanel.add(date);
		  topPanel.add(Box.createHorizontalGlue()); 
		  
		  
		  r2.setSelected(true);
		  grp.add(r1);
		  grp.add(r2);
		  centerPanel.setLayout(new GridLayout (3,2, 10, 20));
		  centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
		  centerPanel.add(new JLabel("Nom : "));
		  centerPanel.add(nom);
		  centerPanel.add(new JLabel("Prenomom : "));
		  centerPanel.add(prenom);
		  centerPanel.add(new JLabel("Sexe : "));
		  JPanel sexePanel = new JPanel();
		  sexePanel.add(r1);
		  sexePanel.add(r2);
		  centerPanel.add(sexePanel);
		  
		  for (Component comp : centerPanel.getComponents()) {
			    comp.setFont(new Font("Arial", Font.BOLD, 14));
			}

		  bottomPanel.setLayout(new FlowLayout (FlowLayout.CENTER,20,10));
		  bottomPanel.add(ajouter);
		  bottomPanel.add(quitter);
		  ajouter.setPreferredSize(new Dimension(120,30));
		  quitter.setPreferredSize(new Dimension(120,30));
		  ajouter.setFont(new Font("Arial", Font.BOLD, 12)); 
		  ajouter.setBackground(new Color(115,115,115)); 
		  ajouter.setForeground(Color.WHITE);
		  quitter.setFont(new Font("Arial", Font.BOLD, 12)); 
		  quitter.setBackground(Color.RED); 
		  quitter.setForeground(Color.WHITE);
		  
		  
		  //
			getContentPane().add(Box.createRigidArea(new Dimension(0, 30))); 
			getContentPane().add(topPanel);
			getContentPane().add(Box.createRigidArea(new Dimension(0, 30))); 
			getContentPane().add(centerPanel);
			getContentPane().add(Box.createRigidArea(new Dimension(0, 50))); 
			getContentPane().add(bottomPanel);
		  

			 this.show();
			 this.pack();
			
		  
		  
	  }
	
}
