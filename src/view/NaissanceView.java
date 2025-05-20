package view;

import javax.swing.*;

import controler.MariageContrl;
import controler.NaissanceContrl;

import java.awt.*;
import model.ActeNaissance;
import model.Mairie;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NaissanceView extends JFrame {
	
	Mairie mairie;

    JTextField jt1, jt2;
    JButton valider, quitter;
    JLabel labelTitre, labelHomme, labelFemme, date,erreur;
    JPanel mainPanel, formPanel, topPanel, bottomPanel;
    JTextField nom =new JTextField(15);
	JTextField prenom =new JTextField(15);
	JTextField dateNaissance =new JTextField(15);
	ButtonGroup grp = new ButtonGroup();
	JRadioButton r1 = new JRadioButton("Femme"); 
	JRadioButton r2 = new JRadioButton("Homme");


    public static String getDateHeureActuelle() {
        LocalDateTime maintenant = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return maintenant.format(formatter);
    }

    public NaissanceView (Mairie m,AffichePView afficheView) {
    	mairie=m;
        
        setTitle("Formulaire de Naissance");
        setPreferredSize(new Dimension(600, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        labelTitre = new JLabel("Formulaire de Naissance");
        labelTitre.setFont(new Font("Arial", Font.BOLD, 18));

        date = new JLabel(getDateHeureActuelle());
        date.setFont(new Font("Arial", Font.BOLD, 14));

        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(labelTitre);
        topPanel.add(Box.createRigidArea(new Dimension(100, 0)));
        topPanel.add(date);
        topPanel.add(Box.createHorizontalGlue());

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 20, 20));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        labelHomme = new JLabel("ID de pére :");
        labelFemme = new JLabel("ID de la mére :");
    

        jt1 = new JTextField(15);
        jt2 = new JTextField(15);

        formPanel.add(labelHomme);
        formPanel.add(jt1);
        formPanel.add(labelFemme);
        formPanel.add(jt2);
        
        r2.setSelected(true);
		  grp.add(r1);
		  grp.add(r2);
		  
		  formPanel.add(new JLabel("Nom : "));
		  formPanel.add(nom);
		  formPanel.add(new JLabel("Prenomom : "));
		  formPanel.add(prenom);
		  formPanel.add(new JLabel("Date de naissance : "));
		  formPanel.add(dateNaissance);
		  formPanel.add(new JLabel("Sexe : "));
		  JPanel sexePanel = new JPanel();
		  sexePanel.add(r1);
		  sexePanel.add(r2);
		  formPanel.add(sexePanel);
		  
		  for (Component comp : formPanel.getComponents()) {
			    comp.setFont(new Font("Arial", Font.BOLD, 14));
			}


        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        valider = new JButton("Ajouter");
        quitter = new JButton("Quitter");

        valider.setPreferredSize(new Dimension(120, 30));
        quitter.setPreferredSize(new Dimension(120, 30));

        valider.setFont(new Font("Arial", Font.BOLD, 12));
        quitter.setFont(new Font("Arial", Font.BOLD, 12));

        valider.setBackground(new Color(115, 115, 115));
        valider.setForeground(Color.WHITE);
        quitter.setBackground(Color.RED);
        quitter.setForeground(Color.WHITE);

        bottomPanel.add(valider);
        bottomPanel.add(quitter);
        erreur=new JLabel();

        getContentPane().add(Box.createRigidArea(new Dimension(0, 20)));
        getContentPane().add(topPanel);
        getContentPane().add(Box.createRigidArea(new Dimension(0, 30)));
        getContentPane().add(formPanel);
        getContentPane().add(erreur);
        getContentPane().add(bottomPanel);
        
        
        NaissanceContrl c= new NaissanceContrl(jt1,jt2,nom, prenom,dateNaissance,erreur,r1,r2,mairie,afficheView);
      	valider.addActionListener(c);
        
        quitter.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
    }
}
