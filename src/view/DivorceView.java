package view;

import javax.swing.*;

import controler.DivorceContrl;
import model.Mairie;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DivorceView extends JFrame {
	Mairie mairie;

    JTextField jt1,dateM;
    JButton valider, quitter;
    JLabel labelTitre, labelId1, date,datem,erreur;;
    JPanel topPanel, formPanel, bottomPanel;

    public static String getDateHeureActuelle() {
        LocalDateTime maintenant = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return maintenant.format(formatter);
    }

    public DivorceView(Mairie m) {
    	
    	mairie =m;
    	
        setTitle("Formulaire de Divorce");
        setPreferredSize(new Dimension(550, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

       
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        labelTitre = new JLabel("Formulaire de Divorce");
        labelTitre.setFont(new Font("Arial", Font.BOLD, 18));

        date = new JLabel(getDateHeureActuelle());
        date.setFont(new Font("Arial", Font.BOLD, 14));

        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(labelTitre);
        topPanel.add(Box.createRigidArea(new Dimension(100, 0)));
        topPanel.add(date);
        topPanel.add(Box.createHorizontalGlue());

        // ===== Formulaire : champ identifiant =====
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 2, 20, 20));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        labelId1 = new JLabel("Identifiant d'act de mariage :");
        date= new JLabel("Date de divorce ");
      
        
        jt1 = new JTextField(15);
        dateM = new JTextField(15);
        formPanel.add(labelId1);
        formPanel.add(jt1);
        formPanel.add(date);
        formPanel.add(dateM);
        
        for (Component comp : formPanel.getComponents()) {
		    comp.setFont(new Font("Arial", Font.BOLD, 14));
		}

        // ===== Bas de page : boutons =====
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        valider = new JButton("Valider");
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

        
        erreur=new JLabel("");
        erreur.setFont(new Font("Arial", Font.BOLD, 14));
        erreur.setAlignmentX(Component.CENTER_ALIGNMENT);
        erreur.setForeground(Color.RED); 
        erreur.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        // ===== Ajout des panels à la fenêtre =====
        getContentPane().add(Box.createRigidArea(new Dimension(0, 20)));
        getContentPane().add(topPanel);
        getContentPane().add(Box.createRigidArea(new Dimension(0, 30)));
        getContentPane().add(formPanel);
        getContentPane().add(erreur);
        getContentPane().add(bottomPanel);

      

        quitter.addActionListener(e -> dispose());
        
        DivorceContrl c= new DivorceContrl(jt1,dateM,erreur,mairie);
		valider.addActionListener(c);

        pack();
        setLocationRelativeTo(null); // centre la fenêtre
        setVisible(true);
    }

    
    
}
