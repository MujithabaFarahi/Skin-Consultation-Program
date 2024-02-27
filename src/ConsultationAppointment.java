import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class ConsultationAppointment extends JFrame {

    public ConsultationAppointment(){



        JLabel labelHead1 = new JLabel("WESTMINSTER CONSULTATION CENTER");
        labelHead1.setForeground(Color.BLACK);
        labelHead1.setBounds(50, 40, 600, 50);
        labelHead1.setFont(new Font(null, Font.BOLD, 27));
        add(labelHead1);

        JLabel header1=new JLabel("Appointment");
        header1.setForeground(Color.BLACK);
        header1.setBounds(270,100,350,30);
        header1.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(header1);

        JPanel panel2=new JPanel(new GridLayout(9,2,0,5));
        panel2.setBounds(110,150,600,400);
        panel2.setBackground(new Color(116, 56, 73));

        JLabel label11=new JLabel("            Name: ");
        label11.setForeground(Color.white);
        JLabel label12=new JLabel(Form.cons[0].getPatient().getName());
        label12.setForeground(Color.white);
        panel2.add(label11);
        panel2.add(label12);

        JLabel label13=new JLabel("            Surname: ");
        label13.setForeground(Color.white);
        JLabel label14=new JLabel(Form.cons[0].getPatient().getSurname());
        label14.setForeground(Color.white);
        panel2.add(label13);
        panel2.add(label14);

        JLabel label15=new JLabel("            Date of birth: ");
        label15.setForeground(Color.white);
        JLabel label16=new JLabel(Form.cons[0].getPatient().getDateOfBirth());
        label16.setForeground(Color.white);
        panel2.add(label15);
        panel2.add(label16);


        JLabel label19=new JLabel("            Mobile number: ");
        label19.setForeground(Color.white);
        JLabel label20=new JLabel(Form.pats[0].getMobileNumber());
        label20.setForeground(Color.white);
        panel2.add(label19);
        panel2.add(label20);

        JLabel label21=new JLabel("            Cost:");
        label21.setForeground(Color.white);
        JLabel label22=new JLabel("£" + Form.cons[0].getCost());
        label22.setForeground(Color.white);
        panel2.add(label21);
        panel2.add(label22);

        SimpleDateFormat sDFormat = new SimpleDateFormat("dd/MM/yyyy");

        JLabel label23=new JLabel("            Consultation Date:");
        label23.setForeground(Color.white);
        JLabel label24=new JLabel(sDFormat.format((Form.cons[0].getConsultationDate())));
        label24.setForeground(Color.white);
        panel2.add(label23);
        panel2.add(label24);

        JLabel label25=new JLabel("            Consultation Time:");
        label25.setForeground(Color.white);
        JLabel label26=new JLabel();
        label26.setText((Form.cons[0].getStartTime()) + " - " + Form.cons[0].getEndTime());
        label26.setForeground(Color.white);
        panel2.add(label25);
        panel2.add(label26);

        JLabel label27=new JLabel("            Consultation Doctor Name:");
        label27.setForeground(Color.white);
        JLabel label28=new JLabel(String.valueOf(Form.cons[0].getDoctor().getName() + " " + Form.cons[0].getDoctor().getSurname() ));
        label28.setForeground(Color.white);
        panel2.add(label27);
        panel2.add(label28);

        JLabel header2=new JLabel("           Consultation Booked Successfully");
        header2.setForeground(Color.BLACK);
        header2.setBounds(115,570,350,30);
        header2.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(header2);

        add(panel2);

        setTitle("Consultation Center");
        setSize(700,700);
        getContentPane().setBackground(new Color(116, 56, 73));
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
