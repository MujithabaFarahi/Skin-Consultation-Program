import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocTable extends JFrame {

    JTable myTable;
    DoctorTableModel tableModel;
    Doctor[] list;

    public DocTable(Doctor[] list) {
        super("Skin Consult");
        this.list = list;
        tableModel = new DoctorTableModel(list);
        myTable = new JTable(tableModel);
        setBounds(10, 10, 400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myTable.setAutoCreateRowSorter(true);

        myTable.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            Color originalColor = null;

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


                return renderer;
            }
        });
        JTableHeader tableHeader = myTable.getTableHeader();
        tableHeader.setBackground(new Color(36, 37, 38));
        tableHeader.setForeground(Color.white);
        tableHeader.setFont(new Font("Arial", Font.BOLD, 13));


        JScrollPane scrollPane = new JScrollPane(myTable);

        //styling
        myTable.setGridColor(Color.black);
        myTable.setBackground(new Color(92, 102, 114));
        myTable.setFont(new Font("Arial",Font.ITALIC, 13));
        myTable.setForeground(Color.white);




        setTitle("Consultation Center");
        scrollPane.setBackground(new Color(116,172,223));
        add(scrollPane);
        getContentPane().setBackground(new Color(116,172,223));
        setSize(900, 220);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    private  class  DataHandler  implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {



        }
    }
}
