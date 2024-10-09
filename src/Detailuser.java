import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class Detailuser extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1;
    
    public static void main(String[] args) {
	new Detailuser().setVisible(true);
    }

    public void student() {
        try {
            conn con = new conn();
            String sql = "select * from student";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }

    public Detailuser() {
    	setBounds(280, 80, 800, 400);
        contentPane = new JPanel();
	contentPane.setBackground(new Color(220, 220, 220));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(40, 133, 711, 200);
	contentPane.add(scrollPane);

	table = new JTable();
	table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
		search.setText(table.getModel().getValueAt(row, 1).toString());
            }
	});
	table.setBackground(new Color(240, 248, 255));
	table.setForeground(Color.DARK_GRAY);
	table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	scrollPane.setViewportView(table);
	
	
	
	
	JLabel l2 = new JLabel("Retourner");
	l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                Accueil Accueil = new Accueil();
                Accueil.setVisible(true);
            }
	});
	l2.setForeground(Color.RED);
	l2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	
        l2.setBounds(47, 10, 100, 33);
	contentPane.add(l2);

	JLabel test = new JLabel("");
	 test.setVerticalAlignment(SwingConstants.TOP);
   ImageIcon test_i  = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.png"));
   Image test_i2 = test_i.getImage().getScaledInstance(80, 80,Image.SCALE_DEFAULT);
   ImageIcon test_i3= new ImageIcon(test_i2);
   test = new JLabel(test_i3);
   test.setBounds(320, 10, 159, 152);
   contentPane.add(test);
        
	student();
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            conn con = new conn();
            if( ae.getSource() == b1){
                String sql = "select * from student where concat(name, student_id) like ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, "%" + search.getText() + "%");
		ResultSet rs = st.executeQuery();

		table.setModel(DbUtils.resultSetToTableModel(rs));
		rs.close();
		st.close();
            }
 
            con.c.close();
        }catch(Exception e){
            
        }
    }
}
