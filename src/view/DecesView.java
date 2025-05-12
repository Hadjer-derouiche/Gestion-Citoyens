package view;

import controler.DecesContrl;
import model.Mairie;

import javax.swing.*;
import java.awt.*;

public class DecesView extends JFrame {

    private JTextField champID;
    private JTextField champDateDeces;
    private JButton boutonDeclarer, quitter;
    private JLabel labelTitre, resultat;
    private JPanel topPanel, formPanel, bottomPanel;

    private Mairie mairie;

    public DecesView(Mairie mairie) {
        this.mairie = mairie;

        setTitle("Déclaration d'un décès");
        setPreferredSize(new Dimension(500, 300));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Titre
        topPanel = new JPanel();
        labelTitre = new JLabel("Déclarer un décès");
        labelTitre.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(labelTitre);

        // Formulaire
        formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        formPanel.add(new JLabel("ID du citoyen :"));
        champID = new JTextField(15);
        formPanel.add(champID);

        formPanel.add(new JLabel("Date du décès (yyyy-mm-dd) :"));
        champDateDeces = new JTextField(15);
        formPanel.add(champDateDeces);

        formPanel.add(new JLabel("Résultat :"));
        resultat = new JLabel("");
        resultat.setForeground(Color.BLUE);
        resultat.setFont(new Font("Arial", Font.BOLD, 12));
        formPanel.add(resultat);

        // Boutons
        bottomPanel = new JPanel();
        boutonDeclarer = new JButton("Déclarer Décès");
        quitter = new JButton("Quitter");

        boutonDeclarer.setPreferredSize(new Dimension(150, 30));
        quitter.setPreferredSize(new Dimension(120, 30));

        boutonDeclarer.setFont(new Font("Arial", Font.BOLD, 12));
        quitter.setFont(new Font("Arial", Font.BOLD, 12));

        boutonDeclarer.setBackground(new Color(115, 115, 115));
        boutonDeclarer.setForeground(Color.WHITE);
        quitter.setBackground(Color.RED);
        quitter.setForeground(Color.WHITE);

        bottomPanel.add(boutonDeclarer);
        bottomPanel.add(quitter);

        add(topPanel);
        add(formPanel);
        add(bottomPanel);

        quitter.addActionListener(e -> dispose());

        new DecesContrl(this, mairie);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JTextField getChampID() {
        return champID;
    }

    public JTextField getChampDateDeces() {
        return champDateDeces;
    }

    public JButton getBoutonDeclarer() {
        return boutonDeclarer;
    }

    public JLabel getResultat() {
        return resultat;
    }
}
