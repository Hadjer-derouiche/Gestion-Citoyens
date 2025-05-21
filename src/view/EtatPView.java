package view;

import javax.swing.*;
import java.awt.*;
import controler.EtatPContrl;
import model.Mairie;

public class EtatPView extends JFrame {

    JTextField champID;
    JButton rechercher, quitter;
    JLabel labelTitre, labelID;
    JPanel topPanel, formPanel, bottomPanel;
    JPanel resultatPanel;


    public EtatPView(Mairie mairie) {
        setTitle("État d'une personne");
        setPreferredSize(new Dimension(550, 400));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        topPanel = new JPanel();
        labelTitre = new JLabel("Rechercher l'état d'une personne");
        labelTitre.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(labelTitre);

        formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        labelID = new JLabel("ID de la personne :");
        champID = new JTextField(15);

        resultatPanel = new JPanel();
        resultatPanel.setLayout(new BoxLayout(resultatPanel, BoxLayout.Y_AXIS));

        // Puis, crée un JScrollPane pour contenir resultatPanel
        JScrollPane scrollPane = new JScrollPane(resultatPanel);
        scrollPane.setPreferredSize(new Dimension(500, 200));



        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        formPanel.add(labelID);
        formPanel.add(champID);
        formPanel.add(new JLabel("Résultat :"));
        formPanel.add(resultatPanel);

        bottomPanel = new JPanel();
        rechercher = new JButton("Rechercher");
        quitter = new JButton("Quitter");

        bottomPanel.add(rechercher);
        bottomPanel.add(quitter);
        
        rechercher.setPreferredSize(new Dimension(120, 30));
        quitter.setPreferredSize(new Dimension(120, 30));

        rechercher.setFont(new Font("Arial", Font.BOLD, 12));
        quitter.setFont(new Font("Arial", Font.BOLD, 12));

        rechercher.setBackground(new Color(115, 115, 115));
        rechercher.setForeground(Color.WHITE);
        quitter.setBackground(Color.RED);
        quitter.setForeground(Color.WHITE);
        
        //resultat.setForeground(new Color(0, 102, 204)); 
        //resultat.setFont(new Font("SansSerif", Font.PLAIN, 14));

   

        add(topPanel);
        add(formPanel);
        add(bottomPanel);

        quitter.addActionListener(e -> dispose());

        EtatPContrl controleur = new EtatPContrl(champID, resultatPanel, mairie);
        rechercher.addActionListener(controleur);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
