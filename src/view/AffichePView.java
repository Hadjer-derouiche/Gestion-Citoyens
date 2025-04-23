package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import model.Citoyen;
import model.Mairie;

public class AffichePView extends JFrame {
    private final Mairie mairie;
    private final JTable table;

    public AffichePView(Mairie mairie) {
        super("Liste des citoyens");  // titre de la fenêtre
        this.mairie = mairie;

        // 1. Créer le modèle de table avec les bonnes colonnes
        String[] entetes = { "Id","Nom", "Prénom", "Date de naissance", "Sexe" };
        DefaultTableModel model = new DefaultTableModel(entetes, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // lecture seule
            }
        };

        // 2. Remplir le modèle avec les données de la mairie
        List<Citoyen> liste = mairie.getCitoyens();  // méthode d’accès à la liste
        for (Citoyen c : liste) {
            Object[] ligne = {
            	c.getId(),
                c.getNom(),
                c.getPrenom(),
                c.getDateNaiss().toString(),  // LocalDate -> String
                c instanceof model.Femme ? "Femme" : "Homme"
            };
            model.addRow(ligne);
        }

        // 3. Instancier le JTable avec notre modèle
        table = new JTable(model);
        table.setFillsViewportHeight(true);

        // 4. Mettre dans un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // 5. Configurer la fenêtre (this), pas une nouvelle JFrame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);  // centré
        this.add(scrollPane);
        
        pack();
        setLocationRelativeTo(null); // centre la fenêtre
        setVisible(true);
    }

   
}
