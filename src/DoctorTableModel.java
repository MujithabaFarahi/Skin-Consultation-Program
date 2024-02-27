import javax.swing.table.AbstractTableModel;


public class DoctorTableModel extends AbstractTableModel {
    public Doctor[] list;
    private String[] columnNames = { "Name",  "Surname",  "DateOfBirth",  "MobileNumber","MedicalLicenceNumber", "Specialisation"};


    public DoctorTableModel(Doctor[] doctorList){
        this.list=doctorList;
    }



    @Override
    public int getRowCount() {
        return list.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if(list[rowIndex] != null){
            if (columnIndex == 0) {
                temp =list[rowIndex].getName();
            }

            else if (columnIndex == 1) {
                temp = list[rowIndex].getSurname();
            }
            else if (columnIndex == 2) {
                temp = list[rowIndex].getDateOfBirth();
            }
            else if (columnIndex == 3) {
                temp = list[rowIndex].getMobileNumber();
            }
            else if (columnIndex ==4) {
                temp = list[rowIndex].getMedicalLicenseNo();
            }
            else if (columnIndex == 5) {
                temp = list[rowIndex].getSpecialization();
            }
        }



        return temp;
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }
}

