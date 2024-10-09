import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AjoutLivre extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6;
    private JButton b1,b2;
    @SuppressWarnings("rawtypes")
	JComboBox comboBox;
        
    public static void main(String[] args) {
	new AjoutLivre().setVisible(true);
    }

    public void random() {
        Random rd = new Random();
	t1.setText("" + rd.nextInt(1000 + 1));
    }
    
    

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public AjoutLivre() {
    	
    	 setBounds(500, 200, 500, 280);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel l1 = new JLabel("NOM");
	l1.setForeground(new Color(47, 79, 79));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(10, 10, 90, 22);
	contentPane.add(l1);

	JLabel l2 = new JLabel("AUTEUR");
	l2.setForeground(new Color(47, 79, 79));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(10, 35, 90, 22);
	contentPane.add(l2);

	JLabel l3 = new JLabel("PUBLIER");
	l3.setForeground(new Color(47, 79, 79));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(10, 60, 90, 22);
	contentPane.add(l3);

	JLabel l4 = new JLabel("PRIX");
	l4.setForeground(new Color(47, 79, 79));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(10, 85, 90, 22);
	contentPane.add(l4);

	JLabel l5 = new JLabel("NB PAGES");
	l5.setForeground(new Color(47, 79, 79));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(10, 110, 90, 22);
	contentPane.add(l5);

	JLabel l6 = new JLabel("ID LIVRE");
	l6.setForeground(new Color(47, 79, 79));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(10, 135, 90, 22);
	l6.setVisible(false);
	contentPane.add(l6);

	JLabel l7 = new JLabel("EDITION");
	l7.setForeground(new Color(47, 79, 79));
	l7.setFont(new Font("Tahoma", Font.BOLD, 14));
	l7.setBounds(10, 135, 90, 22);
	contentPane.add(l7);

	t1 = new JTextField();
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	
	t1.setBounds(389, 104, 198, 20);
	t1.setVisible(false);
	contentPane.add(t1);
	t1.setColumns(10);
	
	
	t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t2.setColumns(10);
	t2.setBounds(130, 10, 198, 20);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(130, 35, 198, 20);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setForeground(new Color(47, 79, 79));
	t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t4.setColumns(10);
	t4.setBounds(130, 60, 198, 20);
	contentPane.add(t4);

        t5 = new JTextField();
	t5.setForeground(new Color(47, 79, 79));
	t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t5.setColumns(10);
	t5.setBounds(130, 85, 198, 20);
	contentPane.add(t5);

	t6 = new JTextField();
	t6.setForeground(new Color(47, 79, 79));
	t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t6.setColumns(10);
	t6.setBounds(130, 110, 198, 20);
	contentPane.add(t6);

	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
	comboBox.setBounds(130, 135, 194, 20);
	contentPane.add(comboBox);

        b1 = new JButton("Ajouter");
	b1.addActionListener(this);
	b1.setBorder(new CompoundBorder(new LineBorder(Color.WHITE), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b1.setBounds(180, 180, 100, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Retourner");
	b2.addActionListener(this);
	b2.setBorder(new CompoundBorder(new LineBorder(Color.WHITE), null));
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b2.setBounds(50, 180, 108, 33);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
	
	contentPane.add(b2);

	 JLabel test = new JLabel("");
	 test.setVerticalAlignment(SwingConstants.TOP);
     ImageIcon test_i  = new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
     Image test_i2 = test_i.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
     ImageIcon test_i3= new ImageIcon(test_i2);
     test = new JLabel(test_i3);
     test.setBounds(320, 50, 159, 152);
     contentPane.add(test);
       
        contentPane.setBackground(Color.WHITE);
	random();
	

    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "insert into book ( book_id, name, auteur, publier, edition, prix, nb_pages) values ( ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t1.getText());
		st.setString(2, t2.getText());
		st.setString(3, t3.getText());
		st.setString(4, t4.getText());
		st.setString(5, (String) comboBox.getSelectedItem());
		st.setString(6, t5.getText());
		st.setString(7, t6.getText());

		int rs = st.executeUpdate();
		
		if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Added");
		else
                    JOptionPane.showMessageDialog(null, "Error");
                
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
		st.close();
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
		new Accueil().setVisible(true);

            }
            con.c.close();
        }catch(Exception e){
            
        }
    }
}

