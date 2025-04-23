package view;

import javax.swing.*;
import java.awt.*;
import model.ActeMariage;
import model.Mairie;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MariageView extends JFrame {
	Mairie mairie;

    JTextField jt1, jt2, dateM;
    JButton valider, quitter;
    JLabel labelTitre, labelHomme, labelFemme, date,datem;
    JPanel mainPanel, formPanel, topPanel, bottomPanel;
    ActeMariage acteMariage;

    public static String getDateHeureActuelle() {
        LocalDateTime maintenant = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return maintenant.format(formatter);
    }



	public MariageView(Mairie m) {
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

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 2, 20, 20));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        labelHomme = new JLabel("ID de marié :");
        labelFemme = new JLabel("ID de la mariée :");
        datem = new JLabel("Date de mariage");
        labelHomme.setFont(new Font("Arial", Font.BOLD, 14));
        labelFemme.setFont(new Font("Arial", Font.BOLD, 14));
        datem.setFont(new Font("Arial", Font.BOLD, 14));

        jt1 = new JTextField(15);
        jt2 = new JTextField(15);
        dateM= new JTextField(15);

        formPanel.add(labelHomme);
        formPanel.add(jt1);
        formPanel.add(labelFemme);
        formPanel.add(jt2);
        formPanel.add(datem);
        formPanel.add(dateM);

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

        getContentPane().add(Box.createRigidArea(new Dimension(0, 20)));
        getContentPane().add(topPanel);
        getContentPane().add(Box.createRigidArea(new Dimension(0, 30)));
        getContentPane().add(formPanel);
        getContentPane().add(bottomPanel);
        
        
        quitter.addActionListener(e -> dispose());
        
        

        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
	}
}
