import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Form extends JFrame implements ActionListener {
    String[] docNames = new String[WestminsterSkinConsultationManager.doctors.length];
    static Consultation[] cons = new Consultation[1];
    static Patient[] pats = new Patient[1];


    JButton buttonSubmit;
    JButton button2;

    JTextField field1,field2,field3,field4,field5,field7,field9,field10;
    JComboBox<String> field8;
    JTextArea fieldNote;

    JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl7,lbl8,lbl9,lbl10;



    public Form()  {
        JPanel panel1 = new JPanel(new GridLayout(9,3,10,10));
        panel1.setBounds(400,150,750,300);
        panel1.setBackground(new Color(116,56,73));

        JLabel labelHead = new JLabel("WESTMINSTER CONSULTATION CENTER");
        labelHead.setForeground(Color.BLACK);
        labelHead.setBounds(400,50,600,50);
        labelHead.setFont(new Font(null,Font.BOLD,27));
        add(labelHead);


        JLabel label1 = new JLabel("                Name : ");
        label1.setForeground(Color.white);
        lbl1 = new JLabel("INVALID NAME");
        lbl1.setVisible(false);
        lbl1.setForeground(Color.red);
        field1 = new JTextField();

        panel1.add(label1);
        panel1.add(field1);
        panel1.add(lbl1);

        JLabel label2 = new JLabel("                Surname : ");
        label2.setForeground(Color.white);
        field2 = new JTextField();
        lbl2 = new JLabel("INVALID SURNAME");
        lbl2.setVisible(false);
        lbl2.setForeground(Color.red);
        panel1.add(label2);
        panel1.add(field2);
        panel1.add(lbl2);


        JLabel label3 = new JLabel("                Date of Birth (dd/MM/yyyy) : ");
        label3.setForeground(Color.white);
        field3 = new JTextField();
        lbl3 = new JLabel("INVALID DATE");
        lbl3.setVisible(false);
        lbl3.setForeground(Color.red);
        panel1.add(label3);
        panel1.add(field3);
        panel1.add(lbl3);

        JLabel label4 = new JLabel("                Mobile Number : ");
        label4.setForeground(Color.white);
        field4 = new JTextField();
        lbl4 = new JLabel("INVALID NUMBER");
        lbl4.setVisible(false);
        lbl4.setForeground(Color.red);
        panel1.add(label4);
        panel1.add(field4);
        panel1.add(lbl4);

        JLabel label5 = new JLabel("                Patient ID : ");
        label5.setForeground(Color.white);
        field5 = new JTextField();
        lbl5 = new JLabel("INVALID ID");
        lbl5.setVisible(false);
        lbl5.setForeground(Color.red);
        panel1.add(label5);
        panel1.add(field5);
        panel1.add(lbl5);

        JLabel label7 = new JLabel("                Consultation Date (dd/MM/yyyy): ");
        label7.setForeground(Color.white);
        field7 = new JTextField();
        lbl7 = new JLabel("INVALID DATE");
        lbl7.setVisible(false);
        lbl7.setForeground(Color.red);
        panel1.add(label7);
        panel1.add(field7);
        panel1.add(lbl7);

        int j =0;

        for (int i = 0; i < WestminsterSkinConsultationManager.doctors.length; i++) {
            if (WestminsterSkinConsultationManager.doctors[i] != null) {
                docNames[j] = WestminsterSkinConsultationManager.doctors[i].getName();
                j++;
            }
        }

        JLabel label8 = new JLabel("                Consultation Doctor : ");
        label8.setForeground(Color.white);
        field8 = new JComboBox<>(docNames);
        lbl8 = new JLabel("");
        lbl8.setVisible(false);
        lbl8.setForeground(Color.red);

        panel1.add(label8);
        panel1.add(field8);
        panel1.add(lbl8);

        JLabel label9 = new JLabel("                Consultation Start Time (HH:MM) : ");
        label9.setForeground(Color.white);
        field9 = new JTextField();
        lbl9 = new JLabel("INVALID TIME");
        lbl9.setVisible(false);
        lbl9.setForeground(Color.red);
        panel1.add(label9);
        panel1.add(field9);
        panel1.add(lbl9);

        JLabel label10 = new JLabel("                Consultation End Time (HH:MM) : ");
        label10.setForeground(Color.white);
        field10 = new JTextField();
        lbl10 = new JLabel("INVALID TIME");
        lbl10.setVisible(false);
        lbl10.setForeground(Color.red);
        panel1.add(label10);
        panel1.add(field10);
        panel1.add(lbl10);


        JLabel labelNote = new JLabel("                Notes : ");
        labelNote.setForeground(Color.white);
        labelNote.setBounds(400,460,250,24);
        fieldNote = new JTextArea(10,10);
        fieldNote.setBounds(655,460,240,100);
        add(labelNote);
        add(fieldNote);


        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(815, 590, 80,30);
        add(buttonSubmit);
        buttonSubmit.addActionListener(this);

        button2 = new JButton("Doctor Table");
        button2.setBounds(670, 590, 130,30);
        add(button2);
        button2.addActionListener(this);


        add(panel1);

        setTitle("Consultation Center");
        getContentPane().setBackground(new Color(116,56,73));
        setSize(1400,900);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == buttonSubmit){

            if (field1.getText().equals("") || field2.getText().equals("") || field3.getText().equals("") || field4.getText().equals("") || field5.getText().equals("") || field7.getText().equals("") || field9.getText().equals("") || field10.getText().equals("") || timeFormatChecking(field9.getText())|| dobDateFormatSetting(field3.getText()) || timeFormatChecking(field10.getText()) || dateFormatSetting(field7.getText())) {
                if (field1.getText().equals("")) {
                    lbl1.setVisible(true);//setting it to visible if it is empty.
                } else {
                    lbl1.setVisible(false);
                }
                if (field2.getText().equals("")) {
                    lbl2.setVisible(true);
                } else {
                    lbl2.setVisible(false);
                }
                if (field3.getText().equals("") || dobDateFormatSetting(field3.getText())) {
                    lbl3.setVisible(true);
                } else {
                    lbl3.setVisible(false);
                }
                if (field4.getText().equals("")) {
                    lbl4.setVisible(true);
                } else {
                    lbl4.setVisible(false);
                }
                if (field5.getText().equals("")) {
                    lbl5.setVisible(true);
                } else {
                    lbl5.setVisible(false);
                }
                if (field7.getText().equals("") || dateFormatSetting(field7.getText())) {
                    lbl7.setVisible(true);
                } else {
                    lbl7.setVisible(false);
                }
                if (field9.getText().equals("") || timeFormatChecking(field9.getText())) {
                    lbl9.setVisible(true);
                } else {
                    lbl9.setVisible(false);
                }
                if (field10.getText().equals("") || timeFormatChecking(field10.getText())) {
                    lbl10.setVisible(true);
                } else {
                    lbl10.setVisible(false);
                }
            }
            else {

                lbl1.setVisible(false);
                lbl2.setVisible(false);
                lbl3.setVisible(false);
                lbl4.setVisible(false);
                lbl5.setVisible(false);
                lbl7.setVisible(false);
                lbl9.setVisible(false);
                lbl10.setVisible(false);

                String patientName = field1.getText().toUpperCase(Locale.ROOT);
                String patientSurname = field2.getText().toUpperCase(Locale.ROOT);
                String patientDOB = field3.getText();
                String patientMobileNumber = field4.getText();
                String patientId = field5.getText();
                String consDate = field7.getText();
                String consDoc = Objects.requireNonNull(field8.getSelectedItem()).toString();
                String consStartTime = field9.getText();
                String consEndTime = field10.getText();
                String consNote;
                consNote = fieldNote.getText();


                try {
                    Patient patient1 = new Patient(patientName,patientSurname,patientDOB,patientMobileNumber,patientId);
                    Doctor doc1 = new Doctor();
                    pats[0] = patient1;

                    for (int i = 0; i < 10 ; i++) {
                        if(WestminsterSkinConsultationManager.doctors[i] != null){
                            if(WestminsterSkinConsultationManager.doctors[i].getName().equals(consDoc)){
                                doc1 = WestminsterSkinConsultationManager.doctors[i];
                            }
                        }
                    }
                    SimpleDateFormat sDFormat = new SimpleDateFormat("dd/MM/yyyy");//creating date formatter

                    Date d = sDFormat.parse(consDate);//getting inputs from text field

                    LocalTime st = LocalTime.parse(consStartTime);

                    LocalTime et = LocalTime.parse(consEndTime);

                    if(consNote.equals("")){
                        consNote="No description";
                    }

                    Duration duration = Duration.between(st, et);
                    double timeDifference = duration.toMinutes();

                    double consCost = calculatingCost(timeDifference);


                    Consultation consultation1 = new Consultation(d,st,et,consCost,consNote,doc1,patient1);
                    cons[0]=consultation1;

                    WestminsterSkinConsultationManager.bookedConsultation.add(consultation1);

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                ConsultationAppointment cons1 = new ConsultationAppointment();

            }
        }



        if (e.getSource() == button2){
            DocTable table = new DocTable(WestminsterSkinConsultationManager.doctors);
        }


    }
    public static double calculatingCost(double timeDifference) {//calculating the cost for consultation
        double fee = 0;
        if (timeDifference <= 60) {
            fee = 15;
        } else if (timeDifference > 60) {
            int i = (int) Math.ceil((timeDifference - 60) / 60);
            fee = 15 + i * 25;
        }
        return fee;
    }
    public static boolean timeFormatChecking(String s) {//checking a valid time
        String[] numbers = s.split("");
        try {
            if (Integer.parseInt(numbers[0]) <= 2 && Integer.parseInt(numbers[0]) >= 0 && Integer.parseInt(numbers[3]) >= 0 && Integer.parseInt(numbers[3]) < 6 && numbers[2].equals(":")) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean dobDateFormatSetting(String s) {//checking valid date for date of birth
        String[] dc = s.split("");
        try {
            if (Integer.parseInt(dc[6]) != 2 && Integer.parseInt(dc[6]) !=1) {
                return true;
            } else if (Integer.parseInt(dc[7]) != 0 && Integer.parseInt(dc[7]) != 9 ) {
                return true;
            } else if (Integer.parseInt(dc[9]) <0) {
                return true;
            } else if (Integer.parseInt(dc[9]) <0) {
                return true;
            } else if (!dc[5].equals("/")) {
                return true;
            } else if (Integer.parseInt(dc[3]) != 0 && Integer.parseInt(dc[3]) != 1) {
                return true;
            } else if ((Integer.parseInt(dc[4]) == 1 && (Integer.parseInt(dc[4]) < 0 || Integer.parseInt(dc[4]) > 2))) {
                return true;
            } else if (!dc[2].equals("/")) {
                return true;
            } else if ((Integer.parseInt(dc[0]) < 0 || Integer.parseInt(dc[1]) > 3)) {
                return true;
            } else if ((Integer.parseInt(dc[1]) < 0 || (Integer.parseInt(dc[1]) == 3 && (Integer.parseInt(dc[0]) < 0 || Integer.parseInt(dc[0]) > 1)))) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return true;
        }

    }

    public static boolean dateFormatSetting(String s) {//checking valid date for consultation
        String[] dc = s.split("");
        try {
            if (Integer.parseInt(dc[6]) != 2) {
                return true;
            } else if (Integer.parseInt(dc[7]) != 0) {
                return true;
            } else if (Integer.parseInt(dc[8]) != 2) {
                return true;
            } else if (Integer.parseInt(dc[9]) != 3) {
                return true;
            } else if (!dc[5].equals("/")) {
                return true;
            } else if (Integer.parseInt(dc[3]) != 0 && Integer.parseInt(dc[3]) != 1) {
                return true;
            } else if ((Integer.parseInt(dc[3]) == 1 && (Integer.parseInt(dc[4]) < 0 || Integer.parseInt(dc[4]) > 2))) {
                return true;
            } else if (!dc[2].equals("/")) {
                return true;
            } else if ((Integer.parseInt(dc[0]) < 0 || Integer.parseInt(dc[0]) > 3)) {
                return true;
            } else if ((Integer.parseInt(dc[1]) < 0 || (Integer.parseInt(dc[0]) == 3 && (Integer.parseInt(dc[1]) < 0 || Integer.parseInt(dc[1]) > 1)))) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return true;
        }

    }

}
