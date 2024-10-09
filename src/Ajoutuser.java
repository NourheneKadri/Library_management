import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Ajoutuser extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField t2,t3;
    @SuppressWarnings("rawtypes")
	private JComboBox  comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;

    public static void main(String[] args) {
        new Ajoutuser().setVisible(true);
    }

    

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Ajoutuser() {
        super("Add Student");
        setBounds(500, 200, 500, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	

	JLabel l2 = new JLabel("NOM");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(10, 10, 102, 22);
	contentPane.add(l2);

	JLabel l3 = new JLabel("PRENOM");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(10, 50, 102, 22);
	contentPane.add(l3);

	

        JLabel l5 = new JLabel("ANNEE");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(10, 90, 102, 22);
	contentPane.add(l5);

	JLabel l6 = new JLabel("SEMESTRE");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(10, 130, 102, 22);
	contentPane.add(l6);

	
	t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t2.setColumns(10);
	t2.setBounds(150, 10, 156, 20);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(150, 50, 156, 20);
	contentPane.add(t3);

	
	comboBox_1 = new JComboBox();
	comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "1ER", "2EME", "3EME", "4EME" }));
	comboBox_1.setForeground(new Color(47, 79, 79));
	comboBox_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	comboBox_1.setBounds(150, 90, 154, 20);
	contentPane.add(comboBox_1);

	comboBox_2 = new JComboBox();
	comboBox_2.setModel(
			new DefaultComboBoxModel(new String[] { "1ER", "2EME", "3EME", "4EME", "5EME", "6EME", "7EME", "8EME" }));
	comboBox_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	comboBox_2.setForeground(new Color(47, 79, 79));
	comboBox_2.setBounds(150, 130, 154, 20);
	contentPane.add(comboBox_2);

	  b1 = new JButton("Ajouter");
		b1.addActionListener(this);
		b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
	        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		b1.setBounds(40, 200, 100, 33);
	        b1.setBackground(Color.BLACK);
	        b1.setForeground(Color.WHITE);
		contentPane.add(b1);

		b2 = new JButton("Retourner");
		b2.addActionListener(this);
		b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
		b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		b2.setBounds(160, 200, 108, 33);
	        b2.setBackground(Color.RED);
	        b2.setForeground(Color.WHITE);
		
		contentPane.add(b2);

	JLabel l7 = new JLabel("lICENCE");
	l7.setForeground(new Color(25, 25, 112));
	l7.setFont(new Font("Tahoma", Font.BOLD, 14));
	l7.setBounds(10, 170, 102, 22);
	contentPane.add(l7);

	comboBox_3 = new JComboBox();
	comboBox_3.setModel(new DefaultComboBoxModel(
			new String[] { "DNI", "LICENCE", "MASTER", "DOCTORA", "AUTRE" }));
	comboBox_3.setForeground(new Color(47, 79, 79));
	comboBox_3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	comboBox_3.setBounds(150, 170, 154, 20);
	contentPane.add(comboBox_3);

	
	
	JLabel test = new JLabel("");
	 test.setVerticalAlignment(SwingConstants.TOP);
    ImageIcon test_i  = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.png"));
    Image test_i2 = test_i.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
    ImageIcon test_i3= new ImageIcon(test_i2);
    test = new JLabel(test_i3);
    test.setBounds(320, 50, 159, 152);
    contentPane.add(test);
      
       contentPane.setBackground(Color.WHITE);
	
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                conn con = new conn();
                String sql = "insert into student( name, lastname, licence, year, semester) values(?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);

		st.setString(1, t2.getText());
		st.setString(2, t3.getText());
		st.setString(3, (String) comboBox_3.getSelectedItem());
		st.setString(4, (String) comboBox_1.getSelectedItem());
		st.setString(5, (String) comboBox_2.getSelectedItem());

		int i = st.executeUpdate();
		if (i > 0){
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                    this.setVisible(false);
                    new Accueil().setVisible(true);
                }
		else
                    JOptionPane.showMessageDialog(null, "error");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            
            if(ae.getSource() == b2){
                this.setVisible(false);
		new Accueil().setVisible(true);		
            }
        }catch(Exception e){
            
        }
    }
}

