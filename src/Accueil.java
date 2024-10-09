import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Accueil extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
        @SuppressWarnings("unused")
		private JButton b1,b2,b3,b4,b5,b6,b7,b8;

	public static void main(String[] args) {
            new Accueil().setVisible(true);
	}
        
        public Accueil() {
	
            setBounds(200, 0, 450, 660);
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);
            contentPane.setBackground(new Color(0, 0, 0, 2));
            Font font1 = new Font("SansSerif", Font.BOLD, 10);
        
            JLabel l1 = new JLabel("Gestion de bibliothéque");
            l1.setForeground(new Color(104, 151, 202));
            l1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
            l1.setBounds(60, 0, 701, 50);
            contentPane.add(l1);

            JLabel l2 = new JLabel("");
            l2.setVerticalAlignment(SwingConstants.TOP);
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
            Image i2 = i1.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            l2 = new JLabel(i3);
            l2.setBounds(40, 20, 120, 120);
            contentPane.add(l2);

            JLabel l3 = new JLabel("");
            ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
            Image i5 = i4.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);
            l3 = new JLabel(i6);
            l3.setBounds(40, 100, 120, 120);
            contentPane.add(l3);

            JLabel l4 = new JLabel("");
            ImageIcon i7  = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.png"));
            Image i8 = i7.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
            ImageIcon i9 = new ImageIcon(i8);
            l4 = new JLabel(i9);
            l4.setBounds(45, 180, 120, 120);
            contentPane.add(l4);
            
            JLabel ll4 = new JLabel("");
            ImageIcon ii7  = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.png"));
            Image ii8 = ii7.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
            ImageIcon ii9 = new ImageIcon(ii8);
            ll4 = new JLabel(ii9);
            ll4.setBounds(40, 260, 120, 120);
            contentPane.add(ll4);
            
           

            b1 = new JButton("Ajouter Livre");
            b1.addActionListener(this);
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.setBounds(200, 70, 109, 44);
            b1.setFont(font1);
            contentPane.add(b1);

           

            b3 = new JButton("Ajouter Etudiant");
            b3.addActionListener(this);
            b3.setBackground(Color.BLACK);
            b3.setForeground(Color.WHITE);
            b3.setBounds(200, 230, 120, 44);
            b3.setFont(font1);
            contentPane.add(b3);

            b7 = new JButton("Etudiant Details");
            b7.addActionListener(this);
            b7.setBackground(Color.BLACK);
            b7.setForeground(Color.WHITE);
            b7.setBounds(200, 310, 120, 44);
            b7.setFont(font1);
            contentPane.add(b7);
            
            b8 = new JButton("Livre Details");
            b8.addActionListener(this);
            b8.setBackground(Color.BLACK);
            b8.setForeground(Color.WHITE);
            b8.setBounds(200, 150, 120, 44);
            b8.setFont(font1);
            contentPane.add(b8);
            
            JPanel panel = new JPanel();
           
            panel.setBackground(Color.BLACK);
            contentPane.add(panel);

            b4 = new JButton("Issue Book");
            b4.addActionListener(this);
            b4.setBackground(Color.BLACK);
            b4.setForeground(Color.WHITE);
            b4.setBounds(200, 470, 143, 41);
            contentPane.add(b4);

            b5 = new JButton("Return Book");
            b5.addActionListener(this);
            b5.setBackground(Color.BLACK);
            b5.setForeground(Color.WHITE);
            b5.setBounds(200, 550, 159, 41);
            contentPane.add(b5);


            JLabel l5 = new JLabel("");
            ImageIcon i10  = new ImageIcon(ClassLoader.getSystemResource("icons/read.png"));
            Image i11 = i10.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
            ImageIcon i12 = new ImageIcon(i11);
            l5 = new JLabel(i12);
            l5.setBounds(40, 420, 120, 120);
            contentPane.add(l5);

            JLabel l6 = new JLabel("");
            ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.png"));
            Image i17 = i13.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
            ImageIcon i18 = new ImageIcon(i17);
            l6 = new JLabel(i18);
            l6.setBounds(40, 500, 120, 120);
            contentPane.add(l6);


           
	}
        
        
        public void actionPerformed(ActionEvent ae){
           
            if(ae.getSource() == b1){
                this.setVisible(false);
                new AjoutLivre().setVisible(true);
            }
            
            if(ae.getSource() == b3){
                this.setVisible(false);
                new Ajoutuser().setVisible(true);
            }
            if(ae.getSource() == b4){
                this.setVisible(false);
                new Issuelivre().setVisible(true);
            }
            if(ae.getSource() == b5){
                this.setVisible(false);
                new Returnlivre().setVisible(true);
            
            }
            
            if(ae.getSource() == b7){
                this.setVisible(false);
                new Detailuser().setVisible(true);
            
            }
            if(ae.getSource() == b8){
                this.setVisible(false);
                new Detaillivre().setVisible(true);
            
            }
            
        }
}
