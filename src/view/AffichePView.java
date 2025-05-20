package view;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

// Imports de ton modèle
import model.Citoyen;
import model.Mairie;
import model.Femme;


public class AffichePView extends JFrame {
    private final Mairie mairie;
    private final JTable table;
    private final DefaultTableModel model;  // <-- nouveau champ

    public AffichePView(Mairie mairie) {
        super("Liste des citoyens");
        this.mairie = mairie;

        String[] entetes = { "Id","Nom", "Prénom", "Date de naissance", "Sexe" };
        model = new DefaultTableModel(entetes, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.add(scrollPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Charge initialement la table
        rafraichirTable();
    }

    // 🔁 Cette méthode met à jour la table à partir de la liste dans mairie
    public void rafraichirTable() {
        model.setRowCount(0);  // Vide la table
        List<Citoyen> liste = mairie.getCitoyens();
        for (Citoyen c : liste) {
            Object[] ligne = {
                c.getId(),
                c.getNom(),
                c.getPrenom(),
                c.getDateNaiss().toString(),
                c instanceof model.Femme ? "Femme" : "Homme"
            };
            model.addRow(ligne);
        }
    }
}
