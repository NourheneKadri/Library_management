import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class Detaillivre extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;
    private JTextField search;
    @SuppressWarnings("unused")
	private JButton b1,b2,b3;

    public static void main(String[] args) {
	new Detaillivre().setVisible(true);
    }
    
    public void Book() {
	try {
            conn con = new conn();
            String sql = "select * from book";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
	} catch (Exception e) {
	
	}
    }

    public Detaillivre() {
    	 setBounds(280, 80, 800, 400);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
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

	


	
	
	JLabel test = new JLabel("");
	 test.setVerticalAlignment(SwingConstants.TOP);
    ImageIcon test_i  = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
    Image test_i2 = test_i.getImage().getScaledInstance(80, 80,Image.SCALE_DEFAULT);
    ImageIcon test_i3= new ImageIcon(test_i2);
    test = new JLabel(test_i3);
    test.setBounds(320, 10, 159, 152);
    contentPane.add(test);

   
	JLabel l3 = new JLabel("Retourner");
	l3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Accueil Accueil = new Accueil();
				Accueil.setVisible(true);
			}
		});
	l3.setForeground(Color.RED);
	l3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	
	l3.setBounds(47, 10, 100, 33);
	contentPane.add(l3);

	
	Book();
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            conn con = new conn();
            if(ae.getSource() == b1){
             
                String sql = "select * from book where concat(name, book_id) like ?";
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