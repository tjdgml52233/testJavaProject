package ch23_oracle;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MaerietlList extends JFrame {

	//추가
	private MaerietlDAO dao;
	private Vector cols;
	private DefaultTableModel model;
	private MaerietlDTO dto;

	private JPanel contentPane;
	private JTable table;
	private JTextField tfProduct_no;
	private JTextField tfPlocal;
	private JTextField tfPname;
	private JTextField tfPcompany;
	private JTextField tfUprice;
	private JTextField tfAcc;
	private JTextField tfSprice;
	private JTextField tfSearch;
	private JTextField tfRedate;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaerietlList frame = new MaerietlList();
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
	public MaerietlList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 165, 773, 378);
		contentPane.add(scrollPane);
		//추가
		dao = new MaerietlDAO();
		cols = new Vector();
		cols.add("제품번호");
		cols.add("지    점");
		cols.add("제품이름");
		cols.add("제조회사");
		cols.add("입고일자");
		cols.add("단    가");
		cols.add("수    량");
		cols.add("총 금 액");
		list();	
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx = table.getSelectedRow();
				tfProduct_no.setEditable(false);
				tfSprice.setEditable(false);
				tfProduct_no.setText(table.getValueAt(idx, 0)+"");
				tfPlocal.setText(table.getValueAt(idx, 1)+"");
				tfPname.setText(table.getValueAt(idx, 2)+"");
				tfPcompany.setText(table.getValueAt(idx, 3)+"");
				tfRedate.setText(table.getValueAt(idx, 4)+"");
				tfUprice.setText(table.getValueAt(idx, 5)+"");
				tfAcc.setText(table.getValueAt(idx, 6)+"");
				tfSprice.setText(table.getValueAt(idx, 7)+"");
		
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("제품번호");
		lblNewLabel.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel);
		
		tfProduct_no = new JTextField();
		tfProduct_no.setBounds(106, 7, 132, 21);
		contentPane.add(tfProduct_no);
		tfProduct_no.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("지점");
		lblNewLabel_1.setBounds(284, 10, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		tfPlocal = new JTextField();
		tfPlocal.setBounds(355, 6, 157, 21);
		contentPane.add(tfPlocal);
		tfPlocal.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("제품명");
		lblNewLabel_2.setBounds(12, 46, 57, 15);
		contentPane.add(lblNewLabel_2);
		tfPname = new JTextField();
		tfPname.setBounds(106, 43, 132, 21);
		contentPane.add(tfPname);
		tfPname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("제조회사");
		lblNewLabel_3.setBounds(284, 46, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		tfPcompany = new JTextField();
		tfPcompany.setBounds(355, 42, 157, 21);
		contentPane.add(tfPcompany);
		tfPcompany.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("입고일자");
		lblNewLabel_8.setBounds(543, 44, 62, 18);
		contentPane.add(lblNewLabel_8);
		
		tfRedate = new JTextField();
		tfRedate.setBounds(619, 41, 116, 24);
		contentPane.add(tfRedate);
		tfRedate.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("단가");
		lblNewLabel_4.setBounds(12, 84, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		tfUprice = new JTextField();
		tfUprice.setBounds(106, 81, 132, 21);
		contentPane.add(tfUprice);
		tfUprice.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("수량");
		lblNewLabel_5.setBounds(284, 84, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		tfAcc = new JTextField();
		tfAcc.setBounds(355, 80, 80, 21);
		contentPane.add(tfAcc);
		tfAcc.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("총금액");
		lblNewLabel_6.setBounds(474, 84, 57, 15);
		contentPane.add(lblNewLabel_6);
		
		tfSprice = new JTextField();
		tfSprice.setBounds(543, 81, 218, 21);
		contentPane.add(tfSprice);
		tfSprice.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("제품번호찾기");
		lblNewLabel_7.setBounds(12, 123, 91, 15);
		contentPane.add(lblNewLabel_7);
		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				search();
			}
		});
		tfSearch.setBounds(106, 120, 132, 21);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(244, 119, 97, 23);
		contentPane.add(btnSearch);
		
		JButton btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input();
				int result = dao.insertProduct(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(
							MaerietlList.this, "저장되었습니다.");
					list();
					table.setModel(model);
					clear();
				}

			}
		});
		btnSave.setBounds(355, 119, 72, 23);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				input();
				int result = dao.updateProduct(dto);
				if (result == 1){
					JOptionPane.showMessageDialog(
							MaerietlList.this, "수정되었습니다.");
					list();
					table.setModel(model);
					clear();
				}
			}
		});
		btnUpdate.setBounds(441, 119, 72, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String product_no = tfProduct_no.getText();
				int result = 0;
				int response = JOptionPane.showConfirmDialog(
						MaerietlList.this, "삭제하시겠습니까?");
				if (response == JOptionPane.YES_OPTION){
					result = dao.deleteProduct(product_no);
					if (result == 1) {
						JOptionPane.showMessageDialog(
								MaerietlList.this, "삭제되었습니다.");
						list();
						table.setModel(model);
						clear();
					}
				}
			}
		});
		btnDelete.setBounds(527, 119, 72, 23);
		contentPane.add(btnDelete);
		
		JButton btnList = new JButton("목록보기");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				list();
				table.setModel(model);
				clear();
			}
		});
		btnList.setBounds(680, 126, 105, 27);
		contentPane.add(btnList);
		
	}
//메소드 추가
	public void search() {
		String name = tfSearch.getText();
		model = new DefaultTableModel(
				dao.searchProduct(name), cols) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(model);
	}	

	public void list() {
		model = new DefaultTableModel(dao.listProduct(), cols) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}

	public void clear() {
		tfProduct_no.setText("");
		tfPlocal.setText("");
		tfPname.setText("");
		tfPcompany.setText("");
		tfRedate.setText("");
		tfUprice.setText("");
		tfAcc.setText("");
		tfSprice.setText("");
		tfProduct_no.requestFocus();
		tfProduct_no.setEditable(true);
	}	
	
	public void input() {
		String product_no = tfProduct_no.getText();
		String plocal = tfPlocal.getText();
		String pname = tfPname.getText();
		String company = tfPcompany.getText();
		Date redate = Date.valueOf(tfRedate.getText());
		int uprice = Integer.parseInt(tfUprice.getText());
		int pacc = Integer.parseInt(tfAcc.getText());
		dto = new MaerietlDTO(product_no, plocal, pname, company, redate, uprice, pacc);
System.out.println(dto.toString());//데이터확인(디버깅용)
		
	}	
}

