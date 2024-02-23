import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameType extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDauSach;
	private JTextField txtTheLoai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameType frame = new JFrameType();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void showMessage(String message) {
	    JOptionPane.showMessageDialog(null, message);
	}
	
	public void showErrorMessage(String errorMessage) {
	    JOptionPane.showMessageDialog(null, errorMessage, "Update Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public JFrameType() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm loại sách");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(140, 20, 193, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Đầu sách");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 73, 127, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thể loại");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 151, 127, 51);
		contentPane.add(lblNewLabel_1_1);
		
		txtDauSach = new JTextField();
		txtDauSach.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDauSach.setBounds(192, 80, 274, 37);
		contentPane.add(txtDauSach);
		txtDauSach.setColumns(10);
		
		txtTheLoai = new JTextField();
		txtTheLoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTheLoai.setColumns(10);
		txtTheLoai.setBounds(192, 158, 274, 37);
		contentPane.add(txtTheLoai);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DauSach ds = new DauSach();
				ds.setDau_sach(txtDauSach.getText());
				ds.setTen_tl(txtTheLoai.getText());
				boolean insertTypeSuccess = MySqlConnect.insertType(ds);
				if(insertTypeSuccess) {
					showMessage("Insert success");
				}
				else {
					showErrorMessage("Insert faild");
				}
				
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(381, 227, 85, 36);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameBook jfBook = new JFrameBook();
				jfBook.setVisible(true);
				dispose();
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnExit.setBounds(10, 10, 75, 27);
		contentPane.add(btnExit);
	}
}
