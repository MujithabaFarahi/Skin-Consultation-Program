import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageOne extends JFrame implements ActionListener{
    JButton button1;
    JButton button2;


    public PageOne() {

        JLabel labelHead = new JLabel("WESTMINSTER CONSULTATION CENTER");
        labelHead.setForeground(Color.BLACK);
        labelHead.setBounds(400, 50, 600, 50);
        labelHead.setFont(new Font(null, Font.BOLD, 27));
        add(labelHead);

        ImageIcon imageIcon=new ImageIcon("Photo/imgdoc.png");
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(400, 210,  Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        JLabel lblPic = new JLabel(imageIcon);
        lblPic.setBounds(700,250,400,210);
        add(lblPic);


        button1 = new JButton("Book Consultation");
        button1.setBounds(450, 270, 240,70);
        button1.setFont(new Font(null,Font.BOLD,20));
        add(button1);
        button1.addActionListener(this);

        button2 = new JButton("Doctor Table");
        button2.setBounds(450, 370, 240,70);
        button2.setFont(new Font(null,Font.BOLD,20));
        add(button2);
        button2.addActionListener(this);

        setTitle("Consultation Center");
        getContentPane().setBackground(new Color(116, 56, 73));
        setSize(1400, 900);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1){
            Form form = new Form();
        }

        if (e.getSource() == button2){
            DocTable table = new DocTable(WestminsterSkinConsultationManager.doctors);
        }

    }
}
