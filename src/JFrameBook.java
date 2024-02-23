import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;

public class JFrameBook extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtName;
	private JTextField txtManxb;
	private JTextField txtMatg;
	private JTextField txtDauSach;
	private static JTable table;
	private static JTable table_1;
	private static JTable table_2;
	private static JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameBook frame = new JFrameBook();
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
	
	public JFrameBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1273, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý sách");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(452, 0, 363, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sách");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 149, 124, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sách");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(10, 235, 124, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã Nhà xuất bản");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(10, 296, 196, 40);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mã tác giả");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_3.setBounds(10, 365, 124, 40);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Đầu sách");
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_3_1.setBounds(10, 422, 124, 40);
		contentPane.add(lblNewLabel_1_3_1);
		
		txtCode = new JTextField();
		txtCode.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCode.setBounds(212, 133, 310, 40);
		contentPane.add(txtCode);
		txtCode.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBounds(212, 235, 310, 40);
		contentPane.add(txtName);
		
		txtManxb = new JTextField();
		txtManxb.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtManxb.setColumns(10);
		txtManxb.setBounds(212, 300, 310, 40);
		contentPane.add(txtManxb);
		
		txtMatg = new JTextField();
		txtMatg.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMatg.setColumns(10);
		txtMatg.setBounds(212, 369, 310, 40);
		contentPane.add(txtMatg);
		
		txtDauSach = new JTextField();
		txtDauSach.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtDauSach.setColumns(10);
		txtDauSach.setBounds(212, 426, 310, 40);
		contentPane.add(txtDauSach);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Book bk = new Book();
					bk.setId(txtCode.getText());
					bk.setTen(txtName.getText());
					bk.setMa_nxb(txtManxb.getText());
					bk.setMa_tac_gia(txtMatg.getText());
					bk.setDau_sach(txtDauSach.getText());
					boolean insertSuccessful = MySqlConnect.insertBook(bk);
					if(insertSuccessful) {
						showMessage("Insert success");
						showData(MySqlConnect.findAll());
					}
					else {
						showErrorMessage("Insert false");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}							
			}
		});
		btnNewButton.setBounds(293, 498, 124, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Book bk= new Book();
					bk.setId(txtCode.getText());
					MySqlConnect.deleteBook(bk);
					JOptionPane.showMessageDialog(null, "Delete success");
					showData(MySqlConnect.findAll());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(154, 498, 124, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("FIND");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Book bk = new Book();
					bk.setTen(txtName.getText());
					showData(MySqlConnect.findByName(bk));
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBounds(441, 498, 109, 50);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("UPDATE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book bk = new Book();
				bk.setId(txtCode.getText());
				bk.setTen(txtName.getText());
				bk.setMa_nxb(txtManxb.getText());
				bk.setMa_tac_gia(txtMatg.getText());
				bk.setDau_sach(txtDauSach.getText());
				try {
					 boolean updateSuccessful = MySqlConnect.updateBook(bk);
					 if(updateSuccessful) {
						 showMessage("Update success.");
						 showData(MySqlConnect.findAll());
					 }
					 else {
						 showErrorMessage("Update failed.");
					 }
					
				} catch (Exception e2) {
					e2.printStackTrace(); 
				}
				
				
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBounds(10, 498, 124, 50);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(612, 96, 645, 234);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 s\u00E1ch", "T\u00EAn S\u00E1ch", "M\u00E3 t\u00E1c gi\u1EA3", "M\u00E3 NXB", "\u0110\u1EA7u s\u00E1ch"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(84);
		table.getColumnModel().getColumn(0).setMinWidth(45);
		table.getColumnModel().getColumn(1).setMinWidth(30);
		table.getColumnModel().getColumn(2).setMinWidth(30);
		table.getColumnModel().getColumn(3).setMinWidth(30);
		table.getColumnModel().getColumn(4).setMinWidth(30);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();

                    if (selectedRow != -1) {
      
                        String bookId = table.getValueAt(selectedRow, 0).toString();
                        String bookName = table.getValueAt(selectedRow, 1).toString();
                        String maTacGia = table.getValueAt(selectedRow, 2).toString();
                        String maNXB = table.getValueAt(selectedRow, 3).toString();
                        String dauSach = table.getValueAt(selectedRow, 4).toString();

                        
                        txtCode.setText(bookId);
                        txtName.setText(bookName);
                        txtManxb.setText(maNXB);
                        txtMatg.setText(maTacGia);
                        txtDauSach.setText(dauSach);
                    }
                }
            }
        });
		
		JButton btnNewButton_2_1 = new JButton("REFESH");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtCode.setText("");
					txtName.setText("");
					txtManxb.setText("");
					txtMatg.setText("");
					txtDauSach.setText("");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2_1.setBounds(10, 60, 109, 33);
		contentPane.add(btnNewButton_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(612, 361, 270, 105);
		contentPane.add(scrollPane_1);
		
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"M\u00E3 t\u00E1c gi\u1EA3", "T\u00EAn t\u00E1c gi\u1EA3"
			}
		));
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(612, 493, 270, 105);
		contentPane.add(scrollPane_2);
		
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"M\u00E3_NXB", "T\u00EAn_NXB"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(947, 361, 285, 234);
		contentPane.add(scrollPane_3);
		
		
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\u0110\u1EA7u S\u00E1ch", "Th\u1EC3 Lo\u1EA1i"
			}
		));
		table_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		scrollPane_3.setViewportView(table_3);
		
		JLabel lblNewLabel_2 = new JLabel("Mã sách: S1, S2, S3,...");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_2.setBounds(212, 183, 310, 28);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_3_1 = new JButton("ADD TYPE");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFrameType Jftype = new JFrameType();
					Jftype.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton_3_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3_1.setBounds(396, 558, 154, 50);
		contentPane.add(btnNewButton_3_1);
		showData(MySqlConnect.findAll());
		showDataTg(MySqlConnect.findAllAuthor());
		showDataNXB(MySqlConnect.findAllNXB());
		showDataDS(MySqlConnect.findAllDauSach());
	}
	public void showData(List<Book>bookl) {
		try {
			List<Book>listBook = new ArrayList<>();
			listBook = bookl;
			DefaultTableModel tableModel;
			table.getModel();
			tableModel = (DefaultTableModel)table.getModel();
			tableModel.setRowCount(0);
			listBook.forEach((book)->{
				tableModel.addRow(new Object[] {
					book.getId(),
					book.getTen(),
					book.getMa_tac_gia(),
					book.getMa_nxb(),
					book.getDau_sach()
				});
			});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void showDataTg(List<Author>AuL) {
		try {
			List<Author>listAu = new ArrayList<>();
			listAu = AuL;
			DefaultTableModel tableModel;
			table_1.getModel();
			tableModel = (DefaultTableModel)table_1.getModel();
			tableModel.setRowCount(0);
			listAu.forEach((au)->{
				tableModel.addRow(new Object[] {
					au.getMa_tac_gia(),
					au.getTen_tg(),
				});
			});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void showDataNXB(List<NXB>NxbL) {
		try {
			List<NXB>listNXB = new ArrayList<>();
			listNXB = NxbL;
			DefaultTableModel tableModel;
			table_2.getModel();
			tableModel = (DefaultTableModel)table_2.getModel();
			tableModel.setRowCount(0);
			listNXB.forEach((nxb)->{
				tableModel.addRow(new Object[] {
					nxb.getMa_nxb(),
					nxb.getTen_nxb(),
				});
			});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void showDataDS(List<DauSach>dsl) {
		try {
			List<DauSach>dsList = new ArrayList<>();
			dsList = dsl;
			DefaultTableModel tableModel = (DefaultTableModel)table_3.getModel();
			tableModel.setRowCount(0);
//			tableModel = (DefaultTableModel)table_3.getModel();
			tableModel.setRowCount(0);
			dsList.forEach((ds)->{
				tableModel.addRow(new Object[] {
					ds.getDau_sach(),
					ds.getTen_tl(),
				});
			});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
