import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class JTableWithEventHandling extends JFrame {

    private JTable jTable;
    private DefaultTableModel tableModel;

    public JTableWithEventHandling() {
        setTitle("JTable with Event Handling");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a DefaultTableModel with some data
        String[] columnNames = {"ID", "Name", "Age"};
        Object[][] data = {
                {1, "John", 25},
                {2, "Jane", 30},
                {3, "Doe", 22}
        };

        tableModel = new DefaultTableModel(data, columnNames);

        // Create a JTable with the DefaultTableModel
        jTable = new JTable(tableModel);

        // Add the JTable to a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(jTable);
        getContentPane().add(scrollPane);

        // Add a ListSelectionListener to detect row selection
        ListSelectionModel selectionModel = jTable.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable.getSelectedRow();
                    if (selectedRow != -1) {
                        // Get data from the selected row
                        Object id = jTable.getValueAt(selectedRow, 0);
                        Object name = jTable.getValueAt(selectedRow, 1);
                        Object age = jTable.getValueAt(selectedRow, 2);

                        // Display the selected data (you can modify this part)
                        System.out.println("Selected Row: " + selectedRow);
                        System.out.println("ID: " + id);
                        System.out.println("Name: " + name);
                        System.out.println("Age: " + age);
                    }
                //}
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JTableWithEventHandling example = new JTableWithEventHandling();
            example.setVisible(true);
        });
    }
}